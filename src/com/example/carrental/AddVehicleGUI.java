package com.example.carrental;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddVehicleGUI {
    private JFrame frame;
    private JTextField licensePlateField;
    private JTextField makeField;
    private JTextField modelField;
    private JTextField seatingCapacityField;
    private JButton addButton;
    private VehicleInventory inventory;

    public AddVehicleGUI(VehicleInventory inventory) {
        this.inventory = inventory;
        frame = new JFrame("Add Vehicle");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        frame.add(panel);
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

        addButton = new JButton("Add Vehicle");
        addButton.setBounds(10, 140, 150, 25);
        panel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String licensePlate = licensePlateField.getText();
                String make = makeField.getText();
                String model = modelField.getText();
                int seatingCapacity = Integer.parseInt(seatingCapacityField.getText());

                Car car = new Car(licensePlate, make, model, seatingCapacity);
                inventory.addVehicle(car);

                JOptionPane.showMessageDialog(frame, "Vehicle added successfully!");
                licensePlateField.setText("");
                makeField.setText("");
                modelField.setText("");
                seatingCapacityField.setText("");
            }
        });
    }
}
