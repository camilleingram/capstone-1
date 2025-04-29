package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import static com.pluralsight.App.scanner;

public class Deposit {
    static ArrayList<Transactions> deposits = new ArrayList<>();

    public static void addDeposit() {
        Transactions transaction = Transactions.transactionPrompt(scanner);
        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transactions.csv", true));

            deposits.add(transaction);

            LocalDate date = LocalDate.parse(transaction.getDate());
            LocalTime time = transaction.getTime();
            String description = transaction.getDescription();
            String vendorName = transaction.getVendorName();
            float deposit = transaction.getAmount();

            String transactionString = String.format("%tF|%tT|%s|%s|$%.2f%n", date, time, description, vendorName, deposit);
            bufferedWriter.write(transactionString);
            bufferedWriter.close();

            HomeScreen.homeScreen(scanner);


        }catch(IOException e) {
            e.getStackTrace();
        }

    }
}


