package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static com.pluralsight.App.scanner;

public class Deposit {

    public static void addDeposit() {

        Transactions transaction = Transactions.transactionPrompt("Deposit");

        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transactions.csv", true));

            App.transactions.add(transaction);

            bufferedWriter.write("\n" + transaction.toString());
            bufferedWriter.close();

            System.out.println("Thank you for your deposit!");

            App.homeScreen(scanner);


        }catch(IOException e) {
            e.getStackTrace();
        }

    }


}


