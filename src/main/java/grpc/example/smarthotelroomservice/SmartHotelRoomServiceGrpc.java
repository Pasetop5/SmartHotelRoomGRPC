package grpc.example.smarthotelroomservice;

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
    comments = "Source: SmartHotelroomserive.proto")
public final class SmartHotelRoomServiceGrpc {

  private SmartHotelRoomServiceGrpc() {}

  public static final String SERVICE_NAME = "SmartHotelRoomService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.example.smarthotelroomservice.RoomServiceRequest,
      grpc.example.smarthotelroomservice.RoomServiceUpdate> getSubscribeForRoomServicesUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeForRoomServicesUpdates",
      requestType = grpc.example.smarthotelroomservice.RoomServiceRequest.class,
      responseType = grpc.example.smarthotelroomservice.RoomServiceUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.example.smarthotelroomservice.RoomServiceRequest,
      grpc.example.smarthotelroomservice.RoomServiceUpdate> getSubscribeForRoomServicesUpdatesMethod() {
    io.grpc.MethodDescriptor<grpc.example.smarthotelroomservice.RoomServiceRequest, grpc.example.smarthotelroomservice.RoomServiceUpdate> getSubscribeForRoomServicesUpdatesMethod;
    if ((getSubscribeForRoomServicesUpdatesMethod = SmartHotelRoomServiceGrpc.getSubscribeForRoomServicesUpdatesMethod) == null) {
      synchronized (SmartHotelRoomServiceGrpc.class) {
        if ((getSubscribeForRoomServicesUpdatesMethod = SmartHotelRoomServiceGrpc.getSubscribeForRoomServicesUpdatesMethod) == null) {
          SmartHotelRoomServiceGrpc.getSubscribeForRoomServicesUpdatesMethod = getSubscribeForRoomServicesUpdatesMethod = 
              io.grpc.MethodDescriptor.<grpc.example.smarthotelroomservice.RoomServiceRequest, grpc.example.smarthotelroomservice.RoomServiceUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "SmartHotelRoomService", "SubscribeForRoomServicesUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.smarthotelroomservice.RoomServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.smarthotelroomservice.RoomServiceUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartHotelRoomServiceMethodDescriptorSupplier("SubscribeForRoomServicesUpdates"))
                  .build();
          }
        }
     }
     return getSubscribeForRoomServicesUpdatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.example.smarthotelroomservice.RoomComponentRequest,
      grpc.example.smarthotelroomservice.RoomComponentUpdate> getRoomServicesComponentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RoomServicesComponent",
      requestType = grpc.example.smarthotelroomservice.RoomComponentRequest.class,
      responseType = grpc.example.smarthotelroomservice.RoomComponentUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.example.smarthotelroomservice.RoomComponentRequest,
      grpc.example.smarthotelroomservice.RoomComponentUpdate> getRoomServicesComponentMethod() {
    io.grpc.MethodDescriptor<grpc.example.smarthotelroomservice.RoomComponentRequest, grpc.example.smarthotelroomservice.RoomComponentUpdate> getRoomServicesComponentMethod;
    if ((getRoomServicesComponentMethod = SmartHotelRoomServiceGrpc.getRoomServicesComponentMethod) == null) {
      synchronized (SmartHotelRoomServiceGrpc.class) {
        if ((getRoomServicesComponentMethod = SmartHotelRoomServiceGrpc.getRoomServicesComponentMethod) == null) {
          SmartHotelRoomServiceGrpc.getRoomServicesComponentMethod = getRoomServicesComponentMethod = 
              io.grpc.MethodDescriptor.<grpc.example.smarthotelroomservice.RoomComponentRequest, grpc.example.smarthotelroomservice.RoomComponentUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "SmartHotelRoomService", "RoomServicesComponent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.smarthotelroomservice.RoomComponentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.smarthotelroomservice.RoomComponentUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartHotelRoomServiceMethodDescriptorSupplier("RoomServicesComponent"))
                  .build();
          }
        }
     }
     return getRoomServicesComponentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartHotelRoomServiceStub newStub(io.grpc.Channel channel) {
    return new SmartHotelRoomServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartHotelRoomServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartHotelRoomServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartHotelRoomServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartHotelRoomServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SmartHotelRoomServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * RPC method to subscribe for room service updates
     * </pre>
     */
    public void subscribeForRoomServicesUpdates(grpc.example.smarthotelroomservice.RoomServiceRequest request,
        io.grpc.stub.StreamObserver<grpc.example.smarthotelroomservice.RoomServiceUpdate> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeForRoomServicesUpdatesMethod(), responseObserver);
    }

    /**
     * <pre>
     * RPC method to stream updates on room components
     * </pre>
     */
    public void roomServicesComponent(grpc.example.smarthotelroomservice.RoomComponentRequest request,
        io.grpc.stub.StreamObserver<grpc.example.smarthotelroomservice.RoomComponentUpdate> responseObserver) {
      asyncUnimplementedUnaryCall(getRoomServicesComponentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubscribeForRoomServicesUpdatesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.example.smarthotelroomservice.RoomServiceRequest,
                grpc.example.smarthotelroomservice.RoomServiceUpdate>(
                  this, METHODID_SUBSCRIBE_FOR_ROOM_SERVICES_UPDATES)))
          .addMethod(
            getRoomServicesComponentMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.example.smarthotelroomservice.RoomComponentRequest,
                grpc.example.smarthotelroomservice.RoomComponentUpdate>(
                  this, METHODID_ROOM_SERVICES_COMPONENT)))
          .build();
    }
  }

  /**
   */
  public static final class SmartHotelRoomServiceStub extends io.grpc.stub.AbstractStub<SmartHotelRoomServiceStub> {
    private SmartHotelRoomServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartHotelRoomServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartHotelRoomServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartHotelRoomServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC method to subscribe for room service updates
     * </pre>
     */
    public void subscribeForRoomServicesUpdates(grpc.example.smarthotelroomservice.RoomServiceRequest request,
        io.grpc.stub.StreamObserver<grpc.example.smarthotelroomservice.RoomServiceUpdate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeForRoomServicesUpdatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RPC method to stream updates on room components
     * </pre>
     */
    public void roomServicesComponent(grpc.example.smarthotelroomservice.RoomComponentRequest request,
        io.grpc.stub.StreamObserver<grpc.example.smarthotelroomservice.RoomComponentUpdate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getRoomServicesComponentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SmartHotelRoomServiceBlockingStub extends io.grpc.stub.AbstractStub<SmartHotelRoomServiceBlockingStub> {
    private SmartHotelRoomServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartHotelRoomServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartHotelRoomServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartHotelRoomServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC method to subscribe for room service updates
     * </pre>
     */
    public java.util.Iterator<grpc.example.smarthotelroomservice.RoomServiceUpdate> subscribeForRoomServicesUpdates(
        grpc.example.smarthotelroomservice.RoomServiceRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeForRoomServicesUpdatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RPC method to stream updates on room components
     * </pre>
     */
    public java.util.Iterator<grpc.example.smarthotelroomservice.RoomComponentUpdate> roomServicesComponent(
        grpc.example.smarthotelroomservice.RoomComponentRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getRoomServicesComponentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SmartHotelRoomServiceFutureStub extends io.grpc.stub.AbstractStub<SmartHotelRoomServiceFutureStub> {
    private SmartHotelRoomServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartHotelRoomServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartHotelRoomServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartHotelRoomServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SUBSCRIBE_FOR_ROOM_SERVICES_UPDATES = 0;
  private static final int METHODID_ROOM_SERVICES_COMPONENT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartHotelRoomServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartHotelRoomServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE_FOR_ROOM_SERVICES_UPDATES:
          serviceImpl.subscribeForRoomServicesUpdates((grpc.example.smarthotelroomservice.RoomServiceRequest) request,
              (io.grpc.stub.StreamObserver<grpc.example.smarthotelroomservice.RoomServiceUpdate>) responseObserver);
          break;
        case METHODID_ROOM_SERVICES_COMPONENT:
          serviceImpl.roomServicesComponent((grpc.example.smarthotelroomservice.RoomComponentRequest) request,
              (io.grpc.stub.StreamObserver<grpc.example.smarthotelroomservice.RoomComponentUpdate>) responseObserver);
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

  private static abstract class SmartHotelRoomServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartHotelRoomServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.example.smarthotelroomservice.RoomService2.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartHotelRoomService");
    }
  }

  private static final class SmartHotelRoomServiceFileDescriptorSupplier
      extends SmartHotelRoomServiceBaseDescriptorSupplier {
    SmartHotelRoomServiceFileDescriptorSupplier() {}
  }

  private static final class SmartHotelRoomServiceMethodDescriptorSupplier
      extends SmartHotelRoomServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartHotelRoomServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SmartHotelRoomServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartHotelRoomServiceFileDescriptorSupplier())
              .addMethod(getSubscribeForRoomServicesUpdatesMethod())
              .addMethod(getRoomServicesComponentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
