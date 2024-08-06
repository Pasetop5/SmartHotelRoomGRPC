package grpc.example.smarthotelroomperformance;

import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class HotelRoomPerformanceServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new HotelRoomPerformanceServiceImpl())
                .build();

        try {
            server.start();
            System.out.println("Server started on port 8080");
            server.awaitTermination();
        } catch (IOException e) {
            System.err.println("Server failed to start: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Server interrupted: " + e.getMessage());
        }
    }

    static class HotelRoomPerformanceServiceImpl extends HotelRoomPerformanceGrpc.HotelRoomPerformanceImplBase {

        @Override
        public StreamObserver<SettingRoomRequest> adjustRoomSettings(StreamObserver<SettingRoomResponse> responseObserver) {
            return new StreamObserver<SettingRoomRequest>() {
                StringBuilder responseMessageBuilder = new StringBuilder();

                @Override
                public void onNext(SettingRoomRequest request) {
                    // Process each setting request
                    responseMessageBuilder.append("Setting ")
                            .append(request.getSettingType())
                            .append(" adjusted to ")
                            .append(request.getValue())
                            .append("; ");
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error in adjustRoomSettings: " + t);
                }

                @Override
                public void onCompleted() {
                    // Send only one response after processing all requests
                    SettingRoomResponse response = SettingRoomResponse.newBuilder()
                            .setMessage(responseMessageBuilder.toString())
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            };
        }

        @Override
        public StreamObserver<ControlRoomRequest> controlRoomFeatures(StreamObserver<ControlRoomResponse> responseObserver) {
            return new StreamObserver<ControlRoomRequest>() {
                @Override
                public void onNext(ControlRoomRequest request) {
                    // Process the control request
                    String status = "Success";
                    String errorMessage = "";
                    if (request.getControlType().isEmpty()) {
                        status = "Failed";
                        errorMessage = "The control type is empty";
                    }
                    ControlRoomResponse response = ControlRoomResponse.newBuilder()
                            .setStatus(status)
                            .setErrorMessage(errorMessage)
                            .build();
                    responseObserver.onNext(response);
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Error in controlRoomFeatures: " + t);
                }

                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();
                }
            };
        }
    }
}
