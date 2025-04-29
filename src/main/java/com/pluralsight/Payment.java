package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static com.pluralsight.App.scanner;

public class Payment {

    static ArrayList<Transactions> payments = new ArrayList<>();

    public static void takePayment() {

        Transactions transaction = Transactions.transactionPrompt(scanner);

        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transactions.csv", true));

            payments.add(transaction);

            LocalDate date = transaction.getDate();
            LocalTime time = transaction.getTime();
            String description = transaction.getDescription();
            String vendorName = transaction.getVendorName();
            float payment = -1 * transaction.getAmount();

            String transactionString = String.format("%tF|%tT|%s|%s|$%.2f%n", date, time, description, vendorName, payment);
            bufferedWriter.write(transactionString);
            bufferedWriter.close();

            App.homeScreen(scanner);

            System.out.println(payment);
        }catch(IOException e) {
            e.getStackTrace();
        }
    }
}
