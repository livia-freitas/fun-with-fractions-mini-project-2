package MiniProject2;
import java.util.regex.Pattern;
import java.io.PrintWriter;

public class BFCalculator {
  public static BigFraction evaluate(String exp){
    /**
     * steps:
     * take in string (done)
     * separate argument 1 and argument 2 (done)
     * separate operator
     * match operator with method
     * apply method to arg1 and arg2
     * return result
     */
    /**
     * my plan:
     * compile regular expression
     * use regular expressions X|Y to find operator
     * 
     */
    PrintWriter pen = new PrintWriter(System.out, true);
    

    Pattern operators = Pattern.compile("(\\+|\\*|\\-)", 2);
    String[] splitArray = operators.split(exp);
    // BigFraction argumentOne = new BigFraction(splitArray[0]);
    // BigFraction argumentTwo = new BigFraction(splitArray[1]);
    // ISSUES: string will be split in 4. because / is the operator for fractions and for division. should fraction division be a special case?
    // like if there are three "/" we know it's division. then call the divide method. maybe that's it.
    pen.println(splitArray[0]);

    return new BigFraction("1/2");
  }

  public static void main(String[] args) throws Exception{
    evaluate("1/2 + 4/5");
  }
}
