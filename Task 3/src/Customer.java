import java.util.Scanner;

public class Customer {

    private final String firstName;
    private final String lastName;
    private int noOfBurgers;

    // Constructor to create a customer object by taking input from the scanner
    public Customer(Scanner scanner){
        System.out.print("First name of customer: ");
        firstName = scanner.next();
        System.out.print("Last name: ");
        lastName = scanner.next();
        do{
            try{scanner.nextLine();  // Clear the input buffer
                System.out.print("Burgers: ");
                noOfBurgers = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Invalid Input");
            }
        }while(noOfBurgers <= 0);
    }

    // Constructor to create a customer object with given details
    public Customer(String firstName, String lastName, int noOfBurgers){
        this.firstName = firstName;
        this.lastName = lastName;
        this.noOfBurgers = noOfBurgers;
    }

    // Get the full name of the customer
    public String getFullName(){
        return firstName + " " + lastName;
    }

    // Get the number of burgers ordered by the customer
    public int getNoOfBurgers() {
        return noOfBurgers;
    }

    // Get the customer details in the format: firstName-lastName-noOfBurgers
    public String CustomerFullDetails(){ return firstName + "-" + lastName + "-" + noOfBurgers;}

    // Get the first name of the customer
    public String getFirstName() {
        return firstName;
    }

    // Get the last name of the customer
    public String getLastName() {
        return lastName;
    }
}
