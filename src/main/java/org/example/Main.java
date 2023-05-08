package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        homescreen();

    }

    public static void homescreen() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            //Display Homescreen
            System.out.println("Welcome to your accounting Ledger: ");
            System.out.println(("Main Menu"));
            System.out.println("[D] - Add Deposit");
            System.out.println("[P] - Make Payment");
            System.out.println("[L] - Ledger");
            System.out.println("[X] - Exit");
            // use switch method for the options in the Homescreen
            input = scanner.nextLine();
            switch (input.toUpperCase()) {
                case "D":
                    addDeposit();
                    break;
                case "P":
                    makePayment();
                    break;
                case "L":
                    showLedger();
                    break;
                case "X":
                    System.out.println("Have a Good Day");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid option and try again");
                    break;
            }
        } while (!input.equalsIgnoreCase("x"));
    }

    private static void showLedger() {
        Ledger.showLedger();
    }

    private static void addDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Date:(yyyy-MM-dd)");
        String date = scanner.nextLine();
        System.out.println("Enter Time: ( HH:mm:SS)");
        String time = scanner.nextLine();
        System.out.println("Enter Description");
        String description = scanner.nextLine();
        System.out.println("Enter vendor");
        String vendor = scanner.nextLine(); // use nextLine() to read the vendor name
        System.out.println("Enter amount");
        double amount = scanner.nextDouble();
        DecimalFormat df = new DecimalFormat("#.##"); // format amount with 2 decimal places
        String formattedAmount = df.format(amount);


        try {
            FileWriter fileWriter = new FileWriter("transactions.csv", true);
            // use String.format() to format the amount with 2 decimal places
            fileWriter.write("\n" + date + "|" + time + "|" + description + "|" + vendor + "|" + formattedAmount);
            System.out.println("Deposit added successfully");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error inputting data!");
        }
    }


    private static void makePayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Date:(yyyy-MM-dd)");
        String date = scanner.nextLine();
        System.out.println("Enter Time: ( HH:mm:SS)");
        String time = scanner.nextLine();
        System.out.println("Enter Description");
        String description = scanner.nextLine();
        System.out.println("Enter vendor");
        String vendor = scanner.nextLine();
        System.out.println("Enter amount");
        double amount = scanner.nextDouble() *-1;

        DecimalFormat df = new DecimalFormat("#.##"); // format amount with 2 decimal places
        String formattedAmount = df.format(amount);

        try {
            FileWriter fileWriter = new FileWriter("transactions.csv", true);
            fileWriter.write("\n" + date + "|" + time + "|" + description + "|" + vendor + "|" + formattedAmount);
            System.out.println("Payment made successfully");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error inputting data!");
        }
    }
}