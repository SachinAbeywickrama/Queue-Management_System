package com.example.task_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController{

    @FXML
    private Text displayName;

    @FXML
    private TextField txtSearchBar;

    @FXML
    private Button searchCustomer;

    @FXML
    public Button viewQueue;

    @FXML
    private Button viewWaiting;

    // Labels for displaying customers in Cashier queues
    @FXML
    private Label C1P1;
    @FXML
    private Label C1P2;
    @FXML
    private Label C2P1;
    @FXML
    private Label C2P2;
    @FXML
    private Label C2P3;
    @FXML
    private Label C3P1;
    @FXML
    private Label C3P2;
    @FXML
    private Label C3P3;
    @FXML
    private Label C3P4;
    @FXML
    private Label C3P5;

    // Labels for displaying customers in the waiting queue
    @FXML
    private Label WC1;
    @FXML
    private Label WC2;
    @FXML
    private Label WC3;
    @FXML
    private Label WC4;
    @FXML
    private Label WC5;
    @FXML
    private Label WC6;
    @FXML
    private Label WC7;
    @FXML
    private Label WC8;
    @FXML
    private Label WC9;
    @FXML
    private Label WC10;



    @FXML
    void viewingQueues(ActionEvent event){
        try{
            // Display customers in Cashier 1 queue
            if(!HelloApplication.Cashier_1.checkIndex(0)){
                C1P1.setText(HelloApplication.Cashier_1.seeCustomer(0).getFullName() + " " + HelloApplication.Cashier_1.seeCustomer(0).getNoOfBurgers());
            } else{
                C1P1.setText("Empty");
            }
            if(!HelloApplication.Cashier_1.checkIndex(1)){
                C1P2.setText(HelloApplication.Cashier_1.seeCustomer(1).getFullName() + " " + HelloApplication.Cashier_1.seeCustomer(1).getNoOfBurgers());
            } else{
                C1P2.setText("Empty");
            }
            //Display customers in Cashier 2 queue
            if(!HelloApplication.Cashier_2.checkIndex(0)){
                C2P1.setText(HelloApplication.Cashier_2.seeCustomer(0).getFullName() + " " + HelloApplication.Cashier_2.seeCustomer(0).getNoOfBurgers());
            } else{
                C2P1.setText("Empty");
            }
            if(!HelloApplication.Cashier_2.checkIndex(1)){
                C2P2.setText(HelloApplication.Cashier_2.seeCustomer(1).getFullName() + " " + HelloApplication.Cashier_2.seeCustomer(1).getNoOfBurgers());
            } else{
                C2P2.setText("Empty");
            }
            if(!HelloApplication.Cashier_2.checkIndex(2)){
                C2P3.setText(HelloApplication.Cashier_2.seeCustomer(2).getFullName() + " " + HelloApplication.Cashier_2.seeCustomer(2).getNoOfBurgers());
            } else{
                C2P3.setText("Empty");
            }
            //Display customers in Cashier 3 queue
            if(!HelloApplication.Cashier_3.checkIndex(0)){
                C3P1.setText(HelloApplication.Cashier_3.seeCustomer(0).getFullName() + " " + HelloApplication.Cashier_3.seeCustomer(0).getNoOfBurgers());
            } else{
                C3P1.setText("Empty");
            }
            if(!HelloApplication.Cashier_3.checkIndex(1)){
                C3P2.setText(HelloApplication.Cashier_3.seeCustomer(1).getFullName() + " " + HelloApplication.Cashier_3.seeCustomer(1).getNoOfBurgers());
            } else{
                C3P2.setText("Empty");
            }
            if(!HelloApplication.Cashier_3.checkIndex(2)){
                C3P3.setText(HelloApplication.Cashier_3.seeCustomer(2).getFullName() + " " + HelloApplication.Cashier_3.seeCustomer(2).getNoOfBurgers());
            } else{
                C3P3.setText("Empty");
            }
            if(!HelloApplication.Cashier_3.checkIndex(3)){
                C3P4.setText(HelloApplication.Cashier_3.seeCustomer(3).getFullName() + " " + HelloApplication.Cashier_3.seeCustomer(3).getNoOfBurgers());
            } else{
                C3P4.setText("Empty");
            }
            if(!HelloApplication.Cashier_3.checkIndex(4)){
                C3P5.setText(HelloApplication.Cashier_3.seeCustomer(4).getFullName() + " " + HelloApplication.Cashier_3.seeCustomer(4).getNoOfBurgers());
            } else{
                C3P5.setText("Empty");
            }
            //end of cashier 3

        }catch (Exception e){
            C1P1.setText("Error");
        }
    }

    @FXML
    void viewingWaitingQueues(ActionEvent event){
        try {
            // Display customers in the waiting queue
            if(!HelloApplication.waitingQueue.checkIndex(0)){
                WC1.setText(HelloApplication.waitingQueue.seeCustomer(0).getFullName() + " " + HelloApplication.waitingQueue.seeCustomer(0).getNoOfBurgers());
            } else{
                WC1.setText("Empty");
            }
            if(!HelloApplication.waitingQueue.checkIndex(1)){
                WC2.setText(HelloApplication.waitingQueue.seeCustomer(1).getFullName() + " " + HelloApplication.waitingQueue.seeCustomer(1).getNoOfBurgers());
            } else{
                WC2.setText("Empty");
            }
            if(!HelloApplication.waitingQueue.checkIndex(2)){
                WC3.setText(HelloApplication.waitingQueue.seeCustomer(2).getFullName() + " " + HelloApplication.waitingQueue.seeCustomer(2).getNoOfBurgers());
            } else{
                WC3.setText("Empty");
            }
            if(!HelloApplication.waitingQueue.checkIndex(3)){
                WC4.setText(HelloApplication.waitingQueue.seeCustomer(3).getFullName() + " " + HelloApplication.waitingQueue.seeCustomer(3).getNoOfBurgers());
            } else{
                WC4.setText("Empty");
            }
            if(!HelloApplication.waitingQueue.checkIndex(4)){
                WC5.setText(HelloApplication.waitingQueue.seeCustomer(4).getFullName() + " " + HelloApplication.waitingQueue.seeCustomer(4).getNoOfBurgers());
            } else{
                WC5.setText("Empty");
            }
            if(!HelloApplication.waitingQueue.checkIndex(5)){
                WC6.setText(HelloApplication.waitingQueue.seeCustomer(5).getFullName() + " " + HelloApplication.waitingQueue.seeCustomer(5).getNoOfBurgers());
            } else{
                WC6.setText("Empty");
            }
            if(!HelloApplication.waitingQueue.checkIndex(6)){
                WC7.setText(HelloApplication.waitingQueue.seeCustomer(6).getFullName() + " " + HelloApplication.waitingQueue.seeCustomer(6).getNoOfBurgers());
            } else{
                WC7.setText("Empty");
            }
            if(!HelloApplication.waitingQueue.checkIndex(7)){
                WC8.setText(HelloApplication.waitingQueue.seeCustomer(7).getFullName() + " " + HelloApplication.waitingQueue.seeCustomer(7).getNoOfBurgers());
            } else{
                WC8.setText("Empty");
            }
            if(!HelloApplication.waitingQueue.checkIndex(8)){
                WC9.setText(HelloApplication.waitingQueue.seeCustomer(8).getFullName() + " " + HelloApplication.waitingQueue.seeCustomer(8).getNoOfBurgers());
            } else{
                WC9.setText("Empty");
            }
            if(!HelloApplication.waitingQueue.checkIndex(9)){
                WC10.setText(HelloApplication.waitingQueue.seeCustomer(9).getFullName() + " " + HelloApplication.waitingQueue.seeCustomer(9).getNoOfBurgers());
            } else{
                WC10.setText("Empty");
            }// Remaining waiting queue labels...
        }catch (Exception e) {
            WC1.setText("Error");
        }
    }

    @FXML
    void searchCustomer(ActionEvent event){
    String searchText = "";
    String temp = "";
    String search = txtSearchBar.getText();
        // Search for customers in Cashier 1 queue
            if(!HelloApplication.Cashier_1.isEmpty()){
        searchText += "---- Queue One ----";
        for(int i = 0; i < HelloApplication.Cashier_1.queueSize(); i++){
            if(!HelloApplication.Cashier_1.checkIndex(i) && HelloApplication.Cashier_1.seeCustomer(i).getFullName().contains(search)){
                searchText += "\n";
                searchText += HelloApplication.Cashier_1.seeCustomer(i).getFullName();
            }
        }
    }searchText += "\n";

            if("QueueOne".equalsIgnoreCase(searchText.replaceAll("\\s+",""))){
        searchText = "";
    }

        // Search for customers in Cashier 2 queue
        if(!HelloApplication.Cashier_2.isEmpty()){
            searchText += "---- Queue Two ----";
            for(int i = 0; i < HelloApplication.Cashier_2.queueSize(); i++){
                if(!HelloApplication.Cashier_2.checkIndex(i) && HelloApplication.Cashier_2.seeCustomer(i).getFullName().contains(search)){
                    searchText += "\n";
                    searchText += HelloApplication.Cashier_2.seeCustomer(i).getFullName();
                }

            }

        }searchText += "\n";

        if("QueueTwo".equalsIgnoreCase(searchText.replaceAll("\\s+",""))){
            searchText = "";
        }

        // Search for customers in Cashier 3 queue
        if(!HelloApplication.Cashier_3.isEmpty()){
            searchText += "---- Queue Three ----";
            for(int i = 0; i < HelloApplication.Cashier_3.queueSize(); i++){
                if(!HelloApplication.Cashier_3.checkIndex(i) && HelloApplication.Cashier_3.seeCustomer(i).getFullName().contains(search)){
                    searchText += "\n";
                    searchText += HelloApplication.Cashier_3.seeCustomer(i).getFullName();
                }

            }

        }

        if("QueueTwo".equalsIgnoreCase(searchText.replaceAll("\\s+",""))){
            searchText = "";
        }
        if(searchText == ""){
            displayName.setText("No results");
        }else {
            displayName.setText(searchText);
        }
    }
}
