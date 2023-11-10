/**
 * Name: Sachin Suranjana Abeywickrama
 * IIT Number: 20221177
 * UOW Number: w1998726
 * I confirm that I understand what plagiarism / collusion /
 * contract cheating is and have read and understood
 * the section on Assessment Offences in the Essential Information for Students. * The work that I have submitted is entirely my own.
 * Any work from other authors is duly referenced and acknowledged.
 */

package com.example.task_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        // Load the GUI using JavaFX FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 920, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    // Declare static variables
    public static int stock = 50;
    public static FoodQueue Cashier_1 = new FoodQueue(2);
    public static FoodQueue Cashier_2 = new FoodQueue(3);
    public static FoodQueue Cashier_3 = new FoodQueue(5);
    public static FoodQueue waitingQueue = new FoodQueue(10);

        public static void main(String[] args) {
            // Create a scanner to read user input
            Scanner scanner = new Scanner(System.in);

            // Variables for user input
            int input_Int;
            String input_String;
            while (true) {
                displayMenu(); // Display the menu options
                input_Int = 0;
                input_String = "";
                System.out.println("\n");
                System.out.print("Enter an option: ");

                // Read user input as integer or string
                if (scanner.hasNextInt()) {
                    int userInt = scanner.nextInt();
                    input_Int += userInt;

                } else {
                    String userString = scanner.next();
                    input_String += userString;
                }

                // Check user input and perform corresponding actions
                if (input_Int == 100 || input_String.equalsIgnoreCase("vfq")) {
                    displayQueue(Cashier_1, Cashier_2, Cashier_3);

                } else if (input_Int == 101 || input_String.equalsIgnoreCase("veq")) {
                    emptyQueue(Cashier_1, Cashier_2, Cashier_3);

                } else if (input_Int == 102 || input_String.equalsIgnoreCase("acq")) {
                    checkShortestQueue(Cashier_1, Cashier_2, Cashier_3, waitingQueue, scanner);

                } else if (input_Int == 103 || input_String.equalsIgnoreCase("rcq")) {
                    removeCustomer(Cashier_1, Cashier_2, Cashier_3, scanner, waitingQueue);

                } else if (input_Int == 104 || input_String.equalsIgnoreCase("pcq")) {
                    servedCustomer(Cashier_1, Cashier_2, Cashier_3, scanner, waitingQueue);

                } else if (input_Int == 105 || input_String.equalsIgnoreCase("vcs")) {
                    sortCustomers(Cashier_1, Cashier_2, Cashier_3);

                } else if (input_Int == 106 || input_String.equalsIgnoreCase("spd")) {
                    storeProgramData(stock, Cashier_1, Cashier_2, Cashier_3, waitingQueue);

                } else if (input_Int == 107 || input_String.equalsIgnoreCase("lpd")) {
                    loadData(Cashier_1, Cashier_2, Cashier_3, waitingQueue);

                } else if (input_Int == 108 || input_String.equalsIgnoreCase("stk")) {
                    viewRemainingBurgers();

                } else if (input_Int == 109 || input_String.equalsIgnoreCase("afs")) {
                    addBurgers(scanner);

                }else if (input_Int == 110 || input_String.equalsIgnoreCase("IFQ")) {
                    printIncomeDetails(Cashier_1, Cashier_2, Cashier_3);

                } else if (input_Int == 112 || input_String.equalsIgnoreCase("GUI")) {
                    launch();

                } else if (input_Int == 999 || input_String.equalsIgnoreCase("ext")) {
                    System.out.println("You will now exit the program");
                    System.out.println("Thank you");
                    break;

                } else {
                    System.out.println("Invalid Input");
                }
                // Check stock and display alert if stock is low
                if (stock <= 10) {
                    System.out.println("Alert");
                    System.out.println("****************************************************************");
                    System.out.println("You have " + stock + " remaining");
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
                        110 or IFQ: Print Income Details
                        112 or GUI: Launch GUI
                        999 or EXT: Exit the Program
                    """);
        }
    // Display the queues and their status
        public static void displayQueue(FoodQueue Cashier_1, FoodQueue Cashier_2, FoodQueue Cashier_3) {
            System.out.println("***********");
            System.out.println("* Cashier *");
            System.out.println("***********");

            for (int i = 0; i < 5; i++) {
                String queueOneStatus = Cashier_1.checkArrayIndex(i);
                String queueTwoStatus = Cashier_2.checkArrayIndex(i);
                String queueThreeStatus = Cashier_3.checkArrayIndex(i);

                System.out.printf("  %s  %s  %s%n", queueOneStatus, queueTwoStatus, queueThreeStatus);
            }

            System.out.println("0 = Occupied  X = Empty");
        }

    // Check if queues are empty
        public static void emptyQueue(FoodQueue Cashier_1, FoodQueue Cashier_2, FoodQueue Cashier_3) {
            if (Cashier_1.isEmpty() && Cashier_2.isEmpty() && Cashier_3.isEmpty()) {
                System.out.println();
                System.out.print("All queues are empty");
                System.out.println();
            } else {
                if (Cashier_1.isEmpty()) {
                    System.out.println();
                    System.out.println("Queue one is empty");
                }
                if (Cashier_2.isEmpty()) {
                    System.out.println();
                    System.out.println("Queue two is empty");
                }
                if (Cashier_3.isEmpty()) {
                    System.out.println();
                    System.out.println("Queue three is empty");

                } else {
                    System.out.println();
                    System.out.println("No queues are empty");
                }
            }
        }
    // Add a customer to the shortest queue or the waiting queue
        public static void checkShortestQueue(FoodQueue Cashier_1, FoodQueue Cashier_2, FoodQueue Cashier_3, FoodQueue waitingQueue, Scanner scanner) {
            Customer customer = new Customer(scanner);
            if (Cashier_1.checkFullQueue() && Cashier_2.checkFullQueue() && Cashier_3.checkFullQueue()) {
                if (waitingQueue.checkFullQueue()) {
                    System.out.println("All the Queues are full ");
                    System.out.println("Waiting queue is also full, Cannot add the customer");
                } else {
                    waitingQueue.addCustomerToQueue(customer);
                    System.out.println(customer.getFullName() + " added to the waiting queue");
                }
            } else {

                FoodQueue shortestQueue = null;

                for (int i = 0; i < 5; i++) {
                    if (i == 0 || i == 1) {
                        if (Cashier_1.checkIndex(i)) {
                            shortestQueue = Cashier_1;
                            System.out.println(customer.getFullName() + " added to queue one");
                            break;
                        }
                    }

                    if (i == 0 || i == 1 || i == 2) {
                        if (Cashier_2.checkIndex(i)) {
                            shortestQueue = Cashier_2;
                            System.out.println(customer.getFullName() + " added to queue two");
                            break;
                        }
                    }

                    if (Cashier_3.checkIndex(i)) {
                        shortestQueue = Cashier_3;
                        System.out.println(customer.getFullName() + " added to queue three");
                        break;
                    }
                }

                if (shortestQueue != null) {
                    shortestQueue.addCustomerToQueue(customer);
                }
            }
        }

    // Remove a customer from a specific queue
        public static void removeCustomer(FoodQueue Cashier_1, FoodQueue Cashier_2, FoodQueue Cashier_3, Scanner scanner, FoodQueue waitingQueue) {
            try {
                System.out.print("From what queue would you like to remove a customer (1, 2, or 3): ");
                int queue = scanner.nextInt();
                System.out.print("Enter position (starting from 1): ");
                int position = scanner.nextInt();
                switch (queue) {
                    case 1 -> removeCustomerFromQueue(Cashier_1, position, waitingQueue);
                    case 2 -> removeCustomerFromQueue(Cashier_2, position, waitingQueue);
                    case 3 -> removeCustomerFromQueue(Cashier_3, position, waitingQueue);
                    default -> System.out.println("Invalid queue");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    // Remove a customer from a specific queue
        public static void removeCustomerFromQueue(FoodQueue queue, int position, FoodQueue waitingQueue) {
            if (queue.checkIndex(position - 1)) {
                System.out.println("position is already empty");
            } else if (queue.queueSize() < position) {
                System.out.println("Invalid input");
            } else {
                queue.getRemovedName(position - 1);
                queue.setPositionToNull(position - 1);
                queue.moveCustomersForward(position);
                addCustomerFromWaitingQueue(queue, waitingQueue);
            }
        }
    // Serve a customer from a specific queue
        public static void servedCustomer(FoodQueue Cashier_1, FoodQueue Cashier_2, FoodQueue Cashier_3, Scanner scanner, FoodQueue waitingQueue) {
            try {
                System.out.print("What queue would you like to serve: ");
                int queue = scanner.nextInt();
                switch (queue) {
                    case 1 -> removeServedCustomer(Cashier_1, waitingQueue);
                    case 2 -> removeServedCustomer(Cashier_2, waitingQueue);
                    case 3 -> removeServedCustomer(Cashier_3, waitingQueue);
                    default -> System.out.println("Invalid input");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }
    // Add a customer from the waiting queue to a specific queue
        public static void addCustomerFromWaitingQueue(FoodQueue queue, FoodQueue waitingQueue) {
            if (!waitingQueue.isEmpty()) {
                queue.setCustomerDetails(queue.queueSize() - 1,
                        waitingQueue.seeCustomer(0).getFirstName(),
                        waitingQueue.seeCustomer(0).getLastName(),
                        Integer.toString(waitingQueue.seeCustomer(0).getNoOfBurgers()));
                System.out.println(waitingQueue.seeCustomer(0).getFullName() + " added to the queue from the waiting queue");
                waitingQueue.setPositionToNull(0);
                waitingQueue.moveCustomersForward(1);
            }
        }

        public static void removeServedCustomer(FoodQueue queue, FoodQueue waitingQueue) {
            if (queue.checkIndex(0)) {
                System.out.println("No one to serve");
            } else {
                if (stock < queue.seeCustomer(0).getNoOfBurgers()) {
                    System.out.println("Don't have that many burgers in stock");
                } else {
                    stock = stock - queue.seeCustomer(0).getNoOfBurgers();
                    System.out.println(queue.seeCustomer(0).getFullName() + " Was served " + queue.seeCustomer(0).getNoOfBurgers() + " burgers");
                    removeCustomerFromQueue(queue, 1, waitingQueue);
                }
            }
        }


    // Sort customers in alphabetical order and display them
        public static void sortCustomers(FoodQueue Cashier_1, FoodQueue Cashier_2, FoodQueue Cashier_3) {
            int totalLength = 0;

            totalLength = Cashier_1.getArrayLength(totalLength);
            totalLength = Cashier_2.getArrayLength(totalLength);
            totalLength = Cashier_3.getArrayLength(totalLength);

            String[] combinedArray = new String[totalLength];

            int index = 0;

            index = Cashier_1.addCustomerToQueue(index, combinedArray);
            index = Cashier_2.addCustomerToQueue(index, combinedArray);
            Cashier_3.addCustomerToQueue(index, combinedArray);

            viewCustomersSorted(combinedArray);
        }


        //This is represents a how to sort customer names in Alphabetical order.
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

        // Compare two customer names for sorting purposes - "compareTo"
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
            return len1 - len2;
        }

        //This is represents a how to store program data into a text file.
        public static void storeProgramData(int stock, FoodQueue Cashier_1, FoodQueue Cashier_2, FoodQueue Cashier_3, FoodQueue waitingQueue) {
            try {
                FileWriter FileWrite = new FileWriter("courseWork.txt");
                FileWrite.write(stock + "\n");
                Cashier_1.saveCustomers(FileWrite);
                Cashier_2.saveCustomers(FileWrite);
                Cashier_3.saveCustomers(FileWrite);
                waitingQueue.saveCustomers(FileWrite);
                FileWrite.close();
                System.out.println("Program data stored successfully.");
            } catch (Exception e) {
                System.out.println("An error occurred");
            }
        }

        //This is represents a how to Read data form Array and launch the program again.
        public static void loadData(FoodQueue queueOne, FoodQueue queueTwo, FoodQueue queueThree, FoodQueue waitingQueue) {
            try (Scanner fileScanner = new Scanner(new File("courseWork.txt"))) {
                stock = Integer.parseInt(fileScanner.nextLine());
                loadCustomer(queueOne, fileScanner);
                loadCustomer(queueTwo, fileScanner);
                loadCustomer(queueThree, fileScanner);
                loadCustomer(waitingQueue, fileScanner);
                System.out.println("Data loaded successfully");
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (NumberFormatException e) {
                System.out.println("Invalid stock value in the file");
            } catch (Exception e) {
                System.out.println("An error occurred while loading data");
            }
        }


    // Load customer data from a file into a queue
        public static void loadCustomer(FoodQueue queue, Scanner scanner) {
            for (int i = 0; i < queue.queueSize(); i++) {
                String name = scanner.nextLine();
                if (name.equals("null")) {
                    queue.setPositionToNull(i);
                } else {
                    String[] customerDetails = name.split("-", 4);
                    if (customerDetails.length >= 3) {
                        queue.setCustomerDetails(i, customerDetails[0], customerDetails[1], customerDetails[2]);
                    } else {
                        // Handle invalid input or missing customer details
                        System.out.println("Invalid input for customer details");
                    }
                }
            }
        }
    // Print income details for each cashier and total income
    public static void printIncomeDetails(FoodQueue Cashier_1, FoodQueue Cashier_2, FoodQueue Cashier_3){
        System.out.println("First Queue Income : " + Cashier_1.checkIncome());
        System.out.println("Second Queue Income : " + Cashier_2.checkIncome());
        System.out.println("Third Queue Income : " + Cashier_3.checkIncome());
        System.out.println("Total income : " + (Cashier_1.checkIncome()+Cashier_2.checkIncome()+Cashier_3.checkIncome()));
    }

    // View the remaining number of burgers in stock
        public static void viewRemainingBurgers() {
            System.out.println("You have " + stock + " remaining");
        }
    // Add burgers to the stock
        public static void addBurgers(Scanner scanner) {
            try {
                System.out.print("How many burgers would you like to add: ");
                int burgers = scanner.nextInt();

                if (burgers < 0) {
                    System.out.println("Invalid Input");
                    return;
                }

                int totalBurgers = stock + burgers;

                if (totalBurgers > 50) {
                    int burgersRemoved = totalBurgers - 50;
                    System.out.println("You can only store 50 burgers");
                    System.out.println(burgersRemoved + " burgers were removed");
                    totalBurgers = 50;
                }

                stock = totalBurgers;
                System.out.println(burgers + " burgers added");
                System.out.println("You currently have " + stock + " in stock");
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }

}

