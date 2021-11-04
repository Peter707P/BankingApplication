package com.company;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double>transaction;

                                      // this is where the customer going to make
                                      // the initial transaction
    public Customer(String name, double initialAmount) {
        this.name = name;
        // we need to initialize the transaction which going to
        // be our array list
        this.transaction = new ArrayList<Double>();
        addTransaction(initialAmount);// going to handle the initial amount and the upcoming transactions
    }
    // and we need a method to process the transaction
    public void addTransaction(double amount){
        this.transaction.add(amount);  //converting primitive type double to an object
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }
}
