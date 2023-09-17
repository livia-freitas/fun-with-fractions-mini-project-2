package mp2;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class BFCalculator {
  
  
  
  BigFraction[] registers = new BigFraction[26];
  BigFraction lastValue;

  public BFCalculator(){


  }

  public void store(char register){
    int numRegister = (int) register - 97;
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println(numRegister);
    registers[numRegister] = lastValue;
  }
 
  public BigFraction evaluate(String exp){
   
    Pattern operators = Pattern.compile("(\\s\\+\\s|\\s\\*\\s|\\s\\-\\s|\\s\\÷\\s)");
    Pattern digits = Pattern.compile("\\d\\/\\d\\s|\\s\\d\\/\\d\\s|\\s\\d\\/\\d");
    PrintWriter pen = new PrintWriter (System.out, true);


    String[] argumentArray = operators.split(exp);
    //issue
    int numArgs = argumentArray.length;
    String[] operatorArray = digits.split(exp);
    int i = 0;
    BigFraction result = new BigFraction("0/1");
    BigFraction[] newArgumentArray = new BigFraction[numArgs];
    
    pen.println("Checkpoint 1");
    while (i < numArgs){ //change strings into BigFractions
      newArgumentArray[i] = new BigFraction(argumentArray[i]);
      i++;
    }
    
    i = 0; //resetting i

    BigFraction argOne = (newArgumentArray[i]);
   
    
    pen.println("Checkpoint 2");
    while(i < numArgs){ 
      pen.println(argumentArray[i]);
      i++;
     } 
     
     i = 0;
     
     pen.println("Checkpoint 3");
     
    while(i + 1 < numArgs){
      String currentOperator = operatorArray[i + 1];
      BigFraction argTwo = (newArgumentArray[i + 1]);
      pen.println("argOne iteration " + i + " is " + argOne);
      pen.println("argTwo iteration " + i + " is " + argTwo);
      pen.println("currentOp iteration " + i + " is " + currentOperator);
     result = argOne.calculate(currentOperator, argTwo); 
     pen.println("result iteration " + i + " is " + result);
     argOne = result;
     i++;
    } 
    
    this.lastValue = result;
    return result;
  }
    // JUST FOR TESTING WHILE IT'S NOT DONE
    public static void main(String[] args) throws Exception{ // delete main once I'm done
      BFCalculator calculator = new BFCalculator();  
      PrintWriter pen = new PrintWriter(System.out, true);
      BigFraction e = new BigFraction("2/7");
      BigFraction test = calculator.evaluate("1/2 ÷ 2/3 * 4/5 + 2/5");
      calculator.store('c');
    
    }
}
