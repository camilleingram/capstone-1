package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static com.pluralsight.App.scanner;

public class Payment {

    public static void takePayment() {

        Transactions transaction = Transactions.transactionPrompt("Payment");

        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transactions.csv", true));

            App.transactions.add(transaction);

            bufferedWriter.write(String.valueOf(transaction));
            bufferedWriter.close();

            App.homeScreen(scanner);

            System.out.println(transaction);
        }catch(IOException e) {
            e.getStackTrace();
        }
    }
}
