package com.ReverseTheString;

import com.ReverseTheString.Products.Product;

import java.util.ArrayList;

public class Store {

    //Member Data

    private double balance;
    private ArrayList<Product> productArrayList;



    //Member Constructor

    public Store(){
        balance = 0;
        productArrayList = new ArrayList<>();
    }


    //Member Setters and Getters

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public void setProductArrayList(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
    }







    //Member Behaviors

    public void addProductToStore(Product product, int quantity){

        for (int i = 0; i < quantity; i++) {
            productArrayList.add(product);

            this.balance -= product.getProductCost();
        }

        System.out.println("\nCurrent Balance: " + this.balance);

    }

    public void sellProduct(Product product, int quantity){

        for (int i = 0; i < quantity; i++) {

            productArrayList.remove(product);

            this.balance += product.getProductCost();
        }

        System.out.println("\n----Sale Complete---");
        System.out.println("\nCurrent Balance: " + this.balance);

    }

    public void throwAwayProduct(Product product, int quantity){

        for (int i = 0; i < quantity; i++) {

            productArrayList.remove(product);

        }

    }

    public Product findProductInStore(String name){

        Product tempProduct = new Product("null",0);

        for (int i = 0; i < productArrayList.size(); i++) {


            if(productArrayList.get(i).getProductName().equals(name)){

                tempProduct =  productArrayList.get(i);
            }

        }

        return tempProduct;
    }

    public Integer getQuantityOfProduct(String name){

       int counter = 0;

        for (int i = 0; i < productArrayList.size(); i++) {


            if(productArrayList.get(i).getProductName().equals(name)){

                counter++;
            }

        }

        return counter;
    }




}
