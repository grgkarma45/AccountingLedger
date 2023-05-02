package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Ledger {
    // initializing an arraylist which holds transaction objects and calling it transactionList
    // and we are inheriting the transactions array list from the getTransactions()
    public static ArrayList<Transaction> transactionsList = getTransactions();

    public static ArrayList<Transaction> getTransactions() { //Declaring a method called getTransactions
        //of the type arraylist that holds transactions objects
        ArrayList<Transaction> transactions = new ArrayList<>();//making an arraylist of transcation objects named transactions
        try { //we're creating filereader and bufferreader and passing the transaction.csv file into it.
            FileReader fileReader = new FileReader("transactions.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input; // declaring a variable named input of type String
            while ((input = bufferedReader.readLine()) != null) {// looping through the csv file,
                // we're taking the current line from the csv file and storing it inside the input variable
                // and this loop will keep repeating until the next line is null()
                String[] details = input.split("\\|");// Splitting the input with "|" and storing all the pieces
                // into the String array variable called details.
                LocalDate date = LocalDate.parse(details[0]); //we're taking the string at index 0 from the detail's array and
                // converting it to LocalDate type using the LocalDate class and storing it to date variable of type Localdate
                LocalTime time = LocalTime.parse(details[1]);// we're taking the string at index 1 from detail's array
                // and converting it to Local time class and storing it to time variable of type Local time.
                String description = details[2];
                // we're taking the string at index 2 from detail's array
                //  and converting it to string class and storing it to description variable of type String
                String vendor = details[3];
                // we're taking the string at index 3 from detail's array
                //  and converting it to string class and storing it to vendor variable of type String
                double amount = Double.parseDouble(details[4]);
                // we're taking the string at index 4 from detail's array
                //  and converting it to string class and storing it to amount variable of type Double

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                //we're using the constructor from the transaction class and we're passing  (date, time, description)
                //into the constructor to make a new object called transaction of type Transaction
                transactions.add(transaction); //adding the transaction object we just created into the transactions array list
                //we will repeat all the steps above for each iteration of the loop(for each line in the csv file)
            }
            //} catch (FileNotFoundException e) { // if the file can't be found , throw an error.
            //  throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("File not found");
            System.exit(0);
            // throw new RuntimeException(e);
        }
        // Sort our transactions ArrayList in ascending order before returning it
        Comparator<Transaction> compareByDate = Comparator.comparing(Transaction::getDate).reversed();
        Comparator<Transaction> compareByTime = Comparator.comparing(Transaction::getTime).reversed();
        transactions.sort(compareByDate.thenComparing(compareByTime));

        return transactions;// we're returning the transactions array list to our method, so that when we call on out
        //method, we get an array list returned to us.
    }

    public static void showLedger() { // creating a method called showLedger() to display the ledger menu
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your ledger ");
        System.out.println(("Main Menu: "));
        System.out.println("[A] - Display all entries");
        System.out.println("[D] - Display only the entries that are deposited into the account");
        System.out.println("[p] - Display only the negative entries(payments)");
        System.out.println("[R] - Reports");
        System.out.println("[H] - Go back to Home page");
        //using switch method instead of if/else statement to run the corresponding method based on user's input
        String input = scanner.nextLine();
        switch (input.toUpperCase()) {
            case "A":
                allEntries();
                break;
            case "D":
                showDepositedEntries();
                break;
            case "P":
                showPaymentEntries();
                break;
            case "R":
                showReports();
                break;
            case "H":
                System.exit(0);
                break;
            default:
                System.out.println("Please enter a valid option");
                break;
        }
    }


    private static void showPaymentEntries() {
        System.out.println("Payment");
        for (Transaction item : transactionsList) { // loop through each transaction object(item) in the transactionslist
            // array list and check if the price is negative (payment)
            if (item.getAmount() < 0) {
                //printing out it's private variables using the getter methods
                System.out.println(item.getDate() + " " + item.getTime() + " " + item.getDescription() + " " +
                        item.getVendor() + " " + item.getAmount());
            }
        }
    }

    private static void showDepositedEntries() {
        System.out.println(" Deposit");
        for (Transaction item : transactionsList) { // loop through each transaction object(item) in the transactionslist
            // array list and check if the amount is positive(Deposits)
            if (item.getAmount() > 0) {
                //printing out it's private variables using the getter methods
                System.out.println(item.getDate() + " " + item.getTime() + " " + item.getDescription() + " " +
                        item.getVendor() + " " + item.getAmount());
            }
        }

    }

    private static void allEntries() { // Declaring the allentries() method
        System.out.println(" All Entries");
        for (Transaction item : transactionsList) { // loop through each transaction object(item) in the transactionslist
            // array list and printing out it's private variables using the getter methods
            System.out.println(item.getDate() + " " + item.getTime() + " " + item.getDescription() + " " +
                    item.getVendor() + " " + item.getAmount());
        }
    }

    //show reports
    public static void showReports() { // creating a method called showReports() to display the reprots menu
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your Reports ledger ");
        System.out.println(("Reports Menu: "));
        System.out.println("[1] - Month to Date");
        System.out.println("[2] - Previous months");
        System.out.println("[3] - Year to Date");
        System.out.println("[4] - Previous Year");
        System.out.println("[5] - Search by Vendor");
        System.out.println("[6] - Go back to Report page");
        //using switch method instead of if/else statement to run the corresponding method based on user's input
        String input = scanner.nextLine();
        switch (input.toUpperCase()) {
            case "1":
                MonthtoDate();
                break;

            case "2":
                PreviousMonths();
                break;

            case "3":
                YeartoDate();
                break;

            case "4":
                PreviousYear();
                break;

            case "5":
                SearchbyVendor();
                break;

            case "6":
                BacktoReport();
                break;

        }
    }

    private static void MonthtoDate() {
        System.out.println("Month to Date");

//        private void displayMonthToDate() {
//            public class MonthToDate {
//                    LocalDate currentDate = LocalDate.now();
//                    LocalDate monthStartDate = currentDate.withDayOfMonth(1);
//                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//                ..System.out.println("Month to Date: " + monthStartDate.format(formatter) + " - " + currentDate.format(formatter));
//                }
//            }
//        }
//        }
    private static void PreviousMonths() {

        }
        System.out.println("Previous Months");
        for (Transaction item : transactionsList) { // loop through each transaction object(item) in the transactionslist
            // array list and check if the price is negative (payment)
            if (item.getAmount() < 0) {
                //printing out it's private variables using the getter methods
                System.out.println(item.getDate());
            }
        }
    }

    private static void YeartoDate() {
        System.out.println("Year to Date");
        for (Transaction item : transactionsList) { // loop through each transaction object(item) in the transactionslist
            // array list and check if the price is negative (payment)
            if (item.getAmount() < 0) {
                //printing out it's private variables using the getter methods
                System.out.println(item.getDate());
            }
        }
    }

    private static void PreviousYear() {
        System.out.println("Previous Year");
        for (Transaction item : transactionsList) { // loop through each transaction object(item) in the transactionslist
            // array list and check if the price is negative (payment)
            if (item.getAmount() < 0) {
                //printing out it's private variables using the getter methods
                System.out.println(item.getDate());
            }
        }
    }

    private static void SearchbyVendor() {
        System.out.println("Search by Vendor");
        for (Transaction item : transactionsList) { // loop through each transaction object(item) in the transactionslist
            // array list and check if the price is negative (payment)
            if (item.getAmount() < 0) {
                //printing out it's private variables using the getter methods
                System.out.println(item.getDate());
            }
        }
    }

    private static void BacktoReport() {
        System.out.println("Back to Report");
        for (Transaction item : transactionsList) { // loop through each transaction object(item) in the transactionslist
            // array list and check if the price is negative (payment)
            if (item.getAmount() < 0) {
                //printing out it's private variables using the getter methods
                System.out.println(item.getDate());
            }
        }
    }
}


