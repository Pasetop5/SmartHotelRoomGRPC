package GuiApp;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import grpc.example.smarthotelRoomLight.LightRequest;
import grpc.example.smarthotelRoomLight.LightResponse;
import grpc.example.smarthotelRoomLight.SmartHotelRoomLightGrpc;
import grpc.example.smarthotelRoomLight.SmartHotelRoomLightGrpc.SmartHotelRoomLightBlockingStub;
import grpc.example.smarthotelroomservice.RoomComponentRequest;
import grpc.example.smarthotelroomservice.RoomComponentUpdate;
import grpc.example.smarthotelroomservice.SmartHotelRoomServiceGrpc;
import grpc.example.smarthotelroomservice.SmartHotelRoomServiceGrpc.SmartHotelRoomServiceStub;
import grpc.example.smarthotelroomperformance.HotelRoomPerformanceClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class SmartHotelRoomApp extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField resultForLight;
    private JTextField roomServicesButton;
    private JTextField performanceTextField;
    private ManagedChannel lightChannel;
    private ManagedChannel roomServiceChannel;
    private SmartHotelRoomLightBlockingStub lightBlockingStub;
    private SmartHotelRoomServiceStub roomServiceStub;
    private HotelRoomPerformanceClient performanceClient;
    private static final Logger logger = Logger.getLogger(SmartHotelRoomApp.class.getName());

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SmartHotelRoomApp frame = new SmartHotelRoomApp();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SmartHotelRoomApp() {
        setTitle("SmartHotelRoomApp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 900);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Light Control Components
        JLabel lblLightController = new JLabel("Light Controller");
        lblLightController.setBounds(6, 18, 115, 16);
        contentPane.add(lblLightController);

        resultForLight = new JTextField();
        resultForLight.setBounds(184, 36, 488, 117);
        contentPane.add(resultForLight);
        resultForLight.setColumns(10);

        JToggleButton toggleLightButton = new JToggleButton("Turn light On");
        toggleLightButton.setBounds(6, 46, 147, 16);
        contentPane.add(toggleLightButton);

        // Room Service Components
        JLabel lblRoomService = new JLabel("Room Service");
        lblRoomService.setBounds(6, 157, 115, 16);
        contentPane.add(lblRoomService);

        JToggleButton roomServiceButton = new JToggleButton("Provide Updates for Room Service");
        roomServiceButton.setBounds(6, 185, 243, 29);
        contentPane.add(roomServiceButton);

        roomServicesButton = new JTextField();
        roomServicesButton.setBounds(169, 226, 503, 170);
        contentPane.add(roomServicesButton);
        roomServicesButton.setColumns(10);

        // Room Performance Components
        JLabel lblRoomPerformance = new JLabel("Room Performance");
        lblRoomPerformance.setBounds(6, 413, 147, 16);
        contentPane.add(lblRoomPerformance);

        performanceTextField = new JTextField();
        performanceTextField.setBounds(174, 495, 533, 170);
        contentPane.add(performanceTextField);
        performanceTextField.setColumns(10);

        JToggleButton togglePerformanceButton = new JToggleButton("Room Performance communication");
        togglePerformanceButton.setBounds(0, 454, 250, 29);
        contentPane.add(togglePerformanceButton);

        // Event Listeners
        toggleLightButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            if (toggleLightButton.isSelected()) {
                handleLightControl("Bedroom", true);
                toggleLightButton.setText("Turn light Off");
            } else {
                handleLightControl("Bedroom", false);
                toggleLightButton.setText("Turn light On");
            }
        }));

        roomServiceButton.addActionListener(e -> SwingUtilities.invokeLater(() ->
            subscribeForRoomServiceUpdates("101")));

        togglePerformanceButton.addActionListener(e -> SwingUtilities.invokeLater(() -> {
            if (togglePerformanceButton.isSelected()) {
                startRoomPerformance();
                togglePerformanceButton.setText("Stop Room Performance");
            } else {
                togglePerformanceButton.setText("Room Performance communication");
            }
        }));

        // Initialize gRPC Connections
        initializeGrpcConnections();
    }

    // Initializing gRPC connections for the light, room service, and performance components
    private void initializeGrpcConnections() {
        String host = "localhost";
        int portLight = 50051;
        int portRoomService = 50057;
        int portPerformance = 8080;

        // Setting gRPC for light control
        lightChannel = ManagedChannelBuilder.forAddress(host, portLight)
                .usePlaintext()
                .build();
        lightBlockingStub = SmartHotelRoomLightGrpc.newBlockingStub(lightChannel);

        // Setting gRPC for room service
        roomServiceChannel = ManagedChannelBuilder.forAddress(host, portRoomService)
                .usePlaintext()
                .build();
        roomServiceStub = SmartHotelRoomServiceGrpc.newStub(roomServiceChannel);

        // Setting gRPC for room performance
        performanceClient = new HotelRoomPerformanceClient(host, portPerformance);
    }

    // Handling the control for turning on and off the light
    private void handleLightControl(String roomArea, boolean turnOn) {
        LightRequest request = LightRequest.newBuilder().setRoomarea(roomArea).build();
        LightResponse response;
        try {
            if (turnOn) {
                response = lightBlockingStub.turnonLights(request);
                SwingUtilities.invokeLater(() -> resultForLight.setText("The light has been turned on in the " + roomArea ));
            } else {
                response = lightBlockingStub.turnoffLights(request);
                SwingUtilities.invokeLater(() -> resultForLight.setText("The light has been turned off in the " + roomArea ));
            }
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            SwingUtilities.invokeLater(() -> resultForLight.setText("RPC failed: " + e.getStatus()));
        }
    }

    // Subscribing for room service updates
    private void subscribeForRoomServiceUpdates(String roomId) {
        RoomComponentRequest request = RoomComponentRequest.newBuilder().setRoomid(roomId).build();
        final StringBuilder updates = new StringBuilder();

        StreamObserver<RoomComponentUpdate> responseObserver = new StreamObserver<RoomComponentUpdate>() {
            @Override
            public void onNext(RoomComponentUpdate update) {
                updates.append("Type: ").append(update.getType())
                       .append(", Status: ").append(update.getStatus())
                       .append("\n");
                SwingUtilities.invokeLater(() -> roomServicesButton.setText(updates.toString()));
            }

            @Override
            public void onError(Throwable t) {
                logger.log(Level.SEVERE, "Room service update error", t);
                SwingUtilities.invokeLater(() -> roomServicesButton.setText("There was an error when receiving updates."));
            }

            @Override
            public void onCompleted() {
                SwingUtilities.invokeLater(() -> roomServicesButton.setText("The Room updates has been completed."));
            }
        };

        roomServiceStub.roomServicesComponent(request, responseObserver);
    }

    // Start room performance operations using SwingWorker
    private void startRoomPerformance() {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    performanceClient.adjustRoomSettings();
                    performanceClient.controlRoomFeatures();
                } catch (InterruptedException e) {
                    logger.log(Level.SEVERE, "Room performance error", e);
                    SwingUtilities.invokeLater(() -> performanceTextField.setText("There was an error in room performance settings."));
                    Thread.currentThread().interrupt();
                }
                return null;
            }

            @Override
            protected void done() {
                SwingUtilities.invokeLater(() -> performanceTextField.setText("The room contols and room features was applied successfully"));
            }
        }.execute();
    }

    // Shutdown gRPC channels and other resources
    private void shutdownGrpcConnections() {
        if (lightChannel != null && !lightChannel.isShutdown()) {
            lightChannel.shutdown();
        }
        if (roomServiceChannel != null && !roomServiceChannel.isShutdown()) {
            roomServiceChannel.shutdown();
        }
        if (performanceClient != null) {
            performanceClient.shutdown();  // to shut downent
        }
    }

    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(operation);
        shutdownGrpcConnections();
    }
}