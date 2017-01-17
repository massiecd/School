/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsestrings;

import java.util.Scanner;
import java.io.IOException;


/**
 *
 * @author Christopher
 */
public class ParseStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
    
       
      Scanner scnr = new Scanner(System.in); // Input stream for standard input
    Scanner inSS = null;                   // Input string stream
    String lineString = "";                // Holds line of text
    String firstWord = "";                 // First name
    String secondWord = "";                  // Last name
    boolean inputDone = false;             // Flag to indicate next iteration

    // Prompt user for input
    System.out.println("Enter input string: ");

    // Grab data as long as "q" is not entered
    while (!inputDone) {

        // Entire line into lineString
        lineString = scnr.nextLine();

        // Create new input string stream
        inSS = new Scanner(lineString);

        // Now process the line
        firstWord = inSS.next();
        

        // Output parsed values
        if (firstWord.equals("q")) {
            System.out.println("Exiting.");

            inputDone = true;
        }
        if (lineString.contains(",")) {
            
            secondWord = inSS.next();


            System.out.println("First word: " + firstWord);
            System.out.println("Second word: " + secondWord);

            System.out.println();
        } 
       else {
            throw new Exception("No comma in string");
        }
        
        
        
        
      
      return;
    }
       }
}


