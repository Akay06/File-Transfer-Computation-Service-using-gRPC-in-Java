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
public final class ComputationServiceGrpc {

  private ComputationServiceGrpc() {}

  public static final String SERVICE_NAME = "ComputationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.Fileserver.AddRequest,
      proto.Fileserver.AddResponse> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Add",
      requestType = proto.Fileserver.AddRequest.class,
      responseType = proto.Fileserver.AddResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Fileserver.AddRequest,
      proto.Fileserver.AddResponse> getAddMethod() {
    io.grpc.MethodDescriptor<proto.Fileserver.AddRequest, proto.Fileserver.AddResponse> getAddMethod;
    if ((getAddMethod = ComputationServiceGrpc.getAddMethod) == null) {
      synchronized (ComputationServiceGrpc.class) {
        if ((getAddMethod = ComputationServiceGrpc.getAddMethod) == null) {
          ComputationServiceGrpc.getAddMethod = getAddMethod = 
              io.grpc.MethodDescriptor.<proto.Fileserver.AddRequest, proto.Fileserver.AddResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ComputationService", "Add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.AddRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.AddResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ComputationServiceMethodDescriptorSupplier("Add"))
                  .build();
          }
        }
     }
     return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Fileserver.SortRequest,
      proto.Fileserver.SortResponse> getSortMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Sort",
      requestType = proto.Fileserver.SortRequest.class,
      responseType = proto.Fileserver.SortResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Fileserver.SortRequest,
      proto.Fileserver.SortResponse> getSortMethod() {
    io.grpc.MethodDescriptor<proto.Fileserver.SortRequest, proto.Fileserver.SortResponse> getSortMethod;
    if ((getSortMethod = ComputationServiceGrpc.getSortMethod) == null) {
      synchronized (ComputationServiceGrpc.class) {
        if ((getSortMethod = ComputationServiceGrpc.getSortMethod) == null) {
          ComputationServiceGrpc.getSortMethod = getSortMethod = 
              io.grpc.MethodDescriptor.<proto.Fileserver.SortRequest, proto.Fileserver.SortResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ComputationService", "Sort"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.SortRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.SortResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ComputationServiceMethodDescriptorSupplier("Sort"))
                  .build();
          }
        }
     }
     return getSortMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Fileserver.AddRequest,
      proto.Fileserver.AckResponse> getAddAsyncMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddAsync",
      requestType = proto.Fileserver.AddRequest.class,
      responseType = proto.Fileserver.AckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Fileserver.AddRequest,
      proto.Fileserver.AckResponse> getAddAsyncMethod() {
    io.grpc.MethodDescriptor<proto.Fileserver.AddRequest, proto.Fileserver.AckResponse> getAddAsyncMethod;
    if ((getAddAsyncMethod = ComputationServiceGrpc.getAddAsyncMethod) == null) {
      synchronized (ComputationServiceGrpc.class) {
        if ((getAddAsyncMethod = ComputationServiceGrpc.getAddAsyncMethod) == null) {
          ComputationServiceGrpc.getAddAsyncMethod = getAddAsyncMethod = 
              io.grpc.MethodDescriptor.<proto.Fileserver.AddRequest, proto.Fileserver.AckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ComputationService", "AddAsync"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.AddRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.AckResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ComputationServiceMethodDescriptorSupplier("AddAsync"))
                  .build();
          }
        }
     }
     return getAddAsyncMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Fileserver.SortRequest,
      proto.Fileserver.AckResponse> getSortAsyncMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SortAsync",
      requestType = proto.Fileserver.SortRequest.class,
      responseType = proto.Fileserver.AckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Fileserver.SortRequest,
      proto.Fileserver.AckResponse> getSortAsyncMethod() {
    io.grpc.MethodDescriptor<proto.Fileserver.SortRequest, proto.Fileserver.AckResponse> getSortAsyncMethod;
    if ((getSortAsyncMethod = ComputationServiceGrpc.getSortAsyncMethod) == null) {
      synchronized (ComputationServiceGrpc.class) {
        if ((getSortAsyncMethod = ComputationServiceGrpc.getSortAsyncMethod) == null) {
          ComputationServiceGrpc.getSortAsyncMethod = getSortAsyncMethod = 
              io.grpc.MethodDescriptor.<proto.Fileserver.SortRequest, proto.Fileserver.AckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ComputationService", "SortAsync"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.SortRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.AckResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ComputationServiceMethodDescriptorSupplier("SortAsync"))
                  .build();
          }
        }
     }
     return getSortAsyncMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Fileserver.ResultRequest,
      proto.Fileserver.AddResponse> getGetAddResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAddResult",
      requestType = proto.Fileserver.ResultRequest.class,
      responseType = proto.Fileserver.AddResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Fileserver.ResultRequest,
      proto.Fileserver.AddResponse> getGetAddResultMethod() {
    io.grpc.MethodDescriptor<proto.Fileserver.ResultRequest, proto.Fileserver.AddResponse> getGetAddResultMethod;
    if ((getGetAddResultMethod = ComputationServiceGrpc.getGetAddResultMethod) == null) {
      synchronized (ComputationServiceGrpc.class) {
        if ((getGetAddResultMethod = ComputationServiceGrpc.getGetAddResultMethod) == null) {
          ComputationServiceGrpc.getGetAddResultMethod = getGetAddResultMethod = 
              io.grpc.MethodDescriptor.<proto.Fileserver.ResultRequest, proto.Fileserver.AddResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ComputationService", "GetAddResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.ResultRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.AddResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ComputationServiceMethodDescriptorSupplier("GetAddResult"))
                  .build();
          }
        }
     }
     return getGetAddResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<proto.Fileserver.ResultRequest,
      proto.Fileserver.SortResponse> getGetSortResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSortResult",
      requestType = proto.Fileserver.ResultRequest.class,
      responseType = proto.Fileserver.SortResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Fileserver.ResultRequest,
      proto.Fileserver.SortResponse> getGetSortResultMethod() {
    io.grpc.MethodDescriptor<proto.Fileserver.ResultRequest, proto.Fileserver.SortResponse> getGetSortResultMethod;
    if ((getGetSortResultMethod = ComputationServiceGrpc.getGetSortResultMethod) == null) {
      synchronized (ComputationServiceGrpc.class) {
        if ((getGetSortResultMethod = ComputationServiceGrpc.getGetSortResultMethod) == null) {
          ComputationServiceGrpc.getGetSortResultMethod = getGetSortResultMethod = 
              io.grpc.MethodDescriptor.<proto.Fileserver.ResultRequest, proto.Fileserver.SortResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ComputationService", "GetSortResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.ResultRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Fileserver.SortResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ComputationServiceMethodDescriptorSupplier("GetSortResult"))
                  .build();
          }
        }
     }
     return getGetSortResultMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ComputationServiceStub newStub(io.grpc.Channel channel) {
    return new ComputationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ComputationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ComputationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ComputationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ComputationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ComputationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void add(proto.Fileserver.AddRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.AddResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     */
    public void sort(proto.Fileserver.SortRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.SortResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSortMethod(), responseObserver);
    }

    /**
     */
    public void addAsync(proto.Fileserver.AddRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.AckResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddAsyncMethod(), responseObserver);
    }

    /**
     */
    public void sortAsync(proto.Fileserver.SortRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.AckResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSortAsyncMethod(), responseObserver);
    }

    /**
     */
    public void getAddResult(proto.Fileserver.ResultRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.AddResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAddResultMethod(), responseObserver);
    }

    /**
     */
    public void getSortResult(proto.Fileserver.ResultRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.SortResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSortResultMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Fileserver.AddRequest,
                proto.Fileserver.AddResponse>(
                  this, METHODID_ADD)))
          .addMethod(
            getSortMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Fileserver.SortRequest,
                proto.Fileserver.SortResponse>(
                  this, METHODID_SORT)))
          .addMethod(
            getAddAsyncMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Fileserver.AddRequest,
                proto.Fileserver.AckResponse>(
                  this, METHODID_ADD_ASYNC)))
          .addMethod(
            getSortAsyncMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Fileserver.SortRequest,
                proto.Fileserver.AckResponse>(
                  this, METHODID_SORT_ASYNC)))
          .addMethod(
            getGetAddResultMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Fileserver.ResultRequest,
                proto.Fileserver.AddResponse>(
                  this, METHODID_GET_ADD_RESULT)))
          .addMethod(
            getGetSortResultMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Fileserver.ResultRequest,
                proto.Fileserver.SortResponse>(
                  this, METHODID_GET_SORT_RESULT)))
          .build();
    }
  }

  /**
   */
  public static final class ComputationServiceStub extends io.grpc.stub.AbstractStub<ComputationServiceStub> {
    private ComputationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ComputationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComputationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ComputationServiceStub(channel, callOptions);
    }

    /**
     */
    public void add(proto.Fileserver.AddRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.AddResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sort(proto.Fileserver.SortRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.SortResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSortMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addAsync(proto.Fileserver.AddRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.AckResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddAsyncMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sortAsync(proto.Fileserver.SortRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.AckResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSortAsyncMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAddResult(proto.Fileserver.ResultRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.AddResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAddResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSortResult(proto.Fileserver.ResultRequest request,
        io.grpc.stub.StreamObserver<proto.Fileserver.SortResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSortResultMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ComputationServiceBlockingStub extends io.grpc.stub.AbstractStub<ComputationServiceBlockingStub> {
    private ComputationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ComputationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComputationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ComputationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.Fileserver.AddResponse add(proto.Fileserver.AddRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Fileserver.SortResponse sort(proto.Fileserver.SortRequest request) {
      return blockingUnaryCall(
          getChannel(), getSortMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Fileserver.AckResponse addAsync(proto.Fileserver.AddRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddAsyncMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Fileserver.AckResponse sortAsync(proto.Fileserver.SortRequest request) {
      return blockingUnaryCall(
          getChannel(), getSortAsyncMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Fileserver.AddResponse getAddResult(proto.Fileserver.ResultRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAddResultMethod(), getCallOptions(), request);
    }

    /**
     */
    public proto.Fileserver.SortResponse getSortResult(proto.Fileserver.ResultRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetSortResultMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ComputationServiceFutureStub extends io.grpc.stub.AbstractStub<ComputationServiceFutureStub> {
    private ComputationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ComputationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComputationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ComputationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Fileserver.AddResponse> add(
        proto.Fileserver.AddRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Fileserver.SortResponse> sort(
        proto.Fileserver.SortRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSortMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Fileserver.AckResponse> addAsync(
        proto.Fileserver.AddRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddAsyncMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Fileserver.AckResponse> sortAsync(
        proto.Fileserver.SortRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSortAsyncMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Fileserver.AddResponse> getAddResult(
        proto.Fileserver.ResultRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAddResultMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Fileserver.SortResponse> getSortResult(
        proto.Fileserver.ResultRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSortResultMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;
  private static final int METHODID_SORT = 1;
  private static final int METHODID_ADD_ASYNC = 2;
  private static final int METHODID_SORT_ASYNC = 3;
  private static final int METHODID_GET_ADD_RESULT = 4;
  private static final int METHODID_GET_SORT_RESULT = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ComputationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ComputationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD:
          serviceImpl.add((proto.Fileserver.AddRequest) request,
              (io.grpc.stub.StreamObserver<proto.Fileserver.AddResponse>) responseObserver);
          break;
        case METHODID_SORT:
          serviceImpl.sort((proto.Fileserver.SortRequest) request,
              (io.grpc.stub.StreamObserver<proto.Fileserver.SortResponse>) responseObserver);
          break;
        case METHODID_ADD_ASYNC:
          serviceImpl.addAsync((proto.Fileserver.AddRequest) request,
              (io.grpc.stub.StreamObserver<proto.Fileserver.AckResponse>) responseObserver);
          break;
        case METHODID_SORT_ASYNC:
          serviceImpl.sortAsync((proto.Fileserver.SortRequest) request,
              (io.grpc.stub.StreamObserver<proto.Fileserver.AckResponse>) responseObserver);
          break;
        case METHODID_GET_ADD_RESULT:
          serviceImpl.getAddResult((proto.Fileserver.ResultRequest) request,
              (io.grpc.stub.StreamObserver<proto.Fileserver.AddResponse>) responseObserver);
          break;
        case METHODID_GET_SORT_RESULT:
          serviceImpl.getSortResult((proto.Fileserver.ResultRequest) request,
              (io.grpc.stub.StreamObserver<proto.Fileserver.SortResponse>) responseObserver);
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

  private static abstract class ComputationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ComputationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.Fileserver.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ComputationService");
    }
  }

  private static final class ComputationServiceFileDescriptorSupplier
      extends ComputationServiceBaseDescriptorSupplier {
    ComputationServiceFileDescriptorSupplier() {}
  }

  private static final class ComputationServiceMethodDescriptorSupplier
      extends ComputationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ComputationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ComputationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ComputationServiceFileDescriptorSupplier())
              .addMethod(getAddMethod())
              .addMethod(getSortMethod())
              .addMethod(getAddAsyncMethod())
              .addMethod(getSortAsyncMethod())
              .addMethod(getGetAddResultMethod())
              .addMethod(getGetSortResultMethod())
              .build();
        }
      }
    }
    return result;
  }
}
