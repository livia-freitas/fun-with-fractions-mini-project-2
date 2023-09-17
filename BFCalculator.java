package mp2;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class BFCalculator {
  
  public BigFraction calculate(String operator, BigFraction argOne, BigFraction argTwo){
    if (operator.equals("+")){
     return argOne.add(argTwo);
    } else if (operator.equals("-")){
      return argOne.subtract(argTwo);
    } else if (operator.equals("*")){
      return argOne.multiply(argTwo);
    } else{
      return null;
    }
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
    PrintWriter pen = new PrintWriter(System.out, true);

    Pattern operators = Pattern.compile("(\\+|\\*|\\-)");
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

    while(i < numArgs){ //this is going to evaluate the operations im not sure how. we need store first I think. need to store the results of each subop then use if else to match
      // problem: operator array starts at 1 whereas argarray starts at 0. theyre both the same size bc theres one less operator than argument
     result = calculate(operatorArray[n], argOne, argTwo); // should one of the arguments be result? also need to add reduce to the basic operations
     argOne = result;
    } 
    return result;
    
  }

  
}
