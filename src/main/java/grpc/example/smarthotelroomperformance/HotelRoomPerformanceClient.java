package grpc.example.smarthotelroomperformance;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class HotelRoomPerformanceClient {

    private final ManagedChannel channel;
    private final HotelRoomPerformanceGrpc.HotelRoomPerformanceStub asyncStub;

    public HotelRoomPerformanceClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.asyncStub = HotelRoomPerformanceGrpc.newStub(channel);
    }

    public void adjustRoomSettings() throws InterruptedException {
        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<SettingRoomRequest> requestObserver = asyncStub.adjustRoomSettings(new StreamObserver<SettingRoomResponse>() {
            @Override
            public void onNext(SettingRoomResponse response) {
                System.out.println("Response: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in adjusting the Room Settings: " + t);
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("All the settings have been adjusted in the room.");
                finishLatch.countDown();
            }
        });

        try {
            requestObserver.onNext(SettingRoomRequest.newBuilder().setSettingType("Temperature").setValue("22").build());
            requestObserver.onNext(SettingRoomRequest.newBuilder().setSettingType("Lights").setValue("On").build());
            requestObserver.onCompleted();
        } catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
        }

        if (!finishLatch.await(1, TimeUnit.MINUTES)) {
            System.err.println("adjustRoomSettings did not finish within 1 minute");
        }
    }

    public void controlRoomFeatures() throws InterruptedException {
        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<ControlRoomRequest> requestObserver = asyncStub.controlRoomFeatures(new StreamObserver<ControlRoomResponse>() {
            @Override
            public void onNext(ControlRoomResponse response) {
                String errorMessage = response.getErrorMessage();
                if (errorMessage == null || errorMessage.isEmpty()) {
                    errorMessage = "There were no errors.";
                }
                System.out.println("Response: Status=" + response.getStatus() + ", ErrorMessage=" + errorMessage);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error in controlRoomFeatures: " + t);
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("All controls have been applied in the room.");
                finishLatch.countDown();
            }
        });

        try {
            requestObserver.onNext(ControlRoomRequest.newBuilder().setControlType("AirConditioner").setAction("TurnOn").build());
            requestObserver.onNext(ControlRoomRequest.newBuilder().setControlType("Curtains").setAction("Open").build());
            requestObserver.onCompleted();
        } catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
        }

        if (!finishLatch.await(1, TimeUnit.MINUTES)) {
            System.err.println("controlRoomFeatures did not finish within 1 minute");
        }
    }

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
