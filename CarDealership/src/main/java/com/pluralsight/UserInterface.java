package com.pluralsight;

public class UserInterface {
    Dealership dealership;

    public void display(){
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
        System.out.println(dealership);
        fileManager.saveDealership(dealership);

    }
}
