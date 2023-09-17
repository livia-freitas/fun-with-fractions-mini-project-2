package mp2;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class BFCalculator {
  
  
  
  BigFraction[] registers = new BigFraction[26];
  BigFraction lastValue;

  public BFCalculator(BigFraction defValue, BigFraction[] registers){
    this.lastValue = defValue;
    this.registers = registers;

  }

  public void store(char register){
    int numRegister = (int) register - 97;
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println(numRegister);
    registers[numRegister] = lastValue;
  }
 
  public BigFraction evaluate(String exp){
    /**
     * steps:
     * take in string (done)
     * separate argument 1 and argument 2 (done)
     * separate operator (done)
     * match operator with method (done)
     * apply method to arg1 and arg2 (done)
     * return result (done)
     */
    /**
     * my plan:
     * compile regular expression
     * use regular expressions X|Y to find operator
     * 
     */

    Pattern operators = Pattern.compile("(\\+|\\*|\\-|\\÷)");
    Pattern digits = Pattern.compile("\\d\\s|\\s\\d|\\n");


    String[] argumentArray = operators.split(exp);
    //issue
    int numArgs = argumentArray.length;
    String[] operatorArray = digits.split(exp);
    int i = 0;
    int n = i + 1;
    BigFraction result = new BigFraction("0/1");
    BigFraction argOne = new BigFraction(argumentArray[i]);
    BigFraction argTwo = new BigFraction(argumentArray[n]);

    while(i < numArgs){ 
     result = argOne.calculate(operatorArray[n], argTwo); 
     argOne = result;
    } 

    this.lastValue = result;
    return result;
  }
    public static void main(String[] args) throws Exception{ // delete main once I'm done
      BigFraction[] registers = new BigFraction[26];
      BigFraction def = new BigFraction("1/1");
      BFCalculator calculator = new BFCalculator(def, registers);  
      PrintWriter pen = new PrintWriter(System.out, true);
      BigFraction e = new BigFraction("2/7");
      //pen.println(calculator.evaluate("1/2 + 2/3")); number format exception???
      calculator.store('c');
      pen.println(calculator.registers[0]); 

    }
}
