import java.util.Scanner;

public class TextMsgAbbreviation {
   public static void main(String[] args) {
   	Scanner scnr = new Scanner(System.in);
   	String userText = "";

   	System.out.print("Enter an abbreviation: ");
     // userText is "LOL"
	if (userText == "LOL");
	   userText = userText.replace("LOL", "laugh out loud"); // Now "laugh out loud" 
	System.out.println(userText);
	
      return;
   }
}