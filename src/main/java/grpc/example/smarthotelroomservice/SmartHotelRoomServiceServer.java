package grpc.example.smarthotelroomservice;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class SmartHotelRoomServiceServer {

    public static void main(String[] args) throws IOException, InterruptedException {
    	
    	// to create and setup the grpc server 
        Server server = ServerBuilder
                .forPort(50057) // he port in which the server will be listening 
                .addService(new SmartHotelRoomServiceImpl()) // for the implementation of service 
                .build(); // to build the server instance 

        server.start(); //starting the server 
        System.out.println("The Server has started, and is listening on " + server.getPort());

        
        // to shutdown the server 
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down the server");
            try {
                server.shutdown().awaitTermination(45, TimeUnit.SECONDS); // shutting the server after 45 seconds 
            } catch (InterruptedException e) {
                e.printStackTrace(System.err); // to print if an error occurs when shutting down 
            }
        }));

        server.awaitTermination();// waiting until the server is terminated 
    }

    static class SmartHotelRoomServiceImpl extends SmartHotelRoomServiceGrpc.SmartHotelRoomServiceImplBase {

        @Override
        public void subscribeForRoomServicesUpdates(RoomServiceRequest request, StreamObserver<RoomServiceUpdate> responseObserver) {
            // new method to handle the room service updates 
            String[][] updates = {
                    {"order received", "Your order has been received."},
                    {"preparing order", "Your order is being prepared."},
                    {"order completed", "Your order is ready."}
            };

            
            // to iterate over updates so it can be sent to client 
            for (String[] update : updates) {
            	  System.out.println("Processing update: " + Arrays.toString(update)); // Logging
            	  
            	// creating the response mesage 
                if (update.length >= 2) {
                    RoomServiceUpdate response = RoomServiceUpdate.newBuilder()
                            .setStatus(update[0])
                            .setMessage(update[1])
                            .build();
                    responseObserver.onNext(response);
                } else {
                    responseObserver.onError(new IllegalStateException("Update array length is insufficient")); // this will help in case the array we have created is not enough
                    return; // to exit if there is an error 
                }

                try {
                    Thread.sleep(2500); // Using a delay of 2.5 seconds to ensure it goes smoothly
                } catch (InterruptedException e) {
                    e.printStackTrace(); // to print if it is interrupted 
                    Thread.currentThread().interrupt(); // To keep the status
                }
            }

            responseObserver.onCompleted();
        }

        @Override
        public void roomServicesComponent(RoomComponentRequest request, StreamObserver<RoomComponentUpdate> responseObserver) {
            // this will help handle the room compoenets
            String[][] updates = {
                    {"Room Temperature", "The Room temperature is 28 °C"},
                    {"Room Curtains", "The Curtain is Open"},
                    {"Room Entertainment", "The TV is Currently on Supersport"}
            };

            
           // to iterate over updates and send them to the client 
            for (String[] update : updates) {
                System.out.println("Processing update: " + Arrays.toString(update)); // Logging

                if (update.length >= 2) {
                	
                	// to build and send the response 
                    RoomComponentUpdate response = RoomComponentUpdate.newBuilder()
                            .setType(update[0])
                            .setStatus(update[1])
                            .build();
                    responseObserver.onNext(response);
                } else {
                    responseObserver.onError(new IllegalStateException("Update array length is insufficient")); // this will help if the array is not enough 
                    return; // exit method if there is an error 
                }

                try {
                    Thread.sleep(2500); // Using a delay of 2.5 seconds to ensure it goes smoothly
                } catch (InterruptedException e) { // to print if it is interrupted 
                    e.printStackTrace();
                    Thread.currentThread().interrupt(); // Preserve interrupt status
                }
            }

            responseObserver.onCompleted(); // to show that all the updates were sent 
        }
    }
}