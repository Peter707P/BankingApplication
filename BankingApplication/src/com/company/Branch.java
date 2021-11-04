package com.company;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer>customers; // we can have a separate list of customers for each branch


    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // we using boolean to return false if the customer already on file
    public boolean newCustomer(String customerName,double initialAmount){
        if (findCustomer(customerName) == null){ // means if the customer not on file
            this.customers.add(new Customer(customerName,initialAmount));// with the new keyword we creating
             return true;                                                           //a new customer object
        }
        return false;
    }

    // creating the add transaction method and only processing if the customer is on file
    public boolean addCustomerTransaction(String customerName,double amount){
        Customer existingCustomer = findCustomer(customerName);

        if (existingCustomer != null){ // means if the customer on file
           existingCustomer.addTransaction(amount);// and process the transaction
            return true;
        }
        return false;
    }

    //make this method private because it will be used internally only in this class
    private Customer findCustomer(String customerName){
        //we need a for loop to go trough the records
        for (int i = 0;i < this.customers.size();i++){
            if (this.customers.get(i).getName().equals(customerName)){//checking if the name we getting is matching
                return this.customers.get(i);
            }
        }
        return null; // if the name is not on file we return null
    }
}
