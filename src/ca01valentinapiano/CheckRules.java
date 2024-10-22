/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca01valentinapiano;

/**
 *
 * @author vale
 */
public class CheckRules {
    // method to check if the first name contain only letters.
   public void checkName(String fullNameAux) {
    try { 
        String[] splittedName = fullNameAux.split(" "); // split the full name into 2 parts using space a delimiter and save in an array.
        
        // check if the array length is 0 or if the first element does not contain only letters
        // if either condition is true, display an error message to the user.
        if (splittedName.length == 0 || !splittedName[0].matches("[a-zA-Z]+")) {
            System.out.println("The first name must contain only letters and be separated by a space from the last name. Please correct it and try again!");
        } 
    } catch (Exception e) {
        System.out.println("An error occurred. Please try again.");// print a generic error message for any unexpected exceptions.
    }
   }
   
   
   // Method to check if the value of idCustomer is a number equal to 1, 2, or 3.
public void validateIdValue(int idCustomerAux) {
    try {
        // Check if the provided ID less than 1 and greater than 3 
        if (idCustomerAux < 1 && idCustomerAux > 3) {
            // Throw an exception if the ID is invalid.(not equal to 1 or 2 or 3)
            throw new IllegalArgumentException("Invalid ID: Please enter an integer equal to 1, 2, or 3.");
        }
        // If the ID is valid, no action is needed 

    } catch (IllegalArgumentException e) {
        // Print an error message if the ID is invalid.
        System.out.println(e.getMessage() + " Please correct it and try again!");
    }
}    
    
   // Method to validate that the lastPurchased year is between 1900 and 2024 (inclusive).
public void checkLastPurchased(int lastPurchasedAux) {
    try {
        // Check if the provided year is greater 1900 and less than 2024.
        if (lastPurchasedAux < 1900 && lastPurchasedAux > 2024) {
            // Throw an exception if the year is invalid.
            throw new IllegalArgumentException("Invalid year: Please enter a year between 1900 and 2024.");
        }
        // If the year is valid, no action is needed 

    } catch (IllegalArgumentException e) {
        // Print an error message if the year is invalid.
        System.out.println(e.getMessage() + " Please correct it and try again!");
    }
}
    
}
