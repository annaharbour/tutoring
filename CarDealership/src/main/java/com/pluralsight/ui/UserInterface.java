package com.pluralsight.ui;

import com.pluralsight.data.DealershipFileManager;
import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager dealershipFileManager;

    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        do {
            String[] menuOptions = {"1 - Find vehicles within a price range",
                    "2 - Find vehicles by make / model",
                    "3 - Find vehicles by year range",
                    "4 - Find vehicles by color",
                    "5 - Find vehicles by mileage range",
                    "6 - Find vehicles by type (car, truck, SUV, van)",
                    "7 - List ALL vehicles",
                    "8 - Add a vehicle",
                    "9 - Remove a vehicle",
                    "10 - Quit"};

            for (String option : menuOptions) {
                System.out.println(option);
            }
            running = makeChoice(scanner, running);
        } while (running);
    }

    public boolean makeChoice(Scanner scanner, boolean running) {
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                displayVehicles(processGetByPriceRequest(scanner, dealership));;
                break;
            case 2:
                displayVehicles(processGetByMakeModelRequest(scanner, dealership));
                break;
            case 3:
                displayVehicles(processGetByYearRequest(scanner, dealership));
                break;
            case 4:
                displayVehicles(processGetByColorRequest(scanner, dealership));
                break;
            case 5:
                displayVehicles(processGetByMileageRequest(scanner, dealership));
                break;
            case 6:
                displayVehicles(processGetByVehicleTypeRequest(scanner, dealership));
                break;
            case 7:
                displayVehicles(processGetAllVehiclesRequest(scanner, dealership));
                break;
            case 8:
                processAddVehicleRequest(scanner, dealership);
                break;
            case 9:
                processRemoveVehicleRequest(scanner, dealership);
                break;
            case 10:
                running = false;
                break;
            default:
                break;
        }
        return running;
    }

    public void init() {
        this.dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
        System.out.println(dealership);
    }

    public void displayVehicles(ArrayList<Vehicle> vehicles){
        for (Vehicle vehicle: vehicles) {
            System.out.println(vehicle);
        }
    }

    public ArrayList<Vehicle> processGetByPriceRequest(Scanner scanner, Dealership dealership) {
        System.out.println("Enter a minimum price: ");
        double min = scanner.nextDouble();
        System.out.println("Enter a maximum price: ");
        double max = scanner.nextDouble();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        return vehicles;
    }

    public ArrayList<Vehicle> processGetByMakeModelRequest(Scanner scanner, Dealership dealership) {
        System.out.println("Enter a make: ");
        String make = scanner.nextLine();
        System.out.println("Enter a model");
        String model = scanner.nextLine();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        return vehicles;
    }

    public ArrayList<Vehicle> processGetByYearRequest(Scanner scanner, Dealership dealership) {
        System.out.println("Please enter earlier year for range: ");
        int minYear = scanner.nextInt();
        System.out.println("Please enter later year for range: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        return vehicles;
    }

    public ArrayList<Vehicle> processGetByColorRequest(Scanner scanner, Dealership dealership) {
        System.out.println("Please enter color: ");
        String color = scanner.nextLine().toLowerCase().trim();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        return vehicles;
    }

    public ArrayList<Vehicle> processGetByMileageRequest(Scanner scanner, Dealership dealership) {
        System.out.println("Please enter lower mileage limit: ");
        int minMileage = scanner.nextInt();
        System.out.println("Please enter upper mileage limit: ");
        int maxMileage = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
        return vehicles;
    }

    public ArrayList<Vehicle> processGetByVehicleTypeRequest(Scanner scanner, Dealership dealership) {
        System.out.println("Please enter a vehicle type (SUV, car, truck, etc): ");
        String vehicleType = scanner.next().trim().toLowerCase();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        return vehicles;
    }

    public ArrayList<Vehicle> processGetAllVehiclesRequest(Scanner scanner, Dealership dealership) {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        return vehicles;
    }

    public void processAddVehicleRequest(Scanner scanner, Dealership dealership) {
        System.out.print("Enter vin: ");
        int vin = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter make: ");
        String make = scanner.next().trim();
        System.out.print("Enter model: ");
        String model = scanner.next().trim();
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.next().trim();
        System.out.print("Enter color: ");
        String color = scanner.next().trim();
        System.out.print("Enter mileage: ");
        int odometer = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);
        dealershipFileManager.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest(Scanner scanner, Dealership dealership) {
        System.out.println("Enter vehicle vin: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        dealership.removeVehicle(vin);
        dealershipFileManager.saveDealership(dealership);
        System.out.println("Dealership data saved successfully.");
    }
}
