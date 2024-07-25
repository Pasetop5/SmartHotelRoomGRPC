package grpc.example.smarthotelRoomLight;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

import java.util.logging.Logger;

import io.grpc.stub.StreamObserver;


public class SmartHotelRoomLightServer  extends SmartHotelRoomLightGrpc.SmartHotelRoomLightImplBase {
	
	/// creating a new instance of logger using for logging messages 
	
	private static final Logger logger = Logger.getLogger(SmartHotelRoomLightServer.class.getName());
	
	
public static void main (String [] args) {
	
	// creating new instance of SmartHotellRoomLightServer
	SmartHotelRoomLightServer lightServer = new SmartHotelRoomLightServer(); //creating a new instance of lightserver
	
	int port =50051; // the port we are using to listen 
	
	try {
		//Building the grpc server 
		Server server = ServerBuilder.forPort(port)
				.addService(lightServer)
				.build()
				.start();
		logger.info("Server started, listening on " + port); // print stament using logger to show that the sever has started successfully
		
        server.awaitTermination();
    } catch (IOException | InterruptedException e) {
    	 logger.severe(" There was an error  when starting the server: " + e.getMessage()); // print statement using logger to show if there is an error 
    }
}
	
	@Override
	   public void turnonLights(LightRequest request, StreamObserver<LightResponse> responseObserver) {
       // to use logger to request for turning on the area at a room area
		
		logger.info("Received TurnonLights request for: " + request.getRoomarea());
	
		
		boolean success = true; // to show that it is successful inturnon the light 
		
		
		// Creating the response to show sucess
		LightResponse response = LightResponse.newBuilder()
				.setSuccess(success)
				.build();
	
		
		// to send the response to the client and show it has been completed 
		responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
		
	@Override
    public void turnoffLights(LightRequest request, StreamObserver<LightResponse> responseObserver) {
		
	    // to use logger to request for turning off the area at a room area
		
		logger.info("Received TurnoffLights request for: " + request.getRoomarea());

       
		// to turn off the light
		
		
        boolean success = true; // to show that it is successful inturnon the light 
        
     // Creating the response to show sucess
        LightResponse response = LightResponse.newBuilder()
                .setSuccess(success)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}