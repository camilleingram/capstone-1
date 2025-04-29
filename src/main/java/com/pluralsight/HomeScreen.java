package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.App.scanner;
import static com.pluralsight.Deposit.addDeposit;

public class HomeScreen {
    private static String option = "";

    public HomeScreen(String option) {
        this.option = option;
    }

    public static String homeScreen(Scanner scanner) {
        System.out.println("Welcome, please select an option");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");
        option = scanner.nextLine();

        switch(option) {
            case "D":
                addDeposit();

                break;
            case "P":

                break;
            case "L":

                break;
            case "X":
                System.out.println("Exiting...");
                break;
        }

        return option;
    }
}
