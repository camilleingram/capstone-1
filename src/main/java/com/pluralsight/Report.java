package com.pluralsight;

import java.time.LocalDate;
import java.util.Scanner;

import static com.pluralsight.App.scanner;

public class Report {

    public static int report(Scanner scanner) {
        System.out.println("How would you like to search your reports? ");
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("6) Custom Search");
        System.out.println("0) Back to Ledger");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch(option) {
            case 0:
                Ledger.ledger(scanner);
                break;
            case 1, 2, 3, 4:
                dateComparison(option);
                break;
            case 5:
                searchVendor(scanner);
                break;
            case 6:
                customSearch(scanner);
                break;
        }

        return option;
    }

    public static void customSearch(Scanner scanner) {
        System.out.print("Enter start date: ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter end date: ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter description to filter: ");
        String inputDesc = scanner.nextLine();
        System.out.print("Enter vendor to filter: ");
        String inputVendor = scanner.nextLine();
        System.out.print("Enter amount to filter: ");
        int inputAmount = (int) scanner.nextFloat();
        scanner.nextLine();
        int searchCounter = 0;


        for(Transactions transaction : App.transactions) {
            LocalDate transDate = transaction.getDate();
            String transDesc = transaction.getDescription();
            String transVendor = transaction.getVendorName();
            int transAmount = (int) transaction.getAmount();

            boolean dateMatch = (startDate.isEqual(transDate) ||transDate.isAfter(startDate)) && (endDate.isEqual(transDate) || transDate.isBefore(endDate));

            boolean descMatch = inputDesc.isEmpty() || transDesc.toLowerCase().contains(inputDesc.toLowerCase());

            boolean vendorMatch = inputVendor.isEmpty() || inputVendor.equalsIgnoreCase(transVendor);
//
            boolean amountMatch = false;
            if (transAmount < 0) {
                transAmount *= -1;
            }
            amountMatch = inputAmount == 0 || transAmount >= inputAmount - 100 && transAmount <= inputAmount + 100;

            if(dateMatch && descMatch && vendorMatch && amountMatch) {
                System.out.println(transaction);
                searchCounter++;
            }

        }

        if(searchCounter > 1 || searchCounter == 0) {
            System.out.printf("%d matches found!%n", searchCounter);
        } else {
            System.out.printf("%d match found!%n", searchCounter);
        }

        report(scanner);
    }

    public static void dateComparison(int searchType) {
        for(Transactions transaction : App.transactions) {
            LocalDate transactionDate = transaction.getDate();
            LocalDate currentDate = LocalDate.now();
            boolean isMatch = false;

            switch(searchType) {
                case 1:
                    isMatch = transactionDate.getMonthValue() == currentDate.getMonthValue();
                    break;
                case 2:
                    isMatch = transactionDate.getMonthValue() == (currentDate.getMonthValue() - 1);
                    break;
                case 3:
                    isMatch = transactionDate.getYear() == currentDate.getYear();
                    break;
                case 4:
                    isMatch = transactionDate.getYear() == (currentDate.getYear() - 1);
                    break;
            }

            if(isMatch) {
                System.out.println(transaction);
            }
        }

        report(scanner);
    }

    public static void searchVendor(Scanner scanner) {
        System.out.print("Enter the vendor name: ");
        String search = scanner.nextLine();

        for(Transactions transactions : App.transactions) {
            String vendor = transactions.getVendorName();
            if(search.equalsIgnoreCase(vendor)) {
                System.out.println(transactions);
            }
        }
        report(scanner);
    }
}
