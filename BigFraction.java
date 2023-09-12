import java.math.BigInteger;

import java.io.PrintWriter;


/**

 * A simple implementation of Fractions.

 * 

 * @author Samuel A. Rebelsky
 
 * @author Noah Mendola (for the parts of the MP taken from Lab 6, which we did together) 

 * @author Livia Stein Freitas

 * @version 1.2 of August 2023

 */

public class Fraction {

  // +------------------+---------------------------------------------

  // | Design Decisions |

  // +------------------+

  /*

   * (1) Denominators are always positive. Therefore, negative fractions are represented 

   * with a negative numerator. Similarly, if a fraction has a negative numerator, it 

   * is negative.

   *  

   * (2) Fractions are not necessarily stored in simplified form. To obtain a fraction 

   * in simplified form, one must call the `simplify` method.

   */


  // +--------+-------------------------------------------------------

  // | Fields |

  // +--------+


  /** The numerator of the fraction. Can be positive, zero or negative. */

  BigInteger num;


  /** The denominator of the fraction. Must be non-negative. */

  BigInteger denom;


  // +--------------+-------------------------------------------------

  // | Constructors |

  // +--------------+


  /**

   * Build a new fraction with numerator num and denominator denom.

   * 

   * Warning! Not yet stable.

   */

  public Fraction(BigInteger num, BigInteger denom) {

    this.num = num;

    this.denom = denom;

  } // Fraction(BigInteger, BigInteger)


  /**

   * Build a new fraction with numerator num and denominator denom.

   * 

   * Warning! Not yet stable.

   */

  public Fraction(int num, int denom) {

    this.num = BigInteger.valueOf(num);

    this.denom = BigInteger.valueOf(denom);

  } // Fraction(int, int)


  /**

   * Build a new fraction by parsing a string.

   *

   * Warning! Not yet implemented.

   */

  public Fraction(String str) {

    String num1 = str.substring (0, 1);

    int numInt = Integer.parseInt(num1);

    this.num = BigInteger.valueOf(numInt);

    String num2 = str.substring (2, 3);

    int numInt2 = Integer.parseInt(num2);

    this.denom = BigInteger.valueOf(numInt2);

  } // Fraction


  // +---------+------------------------------------------------------

  // | Methods |

  // +---------+


  /**

   * Express this fraction as a double.

   */

  public double doubleValue() {

    return this.num.doubleValue() / this.denom.doubleValue();

  } // doubleValue()


  /**

   * Add the fraction `addMe` to this fraction.

   */

  public Fraction add(Fraction addMe) {

    BigInteger resultNumerator;

    BigInteger resultDenominator;


    // The denominator of the result is the

    // product of this object's denominator

    // and addMe's denominator

    resultDenominator = this.denom.multiply(addMe.denom);

    // The numerator is more complicated

    resultNumerator = (this.num.multiply(addMe.denom)).add(addMe.num.multiply(this.denom));


    // Return the computed value

    return new Fraction(resultNumerator, resultDenominator);

  }// add(Fraction)


  /**

   * Multiply two fractions.

   * @param multiplyMe

   * @return

   */

  public Fraction multiply(Fraction multiplyMe){

  BigInteger resultNumerator;

  BigInteger resultDenominator;

  // The numerator of the result is the

  // product of this object's and multiplyMe's numerators.

  resultNumerator = this.num.multiply(multiplyMe.num);

  // The denominator of the result is the

  // product of this object's and multiplyMe's denominators.

  resultDenominator = this.denom.multiply(multiplyMe.denom);


  return new Fraction(resultNumerator, resultDenominator);



}
/**

   * Divide one fraction by another.

   * @param divideMe

   * @return

   */
public Fraction divide(Fraction divideMe) {

BigInteger resultNumerator;

BigInteger resultDenominator;

// The numerator of the result is the

// product of this object's numerator and divideMe's denominator

resultNumerator = this.num.multiply(divideMe.denom);

// The denominator of the result is the

// product of this object's denominator and divideMe's numerator

resultDenominator = this.denom.multiply(divideMe.num);

return new Fraction(resultNumerator, resultDenominator);

}

  public Fraction fractional(){

  BigInteger resultNumerator;

  BigInteger resultDenominator;


  resultNumerator = this.num.mod (this.denom);

  resultDenominator = this.denom;

  return new Fraction(resultNumerator, resultDenominator);

  }


  


  /**

   * Get the denominator of this fraction.

   */

  public BigInteger denominator() {

    return this.denom;

  } // denominator()

  

  /**

   * Get the numerator of this fraction.

   */

  public BigInteger numerator() {

    return this.num;

  } // numerator()

  

  /**

   * Convert this fraction to a string for ease of printing.

   */

  public String toString() {

    // Special case: It's zero

    if (this.num.equals(BigInteger.ZERO)) {

      return "0";

    } // if it's zero


    // Lump together the string represention of the numerator,

    // a slash, and the string representation of the denominator

    // return this.num.toString().concat("/").concat(this.denom.toString());

    return this.num + "/" + this.denom;

  } // toString()


/**
 * @param args
 * @throws Exception
 */
public static void main(String[] args) throws Exception{

Fraction f;

f = new Fraction(7, 2);

Fraction g;

g = new Fraction(11, 4);

PrintWriter pen = new PrintWriter(System.out, true);

pen.println(f.multiply(g));

pen.println(g.fractional());

Fraction e = new Fraction("2/7");

pen.println(f.multiply(e));

pen.println(e);

Fraction m = new Fraction("1/4");

pen.println(m.divide(g));

  }//main

} // class Fraction