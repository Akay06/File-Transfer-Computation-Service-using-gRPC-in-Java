package server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

import proto.FileServiceGrpc.FileServiceImplBase;
import proto.Fileserver.DeleteRequest;
import proto.Fileserver.DeleteResponse;
import proto.Fileserver.DownloadRequest;
import proto.Fileserver.DownloadResponse;
import proto.Fileserver.RenameRequest;
import proto.Fileserver.RenameResponse;
import proto.Fileserver.UploadRequest;
import proto.Fileserver.UploadResponse;

public class FServer {
    
    public static final String SERVER_FOLDER = "Server Files/";

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8010)
                .addService(new FileServiceImpl())
                .executor(Executors.newFixedThreadPool(10))
                .build();

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
                UploadResponse response = UploadResponse.newBuilder()
                        .setMessage("File uploaded successfully")
                        .build();
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
            	if(file.delete()) {
            		DeleteResponse response = DeleteResponse.newBuilder()
                            .setMessage("File deleted successfully")
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
            	}
            	else {
            		responseObserver.onError(Status.INTERNAL.withDescription("File failed to delete").asRuntimeException());
            	}
            } else {
            	responseObserver.onError(Status.NOT_FOUND.withDescription("File not found").asRuntimeException());
            }
        }

        @Override
        public void rename(RenameRequest request, StreamObserver<RenameResponse> responseObserver) {
            String oldFileName = request.getOldFileName();
            String newFileName = request.getNewFileName();
            
            File oldFile = new File(SERVER_FOLDER + oldFileName);
            File newFile = new File(SERVER_FOLDER + newFileName);

            if (oldFile.exists()) {
            	if(oldFile.renameTo(newFile)) {
            		RenameResponse response = RenameResponse.newBuilder()
                            .setMessage("File renamed successfully")
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
            	}
            	else {
            		responseObserver.onError(Status.INTERNAL.withDescription("File rename failed").asRuntimeException());
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
                    DownloadResponse response = DownloadResponse.newBuilder()
                            .setFileName(fileName)
                            .setFileData(com.google.protobuf.ByteString.copyFrom(fileData))
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                } catch (IOException e) {
                    responseObserver.onError(e);
                }
            } else {
                responseObserver.onError(Status.NOT_FOUND.withDescription("File not found").asRuntimeException());
            }
        }
    }
}

