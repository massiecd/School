import java.util.Scanner;

public class TextMsgAbbreviation {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
   	String userText = "";
   	
   	
        
   	System.out.println("Input an abbreviation: ");
      userText = scnr.nextLine();
    
        if ("LOL".equals(userText)){
            
            userText = userText.replace("LOL", "laughing out loud");
            System.out.println(userText);
        }
        else if ("IDK".equals(userText)){
            
            userText = userText.replace("IDK", "I don't know");
            System.out.println(userText);
        }
        else if ("BFF".equals(userText)){
           
            userText = userText.replace("BFF", "best friends forever");
            System.out.println(userText);
        }
        else if ("IMHO".equals(userText)){
            
            userText = userText.replace("IMHO", "in my humble opinion");
            System.out.println(userText);
        }
        else if ("TMI".equals(userText)){
            
            userText = userText.replace("TMI", "too much information");
            System.out.println(userText);
        }
        
        else {
            
            System.out.println("Unknown");
        }
      
      return;
   }
}