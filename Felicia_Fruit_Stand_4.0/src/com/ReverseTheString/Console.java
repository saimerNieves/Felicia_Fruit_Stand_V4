package com.ReverseTheString;

import com.ReverseTheString.Products.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    //Member Data
    private Store getStore = new Store();


    //Member Setter and Getters

    public Store getStore() {
        return getStore;
    }


    //Member Behavior

    public void supplyStore(ArrayList<Product> inventory){
        getStore.setProductArrayList(inventory);
    }


    public void console_operate(){

        Cashier operator = new Cashier();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Name of Cashier: ");
        operator.setName(scanner.nextLine());



        ArrayList<Product> collectionOfProducts = new ArrayList<>();
        String answer = "y";



        this.supplyStore(collectionOfProducts);



        System.out.println("Would you like to sell or (add inventory) or (throw away)  or (look up item) or (check balance) or (deposit balance) or (check operator) or none? \n");
        String saleAnswer = scanner.nextLine();

        do {

            if(saleAnswer.equals("sell")){

                if(this.getStore().getProductArrayList().size() >= 1){
                    System.out.println("What is the name of the Item you would like to sell? ");
                    String productName = scanner.nextLine();

                    Product productFound = this.getStore().findProductInStore(productName);
                    int productQuantityLeft = this.getStore().getQuantityOfProduct(productName);

                    if(productFound.getProductName().equals("null")){
                        System.out.println("Sorry we couldnt find your product");
                    }
                    else{

                        System.out.println("\nQuantity in Stock: " + productQuantityLeft );

                        System.out.println("Price Per Item: " + productFound.getProductCost());

                        System.out.print("How many are you selling: ");
                        int quantity = Integer.parseInt(scanner.nextLine());

                        System.out.println("\n Order Total: " + (quantity * productFound.getProductCost()) );

                        this.getStore().sellProduct(productFound,quantity);
                        operator.incrementSalesCommited();
                        operator.incrementTransactionsCommitted();

                    }
                }
                else{
                    System.out.println("Sorry there are no items to sell");
                }



            }
            else if(saleAnswer.equals("add inventory")) {

                String addAnother = "";

                do {
                    System.out.println("Add A product\n");


                    System.out.print("Product Name: ");
                    String productName = scanner.nextLine();

                    System.out.print("Product price: ");
                    double productPrice = scanner.nextDouble();
                    scanner.nextLine();


                    Product newProduct = new Product(productName,productPrice);

                    System.out.print("Product Stock Quantity: ");
                    int productQuantity = scanner.nextInt();
                    scanner.nextLine();


                    System.out.println("Order Total: $" + (productPrice * productQuantity)+"\n");
                    this.getStore().addProductToStore(newProduct, productQuantity);

                    operator.incrementItemsBroughtToInventory();
                    operator.incrementTransactionsCommitted();
                    System.out.print("\n\n Press y to add another product or n to stop: ");
                    addAnother = scanner.nextLine();

                }while (addAnother.equals("y"));



            }
            else if(saleAnswer.equals("check balance")){
                System.out.println("\n\nCurrent Balance: " + this.getStore().getBalance() + "\n");
            }
            else if(saleAnswer.equals("deposit balance")){

                System.out.println("\nYour Current Balance is :" + this.getStore().getBalance());



                System.out.print("\nDeposit Amount: " );
                double depositAmount = scanner.nextDouble();
                scanner.nextLine();
                double newBalance = this.getStore().getBalance() + depositAmount;

                this.getStore().setBalance(newBalance);
                operator.setDollarsDeposited(depositAmount);

                System.out.println("\nDEPOSIT COMPLETE Your new Balance is: " +  this.getStore().getBalance() +"\n\n");
            }
            else if(saleAnswer.equals("throw away")){

                if(this.getStore().getProductArrayList().size() >= 1){
                    System.out.println("What is the name of the Item you would like to throw away? ");
                    String productName = scanner.nextLine();

                    Product productFound = this.getStore().findProductInStore(productName);
                    int productQuantityLeft = this.getStore().getQuantityOfProduct(productName);

                    if(productFound.getProductName().equals("null")){
                        System.out.println("Sorry we couldnt find your product");
                    }
                    else{

                        System.out.println("\nQuantity in Stock: " + productQuantityLeft );

                        System.out.println("Price Per Item: " + productFound.getProductCost());

                        System.out.print("How many are you throwing away: ");
                        int quantity = Integer.parseInt(scanner.nextLine());

                        System.out.println("\n Items were discarded successfully" );

                        this.getStore().throwAwayProduct(productFound,quantity);
                        operator.incrementItemsThrownAway();
                    }
                }
                else{
                    System.out.println("Sorry there are no items to throw away");
                }



            }
            else if(saleAnswer.equals("look up item")){


                System.out.print("Item Name: ");
                String productName = scanner.nextLine();

                Product productFound = this.getStore().findProductInStore(productName);
                int productQuantityLeft = this.getStore().getQuantityOfProduct(productName);

                if(productFound.getProductName().equals("null")){
                    System.out.println("Sorry we couldnt find your product");
                }
                else{

                    System.out.println("----------------------------------------------");
                    System.out.println("\nQuantity in Stock: " + productQuantityLeft );
                    System.out.println("Price Per Item: " + productFound.getProductCost());
                    System.out.println("----------------------------------------------");

                }


            }
            else if(saleAnswer.equals("check operator")){

                System.out.println("---Operator Actions---\n");
                System.out.println("Dollars Deposited: " + operator.getDollarsDeposited());
                System.out.println("Sales: " + operator.getSalesCommited());
                System.out.println("Total Transactions: " + operator.getTransactionsCommitted());
                System.out.println("Types of Items brought: " + operator.getItemsBroughtToInventory());


            }
            else if(saleAnswer.equals("none")){}


            System.out.println("Would you like to sell or (add inventory) or (throw away)  or (look up item) or (check balance) or (deposit balance) or (check operator) or none? \n");
            saleAnswer = scanner.nextLine();

        }while ((saleAnswer.equals("sell")) || (saleAnswer.equals("add inventory")) || (saleAnswer.equals("deposit balance")) || (saleAnswer.equals("check balance")) || (saleAnswer.equals("throw away")) || (saleAnswer.equals("look up item"))  || (saleAnswer.equals("check operator")) );


        System.out.println("Thank you for using our cashier! ");

        scanner.close();
    }



}
