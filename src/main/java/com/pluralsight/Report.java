package com.pluralsight;

import java.util.Scanner;

public class Report {

    public static int report(Scanner scanner) {
        System.out.println("How would you like to search your reports? ");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("0) Back to Ledger");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch(option) {
            case 0:
                Ledger.ledger(scanner);
                break;
            case 1:
                monthToDate();
                break;
        }

        return option;
    }

    public static void monthToDate() {

    }
}
