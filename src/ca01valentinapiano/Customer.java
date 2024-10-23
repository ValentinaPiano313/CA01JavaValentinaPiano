 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


// The purpose of the Customer class is to define all the attributes related to a customer object.
// All attributes are private, so we provide setter methods for each attribute.
// These methods parse the arguments to ensure they match the required data types of the attribute.
// If the input is invalid, an error message is printed to inform the user of the issue.
// Additionally, this class includes a method to calculate a discount based on the attributes contained within the object.
// A discount standard calculation method is also included to avoid code duplication in the discount methods.



package ca01valentinapiano;

/**
 *
 * @author vale
 */
public class Customer {
    //declaring attributes for Customer Class
    private String fullName;
    private double totalPurchased;
    private int customerId;
    private int lastPurchased;
    
    // methods to get fullName 
    public String getFullName(){
        return this.fullName;
    }
    // method to assign fullName 
    public void setFullName(String  fullNameAux){
        this.fullName = fullNameAux;
    }
    
    
    // methods to get totalPurchase 
    public double getTotalPurchase(){
        return this.totalPurchased;
    }  
    // Method to assign totalPurchase - we check if the string read from the file can be parsed to a double; otherwise, an error is thrown.
    public void setTotalPurchased(String totalPurchasedAux){
        try {
            this.totalPurchased = Double.parseDouble(totalPurchasedAux);
        } catch (IllegalArgumentException e) {
            System.out.println("The total purchased is an invalid value format,please correct it and try again! " + totalPurchasedAux);
        }
    }
    
    
    // methods to get customerId 
    public int getCustomerId(){
        return this.customerId;
    }  
    // Method to assign customerId - we check if the string read from the file can be parsed to an integer; otherwise, an error is thrown.
    public void setCustomerId(String customerIdAux){
        try {
            this.customerId = Integer.parseInt(customerIdAux);
        } catch (IllegalArgumentException e) {
            System.out.println("The Customer ID must be a valid integer number between 1 and 3,please correct it and try again! " + customerIdAux);
        }  
    }
    
    
    // methods to get lastPurchase 
    public int getLastPurchased(){
        return this.lastPurchased;
    }  
    // Method to assign lastPurchase - we check if the string read from the file can be parsed to an integer; otherwise, an error is thrown.
   public void setLastPurchased(String lastPurchasedAux){
        try {
            this.lastPurchased = Integer.parseInt(lastPurchasedAux);
        } catch (IllegalArgumentException e) {
            System.out.println("The Last Purchased must be a valid year between 1900 to 2024, please correct it and try again! " + lastPurchasedAux);
        }
    }
   
   // Method to calculate the total after applying a discount end return  
    public double discountFormula( double totalPurchasedAux, double percentageAux){
       double discountAmount = (totalPurchasedAux / 100) * percentageAux;
       return totalPurchasedAux - discountAmount;
    }
    
    // Method to get the purchase discounted based on IDcustomer and the year of the purchase
    public double getDiscount(){
         // Get the total purchase amount 
         double purchase = getTotalPurchase();
         // Get the customer ID to determine amount discount
         int id = getCustomerId();
         // Get the year of the last purchase to apply time-based discounts
         int year = getLastPurchased();
          // Initialize discount variable
         double discount = 0.0;
        if (id == 1) { // Case for customer ID 1
           if (year == 2024) {
               discount = discountFormula(purchase, 30); // 30% discount for purchases in 2024
           } else if (year < 2024 - 5) {
               discount = discountFormula(purchase, 10); // 10% discount for no purchases in the last 5 years 
           } else if (year < 2024) {
               discount = discountFormula(purchase, 20); // 20% discount for purchases less than 2024
           }
        } else if (id == 2) { // Case for customer ID 2
           if (year == 2024) {
               discount = discountFormula(purchase, 15); // 15% discount for purchases in 2024
           } else if (year < 2024 - 5) {
               discount = discountFormula(purchase, 5); // 5% discount for no purchases in the last 5 years
           } else if (year < 2024) {
               discount = discountFormula(purchase, 13); // 13% discount for purchases less than 2024
           }
        } else if (id == 3) { // Case for customer ID 3
            if (year == 2024) {
              discount = discountFormula(purchase, 3); // 3% discount for purchases in 2024
            } else  {
              discount = discountFormula(purchase, 0); // 0% discount for purchse less than 2024
            
        }
        }

    return discount;
    }
    
}
