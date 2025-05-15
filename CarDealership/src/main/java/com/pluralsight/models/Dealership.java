package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : this.inventory){
            if(min <= vehicle.getPrice() && max >= vehicle.getPrice()){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : this.inventory){
            if(make.trim().equalsIgnoreCase(vehicle.getMake()) && model.trim().equalsIgnoreCase(model)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : this.inventory){
            if(min <= vehicle.getYear() && max >= vehicle.getYear()){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : this.inventory){
            if(color.trim().equalsIgnoreCase(vehicle.getColor())){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : this.inventory){
            if(min <= vehicle.getPrice() && max >= vehicle.getPrice()){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByType(String type) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle vehicle : this.inventory){
            if(type.trim().equalsIgnoreCase(vehicle.getVehicleType())){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(int vin) {
        for(Vehicle vehicle : this.inventory){
            if(vehicle.getVin() == vin){
                this.inventory.remove(vehicle);
            }
        }
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

