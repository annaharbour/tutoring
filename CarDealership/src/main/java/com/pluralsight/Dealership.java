package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        return this.getAllVehicles();
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return this.getAllVehicles();

    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        return this.getAllVehicles();

    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        return this.getAllVehicles();

    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        return this.getAllVehicles();

    }

    public ArrayList<Vehicle> getVehiclesByType(String type) {
        return this.getAllVehicles();
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(int vin) {
        System.out.println("Removing vehicle.... " + vin);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dealership{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", inventory=").append(inventory);
        sb.append('}');
        return sb.toString();
    }
}

//Vehicle vehicle = new Vehicle()

//Dealership dealership = new Dealership("fds", "fsd", "dfsa");
//dealership.getAllVehicles();
//dealership.getVehiclesByType("car")

