package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    public Dealership getDealership() {
        //read inventory.csv file
        //read the first line which has the dealership data
        //take the line of dealership data and split by | which returns a string array of each piece of dealership data
        //take each column/piece of data and pass it into the constructor of our Dealership to create a specific
        // dealership object
        Dealership dealership = null;

        try {
            FileReader fileReader = new FileReader("CarDealership/data/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            String[] dealerShipFields = line.split("\\|");
            dealership = new Dealership(dealerShipFields[0], dealerShipFields[1], dealerShipFields[2]);
            line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] vehicleFields = line.split("\\|");
                int vin = Integer.parseInt(vehicleFields[0]);
                int year = Integer.parseInt(vehicleFields[1]);
                String make = vehicleFields[2];
                String model = vehicleFields[3];
                String vehicleType = vehicleFields[4];
                String color = vehicleFields[5];
                int odometer = Integer.parseInt(vehicleFields[6]);
                double cost = Double.parseDouble(vehicleFields[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, cost);
                dealership.addVehicle(vehicle);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }


        return dealership;
    }


    public void saveDealership(Dealership dealership) {
        List<String> lines = new ArrayList<>();
        List<Vehicle> vehicles = dealership.getAllVehicles();
        lines.add("D & B Used Cars|111 Old Benbrook Rd|817-555-5555");
        lines.add("VIN|Year|Make|Model|Type|Color|Mileage|Price");
        for (Vehicle vehicle : vehicles) {
            lines.add(
                    vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + String.format(
                            "%.2f", vehicle.getPrice()));
        }
        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter("CarDealership/data/inventory.csv"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}