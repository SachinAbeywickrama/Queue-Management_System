import java.io.FileWriter;
import java.io.IOException;

public class FoodQueue {

    Customer[] queue;

    public FoodQueue(int size){
        queue = new Customer[size];
    }

    // Check the status of a specific index in the queue array
    public String checkArrayIndex(int i){
        try{
            if(queue[i] == null){
                return "X";
            }else{
                return "0";
            }
        }catch(Exception e){
            return " ";
        }
    }

    // Check if the queue is empty
    public boolean isEmpty(){
        return queue[0] == null;
    }

    // Add a customer to the queue
    public void addCustomerToQueue(Customer customer){
        for(int i = 0; i < queue.length; i++){
            if(queue[i] == null){
                queue[i] = customer;
                break;
            }
        }
    }

    // Check if a specific index in the queue is empty
    public boolean checkIndex(int i){
        return queue[i] == null;
    }

    // Get the size of the queue
    public int queueSize(){
        return queue.length;
    }

    // Set a specific position in the queue to null
    public void setPositionToNull(int i){
        queue[i] = null;
    }

    // Move customers forward in the queue after a position is removed
    public void moveCustomersForward(int position){
        for(int i = position - 1 ; i < queue.length - 1; i++){
            if(checkIndex(i) && !checkIndex(i + 1)) {
                queue[i] = queue[i+1];
                queue[i+1] = null;
            }
        }
    }


    // Check if the queue is full
    public boolean checkFullQueue(){
        for (Customer customer : queue) {
            if (customer == null) {
                return false;
            }
        }
        return true;
    }

    // Print the name of the removed customer
    public void getRemovedName(int i){
        System.out.println(queue[i].getFullName() + " has been removed");
    }

    // Get the customer at a specific index in the queue
    public Customer seeCustomer(int i){
        return queue[i];
    }

    // Save customers' data to a file
    public void saveCustomers(FileWriter dataFile) throws IOException {
        for (Customer customer : queue) {
            if (customer == null) {
                dataFile.write("null\n");
            } else {
                dataFile.write(customer.CustomerFullDetails()+"\n");
            }
        }
    }

    // Get the length of the array with non-null elements
    public int getArrayLength(int index){
        for(Customer customer : queue){
            if(customer != null){
                index++;
            }
        }
        return index;
    }

    // Add customers' names to an array for sorting
    public int addCustomerToQueue(int index, String[] array){
        for(int i = 0; i < queue.length; i++){
            if(!checkIndex(i)){
                array[index] = queue[i].getFullName();
                index++;
            }
        }
        return index;
    }
    // Set customer details at a specific index in the queue
    public void setCustomerDetails(int i, String fName, String sName, String burgers){
        int noOfBurgers = Integer.parseInt(burgers);
        Customer customer = new Customer(fName, sName, noOfBurgers);
        queue[i] = customer;
    }

    // Calculate the total income from the queue
    public int checkIncome(){
        int income = 0;
        for(Customer customer : queue){
            if(customer!= null){
                income += customer.getNoOfBurgers() * 650; // Assuming the price per burger is 650
            }
        }
        return income;
    }

}
