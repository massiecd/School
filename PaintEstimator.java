/*
 * Lab 2.15: PaintEstimator
 * IT-145 Foundations in App. Development
 * Southern New Hampshire University
 */
//package paintestimator;

/**
 *
 * @author Christopher
 */
import java.util.Scanner;
import java.lang.Math;     // Note: Needed for math functions

public class PaintEstimator {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      double wallHeight = 0.0;
      double wallWidth = 0.0;
      double wallArea = 0.0;
      double gallonsPaintNeeded = 0.0;
      int cansNeeded = 0;
      
      final double squareFeetPerGallons = 350.0;
      final double gallonsPerCan = 1.0;
      
      // Prompt user to input wall's height
      System.out.println("Enter wall height (feet): ");
      wallHeight = scnr.nextDouble();
      
      // Prompt user to input wall's width
      System.out.println("Enter wall width (feet): ");
      wallWidth = scnr.nextDouble();
      
      // Calculate and output wall area
      wallArea = wallHeight * wallWidth;
      System.out.println("Wall area: " + wallArea + " square feet" );
      
      // Calculate and output the amount of paint in gallons needed to paint the wall
      gallonsPaintNeeded = wallArea / squareFeetPerGallons;
      System.out.println("Paint needed: " + gallonsPaintNeeded + " gallons");
      
      // Calculate and output the number of 1 gallon cans needed to paint the wall, rounded up to nearest integer
      cansNeeded = (int) Math.ceil(gallonsPaintNeeded / gallonsPerCan);  //Hint: this line is missing two operations
      System.out.println("Cans needed: " + cansNeeded + " can(s)");  

      return;
   }
}
