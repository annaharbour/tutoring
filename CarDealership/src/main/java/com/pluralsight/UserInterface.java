package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Dealership dealership;

    public void display() {
        init();

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


    }

    public void makeChoice(){
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice){
            case 1:
                processGetByPriceRequest(scanner);
                break;
            case 2:
                processGetByMakeModelRequest(scanner);

        }
    }


    public void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
        System.out.println(dealership);
        fileManager.saveDealership(dealership);
    }

    public ArrayList<Vehicle> processGetByPriceRequest(Scanner scanner) {
        return dealership.getAllVehicles();
    }

    public ArrayList<Vehicle> processGetByMakeModelRequest(Scanner scanner) {
        return dealership.getAllVehicles();
    }

    public ArrayList<Vehicle> processGetByYearRequest() {
        return dealership.getAllVehicles();
    }

    public ArrayList<Vehicle> processGetByColorRequest() {
        return dealership.getAllVehicles();
    }

    public ArrayList<Vehicle> processGetByMileageRequest() {
        return dealership.getAllVehicles();
    }

    public ArrayList<Vehicle> processGetByVehicleTypeRequest() {
        return dealership.getAllVehicles();
    }

    public ArrayList<Vehicle> processGetByAllVehiclesRequest() {
        return dealership.getAllVehicles();
    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest() {

    }
}
