package com.ReverseTheString;

import java.util.Scanner;

public  class Cashier {

    private String name;
    private int TransactionsCommitted;
    private int salesCommited;
    private double dollarsDeposited;
    private int itemsBroughtToInventory;
    private int itemsThrownAway;


    public void setItemsThrownAway(int itemsThrownAway) {
        this.itemsThrownAway = itemsThrownAway;
    }

    public int getItemsThrownAway() {
        return itemsThrownAway;
    }

    public void incrementItemsThrownAway() {
        this.itemsThrownAway++;
    }


    public void setDollarsDeposited(double dollarsDeposited) {
        this.dollarsDeposited += dollarsDeposited;
    }

    public double getDollarsDeposited() {
        return dollarsDeposited;
    }



    public void setItemsBroughtToInventory(int itemsBroughtToInventory) {
        this.itemsBroughtToInventory = itemsBroughtToInventory;
    }

    public int getItemsBroughtToInventory() {
        return itemsBroughtToInventory;
    }

    public void incrementItemsBroughtToInventory() {
        this.itemsBroughtToInventory++;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTransactionsCommitted() {
        return TransactionsCommitted;
    }



    public int getSalesCommited() {
        return salesCommited;
    }

    public void setSalesCommited(int salesCommited) {
        this.salesCommited = salesCommited;
    }

    public void incrementSalesCommited() {
        this.salesCommited++;
    }



    public void setTransactionsCommitted(int transactionsCommitted) {

        this.TransactionsCommitted = transactionsCommitted;
    }

    public void incrementTransactionsCommitted() {

        this.TransactionsCommitted++;
    }

}
