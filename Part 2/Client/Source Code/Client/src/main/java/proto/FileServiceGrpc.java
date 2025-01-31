package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: fileserver.proto")
public final class FileServiceGrpc {

  private FileServiceGrpc() {}

  public static final String SERVICE_NAME = "FileService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.Fileserver.UploadRequest,
      proto.Fileserver.UploadResponse> getUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Upload",
      requestType = proto.Fileserver.UploadRequest.class,
      responseType = proto.Fileserver.UploadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Fileserver.UploadRequest,
      proto.Fileserver.UploadResponse> getUploadMethod() {
    io.grpc.MethodDescriptor<proto.Fileserver.UploadRequest, proto.Fileserver.UploadResponse> getUploadMethod;
    if ((getUploadMethod = FileServiceGrpc.getUploadMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getUploadMethod = FileServiceGrpc.getUploadMethod) == null) {
          FileServiceGrpc.getUploadMethod = getUploadMethod = 
              io.grpc.MethodDescriptor.<proto.Fileserver.UploadRequest, proto.Fileserver.UploadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "FileService", "Upload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.UploadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.UploadResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("Upload"))
                  .build();
          }
        }
     }
     return getUploadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Fileserver.DeleteRequest,
      proto.Fileserver.DeleteResponse> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = proto.Fileserver.DeleteRequest.class,
      responseType = proto.Fileserver.DeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Fileserver.DeleteRequest,
      proto.Fileserver.DeleteResponse> getDeleteMethod() {
    io.grpc.MethodDescriptor<proto.Fileserver.DeleteRequest, proto.Fileserver.DeleteResponse> getDeleteMethod;
    if ((getDeleteMethod = FileServiceGrpc.getDeleteMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getDeleteMethod = FileServiceGrpc.getDeleteMethod) == null) {
          FileServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<proto.Fileserver.DeleteRequest, proto.Fileserver.DeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "FileService", "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.DeleteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("Delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Fileserver.RenameRequest,
      proto.Fileserver.RenameResponse> getRenameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Rename",
      requestType = proto.Fileserver.RenameRequest.class,
      responseType = proto.Fileserver.RenameResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Fileserver.RenameRequest,
      proto.Fileserver.RenameResponse> getRenameMethod() {
    io.grpc.MethodDescriptor<proto.Fileserver.RenameRequest, proto.Fileserver.RenameResponse> getRenameMethod;
    if ((getRenameMethod = FileServiceGrpc.getRenameMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getRenameMethod = FileServiceGrpc.getRenameMethod) == null) {
          FileServiceGrpc.getRenameMethod = getRenameMethod = 
              io.grpc.MethodDescriptor.<proto.Fileserver.RenameRequest, proto.Fileserver.RenameResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "FileService", "Rename"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.RenameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.RenameResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("Rename"))
                  .build();
          }
        }
     }
     return getRenameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Fileserver.DownloadRequest,
      proto.Fileserver.DownloadResponse> getDownloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Download",
      requestType = proto.Fileserver.DownloadRequest.class,
      responseType = proto.Fileserver.DownloadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Fileserver.DownloadRequest,
      proto.Fileserver.DownloadResponse> getDownloadMethod() {
    io.grpc.MethodDescriptor<proto.Fileserver.DownloadRequest, proto.Fileserver.DownloadResponse> getDownloadMethod;
    if ((getDownloadMethod = FileServiceGrpc.getDownloadMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getDownloadMethod = FileServiceGrpc.getDownloadMethod) == null) {
          FileServiceGrpc.getDownloadMethod = getDownloadMethod = 
              io.grpc.MethodDescriptor.<proto.Fileserver.DownloadRequest, proto.Fileserver.DownloadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "FileService", "Download"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.DownloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.DownloadResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("Download"))
                  .build();
          }
        }
     }
     return getDownloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Fileserver.ListFilesRequest,
      proto.Fileserver.ListFilesResponse> getListFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFiles",
      requestType = proto.Fileserver.ListFilesRequest.class,
      responseType = proto.Fileserver.ListFilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Fileserver.ListFilesRequest,
      proto.Fileserver.ListFilesResponse> getListFilesMethod() {
    io.grpc.MethodDescriptor<proto.Fileserver.ListFilesRequest, proto.Fileserver.ListFilesResponse> getListFilesMethod;
    if ((getListFilesMethod = FileServiceGrpc.getListFilesMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getListFilesMethod = FileServiceGrpc.getListFilesMethod) == null) {
          FileServiceGrpc.getListFilesMethod = getListFilesMethod = 
              io.grpc.MethodDescriptor.<proto.Fileserver.ListFilesRequest, proto.Fileserver.ListFilesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "FileService", "ListFiles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.ListFilesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.ListFilesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("ListFiles"))
                  .build();
          }
        }
     }
     return getListFilesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FileServiceStub newStub(io.grpc.Channel channel) {
    return new FileServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FileServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FileServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FileServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FileServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FileServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void upload(proto.Fileserver.UploadRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.UploadResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUploadMethod(), responseObserver);
    }

    /**
     */
    public void delete(proto.Fileserver.DeleteRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.DeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     */
    public void rename(proto.Fileserver.RenameRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.RenameResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRenameMethod(), responseObserver);
    }

    /**
     */
    public void download(proto.Fileserver.DownloadRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.DownloadResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDownloadMethod(), responseObserver);
    }

    /**
     */
    public void listFiles(proto.Fileserver.ListFilesRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.ListFilesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListFilesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUploadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Fileserver.UploadRequest,
                proto.Fileserver.UploadResponse>(
                  this, METHODID_UPLOAD)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Fileserver.DeleteRequest,
                proto.Fileserver.DeleteResponse>(
                  this, METHODID_DELETE)))
          .addMethod(
            getRenameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Fileserver.RenameRequest,
                proto.Fileserver.RenameResponse>(
                  this, METHODID_RENAME)))
          .addMethod(
            getDownloadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Fileserver.DownloadRequest,
                proto.Fileserver.DownloadResponse>(
                  this, METHODID_DOWNLOAD)))
          .addMethod(
            getListFilesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Fileserver.ListFilesRequest,
                proto.Fileserver.ListFilesResponse>(
                  this, METHODID_LIST_FILES)))
          .build();
    }
  }

  /**
   */
  public static final class FileServiceStub extends io.grpc.stub.AbstractStub<FileServiceStub> {
    private FileServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileServiceStub(channel, callOptions);
    }

    /**
     */
    public void upload(proto.Fileserver.UploadRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.UploadResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(proto.Fileserver.DeleteRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.DeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void rename(proto.Fileserver.RenameRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.RenameResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRenameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void download(proto.Fileserver.DownloadRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.DownloadResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDownloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listFiles(proto.Fileserver.ListFilesRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.ListFilesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListFilesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FileServiceBlockingStub extends io.grpc.stub.AbstractStub<FileServiceBlockingStub> {
    private FileServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.Fileserver.UploadResponse upload(proto.Fileserver.UploadRequest request) {
      return blockingUnaryCall(
          getChannel(), getUploadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Fileserver.DeleteResponse delete(proto.Fileserver.DeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Fileserver.RenameResponse rename(proto.Fileserver.RenameRequest request) {
      return blockingUnaryCall(
          getChannel(), getRenameMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Fileserver.DownloadResponse download(proto.Fileserver.DownloadRequest request) {
      return blockingUnaryCall(
          getChannel(), getDownloadMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Fileserver.ListFilesResponse listFiles(proto.Fileserver.ListFilesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListFilesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FileServiceFutureStub extends io.grpc.stub.AbstractStub<FileServiceFutureStub> {
    private FileServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Fileserver.UploadResponse> upload(
        proto.Fileserver.UploadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUploadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Fileserver.DeleteResponse> delete(
        proto.Fileserver.DeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Fileserver.RenameResponse> rename(
        proto.Fileserver.RenameRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRenameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Fileserver.DownloadResponse> download(
        proto.Fileserver.DownloadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDownloadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Fileserver.ListFilesResponse> listFiles(
        proto.Fileserver.ListFilesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListFilesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPLOAD = 0;
  private static final int METHODID_DELETE = 1;
  private static final int METHODID_RENAME = 2;
  private static final int METHODID_DOWNLOAD = 3;
  private static final int METHODID_LIST_FILES = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FileServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FileServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPLOAD:
          serviceImpl.upload((proto.Fileserver.UploadRequest) request,
              (io.grpc.stub.StreamObserver<proto.Fileserver.UploadResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((proto.Fileserver.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<proto.Fileserver.DeleteResponse>) responseObserver);
          break;
        case METHODID_RENAME:
          serviceImpl.rename((proto.Fileserver.RenameRequest) request,
              (io.grpc.stub.StreamObserver<proto.Fileserver.RenameResponse>) responseObserver);
          break;
        case METHODID_DOWNLOAD:
          serviceImpl.download((proto.Fileserver.DownloadRequest) request,
              (io.grpc.stub.StreamObserver<proto.Fileserver.DownloadResponse>) responseObserver);
          break;
        case METHODID_LIST_FILES:
          serviceImpl.listFiles((proto.Fileserver.ListFilesRequest) request,
              (io.grpc.stub.StreamObserver<proto.Fileserver.ListFilesResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FileServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.Fileserver.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FileService");
    }
  }

  private static final class FileServiceFileDescriptorSupplier
      extends FileServiceBaseDescriptorSupplier {
    FileServiceFileDescriptorSupplier() {}
  }

  private static final class FileServiceMethodDescriptorSupplier
      extends FileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FileServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FileServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FileServiceFileDescriptorSupplier())
              .addMethod(getUploadMethod())
              .addMethod(getDeleteMethod())
              .addMethod(getRenameMethod())
              .addMethod(getDownloadMethod())
              .addMethod(getListFilesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
