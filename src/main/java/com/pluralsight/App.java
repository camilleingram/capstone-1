package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
public class App {

    static Scanner scanner = new Scanner(System.in);;
    static String option;
    public static void main(String[] args) {
        getTransactions();
        option = homeScreen(scanner);
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
                Deposit.addDeposit();
                break;
            case "P":
                Payment.takePayment();
                break;
            case "L":
                Ledger.ledger(scanner);
                break;
            case "X":
                System.out.println("Exiting...");
                break;
        }

        return option;
    }

    public static void getTransactions() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("transactions.csv"));
            String line;
            bufferedReader.readLine();

            while((line = bufferedReader.readLine()) != null) {
                String[] details = line.split("\\|");
                LocalDate date = LocalDate.parse(details[0]);
                LocalTime time = LocalTime.parse(details[1]);
                String description = details[2];
                String vendorName = details[3];
                float amount = Float.parseFloat(details[4].replace("$", ""));
                Transactions transaction = new Transactions(date, time, description, vendorName, amount);
                if(amount > 0) {
                    Deposit.deposits.add(transaction);
                } else {
                    Payment.payments.add(transaction);
                }
            }
        }
        catch(IOException e) {
            e.getStackTrace();
        }
    }
    
}