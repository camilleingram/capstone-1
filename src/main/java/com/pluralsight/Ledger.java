package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static com.pluralsight.App.scanner;

public class Ledger {
    private static String option = "";

    public static String ledger(Scanner scanner) {

        System.out.println("What would you like to see? ");
        System.out.println("A) All");
        System.out.println("D) Deposits");
        System.out.println("P) Payments");
        System.out.println("R) Reports");
        System.out.println("H) Return to Home");
        option = scanner.nextLine();

        switch(option) {
            case "A":
                displayAll();
                break;
            case "D":
                displayDeposits();
                break;
            case "P":
                displayPayments();
                break;
            case "R":
//                Report.reports();
                break;
            case "H":
                App.homeScreen(scanner);
                break;
        }

        return option;
    }

    public static void displayPayments() {
        for(Transactions transaction : App.transactions) {
            if(transaction.getAmount() < 0){
                System.out.println(transaction);
            }
        }

        ledger(scanner);
    }

    public static void displayDeposits() {

        for(Transactions transaction : App.transactions) {
            if(transaction.getAmount() > 0) {
                System.out.println(transaction);
            }
        }

        ledger(scanner);
    }

    public static void displayAll() {
        for(Transactions transaction : App.transactions) {
            System.out.println(transaction);
        }

        ledger(scanner);

    }
}
