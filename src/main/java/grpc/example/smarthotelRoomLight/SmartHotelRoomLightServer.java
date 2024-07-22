package grpc.example.smarthotelRoomLight;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

import java.util.logging.Logger;

import io.grpc.stub.StreamObserver;


public class SmartHotelRoomLightServer  extends SmartHotelRoomLightGrpc.SmartHotelRoomLightImplBase {
	
	private static final Logger logger = Logger.getLogger(SmartHotelRoomLightServer.class.getName());
	
	
public static void main (String [] args) {
	
	SmartHotelRoomLightServer lightServer = new SmartHotelRoomLightServer(); //creating a new instance of lightserver
	
	int port =50051; // the port we are using 
	
	try {
		Server server = ServerBuilder.forPort(port)
				.addService(lightServer)
				.build()
				.start();
		logger.info("Server started, listening on " + port); // print stament using logger 
		
        server.awaitTermination();
    } catch (IOException | InterruptedException e) {
    	 logger.severe(" There was an error  when starting the server: " + e.getMessage()); // print statement using logger
    }
}
	
	@Override
	   public void turnonLights(LightRequest request, StreamObserver<LightResponse> responseObserver) {
        logger.info("Received TurnonLights request for: " + request.getRoomarea());
		
		// to turn on the light
		
		boolean success = true; // to show that it is successful
		
		LightResponse response = LightResponse.newBuilder()
				.setSuccess(success)
				.build();
	
		responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
		
	@Override
    public void turnoffLights(LightRequest request, StreamObserver<LightResponse> responseObserver) {
		logger.info("Received TurnoffLights request for: " + request.getRoomarea());

       
		// to turn off the light
		
		
        boolean success = true; // to show that it is successful

        LightResponse response = LightResponse.newBuilder()
                .setSuccess(success)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}