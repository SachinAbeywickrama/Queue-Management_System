/**
 * Name: Sachin Suranjana Abeywickrama
 * IIT Number: 20221177
 * UOW Number: w1998726
 * I confirm that I understand what plagiarism / collusion /
 * contract cheating is and have read and understood
 * the section on Assessment Offences in the Essential Information for Students. * The work that I have submitted is entirely my own.
 * Any work from other authors is duly referenced and acknowledged.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize the arrays and stock
        String[] Cashier_1 = new String[2];
        String[] Cashier_2 = new String[3];
        String[] Cashier_3 = new String[5];
        int stock = 50;

        while (true) {
            // Display the menu
            displayMenu();
            // Read user input
            int input_Int = 0;
            String input_String = "";
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n");
            System.out.print("Enter an option: ");

            if (scanner.hasNextInt()) {
                int userInt = scanner.nextInt();
                input_Int += userInt;

            } else {
                String userString = scanner.next();
                input_String += userString;

            }
            // Process user input based on the selected option
            if (input_Int == 100 || input_String.equalsIgnoreCase("vfq")) {
                displayQueues(Cashier_1, Cashier_2, Cashier_3);

            } else if (input_Int == 101 || input_String.equalsIgnoreCase("veq")) {
                checkEmptyQueues(Cashier_1, Cashier_2, Cashier_3);

            } else if (input_Int == 102 || input_String.equalsIgnoreCase("acq")) {
                // Add customer to a queue
                try {
                    System.out.println("Enter cashier index (1, 2, or 3): ");
                    int addToQueue = scanner.nextInt();
                    System.out.print("Enter customer name: ");
                    String name = scanner.next();
                    switch (addToQueue) {
                        case 1 -> addCustomerToQueue(Cashier_1, name);
                        case 2 -> addCustomerToQueue(Cashier_2, name);
                        case 3 -> addCustomerToQueue(Cashier_3, name);
                        default -> System.out.println("Invalid Cashier");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input");
                }
            } else if (input_Int == 103 || input_String.equalsIgnoreCase("rcq")) {
                // Remove a customer from a queue
                try {
                    System.out.print("Enter cashier number (1, 2, or 3): ");
                    int removeFromQueue = scanner.nextInt();
                    System.out.print("Enter the position of the customer to remove (starting from 1): ");
                    int position = scanner.nextInt();
                    switch (removeFromQueue) {
                        case 1 -> removeCustomerFromQueue(Cashier_1, position);
                        case 2 -> removeCustomerFromQueue(Cashier_2, position);
                        case 3 -> removeCustomerFromQueue(Cashier_3, position);
                        default -> System.out.println("Invalid input");
                    }
                    System.out.println("Customer " + position + " removed from the queue of Cashier " + removeFromQueue);
                } catch (Exception e) {
                    System.out.println("Invalid Input");
                }
            } else if (input_Int == 104 || input_String.equalsIgnoreCase("pcq")) {
                // Remove a served customer
                try {
                    System.out.print("Enter cashier number (1, 2, or 3): ");
                    int serveCustomer = scanner.nextInt();
                    if (stock > 0) {
                        switch (serveCustomer) {
                            case 1 -> stock = removeServedCustomer(Cashier_1, stock);
                            case 2 -> stock = removeServedCustomer(Cashier_2, stock);
                            case 3 -> stock = removeServedCustomer(Cashier_3, stock);
                            default -> System.out.println("invalid Input");
                        }
                    }else {
                        System.out.println("No Burgers to serve! ");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Input");
                }

            } else if (input_Int == 105 || input_String.equalsIgnoreCase("vcs")) {
                // View Customers Sorted in alphabetical order
                sortCustomers(Cashier_1, Cashier_2, Cashier_3);

            }else if (input_Int == 106 || input_String.equalsIgnoreCase("spd")) {
                // Store Program Data into file
                storeProgramData(stock, Cashier_1, Cashier_2, Cashier_3);

            } else if (input_Int == 107 || input_String.equalsIgnoreCase("lpd")) {
                // Load Program Data from file
                stock = loadStoredData(stock, Cashier_1, Cashier_2, Cashier_3);

            } else if (input_Int == 108 || input_String.equalsIgnoreCase("stk")) {
                // View Remaining burgers Stock
                System.out.println("There are " + stock + " remaining");

            } else if (input_Int == 109 || input_String.equalsIgnoreCase("afs")) {
                // Add burgers to Stock
                try {
                    if(stock < 50) {
                        System.out.print("Enter the number of burgers to add: ");
                        int burgersAdding = scanner.nextInt();
                        stock = addBurgersToStock(burgersAdding, stock);
                    }else{
                        System.out.println("Cannot store more than 50 burgers");
                    }
                }catch (Exception e){
                    System.out.println("Invalid Input");
                }
            } else if (input_Int == 999 || input_String.equalsIgnoreCase("ext")) {
                // Exit the program
                System.out.println("You will now exit the program");
                System.out.println("Thank you");
                break;
            }else {
                System.out.println("Invalid Input");
            }
            // Check if stock is low
            if (stock <= 10){
                System.out.println();
                System.out.println("Alert!");
                System.out.println("There's only "+stock+" Burgers left.");
            }
        }
    }

    // Display the menu options
    public static void displayMenu() {
        System.out.println();
        System.out.println("""
                    Welcome to Foodies Fave Food center
                    100 or VFQ: View all Queues
                    101 or VEQ: View all Empty Queues
                    102 or ACQ: Add customer to a Queue
                    103 or RCQ: Remove a customer from a Queue
                    104 or PCQ: Remove a served customer.
                    105 or VCS: View Customers Sorted in alphabetical order
                    106 or SPD: Store Program Data into file
                    107 or LPD: Load Program Data from file
                    108 or STK: View Remaining burgers Stock
                    109 or AFS: Add burgers to Stock
                    999 or EXT: Exit the Program
                """);
    }

    // Check if a queue is empty
    public static boolean emptyQueue(String[] array) {
        for (String s : array) {
            if (s != null) {
                return false;
            }
        }
        return true;
    }

    // Check and display empty queues
    public static void checkEmptyQueues(String[] arrayOne, String[] arrayTwo, String[] arrayThree) {
        if (emptyQueue(arrayOne) && emptyQueue(arrayTwo) && emptyQueue(arrayThree)) {
            System.out.println("All queues are empty");
            return;
        }

        if (emptyQueue(arrayOne)) {
            System.out.println("Queue one is empty");
        }
        if (emptyQueue(arrayTwo)) {
            System.out.println("Queue two is empty");
        }
        if (emptyQueue(arrayThree)) {
            System.out.println("Queue three is empty");
        }
    }

    // Create a copy of the array and replace null elements with "X" or "0"
    public static String[] copyArray(String[] array){
        String[] Queue = new String[array.length];
        for(int i = 0; i < array.length; i++){
            if(array[i] == null){
                Queue[i] = "X";
            }else{
                Queue[i] = "0";
            }
        }
        return Queue;
    }

    // Display the queues
    public static void displayQueues(String[] arrayOne, String[] arrayTwo, String[] arrayThree){
        String[] Queue_1 = copyArray(arrayOne);
        String[] Queue_2 = copyArray(arrayTwo);
        String[] Queue_3 = copyArray(arrayThree);

        System.out.println();
        System.out.println("""
                ***********
                * Cashier *
                ***********""");
        for (int i = 0; i < 2; i++) {
            System.out.printf("  %s  %s  %s%n", Queue_1[i], Queue_2[i], Queue_3[i]);
        }

        System.out.printf("     %s  %s%n", Queue_2[2], Queue_3[2]);
        System.out.println("        " + Queue_3[3]);
        System.out.println("        " + Queue_3[4]);
    }


    // Check if a queue is full
    public static boolean displayFullQueue(String[] array) {
        for(String s : array){
            if(s == null){
                return false;
            }
        }
        return true;
    }

    // Add a customer to a queue
    public static void addCustomerToQueue(String[] array, String name) {
        if (displayFullQueue(array)) {
            System.out.println("Cashier is full");
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    array[i] = name;
                    break;
                }
            }
        }
    }

    // Shift customers forward after the 1st customer served
    public static void shiftCustomersForward(String[] array, int position){
        for(int i = position - 1; i < array.length - 1; i++) {
            if (array[i] == null && array[i+1] != null) {
                array[i] = array[i+1];
                array[i+1] = null;
            }
        }
    }

    // Remove a customer from a queue
    public static void removeCustomerFromQueue(String[] array, int position){
        if(array[position - 1] == null){
            System.out.println("That position is empty");
        }else{
            System.out.printf("%s has been removed", array[position - 1]);
            array[position - 1] = null;
            shiftCustomersForward(array, position);
        }
    }

    // Remove a served customer
    public static int removeServedCustomer(String[] array, int burgersRemaining) {
        if(array[0] == null){
            System.out.println("No one to serve");
        }else{
            System.out.printf("%s has been served 5 burgers", array[0]);
            array[0] = null;
            burgersRemaining -= 5;
            shiftCustomersForward(array, 1);
        }
        return burgersRemaining;
    }

    // Combine arrays and sort customer names in alphabetical order
    public static void sortCustomers(String[] arrayOne, String[] arrayTwo, String[] arrayThree){
        int totalLength = 0;

        // Calculate the total length, excluding null elements
        for (String s : arrayOne) {
            if (s != null) {
                totalLength++;
            }
        }
        for (String s : arrayTwo) {
            if (s != null) {
                totalLength++;
            }
        }
        for (String s : arrayThree) {
            if (s != null) {
                totalLength++;
            }
        }

        // Create a new array with the calculated length
        String[] combinedArray = new String[totalLength];

        int index = 0;

        // Copy non-null elements from arrOne into combinedArray
        for (String s : arrayOne) {
            if (s != null) {
                combinedArray[index] = s;
                index++;
            }
        }

        // Copy non-null elements from arrTwo into combinedArray
        for (String s : arrayTwo) {
            if (s != null) {
                combinedArray[index] = s;
                index++;
            }
        }

        // Copy non-null elements from arrayThree into combinedArray
        for (String s : arrayThree) {
            if (s != null) {
                combinedArray[index] = s;
                index++;
            }
        }

        viewCustomersSorted(combinedArray);
    }


    // Sort and display customers in alphabetical order
    public static void viewCustomersSorted(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (customerRelationTo(array[i], array[j]) > 0) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (String name : array) {
            System.out.println("- " + name);
        }
    }

    // Compare two customer names for sorting - "compareTo"
    public static int customerRelationTo(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int minLength = Math.min(len1, len2);

        for (int i = 0; i < minLength; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (ch1 != ch2) {
                return ch1 - ch2;
            }
        }

        // All characters in the common prefix are equal, compare lengths
        return len1 - len2;
    }

    // Store program data into a text file
    public static void storeProgramData(int stock, String[] arrayOne, String[] arrayTwo, String[] arrayThree){
        try{
            FileWriter FileWrite = new FileWriter("courseWork.txt");
            FileWrite.write(stock+"\n");
            saveCustomers(arrayOne, FileWrite);
            saveCustomers(arrayTwo, FileWrite);
            saveCustomers(arrayThree, FileWrite);
            FileWrite.close();
            System.out.println("Program data stored successfully.");
        }catch(Exception e){
            System.out.println("An error occurred");
        }
    }

    // Check and write customer names or "null"
    public static void saveCustomers(String[] array, FileWriter FileWrite) throws IOException {
        for (String s : array) {
            if (s == null) {
                FileWrite.write("- null -\n");
            } else {
                FileWrite.write(s + "\n");
            }
        }
    }

    // Load program data from file
    public static int loadStoredData(int stock,  String[] arrayOne, String[] arrayTwo, String[] arrayThree){
        try {
            File FileWrite = new File("courseWork.txt");
            Scanner fileScanner = new Scanner(FileWrite);
            stock = Integer.parseInt(fileScanner.nextLine());
            loadCustomers(arrayOne, fileScanner);
            loadCustomers(arrayTwo, fileScanner);
            loadCustomers(arrayThree, fileScanner);
            fileScanner.close();

        }catch (Exception e){
            System.out.println("An error occurred");
        }
        return stock;
    }

    // Check and load customer names from file into an array
    public static void loadCustomers(String[] array, Scanner scan){
        for(int i = 0; i < array.length; i++){
            String name = scan.nextLine();
            if(name.equals("- null -")){
                array[i] = null;
            }else{
                array[i] = name;
            }
        }
    }

    // Add burgers to stock
    public static int addBurgersToStock(int burgersAdded, int stock){
        if((stock+burgersAdded) > 50){
            System.out.println("50 burgers has been stored");
            System.out.printf("%d burgers has been ignored", (stock+burgersAdded-50));
            return 50;
        }else if(burgersAdded < 0){
            System.out.println("Invalid input");
        }else {
            return stock + burgersAdded;
        }
        return stock;
    }

}