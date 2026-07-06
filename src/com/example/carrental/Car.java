package com.example.carrental;

public class Car extends Vehicle {
    private int seatingCapacity;

    public Car(String licensePlate, String make, String model, int seatingCapacity) {
        super(licensePlate, make, model);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}
