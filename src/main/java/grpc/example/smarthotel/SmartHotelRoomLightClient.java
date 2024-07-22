package grpc.example.smarthotel;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import grpc.example.smarthotel.SmartHotelRoomLightGrpc.SmartHotelRoomLightBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class SmartHotelRoomLightClient {
	
	private static final Logger logger = Logger.getLogger(SmartHotelRoomLightClient.class.getName());

	public static void main (String [] args ) throws Exception{
		String host = "localhost"; // using the same port as the server 
		int port = 50051;  // using the same port as the server
		
		   
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        
        SmartHotelRoomLightBlockingStub  blockingstub = SmartHotelRoomLightGrpc.newBlockingStub(channel);
        
        try {
        	
        	// turn on the light with a focus on the hotel room bedroom
        	String roomareaturnon = "Bedroom";
        	LightRequest requestturnon = LightRequest.newBuilder().setRoomarea(roomareaturnon).build();
        	LightResponse responseturnon = blockingstub.turnonLights(requestturnon);
        	
        	logger.info("'Turn on the lights in "  + roomareaturnon + ":" + responseturnon.getSuccess());

            // Turn off the light with a focus on the bathroom
            String roomAreaTurnOff = "Bathroom";
            LightRequest requestTurnOff = LightRequest.newBuilder().setRoomarea(roomAreaTurnOff).build();
            LightResponse responseTurnOff = blockingstub.turnoffLights(requestTurnOff);
            logger.info("Turn off the lights in " + roomAreaTurnOff + ": " + responseTurnOff.getSuccess());

        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;
        } finally {
            // Shutdown channel
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}