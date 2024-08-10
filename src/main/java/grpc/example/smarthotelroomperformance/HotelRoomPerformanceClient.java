package grpc.example.smarthotelroomperformance;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class HotelRoomPerformanceClient {

    private final ManagedChannel channel;
    private final HotelRoomPerformanceGrpc.HotelRoomPerformanceStub asyncStub;

    // Constructor to initialize the gRPC channel and stub
    public HotelRoomPerformanceClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.asyncStub = HotelRoomPerformanceGrpc.newStub(channel);
    }

    // Method to adjust the room settings using client streaming
    public void adjustRoomSettings() throws InterruptedException {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        final Set<String> messages = new HashSet<>();

        // StreamObserver for handling responses from the server
        StreamObserver<SettingRoomRequest> requestObserver = asyncStub.adjustRoomSettings(new StreamObserver<SettingRoomResponse>() {
            @Override
            public void onNext(SettingRoomResponse response) {
                messages.add(response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in adjusting the Room Settings: " + t);
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                // Print  messages
                System.out.println("Message: " + String.join("; ", messages));
                System.out.println("All the settings have been adjusted in the room.");
                finishLatch.countDown();
            }
        });

        try {
            // Sending the requests to adjust room settings (lights, temperature)
            requestObserver.onNext(SettingRoomRequest.newBuilder().setSettingType("Temperature").setValue("22").build());
            requestObserver.onNext(SettingRoomRequest.newBuilder().setSettingType("Lights").setValue("On").build());
            requestObserver.onCompleted();
        } catch (RuntimeException e) {
            // Handling errors during the request
            requestObserver.onError(e);
            throw e;
        }

        // Waiting for the response after one minute
        if (!finishLatch.await(1, TimeUnit.MINUTES)) {
            System.err.println("adjustRoomSettings did not finish within 1 minute");
        }
    }

    // Method to control room features using bidirectional streaming
    public void controlRoomFeatures() throws InterruptedException {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        final Set<String> messages = new HashSet<>();

        // Using StreamObserver to handle the response from the server 
        StreamObserver<ControlRoomRequest> requestObserver = asyncStub.controlRoomFeatures(new StreamObserver<ControlRoomResponse>() {
            @Override
            public void onNext(ControlRoomResponse response) {
                String message = (response.getErrorMessage() == null || response.getErrorMessage().isEmpty())
                        ? "Room features applied successfully."
                        : "Error: " + response.getErrorMessage();

                messages.add(message);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("There was a problem in controlling the RoomFeatures: " + t);
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                // Print unique messages
                System.out.println("Message: " + String.join("; ", messages));
                System.out.println("All controls have been applied in the hotel room.");
                finishLatch.countDown();
            }
        });

        try {
            // Sending requests to control room features (Air conditions and curtains)
            requestObserver.onNext(ControlRoomRequest.newBuilder().setControlType("AirConditioner").setAction("TurnOn").build());
            requestObserver.onNext(ControlRoomRequest.newBuilder().setControlType("Curtains").setAction("Open").build());
            requestObserver.onCompleted();
        } catch (RuntimeException e) {
            // Handling errors
            requestObserver.onError(e);
            throw e;
        }

        // Waiting for the response after 1 minute
        if (!finishLatch.await(1, TimeUnit.MINUTES)) {
            System.err.println("controlRoomFeatures did not finish within 1 minute");
        }
    }

    // Method to shut down the gRPC channel
    public void shutdown() {
        if (channel != null && !channel.isShutdown()) {
            channel.shutdown();
            try {
                if (!channel.awaitTermination(5, TimeUnit.SECONDS)) {
                    channel.shutdownNow();
                }
            } catch (InterruptedException e) {
                channel.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    // Main method for running the client
    public static void main(String[] args) {
        HotelRoomPerformanceClient client = new HotelRoomPerformanceClient("localhost", 8080);
        try {
            client.adjustRoomSettings();
            client.controlRoomFeatures();
        } catch (InterruptedException e) {
            System.err.println("Operation was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            client.shutdown();
        }
    }
}
