/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
}
