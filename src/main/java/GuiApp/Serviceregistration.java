package GuiApp;

import java.io.IOException;
import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.example.smarthotelRoomLight.SmartHotelRoomLightServer;
import grpc.example.smarthotelroomservice.SmartHotelRoomServiceServer;
import grpc.example.smarthotelroomperformance.HotelRoomPerformanceServer;

public class Serviceregistration {

    public static void main(String[] args) {
        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            //  to register the SmartHotelRoomLight service
            ServiceInfo lightServiceInfo = ServiceInfo.create(
                "_grpc._tcp.local.", // the  Service type for gRPC
                "SmartHotelRoomLight", // the name of the service 
                50051, // Port
                "description=Smart Hotel Room Light Service" // description of the service
            );
            jmdns.registerService(lightServiceInfo);
            System.out.println("Service registered: " + InetAddress.getLocalHost() + " on port: " + lightServiceInfo.getPort());

            //  to register the SmartHotelRoomService service
            ServiceInfo roomServiceInfo = ServiceInfo.create(
                "_grpc._tcp.local.", //  the Service type for gRPC
                "SmartHotelRoomService", // the name of the service 
                50057, // Port
                "description=Smart Hotel Room Service" // Description of the service
            );
            jmdns.registerService(roomServiceInfo);
            System.out.println("Service registered: " + InetAddress.getLocalHost() + " on port: " + roomServiceInfo.getPort());

            // to register the HotelRoomPerformance service
            ServiceInfo performanceServiceInfo = ServiceInfo.create(
                "_grpc._tcp.local.", // the service type for gRPC
                "HotelRoomPerformance", // the name of the Service 
                8080, // Port
                "description=Hotel Room Performance Service" // description of the service 
            );
            jmdns.registerService(performanceServiceInfo);
            System.out.println("Service registered: " + InetAddress.getLocalHost() + " on port: " + performanceServiceInfo.getPort());

            // to start all services in separate threads
            Thread lightServiceThread = new Thread(() -> {
                try {
                    SmartHotelRoomLightServer.main(args);
                } catch (Exception e) {
                    e.printStackTrace(); // to catch any exception that can occur
                }
            });
            Thread roomServiceThread = new Thread(() -> {
                try {
                    SmartHotelRoomServiceServer.main(args);
                } catch (Exception e) {
                    e.printStackTrace(); // to catch any exception that can occur
                }
            });
            Thread performanceServiceThread = new Thread(() -> {
                try {
                    HotelRoomPerformanceServer.main(args);
                } catch (Exception e) {
                    e.printStackTrace(); // to catch any exception that can occur
                }
            });

            lightServiceThread.start();
            roomServiceThread.start();
            performanceServiceThread.start();

            // to keep the main thread alive
            lightServiceThread.join();
            roomServiceThread.join();
            performanceServiceThread.join();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace(); //to  Print stack trace for any exception caught
        }
    }
}
