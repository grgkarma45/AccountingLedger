# **[Accounting Ledger]()**

This is a simple command-line program for managing financial transactions.
The program allows users to make deposits, payments, and view a ledger of
all transactions. All transactions are stored in a CSV file named transactions.csv.

### How to start the application:

* Clone the repository and navigate to the src directory.

* Run the compiled file using the application like intellij.


## What does the program do:

    The program displays a Home Screen which has the following
    options:

    D - Add Deposit
    P - Make Payment 
    L - Ledger
    X - Exit

1) You can select an option by entering the corresponding
letter and press enter.

2) Depending on the option selected,
the program will prompt the user to enter the required information.

3) After the user enters the required information, the program will 
write the transaction to the transactions.csv file. 

4) If the user selects the L option, the program will take the user to showLedger() 
method which displays a menu of options to the user and waits for their input.


    The options are:
    [A] - Display all entries
    [D] - Display only the entries that are deposited into the account
    [p] - Display only the negative entries(payments)
    [R] - Reports
    [H] - Go back to Home page

    

The user's choice is read using a Scanner object and a switch statement is used to call the corresponding method based on the choice.

5) To exit the program, select the X option.

## How transactions are stored


The transactions.csv file stores all transactions in the following format:
date|time|description|vendor|amount

date - The date the transaction was made in the format yyyy-MM-dd.

time - The time the transaction was made in the format HH:mm:SS.

description - A brief description of the transaction.

vendor - The vendor associated with the transaction.

amount - The amount of the transaction. For payments, the amount is negative
##

### Some Screenshots of the application


![Main Menu.png](..%2F..%2FUsers%2FStudent%2FDesktop%2Fscreenshots%2FMain%20Menu.png)

![Ledger Menu.png](..%2F..%2FUsers%2FStudent%2FDesktop%2Fscreenshots%2FLedger%20Menu.png)

![Reports Menu.png](..%2F..%2FUsers%2FStudent%2FDesktop%2Fscreenshots%2FReports%20Menu.png)

![All Entries.png](..%2F..%2FUsers%2FStudent%2FDesktop%2Fscreenshots%2FAll%20Entries.png)