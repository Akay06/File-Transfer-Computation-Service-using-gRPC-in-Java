package client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import proto.FileServiceGrpc;
import proto.FileServiceGrpc.FileServiceBlockingStub;
import proto.Fileserver.DeleteRequest;
import proto.Fileserver.DownloadRequest;
import proto.Fileserver.DownloadResponse;
import proto.Fileserver.FileInfo;
import proto.Fileserver.ListFilesRequest;
import proto.Fileserver.ListFilesResponse;
import proto.Fileserver.UploadRequest;

public class FolderWatcher implements Runnable {
	private Path syncFolder;

	private ManagedChannel channel;

	private FileServiceBlockingStub stub;

	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public FolderWatcher(String folderPath) {
		this.syncFolder = Paths.get(folderPath);
		this.channel = ManagedChannelBuilder.forAddress("localhost", 8010).usePlaintext().build();
		this.stub = FileServiceGrpc.newBlockingStub(channel);

		System.out.println("Client started...");

		try {
			scanAndSyncFileFromServerToClient();
		} catch (Exception e) {
			e.printStackTrace();
		}

		startSyncFromServer();
	}

	@Override
	public void run() {
		try (WatchService watchService = syncFolder.getFileSystem().newWatchService()) {
			syncFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

			WatchKey key = null;

			while (true) {
				try {
					key = watchService.take();
					for (WatchEvent<?> event : key.pollEvents()) {
						WatchEvent.Kind<?> kind = event.kind();
						Path changedFile = (Path) event.context();

						if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
							syncFileToServer(changedFile);
							// System.out.println("File created: " + changedFile);
						} else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
							syncFileToServer(changedFile);
							System.out.println("File modified: " + changedFile);
						} else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
							deleteFileOnServer(changedFile);
							System.out.println("File deleted: " + changedFile);
						}
					}
					key.reset();
				} catch (StatusRuntimeException e) {
					if (e.getStatus().getCode() == Status.Code.NOT_FOUND) {
						// System.out.println("Error: " + e.getStatus().getDescription());
					} else if (e.getStatus().getCode() == Status.Code.INTERNAL) {
						// System.out.println("Error: " + e.getStatus().getDescription());
					} else if (e.getStatus().getCode() == Status.Code.UNAVAILABLE) {
						System.out.println("Server unavailable");
					} else {
						// System.out.println("An error occurred: " + e.getStatus());
					}
					key.reset();
				} catch (Exception e) {
					e.printStackTrace();
					key.reset();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			channel.shutdown();
		}
	}

	/*
	 * private void scanAndSyncFileFromClientToServer() throws Exception {
	 * ListFilesRequest listFilesRequest = ListFilesRequest.newBuilder().build();
	 * ListFilesResponse response = stub.listFiles(listFilesRequest);
	 * 
	 * Map<String, Long> serverFileinfo = new HashMap<>(); for (FileInfo fileInfo :
	 * response.getFilesList()) { serverFileinfo.put(fileInfo.getFileName(),
	 * fileInfo.getLastModified()); }
	 * Files.list(syncFolder).filter(Files::isRegularFile).forEach(file -> { try {
	 * if (serverFileinfo.containsKey(file.getFileName().toString())) { if
	 * (serverFileinfo.get(file.getFileName().toString()) <
	 * Files.getLastModifiedTime(file) .toMillis()) {
	 * syncFileToServer(file.getFileName());
	 * //System.out.println("Existing file (Latest) synchronized to server: " +
	 * file); } } else { syncFileToServer(file.getFileName());
	 * //System.out.println("New file synchronized to server: " + file); } } catch
	 * (Exception e) { e.printStackTrace(); } }); }
	 */

	private synchronized void scanAndSyncFileFromServerToClient() throws Exception {
		try {
			ListFilesRequest listFilesRequest = ListFilesRequest.newBuilder().build();
			ListFilesResponse response = stub.listFiles(listFilesRequest);

			List<String> clientFiles = new ArrayList<>();

			Stream<Path> stream = Files.list(syncFolder);
			stream.filter(Files::isRegularFile).forEach(file -> clientFiles.add(file.getFileName().toString()));

			stream.close();

			response.getFilesList().forEach(fileInfo -> {
				if (clientFiles.contains(fileInfo.getFileName())) {
					try {
						if (!fileInfo.getFileHash()
								.equals(calculateFileHash(syncFolder.resolve(Paths.get(fileInfo.getFileName()))))
								&& fileInfo.getLastModified() > Files
										.getLastModifiedTime(syncFolder.resolve(Paths.get(fileInfo.getFileName())))
										.toMillis()) {
							download(fileInfo);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					clientFiles.remove(fileInfo.getFileName());
				} else {
					download(fileInfo);
				}
			});

			for (String temp : clientFiles) {
				Files.delete(syncFolder.resolve(Paths.get(temp)));
			}
		} catch (StatusRuntimeException e) {
			if (e.getStatus().getCode() == Status.Code.UNAVAILABLE) {
				System.out.println("Server unavailable");
			}
		}
	}

	private synchronized void syncFileToServer(Path file) throws Exception {
		Thread.sleep(500);
		byte[] fileData = Files.readAllBytes(Paths.get(syncFolder.toString(), file.toString()));

		UploadRequest uploadRequest = UploadRequest.newBuilder().setFileName(file.getFileName().toString())
				.setFileData(com.google.protobuf.ByteString.copyFrom(fileData)).build();
		stub.upload(uploadRequest);
	}

	private synchronized void deleteFileOnServer(Path file) throws Exception {
		Thread.sleep(500);
		DeleteRequest deleteRequest = DeleteRequest.newBuilder().setFileName(file.getFileName().toString()).build();
		stub.delete(deleteRequest);
	}

	public synchronized void startSyncFromServer() {
		scheduler.scheduleAtFixedRate(() -> {
			try {
				scanAndSyncFileFromServerToClient();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, 0, 10, TimeUnit.SECONDS);
	}

	public synchronized void download(FileInfo fileInfo) {
		DownloadRequest downloadRequest = DownloadRequest.newBuilder().setFileName(fileInfo.getFileName()).build();
		DownloadResponse downloadResponse = stub.download(downloadRequest);
		try {
			Files.write(syncFolder.resolve(Paths.get(downloadResponse.getFileName())),
					downloadResponse.getFileData().toByteArray());
		} catch (StatusRuntimeException e) {
			if (e.getStatus().getCode() == Status.Code.NOT_FOUND) {
				// System.out.println("Error: " + e.getStatus().getDescription());
			} else if (e.getStatus().getCode() == Status.Code.INTERNAL) {
				// System.out.println("Error: " + e.getStatus().getDescription());
			} else {
				// System.out.println("An error occurred: " + e.getStatus());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String calculateFileHash(Path filePath) throws Exception {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] fileBytes = Files.readAllBytes(filePath);
		byte[] hashBytes = digest.digest(fileBytes);
		return Base64.getEncoder().encodeToString(hashBytes);
	}
}
