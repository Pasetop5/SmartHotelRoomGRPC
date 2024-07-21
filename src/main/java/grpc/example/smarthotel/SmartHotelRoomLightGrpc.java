package grpc.example.smarthotel;

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
 * <pre>
 * The service for the smart room which is to control the light
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: SmartHotelRoomLight.proto")
public final class SmartHotelRoomLightGrpc {

  private SmartHotelRoomLightGrpc() {}

  public static final String SERVICE_NAME = "SmartHotelRoom.SmartHotelRoomLight";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.example.smarthotel.LightRequest,
      grpc.example.smarthotel.LightResponse> getTurnonLightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TurnonLights",
      requestType = grpc.example.smarthotel.LightRequest.class,
      responseType = grpc.example.smarthotel.LightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.example.smarthotel.LightRequest,
      grpc.example.smarthotel.LightResponse> getTurnonLightsMethod() {
    io.grpc.MethodDescriptor<grpc.example.smarthotel.LightRequest, grpc.example.smarthotel.LightResponse> getTurnonLightsMethod;
    if ((getTurnonLightsMethod = SmartHotelRoomLightGrpc.getTurnonLightsMethod) == null) {
      synchronized (SmartHotelRoomLightGrpc.class) {
        if ((getTurnonLightsMethod = SmartHotelRoomLightGrpc.getTurnonLightsMethod) == null) {
          SmartHotelRoomLightGrpc.getTurnonLightsMethod = getTurnonLightsMethod = 
              io.grpc.MethodDescriptor.<grpc.example.smarthotel.LightRequest, grpc.example.smarthotel.LightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SmartHotelRoom.SmartHotelRoomLight", "TurnonLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.smarthotel.LightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.smarthotel.LightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartHotelRoomLightMethodDescriptorSupplier("TurnonLights"))
                  .build();
          }
        }
     }
     return getTurnonLightsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.example.smarthotel.LightRequest,
      grpc.example.smarthotel.LightResponse> getTurnoffLightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TurnoffLights",
      requestType = grpc.example.smarthotel.LightRequest.class,
      responseType = grpc.example.smarthotel.LightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.example.smarthotel.LightRequest,
      grpc.example.smarthotel.LightResponse> getTurnoffLightsMethod() {
    io.grpc.MethodDescriptor<grpc.example.smarthotel.LightRequest, grpc.example.smarthotel.LightResponse> getTurnoffLightsMethod;
    if ((getTurnoffLightsMethod = SmartHotelRoomLightGrpc.getTurnoffLightsMethod) == null) {
      synchronized (SmartHotelRoomLightGrpc.class) {
        if ((getTurnoffLightsMethod = SmartHotelRoomLightGrpc.getTurnoffLightsMethod) == null) {
          SmartHotelRoomLightGrpc.getTurnoffLightsMethod = getTurnoffLightsMethod = 
              io.grpc.MethodDescriptor.<grpc.example.smarthotel.LightRequest, grpc.example.smarthotel.LightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SmartHotelRoom.SmartHotelRoomLight", "TurnoffLights"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.smarthotel.LightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.smarthotel.LightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartHotelRoomLightMethodDescriptorSupplier("TurnoffLights"))
                  .build();
          }
        }
     }
     return getTurnoffLightsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartHotelRoomLightStub newStub(io.grpc.Channel channel) {
    return new SmartHotelRoomLightStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartHotelRoomLightBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartHotelRoomLightBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartHotelRoomLightFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartHotelRoomLightFutureStub(channel);
  }

  /**
   * <pre>
   * The service for the smart room which is to control the light
   * </pre>
   */
  public static abstract class SmartHotelRoomLightImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * RPC to turn on the light
     * </pre>
     */
    public void turnonLights(grpc.example.smarthotel.LightRequest request,
        io.grpc.stub.StreamObserver<grpc.example.smarthotel.LightResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTurnonLightsMethod(), responseObserver);
    }

    /**
     * <pre>
     * RPC to turn off the lights
     * </pre>
     */
    public void turnoffLights(grpc.example.smarthotel.LightRequest request,
        io.grpc.stub.StreamObserver<grpc.example.smarthotel.LightResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTurnoffLightsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTurnonLightsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.example.smarthotel.LightRequest,
                grpc.example.smarthotel.LightResponse>(
                  this, METHODID_TURNON_LIGHTS)))
          .addMethod(
            getTurnoffLightsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.example.smarthotel.LightRequest,
                grpc.example.smarthotel.LightResponse>(
                  this, METHODID_TURNOFF_LIGHTS)))
          .build();
    }
  }

  /**
   * <pre>
   * The service for the smart room which is to control the light
   * </pre>
   */
  public static final class SmartHotelRoomLightStub extends io.grpc.stub.AbstractStub<SmartHotelRoomLightStub> {
    private SmartHotelRoomLightStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartHotelRoomLightStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartHotelRoomLightStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartHotelRoomLightStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC to turn on the light
     * </pre>
     */
    public void turnonLights(grpc.example.smarthotel.LightRequest request,
        io.grpc.stub.StreamObserver<grpc.example.smarthotel.LightResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTurnonLightsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * RPC to turn off the lights
     * </pre>
     */
    public void turnoffLights(grpc.example.smarthotel.LightRequest request,
        io.grpc.stub.StreamObserver<grpc.example.smarthotel.LightResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTurnoffLightsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The service for the smart room which is to control the light
   * </pre>
   */
  public static final class SmartHotelRoomLightBlockingStub extends io.grpc.stub.AbstractStub<SmartHotelRoomLightBlockingStub> {
    private SmartHotelRoomLightBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartHotelRoomLightBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartHotelRoomLightBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartHotelRoomLightBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC to turn on the light
     * </pre>
     */
    public grpc.example.smarthotel.LightResponse turnonLights(grpc.example.smarthotel.LightRequest request) {
      return blockingUnaryCall(
          getChannel(), getTurnonLightsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * RPC to turn off the lights
     * </pre>
     */
    public grpc.example.smarthotel.LightResponse turnoffLights(grpc.example.smarthotel.LightRequest request) {
      return blockingUnaryCall(
          getChannel(), getTurnoffLightsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The service for the smart room which is to control the light
   * </pre>
   */
  public static final class SmartHotelRoomLightFutureStub extends io.grpc.stub.AbstractStub<SmartHotelRoomLightFutureStub> {
    private SmartHotelRoomLightFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartHotelRoomLightFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartHotelRoomLightFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartHotelRoomLightFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * RPC to turn on the light
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.example.smarthotel.LightResponse> turnonLights(
        grpc.example.smarthotel.LightRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTurnonLightsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * RPC to turn off the lights
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.example.smarthotel.LightResponse> turnoffLights(
        grpc.example.smarthotel.LightRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTurnoffLightsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TURNON_LIGHTS = 0;
  private static final int METHODID_TURNOFF_LIGHTS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartHotelRoomLightImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartHotelRoomLightImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TURNON_LIGHTS:
          serviceImpl.turnonLights((grpc.example.smarthotel.LightRequest) request,
              (io.grpc.stub.StreamObserver<grpc.example.smarthotel.LightResponse>) responseObserver);
          break;
        case METHODID_TURNOFF_LIGHTS:
          serviceImpl.turnoffLights((grpc.example.smarthotel.LightRequest) request,
              (io.grpc.stub.StreamObserver<grpc.example.smarthotel.LightResponse>) responseObserver);
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

  private static abstract class SmartHotelRoomLightBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartHotelRoomLightBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.example.smarthotel.SmartHotelRoomLightProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartHotelRoomLight");
    }
  }

  private static final class SmartHotelRoomLightFileDescriptorSupplier
      extends SmartHotelRoomLightBaseDescriptorSupplier {
    SmartHotelRoomLightFileDescriptorSupplier() {}
  }

  private static final class SmartHotelRoomLightMethodDescriptorSupplier
      extends SmartHotelRoomLightBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartHotelRoomLightMethodDescriptorSupplier(String methodName) {
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
      synchronized (SmartHotelRoomLightGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartHotelRoomLightFileDescriptorSupplier())
              .addMethod(getTurnonLightsMethod())
              .addMethod(getTurnoffLightsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
