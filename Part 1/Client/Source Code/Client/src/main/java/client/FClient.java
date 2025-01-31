package client;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;

import proto.FileServiceGrpc;
import proto.FileServiceGrpc.FileServiceBlockingStub;
import proto.Fileserver.DeleteRequest;
import proto.Fileserver.DeleteResponse;
import proto.Fileserver.DownloadRequest;
import proto.Fileserver.DownloadResponse;
import proto.Fileserver.RenameRequest;
import proto.Fileserver.RenameResponse;
import proto.Fileserver.UploadRequest;
import proto.Fileserver.UploadResponse;

public class FClient {

	public static final String CLIENT_FOLDER = "Client Files/";

	public static void main(String[] args) throws Exception {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8010).usePlaintext().build();

		FileServiceBlockingStub stub = FileServiceGrpc.newBlockingStub(channel);

		boolean exit = false;

		Scanner sc = new Scanner(System.in);

		while (!exit) {
			try {
				System.out.println("Choose an option:");
				System.out.println("(1) File Upload");
				System.out.println("(2) File Download");
				System.out.println("(3) Rename File");
				System.out.println("(4) Delete File");
				System.out.println("(5) Exit");

				int choice = sc.nextInt();
				String fileName = "";
				String newFileName = "";

				switch (choice) {
				case 1:
					System.out.println("Enter the filename to upload: ");
					sc.nextLine();
					fileName = sc.nextLine();

					if (!Files.exists(Path.of(CLIENT_FOLDER + fileName))) {
						System.out.println("File \"" + fileName + "\" not found. Please try again!");
						break;
					}

					byte[] fileData = Files.readAllBytes(Paths.get(CLIENT_FOLDER + fileName));

					UploadRequest uploadRequest = UploadRequest.newBuilder().setFileName(fileName)
							.setFileData(com.google.protobuf.ByteString.copyFrom(fileData)).build();
					UploadResponse uploadResponse = stub.upload(uploadRequest);
					System.out.println("Upload Response: " + uploadResponse.getMessage());
					break;

				case 2:
					System.out.println("Enter the filename to download: ");
					sc.nextLine();
					fileName = sc.nextLine();
					DownloadRequest downloadRequest = DownloadRequest.newBuilder().setFileName(fileName).build();
					DownloadResponse downloadResponse = stub.download(downloadRequest);
					Files.write(Paths.get(CLIENT_FOLDER + downloadResponse.getFileName()),
							downloadResponse.getFileData().toByteArray());
					System.out.println("Downloaded file: " + downloadResponse.getFileName());
					break;

				case 3:
					System.out.println("Enter the current filename: ");
					sc.nextLine();
					fileName = sc.nextLine();
					System.out.println("Enter the new filename: ");
					newFileName = sc.nextLine();
					RenameRequest renameRequest = RenameRequest.newBuilder().setOldFileName(fileName)
							.setNewFileName(newFileName).build();
					RenameResponse renameResponse = stub.rename(renameRequest);
					System.out.println("Rename Response: " + renameResponse.getMessage());
					break;

				case 4:
					System.out.println("Enter the filename to delete: ");
					sc.nextLine();
					fileName = sc.nextLine();
					DeleteRequest deleteRequest = DeleteRequest.newBuilder().setFileName(fileName).build();
					DeleteResponse deleteResponse = stub.delete(deleteRequest);
					System.out.println("Delete Response: " + deleteResponse.getMessage());
					break;

				case 5:
					exit = !exit;
					break;

				default:
					System.out.println("Invalid choice. Please choose from above!");
				}
			} catch (StatusRuntimeException e) {
				if (e.getStatus().getCode() == Status.Code.NOT_FOUND) {
					System.out.println("Error: " + e.getStatus().getDescription());
				} else if (e.getStatus().getCode() == Status.Code.INTERNAL) {
					System.out.println("Error: " + e.getStatus().getDescription());
				} else if (e.getStatus().getCode() == Status.Code.UNAVAILABLE) {
					System.out.println("Server unavailable");
				} else {
					System.out.println("An error occurred: " + e.getStatus());
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid choice. Please enter a number!");
				sc.next();
			}

		}

		sc.close();
		channel.shutdown();

	}
}
