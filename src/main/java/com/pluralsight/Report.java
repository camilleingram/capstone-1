package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;

import static com.pluralsight.App.scanner;

public class Report {

    public static int report(Scanner scanner) {
        System.out.println("How would you like to search your reports? ");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("0) Back to Ledger");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch(option) {
            case 0:
                Ledger.ledger(scanner);
                break;
            case 1:
                monthToDate();
                break;
            case 2:
                previousMonth();
                break;
            case 3:
                yearToDate();
                break;
            case 4:
                previousYear();
                break;
            case 5:
                searchVendor(scanner);
                break;
        }

        return option;
    }

    public static void searchVendor(Scanner scanner) {
        System.out.print("Enter the vendor name: ");
        String search = scanner.nextLine();

        for(Transactions transactions : App.transactions) {
            String vendor = transactions.getVendorName();
            if(search.equalsIgnoreCase(vendor)) {
                System.out.println(transactions);
            }
        }

        report(scanner);
    }

    public static void previousYear() {
        for(Transactions transaction : App.transactions) {
            LocalDate transactionDate = transaction.getDate();
            LocalDate currentDate = LocalDate.now();

            if(transactionDate.getYear() == (currentDate.getYear() - 1)){
                System.out.println(transaction);
            }
        }

        report(scanner);
    }

    public static void yearToDate() {
        for(Transactions transaction : App.transactions) {
            LocalDate transactionDate = transaction.getDate();
            LocalDate currentDate = LocalDate.now();

            if(transactionDate.getYear() == currentDate.getYear()){
                System.out.println(transaction);
            }
        }

        report(scanner);
    }

    public static void previousMonth() {
        for(Transactions transaction : App.transactions) {
            LocalDate transactionDate = transaction.getDate();
            LocalDate currentDate = LocalDate.now();

            if(transactionDate.getMonthValue() == (currentDate.getMonthValue() - 1)){
                System.out.println(transaction);
            }
        }

        report(scanner);
    }

    public static void monthToDate() {
       for(Transactions transaction : App.transactions) {
           LocalDate transactionDate = transaction.getDate();
           LocalDate currentDate = LocalDate.now();

           if(transactionDate.getMonthValue() == currentDate.getMonthValue()){
               System.out.println(transaction);
           }
       }

       report(scanner);
    }
}
