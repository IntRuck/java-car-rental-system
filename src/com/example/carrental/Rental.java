

package com.example.carrental;

public class Rental implements RentalActions {
    private Customer customer;
    private Vehicle vehicle;
    private String rentalStartDate;
    private String rentalEndDate;

    public Rental(Customer customer, Vehicle vehicle, String rentalStartDate, String rentalEndDate) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
    }

    @Override
    public void startRental() {
        System.out.println("Rental started for vehicle: " + vehicle.getLicensePlate());
    }

    @Override
    public void endRental() {
        System.out.println("Rental ended for vehicle: " + vehicle.getLicensePlate());
    }

    // Getters and Setters
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(String rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public String getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(String rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }
}
