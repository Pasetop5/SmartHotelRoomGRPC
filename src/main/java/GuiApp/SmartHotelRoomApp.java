package GuiApp;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import grpc.example.smarthotelroomservice.RoomComponentRequest;
import grpc.example.smarthotelroomservice.RoomComponentUpdate;
import grpc.example.smarthotelroomservice.RoomServiceRequest;
import grpc.example.smarthotelroomservice.RoomServiceUpdate;
import grpc.example.smarthotelroomservice.SmartHotelRoomServiceGrpc;
import grpc.example.smarthotelroomservice.SmartHotelRoomServiceGrpc.SmartHotelRoomServiceStub;
import grpc.example.smarthotelroomperformance.HotelRoomPerformanceClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import grpc.example.smarthotelRoomLight.LightRequest;
import grpc.example.smarthotelRoomLight.LightResponse;
import grpc.example.smarthotelRoomLight.SmartHotelRoomLightGrpc;
import grpc.example.smarthotelRoomLight.SmartHotelRoomLightGrpc.SmartHotelRoomLightBlockingStub;

public class SmartHotelRoomApp extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea roomServicesTextArea;
    private JTextArea roomComponentsTextArea;
    private JTextArea performanceTextArea;
    private ManagedChannel roomServiceChannel;
    private SmartHotelRoomServiceStub roomServiceStub;
    private HotelRoomPerformanceClient performanceClient;
    
    private JTextField resultForLight;
    private ManagedChannel lightChannel;
    private SmartHotelRoomLightBlockingStub lightBlockingStub;

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
        resultForLight.setBounds(197, 6, 488, 117);
        contentPane.add(resultForLight);
        resultForLight.setColumns(10);

        JToggleButton toggleLightButton = new JToggleButton("Turn light On");
        toggleLightButton.setBounds(6, 46, 147, 16);
        contentPane.add(toggleLightButton);

        // Room Service 
        JLabel lblRoomService = new JLabel("Room Service");
        lblRoomService.setBounds(23, 107, 115, 16);
        contentPane.add(lblRoomService);

        JToggleButton roomServiceButton = new JToggleButton("Provide Updates for Room Service");
        roomServiceButton.setBounds(6, 128, 243, 29);
        contentPane.add(roomServiceButton);

        roomServicesTextArea = new JTextArea();
        roomServicesTextArea.setBounds(169, 169, 503, 170);
        contentPane.add(roomServicesTextArea);
        roomServicesTextArea.setLineWrap(true);
        roomServicesTextArea.setWrapStyleWord(true);

        // Room Component Components
        JLabel lblRoomComponents = new JLabel("Room Components");
        lblRoomComponents.setBounds(17, 347, 147, 16);
        contentPane.add(lblRoomComponents);

        roomComponentsTextArea = new JTextArea();
        roomComponentsTextArea.setBounds(169, 405, 503, 170);
        contentPane.add(roomComponentsTextArea);
        roomComponentsTextArea.setLineWrap(true);
        roomComponentsTextArea.setWrapStyleWord(true);

        JToggleButton roomComponentButton = new JToggleButton("Room features updates");
        roomComponentButton.setBounds(6, 364, 243, 29);
        contentPane.add(roomComponentButton);

        // Room Performance Components
        JLabel lblRoomPerformance = new JLabel("Room Performance");
        lblRoomPerformance.setBounds(6, 582, 147, 16);
        contentPane.add(lblRoomPerformance);

        performanceTextArea = new JTextArea();
        performanceTextArea.setBounds(169, 651, 503, 170);
        contentPane.add(performanceTextArea);
        performanceTextArea.setLineWrap(true);
        performanceTextArea.setWrapStyleWord(true);

        JToggleButton togglePerformanceButton = new JToggleButton("Room Performance communication");
        togglePerformanceButton.setBounds(-1, 610, 250, 29);
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

        roomServiceButton.addActionListener(e -> SwingUtilities.invokeLater(() -> subscribeForRoomServiceUpdates("101")));
        roomComponentButton.addActionListener(e -> SwingUtilities.invokeLater(() -> subscribeForRoomComponentsUpdates("101")));

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

    private void initializeGrpcConnections() {
        String host = "localhost";
        int portRoomService = 50057;
        int portLight = 50051;
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
    
    // to handle light contol

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

    
    // to suscribe to room update
    private void subscribeForRoomServiceUpdates(String roomId) {
        RoomServiceRequest request = RoomServiceRequest.newBuilder().setRoomid(roomId).build();
        final StringBuilder updates = new StringBuilder();

        StreamObserver<RoomServiceUpdate> responseObserver = new StreamObserver<RoomServiceUpdate>() {
            @Override
            public void onNext(RoomServiceUpdate update) {
                updates.append("Service Status: ").append(update.getStatus())
                       .append(", Message: ").append(update.getMessage())
                       .append("\n");
                SwingUtilities.invokeLater(() -> roomServicesTextArea.setText(updates.toString()));
            }

            @Override
            public void onError(Throwable t) {
                logger.log(Level.SEVERE, "Room service update error", t);
                SwingUtilities.invokeLater(() -> roomServicesTextArea.setText("There was an error when receiving updates."));
            }

            @Override
            public void onCompleted() {
                SwingUtilities.invokeLater(() -> roomServicesTextArea.append("Room service updates have been completed."));
            }
        };

        roomServiceStub.subscribeForRoomServicesUpdates(request, responseObserver);
    }

    
    // to sucribe to room component 
    private void subscribeForRoomComponentsUpdates(String roomId) {
        RoomComponentRequest request = RoomComponentRequest.newBuilder().setRoomid(roomId).build();
        final StringBuilder updates = new StringBuilder();

        StreamObserver<RoomComponentUpdate> responseObserver = new StreamObserver<RoomComponentUpdate>() {
            @Override
            public void onNext(RoomComponentUpdate update) {
                updates.append("Component Type: ").append(update.getType())
                       .append(", Status: ").append(update.getStatus())
                       .append("\n");
                SwingUtilities.invokeLater(() -> roomComponentsTextArea.setText(updates.toString()));
            }

            @Override
            public void onError(Throwable t) {
                logger.log(Level.SEVERE, "Room component update error", t);
                SwingUtilities.invokeLater(() -> roomComponentsTextArea.setText("There was an error when receiving updates."));
            }

            @Override
            public void onCompleted() {
                SwingUtilities.invokeLater(() -> roomComponentsTextArea.append("Room component updates have been completed."));
            }
        };

        roomServiceStub.roomServicesComponent(request, responseObserver);
    }

    
    // for room performance
    private void startRoomPerformance() {
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    performanceClient.adjustRoomSettings();
                    performanceClient.controlRoomFeatures();
                } catch (InterruptedException e) {
                    logger.log(Level.SEVERE, "Room performance error", e);
                    SwingUtilities.invokeLater(() -> performanceTextArea.setText("There was an error in room performance settings."));
                    Thread.currentThread().interrupt();
                }
                return null;
            }

            @Override
            protected void done() {
                SwingUtilities.invokeLater(() -> performanceTextArea.setText("The room controls and room features were applied successfully"));
            }
        }.execute();
    }
    
    // to shut down

    private void shutdownGrpcConnections() {
        if (lightChannel != null && !lightChannel.isShutdown()) {
            lightChannel.shutdown();
        }
        if (roomServiceChannel != null && !roomServiceChannel.isShutdown()) {
            roomServiceChannel.shutdown();
        }
        if (performanceClient != null) {
            performanceClient.shutdown();  // to shut down
        }
    }

    @Override
    public void setDefaultCloseOperation(int operation) {
        super.setDefaultCloseOperation(operation);
        shutdownGrpcConnections();
    }
}
