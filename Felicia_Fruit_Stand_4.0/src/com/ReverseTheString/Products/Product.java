package com.ReverseTheString.Products;

public class Product {

    protected String productName;
    protected double productCost;

    public Product(String productName, double productCost){
        this.setProductName(productName);
        this.setProductCost(productCost);
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public double getProductCost(){
        return productCost;
    }

    public void setProductCost(double productCost){
        this.productCost = productCost;
    }


}
