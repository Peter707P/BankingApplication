package com.company;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch>branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }
    private Branch findBranch(String branchName){
        for (int i = 0;i < this.branches.size();i++){
            Branch checkedBranch = this.branches.get(i);
           if (checkedBranch.getName().equals(branchName)){
               return checkedBranch;   // if on the list
           }
        }
        return null; // if not on the list
    }
    public boolean addBranch(String branchName){
        if (findBranch(branchName) == null){
            this.branches.add(new Branch(branchName));// add if not on the list
            return true;
        }
        return false;  // if already on the list
    }
    public boolean addCustomer(String branchName,String customerName,double initialAmount){
        Branch branch = findBranch(branchName);

        if (branch != null){   // if branch exists
           return branch.newCustomer(customerName, initialAmount);
        }
         return false; // if we can not add customer
    }
    public boolean addCustomerTransaction(String branchName,String customerName,double amount){
        Branch branch = findBranch(branchName);

        if (branch != null){   // if branch exists
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false; // if we can not add transaction
    }
    public boolean listCustomers(String branchName,boolean showTransactions){
        Branch branch = findBranch(branchName);

        if (branch != null){
            System.out.println("Customers details for branch " + branch.getName());

            ArrayList<Customer>branchCustomers = branch.getCustomers();
            for (int i = 0;i < branchCustomers.size();i++){  // here we getting a list of all customers for that branch
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer : " + branchCustomer.getName() + "[" + (i+1) + "]");
                if (showTransactions){ // optional if it set to true it will show
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransaction();
                    for (int j = 0;j < transactions.size();j++){ // we are already in a loop so using j as a variable
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }else {
            return false;
        }

    }

}
