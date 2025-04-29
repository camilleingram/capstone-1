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
                displayDeposit();
                break;
            case "P":
//                displayPayment();
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
        for(Transactions payment : Payment.payments) {
            System.out.println(payment);
        }
    }

    public static void displayDeposit() {

        for(Transactions deposit : Deposit.deposits) {
            System.out.println(deposit);
        }

        ledger(scanner);
    }

    public static void displayAll() {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("transactions.csv"));
            String line;
//          bufferedReader.readLine();

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            ledger(scanner);
        }
        catch(IOException e) {
            e.getStackTrace();
        }
    }
}
