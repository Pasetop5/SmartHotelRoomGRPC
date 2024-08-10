package grpc.example.smarthotelroomservice;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class SmartHotelRoomServiceClient {
	
	// the ayncStub will be making non-blockin grpc calling
    private final SmartHotelRoomServiceGrpc.SmartHotelRoomServiceStub asyncStub;

    // Constructor that initializes the asyncStub to the channel
    public SmartHotelRoomServiceClient(ManagedChannel channel) {
        asyncStub = SmartHotelRoomServiceGrpc.newStub(channel);
    }

    // Method to subscribe for updates for the room services 
    public void subscribeForRoomServicesUpdates(String roomId) throws InterruptedException {
    	
        RoomServiceRequest request = RoomServiceRequest.newBuilder()
        		.setRoomid(roomId) // Setting the room ID in the request
        		.build(); 
        
        CountDownLatch finishLatch = new CountDownLatch(1);

        // Observer to handle incoming room service updates
        StreamObserver<RoomServiceUpdate> responseObserver = new StreamObserver<RoomServiceUpdate>() {
            @Override
            public void onNext(RoomServiceUpdate value) {
                // Handle each room service update received
                System.out.println("Status: " + value.getStatus() + ", Message: " + value.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                finishLatch.countDown(); // Indicate completion in case of error
            }

            @Override
            public void onCompleted() {
                System.out.println("Room service updates have been received.");
                finishLatch.countDown(); // Indicate the stream has ended
            }
        };

        // Make the asyncStub call to subscribe for room services updates
        asyncStub.subscribeForRoomServicesUpdates(request, responseObserver);

        finishLatch.await(1, TimeUnit.MINUTES); // Wait for the stream to complete
    }
    
    // Method to subscribe for updates for the room components
    public void subscribeForRoomComponentsUpdates(String roomId) throws InterruptedException {
    	
        RoomComponentRequest request = RoomComponentRequest.newBuilder()
        		.setRoomid(roomId) // Setting the room ID in the request
        		.build(); 
        
        CountDownLatch finishLatch = new CountDownLatch(1);

        // Observer to handle incoming room component updates
        StreamObserver<RoomComponentUpdate> responseObserver = new StreamObserver<RoomComponentUpdate>() {
            @Override
            public void onNext(RoomComponentUpdate value) {
                // Handle each room component update received
                System.out.println("Type: " + value.getType() + ", Status: " + value.getStatus());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
                finishLatch.countDown(); // Indicate completion in case of error
            }

            @Override
            public void onCompleted() {
                System.out.println("Room component updates have been received.");
                finishLatch.countDown(); // Indicate the stream has ended
            }
        };

        // Make the asyncStub call to subscribe for room components updates
        asyncStub.roomServicesComponent(request, responseObserver);

        finishLatch.await(1, TimeUnit.MINUTES); // Wait for the stream to complete
    }

    public static void main(String[] args) throws InterruptedException {
    	// to Create a new channel to localhost and port
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50057)
                .usePlaintext() 
                .build();

        SmartHotelRoomServiceClient client = new SmartHotelRoomServiceClient(channel);
        
        //  to Subscribe for room service updates for room ID 101
        System.out.println("Subscribing for updates for room service");
        client.subscribeForRoomServicesUpdates("101");

        // to Subscribe for room component updates for room ID 101
        System.out.println("Subscribing for updates for room components");
        client.subscribeForRoomComponentsUpdates("101");

        // to Shutdown the channel and wait for termination
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
}        
