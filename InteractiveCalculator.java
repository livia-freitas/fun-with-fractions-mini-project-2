package mp2;
import java.util.Scanner;  
import java.io.PrintWriter;

public class InteractiveCalculator {
  public static void main (String[] args) throws Exception{
    Scanner myScanner = new Scanner(System.in);       
    PrintWriter pen = new PrintWriter(System.out, true);
    BFCalculator calculator = new BFCalculator(); 

    pen.println("\nPlease enter a mathematical expression. There should be one whitespace before and after each operator.\n");
    pen.println("Use symbols:\n");
    pen.println("+ for addition\n");
    pen.println("- for subtraction\n");
    pen.println("* for multiplication\n");
    pen.println("÷ for division\n");
    pen.println("Write QUIT to stop the program.\n");

    String userInput = myScanner.nextLine();           
    pen.println("\n->" + calculator.evaluate(userInput) + "\n");

    while(userInput.equals("QUIT") == false){
      userInput = myScanner.nextLine();
      if (userInput.contains("STORE")){

      }           
      pen.println("\n->" + calculator.evaluate(userInput) + "\n");
    }

    
  }
}
