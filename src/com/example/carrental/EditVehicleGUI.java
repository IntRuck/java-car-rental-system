package com.example.carrental;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EditVehicleGUI {
    private JFrame frame;
    private JTextField licensePlateField;
    private JTextField makeField;
    private JTextField modelField;
    private JTextField seatingCapacityField;
    private JButton editButton;
    private JButton nextButton;
    private JLabel displayLabel;
    private VehicleInventory inventory;
    private int currentIndex;

    public EditVehicleGUI(VehicleInventory inventory) {
        this.inventory = inventory;
        frame = new JFrame("Edit Vehicle");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        JPanel panel = new JPanel();
        frame.add(panel);
        currentIndex = 0;
        placeComponents(panel);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel licensePlateLabel = new JLabel("License Plate:");
        licensePlateLabel.setBounds(10, 20, 100, 25);
        panel.add(licensePlateLabel);

        licensePlateField = new JTextField(20);
        licensePlateField.setBounds(150, 20, 165, 25);
        panel.add(licensePlateField);

        JLabel makeLabel = new JLabel("Make:");
        makeLabel.setBounds(10, 50, 100, 25);
        panel.add(makeLabel);

        makeField = new JTextField(20);
        makeField.setBounds(150, 50, 165, 25);
        panel.add(makeField);

        JLabel modelLabel = new JLabel("Model:");
        modelLabel.setBounds(10, 80, 100, 25);
        panel.add(modelLabel);

        modelField = new JTextField(20);
        modelField.setBounds(150, 80, 165, 25);
        panel.add(modelField);

        JLabel seatingCapacityLabel = new JLabel("Seating Capacity:");
        seatingCapacityLabel.setBounds(10, 110, 120, 25);
        panel.add(seatingCapacityLabel);

        seatingCapacityField = new JTextField(20);
        seatingCapacityField.setBounds(150, 110, 165, 25);
        panel.add(seatingCapacityField);

        editButton = new JButton("Edit Vehicle");
        editButton.setBounds(10, 140, 150, 25);
        panel.add(editButton);

        nextButton = new JButton("Next Car");
        nextButton.setBounds(200, 140, 150, 25);
        panel.add(nextButton);

        displayLabel = new JLabel("");
        displayLabel.setBounds(10, 180, 350, 25);
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
                    
                    licensePlateField.setText(currentVehicle.getLicensePlate());
                    makeField.setText(currentVehicle.getMake());
                    modelField.setText(currentVehicle.getModel());
                    seatingCapacityField.setText(String.valueOf(((Car) currentVehicle).getSeatingCapacity()));
                    
                    currentIndex = (currentIndex + 1) % vehicles.size();
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Vehicle> vehicles = inventory.getVehicles();
                if (vehicles.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No vehicles available to edit.");
                } else {
                    currentIndex = (currentIndex == 0) ? vehicles.size() - 1 : currentIndex - 1;
                    Vehicle currentVehicle = vehicles.get(currentIndex);
                    currentVehicle.setLicensePlate(licensePlateField.getText());
                    currentVehicle.setMake(makeField.getText());
                    currentVehicle.setModel(modelField.getText());
                    ((Car) currentVehicle).setSeatingCapacity(Integer.parseInt(seatingCapacityField.getText()));

                    JOptionPane.showMessageDialog(frame, "Vehicle updated successfully!");
                }
            }
        });
    }

    public static void main(String[] args) {
        new EditVehicleGUI(new VehicleInventory());
    }
}
