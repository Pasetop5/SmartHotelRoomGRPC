package GuiApp;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class ServiceDiscovery {

    public static void main(String[] args) {
        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // to Define a listener to handle discovered services
            ServiceListener listener = new ServiceListener() {
                
            	// to call when a service is added
            	@Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Service added: " + event.getInfo());
                    printServiceInfo(event.getInfo());
                }	
            	
            	// to call a service is removed
                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Service removed: " + event.getInfo());
                }


            	// to call a service is resolved
                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Service resolved: " + event.getInfo());
                    printServiceInfo(event.getInfo());
                }

                
                // to print serviceinfo 
                private void printServiceInfo(ServiceInfo info) {
                    System.out.println("Name: " + info.getName());
                    System.out.println("Type: " + info.getType());
                    System.out.println("Description: " + info.getNiceTextString());
                    System.out.println("Port: " + info.getPort());
                    System.out.println("Host: " + info.getHostAddresses()[0]);
                    System.out.println();
                }
            };

            // Add a listener for the _grpc._tcp.local. service type
            jmdns.addServiceListener("_grpc._tcp.local.", listener);

            // Wait for a while to let JmDNS discover services
            Thread.sleep(1500); // Wait for 15 seconds

            // to remove the service listener
            jmdns.removeServiceListener("_grpc._tcp.local.", listener);

        } catch (IOException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace(); //  to Print stack trace for any exception caught
        }
    }
}
