/*
 * Lab 2.15: PaintEstimator
 * IT-145 Foundations in App. Development
 * Southern New Hampshire University
 */
//package textmsgexpander;

import java.util.Scanner;

/**
 *
 * @author Christopher
 */
public class TextMsgExpander {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String msgInput;
        //Needed string variables defined for proper replacing
        String BFF = "best friend forever";
        String IDK = "I don't know";
        String JK = "just kidding";
        String TMI = "too much information";
        String TTYL = "talk to you later";
        //Enter the text with Abbreviations
        System.out.println("Enter text: ");
        msgInput = scnr.nextLine();
        //Return the statemnent
        System.out.println("You entered: " + msgInput);
        System.out.println(); // blank line


        //If statements for replacing 
        if (msgInput.contains("BFF")) {
            msgInput = msgInput.replace("BFF", BFF);
            System.out.println("Replaced \"BFF\" with " + "\"" + BFF + "\"" + ".");
        }

        if (msgInput.contains("IDK")) {
            msgInput = msgInput.replace("IDK", IDK);
            System.out.println("Replaced \"IDK\" with " + "\"" + IDK + "\"" + ".");
        }

        if (msgInput.contains("JK")) {
            msgInput = msgInput.replace("JK", JK);
            System.out.println("Replaced \"JK\" with " + "\"" + JK + "\"" + ".");
        }

        if (msgInput.contains("TMI")) {
            msgInput = msgInput.replace("TMI", TMI);
            System.out.println("Replaced \"TMI\" with " + "\"" + TMI + "\"" + ".");
        }

        if (msgInput.contains("TTYL")) {
            msgInput = msgInput.replace("TTYL", TTYL);
            System.out.println("Replaced \"TTYL\" with " + "\"" + TTYL + "\"" + ".");
        }

        System.out.println(); //blank line
        //Final expanded out sentence        
        System.out.println("Expanded: " + msgInput);
    }


}
