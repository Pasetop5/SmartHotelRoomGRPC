package grpc.example.smarthotelroomperformance;

import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class HotelRoomPerformanceServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080) // Creating and configuring gRPC to port 8080
                .addService(new HotelRoomPerformanceServiceImpl())
                .build();

        try {
            server.start(); // Start the server
            System.out.println("Server started on port 8080");  // Log server start
            server.awaitTermination(); // Keep the server running
        } catch (IOException e) {
            System.err.println("Server failed to start: " + e.getMessage()); // Catch server start failure
        } catch (InterruptedException e) {
            System.err.println("Server interrupted: " + e.getMessage()); // Catch server interruption
        }
    }

    // Methods for smart room performance
    static class HotelRoomPerformanceServiceImpl extends HotelRoomPerformanceGrpc.HotelRoomPerformanceImplBase {

        @Override
        public StreamObserver<SettingRoomRequest> adjustRoomSettings(StreamObserver<SettingRoomResponse> responseObserver) {
            return new StreamObserver<SettingRoomRequest>() {
                StringBuilder responseMessageBuilder = new StringBuilder();

                @Override
                public void onNext(SettingRoomRequest request) {
                    // Process each setting request and append the response message to it
                    responseMessageBuilder.append("Setting ")
                            .append(request.getSettingType())
                            .append(" adjusted to ")
                            .append(request.getValue())
                            .append("; ");
                }

                @Override
                public void onError(Throwable t) {
                    // Catch any error during the process
                    System.err.println("Error in adjustRoomSettings: " + t);
                }

                @Override
                public void onCompleted() {
                    // Send a response after processing all requests
                    SettingRoomResponse response = SettingRoomResponse.newBuilder()
                            .setMessage(responseMessageBuilder.toString())
                            .build();
                    responseObserver.onNext(response); // Sending the response
                    responseObserver.onCompleted(); // Completing the process
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
                        // If the control type is empty, mark as failed and set an error
                        status = "Failed";
                        errorMessage = "The control type is empty";
                    }
                    
                    // Building the response
                    ControlRoomResponse response = ControlRoomResponse.newBuilder()
                            .setStatus(status)
                            .setErrorMessage(errorMessage)
                            .build();
                    responseObserver.onNext(response); // Sending the response
                }

                @Override
                public void onError(Throwable t) {
                    // Handling if there is an error during the stream
                    System.err.println("Error in controlRoomFeatures: " + t);
                }

                @Override
                public void onCompleted() {
                    responseObserver.onCompleted(); // To show completion
                }
            };
        }
    }
}
