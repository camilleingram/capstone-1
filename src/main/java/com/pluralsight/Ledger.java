package com.pluralsight;

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
            case "A", "D", "P":
                displayTransactions(option);
                break;
            case "R":
                Report.report(scanner);
                break;
            case "H":
                App.homeScreen(scanner);
                break;
        }

        return option;
    }


    public static void displayTransactions(String displayType) {
        for(Transactions transaction : App.transactions) {

            switch(displayType) {
                case "A":
                    System.out.println(transaction);
                    break;
                case "D":
                    if(transaction.getAmount() > 0) {
                        System.out.println(transaction);
                    }
                    break;
                case "P":
                    if(transaction.getAmount() < 0){
                        System.out.println(transaction);
                    }
                    break;
            }
        }

        ledger(scanner);

    }
}
