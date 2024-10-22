/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


//The CA01ValentinaPiano class is designed to read customer data from an input file,
//validate the data according to predefined rules, and write the results to an output file.
//It performs the following tasks:
// - Reads customer information from "customers.txt".
// - Validates attributes such as full name, total purchased amount, customer ID, and last purchased year.
// - Calculates discounts based on the validated data.
// - Outputs the customer's full name and the calculated discount to "customerdiscount.txt"


package ca01valentinapiano;

import java.util.HashSet;
import java.util.Set;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

/**
 *
 * @author vale
 */
public class CA01ValentinaPiano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // try block attempt to read from a file and handle exceptions
        try (FileReader inFile = new FileReader("customers.txt"); // FileReader for reading the input file
             BufferedReader bufferR = new BufferedReader(inFile); //BufferedReader for efficient reading of text from the input file
             FileWriter outFile = new FileWriter("customerdiscount.txt"); // FileWriter for writing to the output file
             BufferedWriter bufferW = new BufferedWriter(outFile)) { // BufferedWriter for efficient writing of text to the output file
      // if the try block pass this code is execute
      
            String line;
            String[] dataRead = new String[4]; // Declaration and assignment of an array to store lines read from the file,which contain the data needed for the program. This array can hold up to 4 strings.
            Customer customer = new Customer(); // create a customer object to set the data
            CheckRules checkRules= new CheckRules();// Create a CheckRules object to handle validation
            int lineCount = 0; // Counter to track the number of lines read

            // First loop to read the complete file
            while ((line = bufferR.readLine()) != null) {
                dataRead[lineCount % 4] = line; // Store each line in the array

                // Check if we have read 4 lines
                if (lineCount % 4 == 3) { // When 4 lines are ready we assign every data to the corrispendive object attribute
                                          // if the check fail a error is printed and the program stop running
                
                    customer.setFullName(dataRead[0]);
                    checkRules.checkName(customer.getFullName());
                    
                    customer.setTotalPurchased(dataRead[1]);
                    checkRules.checkLastPurchased(customer.getLastPurchased());
                    
                    customer.setCustomerId(dataRead[2]);
                    checkRules.validateIdValue(customer.getCustomerId());
                                    
                    customer.setLastPurchased(dataRead[3]);
                    checkRules.checkLastPurchased(customer.getLastPurchased());
                    
                    
                    double discount = customer.getDiscount(); //calculate the discount
                    bufferW.write(customer.getFullName()); // Write the customer's full name to the output file
                    bufferW.newLine();//Add a new line
                    bufferW.write(Double.toString(discount));// Write the discount to the output file
                    bufferW.newLine();//Add a new line
                
                }
                
                lineCount++;
            }
              // Flush and close resources
             bufferW.flush();// Ensure all data is written to the output file
             bufferW.close();// Close the BufferedWriter, releasing resources
             bufferR.close();// Close the BufferedReader, releasing resources      
  
        }catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }    
    }
}
    

