package com.example.carrental;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewVehiclesGUI {
    private JFrame frame;
    private JButton nextButton;
    private JLabel displayLabel;
    private VehicleInventory inventory;
    private int currentIndex;

    public ViewVehiclesGUI(VehicleInventory inventory) {
        this.inventory = inventory;
        frame = new JFrame("View Vehicles");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        frame.add(panel);
        currentIndex = 0;
        placeComponents(panel);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        nextButton = new JButton("Next Car");
        nextButton.setBounds(100, 50, 150, 25);
        panel.add(nextButton);

        displayLabel = new JLabel("");
        displayLabel.setBounds(10, 20, 350, 25);
        panel.add(displayLabel);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Vehicle> vehicles = inventory.getVehicles();
                if (vehicles.isEmpty()) {
                    displayLabel.setText("No vehicles available.");
                } else {
                    Vehicle currentVehicle = vehicles.get(currentIndex);
                    displayLabel.setText("License Plate: " + currentVehicle.getLicensePlate() + 
                        ", Make: " + currentVehicle.getMake() + 
                        ", Model: " + currentVehicle.getModel());
                    
                    currentIndex = (currentIndex + 1) % vehicles.size();
                }
            }
        });
    }

    public static void main(String[] args) {
        new ViewVehiclesGUI(new VehicleInventory());
    }
}
