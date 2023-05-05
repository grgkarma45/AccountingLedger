package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        homescreen(); //calling a homescreen() to display home screen menu.
    }

    public static void homescreen() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        //Display Homescreen
        do{
            System.out.println("Welcome to your accounting Ledger: ");
            System.out.println("What would you like to do today?");
            System.out.println(("-------------Main Menu-----------"));
            System.out.println("[D] - Add Deposit");
            System.out.println("[P] - Make Payment");
            System.out.println("[L] - Ledger");
            System.out.println("[X] - Exit");
            // use switch method for the options in the Homescreen
            input = scanner.nextLine();
            switch (input.toUpperCase()) {
                case "D" -> addDeposit();
                case "P" -> makePayment();
                case "L" -> showLedger();
                case "X" -> System.exit(0);
                default -> System.out.println("Please enter a valid option");
            }
        } while(!input.equalsIgnoreCase("X"));
        System.out.println("Have a nice day");



    }


    private static void showLedger() { // Calling showLedger() method from the ledger class
        Ledger.showLedger();
    }



    private static void makePayment() {  // using Scanner to get user's input and storing it in the corresponding variable
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Date:(yyyy-MM-dd)");
        String date = scanner.nextLine();
        System.out.println("Enter Time: ( HH:mm:SS");
        String time = scanner.nextLine();
        System.out.println("Enter Description");
        String description =scanner.nextLine();
        System.out.println("Enter vendor");
        String vendor = scanner.next();
        System.out.println("Enter amount");
        double amount = scanner.nextDouble();//Storing  the amount as the Double.
        scanner.nextLine();

        try{ // using the filewriter to add the collected data into the csv file
            FileWriter fileWriter = new FileWriter("transactions.csv", true);
            // store all the information with a -ve sign before the amount variable.
            fileWriter.write( "\n" + date + "|" + time + "|" + description  + "|" + vendor + "|" + "-"  + amount);
            System.out.println("Payment made successfully");
            fileWriter.close();
        } catch (IOException e){ //prints out an error message when the input is wrong
            System.out.println("Error inputting data! Please try again!");
        }
    }

    private static void addDeposit() { // using Scanner to get user's input and storing it in a corresponding variable
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Date:(yyyy-MM-dd)");
        String date = scanner.nextLine();

        System.out.println("Enter Time: ( HH:mm:SS");
        String time = scanner.nextLine();

        System.out.println("Enter Description");
        String description =scanner.nextLine();

        System.out.println("Enter vendor");
        String vendor = scanner.next();

        System.out.println("Enter amount");
        double amount = scanner.nextDouble();

        try{ // writing the information from the variables to the csv.file
            FileWriter fileWriter = new FileWriter("transactions.csv", true);
            //add | in between the variables
            fileWriter.write( "\n" + date + "|" + time + "|" + description+ "|" + vendor + "|" + amount);
            System.out.println("Deposit added successfully");
            fileWriter.close();

        } catch (IOException e){
            System.out.println("Error inputting data! Please try again");
        }

    }
}

