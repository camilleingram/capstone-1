package com.pluralsight;

import java.util.Scanner;

public class HomeScreen {
    private static String option = "";

    public static String homeScreen(Scanner scanner) {
        System.out.println("Welcome, please select an option");
        System.out.println("D) Add Deposit");
        System.out.println("P) Make Payment (Debit)");
        System.out.println("L) Ledger");
        System.out.println("X) Exit");
        option = scanner.nextLine();

        switch(option) {
            case "D":
                Deposit.addDeposit();
                break;
            case "P":
                Payment.takePayment();
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
