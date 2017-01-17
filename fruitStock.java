/*
 * Assignment 2-2 Psuedocode and Build ()
 * IT-145 Foundations in App. Development
 * Southern New Hampshire University
 */
//package fruitstock;

/**
 *
 * @author Christopher Massie
 */
import java.util.Scanner;

public class fruitStock {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int actualApples = 0; //numbers of apples in store
      int stockApples = 0; //number of apples listed on the stock sheet
      int actualOranges = 0; //numbers of oranges in store
      int stockOranges = 0; //number of oranges listed on the stock sheet
      int applesNeeded = 0; //number of apples to order
      int orangesNeeded =0; //number of oranges to order
      
      
      // Prompt user to input the number of apples in the store
      System.out.println("Enter number of apples in store: ");
      actualApples = (int) scnr.nextDouble();
      
      // Prompt user to input the number of apples listed on the stock sheet
      System.out.println("Enter number of oranges in store: ");
      actualOranges = (int) scnr.nextDouble();
      
        // Prompt user to input the number of apples that should be in store
      System.out.println("Enter number of apples listed on the stock sheet: ");
      stockApples = (int) scnr.nextDouble();
      
      // Prompt user to input the number of oranges that should be in store
      System.out.println("Enter number of oranges listed on the stock sheet: ");
      stockOranges = (int) scnr.nextDouble();
      
      // Calculate and output wall area
      applesNeeded = stockApples - actualApples;
      System.out.println("Order: " + applesNeeded + " apples" );
      
       // Calculate and output wall area
      orangesNeeded = stockOranges - actualOranges;
      System.out.println("Order: " + orangesNeeded + " oranges" );
      
   }
}