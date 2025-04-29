package com.pluralsight;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
public class App {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Transactions> payments = new ArrayList<>();


    public static void main(String[] args) {
        String homeScreen = HomeScreen.homeScreen(scanner);

    }


}
