package grpc.example.smarthotelroomperformance;

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
    comments = "Source: SmartHotelRoomPerformance.proto")
public final class HotelRoomPerformanceGrpc {

  private HotelRoomPerformanceGrpc() {}

  public static final String SERVICE_NAME = "grpc.example.smarthotelroomperformance.HotelRoomPerformance";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.example.smarthotelroomperformance.SettingRoomRequest,
      grpc.example.smarthotelroomperformance.SettingRoomResponse> getAdjustRoomSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AdjustRoomSettings",
      requestType = grpc.example.smarthotelroomperformance.SettingRoomRequest.class,
      responseType = grpc.example.smarthotelroomperformance.SettingRoomResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.example.smarthotelroomperformance.SettingRoomRequest,
      grpc.example.smarthotelroomperformance.SettingRoomResponse> getAdjustRoomSettingsMethod() {
    io.grpc.MethodDescriptor<grpc.example.smarthotelroomperformance.SettingRoomRequest, grpc.example.smarthotelroomperformance.SettingRoomResponse> getAdjustRoomSettingsMethod;
    if ((getAdjustRoomSettingsMethod = HotelRoomPerformanceGrpc.getAdjustRoomSettingsMethod) == null) {
      synchronized (HotelRoomPerformanceGrpc.class) {
        if ((getAdjustRoomSettingsMethod = HotelRoomPerformanceGrpc.getAdjustRoomSettingsMethod) == null) {
          HotelRoomPerformanceGrpc.getAdjustRoomSettingsMethod = getAdjustRoomSettingsMethod = 
              io.grpc.MethodDescriptor.<grpc.example.smarthotelroomperformance.SettingRoomRequest, grpc.example.smarthotelroomperformance.SettingRoomResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.example.smarthotelroomperformance.HotelRoomPerformance", "AdjustRoomSettings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.smarthotelroomperformance.SettingRoomRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.smarthotelroomperformance.SettingRoomResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HotelRoomPerformanceMethodDescriptorSupplier("AdjustRoomSettings"))
                  .build();
          }
        }
     }
     return getAdjustRoomSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.example.smarthotelroomperformance.ControlRoomRequest,
      grpc.example.smarthotelroomperformance.ControlRoomResponse> getControlRoomFeaturesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ControlRoomFeatures",
      requestType = grpc.example.smarthotelroomperformance.ControlRoomRequest.class,
      responseType = grpc.example.smarthotelroomperformance.ControlRoomResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.example.smarthotelroomperformance.ControlRoomRequest,
      grpc.example.smarthotelroomperformance.ControlRoomResponse> getControlRoomFeaturesMethod() {
    io.grpc.MethodDescriptor<grpc.example.smarthotelroomperformance.ControlRoomRequest, grpc.example.smarthotelroomperformance.ControlRoomResponse> getControlRoomFeaturesMethod;
    if ((getControlRoomFeaturesMethod = HotelRoomPerformanceGrpc.getControlRoomFeaturesMethod) == null) {
      synchronized (HotelRoomPerformanceGrpc.class) {
        if ((getControlRoomFeaturesMethod = HotelRoomPerformanceGrpc.getControlRoomFeaturesMethod) == null) {
          HotelRoomPerformanceGrpc.getControlRoomFeaturesMethod = getControlRoomFeaturesMethod = 
              io.grpc.MethodDescriptor.<grpc.example.smarthotelroomperformance.ControlRoomRequest, grpc.example.smarthotelroomperformance.ControlRoomResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.example.smarthotelroomperformance.HotelRoomPerformance", "ControlRoomFeatures"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.smarthotelroomperformance.ControlRoomRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.example.smarthotelroomperformance.ControlRoomResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HotelRoomPerformanceMethodDescriptorSupplier("ControlRoomFeatures"))
                  .build();
          }
        }
     }
     return getControlRoomFeaturesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HotelRoomPerformanceStub newStub(io.grpc.Channel channel) {
    return new HotelRoomPerformanceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HotelRoomPerformanceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HotelRoomPerformanceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HotelRoomPerformanceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HotelRoomPerformanceFutureStub(channel);
  }

  /**
   */
  public static abstract class HotelRoomPerformanceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.example.smarthotelroomperformance.SettingRoomRequest> adjustRoomSettings(
        io.grpc.stub.StreamObserver<grpc.example.smarthotelroomperformance.SettingRoomResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAdjustRoomSettingsMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.example.smarthotelroomperformance.ControlRoomRequest> controlRoomFeatures(
        io.grpc.stub.StreamObserver<grpc.example.smarthotelroomperformance.ControlRoomResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getControlRoomFeaturesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAdjustRoomSettingsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.example.smarthotelroomperformance.SettingRoomRequest,
                grpc.example.smarthotelroomperformance.SettingRoomResponse>(
                  this, METHODID_ADJUST_ROOM_SETTINGS)))
          .addMethod(
            getControlRoomFeaturesMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.example.smarthotelroomperformance.ControlRoomRequest,
                grpc.example.smarthotelroomperformance.ControlRoomResponse>(
                  this, METHODID_CONTROL_ROOM_FEATURES)))
          .build();
    }
  }

  /**
   */
  public static final class HotelRoomPerformanceStub extends io.grpc.stub.AbstractStub<HotelRoomPerformanceStub> {
    private HotelRoomPerformanceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HotelRoomPerformanceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HotelRoomPerformanceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HotelRoomPerformanceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.example.smarthotelroomperformance.SettingRoomRequest> adjustRoomSettings(
        io.grpc.stub.StreamObserver<grpc.example.smarthotelroomperformance.SettingRoomResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAdjustRoomSettingsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.example.smarthotelroomperformance.ControlRoomRequest> controlRoomFeatures(
        io.grpc.stub.StreamObserver<grpc.example.smarthotelroomperformance.ControlRoomResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getControlRoomFeaturesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class HotelRoomPerformanceBlockingStub extends io.grpc.stub.AbstractStub<HotelRoomPerformanceBlockingStub> {
    private HotelRoomPerformanceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HotelRoomPerformanceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HotelRoomPerformanceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HotelRoomPerformanceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class HotelRoomPerformanceFutureStub extends io.grpc.stub.AbstractStub<HotelRoomPerformanceFutureStub> {
    private HotelRoomPerformanceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HotelRoomPerformanceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HotelRoomPerformanceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HotelRoomPerformanceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ADJUST_ROOM_SETTINGS = 0;
  private static final int METHODID_CONTROL_ROOM_FEATURES = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HotelRoomPerformanceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HotelRoomPerformanceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADJUST_ROOM_SETTINGS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.adjustRoomSettings(
              (io.grpc.stub.StreamObserver<grpc.example.smarthotelroomperformance.SettingRoomResponse>) responseObserver);
        case METHODID_CONTROL_ROOM_FEATURES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.controlRoomFeatures(
              (io.grpc.stub.StreamObserver<grpc.example.smarthotelroomperformance.ControlRoomResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HotelRoomPerformanceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HotelRoomPerformanceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.example.smarthotelroomperformance.RoomPerformance3.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HotelRoomPerformance");
    }
  }

  private static final class HotelRoomPerformanceFileDescriptorSupplier
      extends HotelRoomPerformanceBaseDescriptorSupplier {
    HotelRoomPerformanceFileDescriptorSupplier() {}
  }

  private static final class HotelRoomPerformanceMethodDescriptorSupplier
      extends HotelRoomPerformanceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HotelRoomPerformanceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HotelRoomPerformanceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HotelRoomPerformanceFileDescriptorSupplier())
              .addMethod(getAdjustRoomSettingsMethod())
              .addMethod(getControlRoomFeaturesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
