package server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import proto.FileServiceGrpc.FileServiceImplBase;
import proto.Fileserver.DeleteRequest;
import proto.Fileserver.DeleteResponse;
import proto.Fileserver.DownloadRequest;
import proto.Fileserver.DownloadResponse;
import proto.Fileserver.FileInfo;
import proto.Fileserver.ListFilesRequest;
import proto.Fileserver.ListFilesResponse;
import proto.Fileserver.UploadRequest;
import proto.Fileserver.UploadResponse;

public class FServer {

	public static final String SERVER_FOLDER = "Server Files/";

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(8010).addService(new FileServiceImpl())
				.executor(Executors.newFixedThreadPool(10)).build();

		System.out.println("Server started...");
		server.start();
		server.awaitTermination();
	}

	static class FileServiceImpl extends FileServiceImplBase {

		@Override
		public void upload(UploadRequest request, StreamObserver<UploadResponse> responseObserver) {
			String fileName = request.getFileName();
			byte[] fileData = request.getFileData().toByteArray();

			try {
				Files.write(Paths.get(SERVER_FOLDER + fileName), fileData);
				UploadResponse response = UploadResponse.newBuilder().setMessage("File uploaded successfully").build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			} catch (IOException e) {
				responseObserver.onError(e);
			}
		}

		@Override
		public void delete(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
			String fileName = request.getFileName();
			File file = new File(SERVER_FOLDER + fileName);

			if (file.exists()) {
				if (file.delete()) {
					DeleteResponse response = DeleteResponse.newBuilder().setMessage("File deleted successfully")
							.build();
					responseObserver.onNext(response);
					responseObserver.onCompleted();
				} else {
					responseObserver
							.onError(Status.INTERNAL.withDescription("File failed to delete").asRuntimeException());
				}
			} else {
				responseObserver.onError(Status.NOT_FOUND.withDescription("File not found").asRuntimeException());
			}
		}

		@Override
		public void download(DownloadRequest request, StreamObserver<DownloadResponse> responseObserver) {
			String fileName = request.getFileName();
			File file = new File(SERVER_FOLDER + fileName);

			if (file.exists()) {
				try {
					byte[] fileData = Files.readAllBytes(file.toPath());
					DownloadResponse response = DownloadResponse.newBuilder().setFileName(fileName)
							.setFileData(com.google.protobuf.ByteString.copyFrom(fileData)).build();
					responseObserver.onNext(response);
					responseObserver.onCompleted();
				} catch (IOException e) {
					responseObserver.onError(e);
				}
			} else {
				responseObserver.onError(Status.NOT_FOUND.withDescription("File not found").asRuntimeException());
			}
		}

		@Override
		public void listFiles(ListFilesRequest request, StreamObserver<ListFilesResponse> responseObserver) {
			List<FileInfo> fileInfos = new ArrayList<>();
			Stream<Path> stream = null;
			
			try {
				stream = Files.list(Paths.get(SERVER_FOLDER));
				stream.filter(Files::isRegularFile)
						.forEach(file -> {
							try {
								fileInfos.add(FileInfo.newBuilder()
								        .setFileName(file.getFileName().toString())
								        .setFileHash(calculateFileHash(file))
								        .setLastModified(Files.getLastModifiedTime(file).toMillis())
								        .build());
							} catch (Exception e) {
								e.printStackTrace();
							}
						});
				ListFilesResponse response = ListFilesResponse.newBuilder().addAllFiles(fileInfos).build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
			} catch (IOException e) {
				responseObserver.onError(e);
			} finally {
				if(stream!=null) stream.close();
			}
		}
		
		private String calculateFileHash(Path filePath) throws Exception {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] fileBytes = Files.readAllBytes(filePath);
	        byte[] hashBytes = digest.digest(fileBytes);
	        return Base64.getEncoder().encodeToString(hashBytes);
	    }

	}
}
