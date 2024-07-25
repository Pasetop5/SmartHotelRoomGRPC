package grpc.example.smarthotelroomservice;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class SmartHotelRoomServiceClient {
	

	// the ayncStub will be making non-blockin grpc calling

    private final SmartHotelRoomServiceGrpc.SmartHotelRoomServiceStub asyncStub;

   
    // to create the constuctor that will intialize the async stub to chanell
    public SmartHotelRoomServiceClient(ManagedChannel channel) {
    	
        asyncStub = SmartHotelRoomServiceGrpc.newStub(channel);
    }

    // the method to subscribe for updates for the room services 
    public void subscribeForRoomServicesUpdates(String roomId) throws InterruptedException {
    	
    	// passing the request massage into new builder in order to suscribe to room services updates
        RoomComponentRequest request = RoomComponentRequest.newBuilder()
        		.setRoomid(roomId) //setting the room id in the request
        		.build(); 
        
        // using latch to wait for the response stream to be completed
        CountDownLatch finishLatch = new CountDownLatch(1);

        
        // Observer will be handling the incoming responses
        StreamObserver<RoomComponentUpdate> responseObserver = new StreamObserver<RoomComponentUpdate>() {
            @Override
            public void onNext(RoomComponentUpdate value) {
            	 // this will handle each room component update that is received 
                System.out.println("Type: " + value.getType() + ", Status: " + value.getStatus());
            }

            @Override
            public void onError(Throwable t) {
            	// to hold any errors that will occur 
                t.printStackTrace();
                finishLatch.countDown(); // to indicate that it has been completed
            }

            @Override
            public void onCompleted() {
            	// handling the completion
            	
                System.out.println("Room updates have been received.");
                finishLatch.countDown(); // to show that the stream has ended 
            }
        };

        
        // making the asyncStub call to subscribe for the updates for the room services 
        asyncStub.roomServicesComponent(request, responseObserver); 
        
        // Setting the response to a time out after 1 minutes or wait for a response
        finishLatch.await(1, TimeUnit.MINUTES);
    }

    public static void main(String[] args) throws InterruptedException {
    	// create a new channel to local host and port 
    	
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50057)
                .usePlaintext() 
                .build();

        SmartHotelRoomServiceClient client = new SmartHotelRoomServiceClient(channel);
        
        // suscribing for room updates for room id 101
        System.out.println("Subscribing for updates for room service");
        client.subscribeForRoomServicesUpdates("101");

        
        // to sut down the channel and wait for the termination
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
}        
  
