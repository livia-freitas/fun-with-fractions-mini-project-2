import java.io.PrintWriter;

public class QuickCalculator {
  public static void main (String[] args) throws Exception{     
    PrintWriter pen = new PrintWriter(System.out, true);
    BFCalculator calculator = new BFCalculator(); 

    pen.println("\nPlease enter a mathematical expression. There should be one whitespace before and after each operator.\n");
    pen.println("Use symbols:\n");
    pen.println("+ for addition\n");
    pen.println("- for subtraction\n");
    pen.println("* for multiplication\n");
    pen.println("÷ for division\n");
    pen.println("Write QUIT to stop the program.\n");

    for(String s: args){
      if (s.contains("STORE")){
        int storeIndex = userInput.lastIndexOf("STORE");
        int charIndex = storeIndex + 2;
        char charRegister = userInput.charAt(charIndex);
        calculator.store(charRegister);
        continue;
      }//if(s.contains"STORE")
      pen.println("\n->" + calculator.evaluate(userInput) + "\n");           
    } //for(String s: args)
  } // main()
} // QuickCalculator
