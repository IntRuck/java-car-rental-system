package com.example.carrental;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    private JFrame frame;
    private JButton addButton;
    private JButton deleteButton;
    private JButton viewButton;
    private JButton editButton;
    private VehicleInventory inventory;

    public MainGUI() {
        frame = new JFrame("Car Rental System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        JPanel panel = new JPanel();
        frame.add(panel);
        inventory = new VehicleInventory();
        placeComponents(panel);
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        addButton = new JButton("Add Vehicle");
        addButton.setBounds(120, 50, 150, 25);
        panel.add(addButton);

        editButton = new JButton("Edit Vehicle");
        editButton.setBounds(120, 100, 150, 25);
        panel.add(editButton);

        deleteButton = new JButton("Delete Vehicle");
        deleteButton.setBounds(120, 150, 150, 25);
        panel.add(deleteButton);

        viewButton = new JButton("View Vehicles");
        viewButton.setBounds(120, 200, 150, 25);
        panel.add(viewButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddVehicleGUI(inventory);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditVehicleGUI(inventory);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteVehicleGUI(inventory);
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewVehiclesGUI(inventory);
            }
        });
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
