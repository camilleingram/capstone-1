package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Transactions {

    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();
    private String description = "";
    private String vendorName = "";
    private float amount = 0;


    public Transactions(LocalDate date, LocalTime time, String description, String vendorName, float amount) {

        this.date = date;
        this.time = time;
        this.description = description;
        this.vendorName = vendorName;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }




    public static Transactions transactionPrompt(String transactionType){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter transaction date (yyyy/mm/dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter transaction description: ");
        String description = scanner.nextLine();

        System.out.print("Enter vendor name: ");
        String vendorName = scanner.nextLine();

        System.out.print("Enter amount: ");
        float amount = scanner.nextFloat();
        scanner.nextLine();

        if(transactionType.equalsIgnoreCase("Payment")) {
            amount *= -1;
        }


        return new Transactions(date, LocalTime.now(), description, vendorName, amount);
    }

    @Override
    public String toString() {
        return String.format("%tF|%tT|%s|%s|$%.2f", date, time, description, vendorName, amount);
    }

}
