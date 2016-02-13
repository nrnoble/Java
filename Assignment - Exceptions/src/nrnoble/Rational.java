package nrnoble;
/**
 * 
 * @author Neal Noble<br>
 * IT301<br>
 * Assignment - Exceptions<br>
 * Feb 5th, 2016<br>
 */


import Exceptions.DivideByZeroException;
import Exceptions.NullArgumentException;

/*
 * Create a class that stores rational numbers. It should have the following fields/methods:
 *
 * Fields
 * int numerator
 * int denominator
 * Methods
 * public Rational(int numerator, int denominator) //constructor
 * public Rational(Rational numerator, Rational denominator) //constructor
 * public int getNumerator()
 * public int getDenominator()
 * public String toString()
 * public Rational add(Rational other)
 * public Rational subtract(Rational other)
 * public Rational multiply(Rational other)
 * public Rational divide(Rational other)
 *  
 */


/**
* @author  Neal Noble<br>
* IT301<br>
* Exercises � Custom Exceptions<br>
* January 29th, 2016<br>
*/
public class Rational extends Main
{
	 private int numerator = 0;
	 private int denominator = 0;
	 
	 // Preserving original values
	 private int orginalNumeratorValue;
	 private int orginalDenominatorValue;
	 
	 private int a,b,c,d;
	 private int r1_Numerator, r1_denominator;

	 
	 public String toString_line_1 = "";
	 public String toString_line_2 = "";
	 public String toString_line_3 = "";
	 public String toString_returnString = "";
	 
	 private Rational()
	{
		// made private so that it can not called.
	}

	 
	 /**
	  * Constructor
	  * @param _numerator any positive or negative integer value
	  * @param _denominator any positive or negative integer value
	  */
	 public Rational(int _numerator, int _denominator) throws DivideByZeroException
	 {
		 this.numerator = _numerator;
		 this.denominator = _denominator; 
		 this.orginalNumeratorValue = _numerator;
		 this.orginalDenominatorValue = _denominator;
		 
		 if (_denominator == 0)
		 {
			 throw new DivideByZeroException(DivideByZeroException.DIVBYZERO,this);
		 }
		 
		 
	 }
	 
	 
	 /**
	  * Constructor
	  * @param _numerator rational object
	  * @param _denominator rational object
	  */
	 public Rational(Rational _numerator, Rational _denominator) throws NullArgumentException
     {
		
		 this();
		 // check parameters for null values. Throw error if null is detected.
		 if (_numerator == null && _denominator == null)
		 {
			 //throw new NullArgumentException("Numerator and Denominator objects can not be null");
			 throw new NullArgumentException(NullArgumentException.NUMERATOR_DENOMINATOR);
		 }
		 
	
		 // Just check the numerator
		 if (_numerator == null)
		 {
			 throw new NullArgumentException(NullArgumentException.NUMERATOR);
		 }
		 
		 
		 // Just check the denominator
		 if (_denominator == null)
		 {
			 throw new NullArgumentException(NullArgumentException.DENOMINATOR);
		 }
		 
		 // checks has passed for both Numerator and denominator, 
		 // assign values to internal values.
		 
		 this.numerator = _numerator.getNumerator();
		 this.denominator = _denominator.getDenominator(); 
		 this.orginalNumeratorValue = this.denominator;
		 this.orginalDenominatorValue = this.denominator;
	 }
	 
	 
	 /**
	  * Get the numerator value
	  * @return the internal Numerator of this object
	  */
	 public int getNumerator()
     {
		 return this.numerator;
	 }
	 
	 
	 /**
	  * Get the Denominator value
	  * @return the internal Denominator of this object
	  */
	 public int getDenominator()
     { 
		 return this.denominator;
	 }
	
	 
	 /**
	  * @return the numerator and denominator as a string
	  */
	 public String toString()
     {
		
		toString_returnString = toString_line_1 + "\r\n" + toString_line_2 + "\r\n" + toString_line_3 + "\r\n";
		return toString_returnString;
		
		 //return "Numerator:   " + this.numerator + "\nDenominator: " + this.denominator;
	 }
	 
	
	 /**
	  * Addition of two rational numbers
	  * @param _r2 Rational object
	  * @return the value of two rational objects added together
	  * @throws NullArgumentException when Rational object parameter is null
      */
	 public Rational add(Rational _r2) throws NullArgumentException
     {
		   
		 if (_r2 == null)
		 {
			 throw new NullArgumentException(NullArgumentException.ADD);
			 
		 }
		 
		  // use conventional math symbols as local variables
		  a = this.numerator;
		  b = this.denominator;
		  c = _r2.getNumerator();
		  d = _r2.getDenominator();
		   
		  // create these for display output
		  r1_Numerator = (a * d) + (b * c) ;
		  r1_denominator = b * d;   
		  
		  
	
		  // assign to internal fields and simplify
		  this.numerator = r1_Numerator;
		  this.denominator = r1_denominator;
          simplify();
		  
          
		  toString_line_1 = String.format("      %03d     %03d        (%03d * %03d) - (%03d * %03d)       %04d       %04d", a,c,a,d,b,c,r1_Numerator,this.numerator);
		  toString_line_2 = "     ----- + -----  =  ----------------------------  =  ------  =  ------";
		  toString_line_3 = String.format("      %03d     %03d                %03d * %03d               %04d       %04d",b,d,b,d,r1_denominator,this.denominator);
		          
         
		 return  new Rational(this.numerator,this.denominator);
	 }
	 
	 
	 
	 /**
	  * Subtraction of rational numbers
	  * @param _r2 Rational object
	  * @return the value of rational number subtracted. j
	  * @throws NullArgumentException when Rational object parameter is null
	  */
	 public Rational subtract(Rational _r2) throws NullArgumentException
     {
		 
		 if (_r2 == null)
		 {
			 throw new NullArgumentException(NullArgumentException.SUBTRACT);
			 
		 }
		 
		// use conventional math symbols as local variables
		  int a = this.numerator;
		  int b = this.denominator;
		  int c = _r2.getNumerator();
		  int d = _r2.getDenominator();
		   
		  // create these for display output
		  int r1_Numerator = (a * d) - (b * c) ;
		  int r1_denominator = b * d;   
		  
		  // assign to internal fields and simplify
		  this.numerator = r1_Numerator;
		  this.denominator = r1_denominator;
		  simplify();
		  
		  
		  
		  toString_line_1 = String.format("      %03d     %03d        (%03d * %03d) - (%03d * %03d)       %04d       %04d", a,c,a,d,b,c,r1_Numerator,this.numerator);
		  toString_line_2 = "     ----- - -----  =  ----------------------------  =  ------  =  ------";
		  toString_line_3 = String.format("      %03d     %03d                %03d * %03d               %04d       %04d",b,d,b,d,r1_denominator,this.denominator);

		 //System.out.println(toString("subtract"));
		  
		 return  new Rational(this.numerator,this.denominator);
	 }
		 
		
	 
	 

	 /**
	  * Multiple of two ration numbers
	  * @param _r2 Rational object
	  * @return the value of two rational objects multiplied together
	  * @throws NullArgumentException when Rational object parameter is null
	  */
	 public Rational multiply(Rational _r2) throws NullArgumentException
     {
		 if (_r2 == null)
		 {
			 throw new NullArgumentException(NullArgumentException.MULTIPLY);
			 
		 }
		 
		 
			// use conventional math symbols as local variables
		  int a = this.numerator;
		  int b = this.denominator;
		  int c = _r2.getNumerator();
		  int d = _r2.getDenominator();
		   
		  // create these for display output
		  int r1_Numerator = a * c; 
		  int r1_denominator = b * d;   
		  
		  // assign to internal fields and simplify
		  this.numerator = r1_Numerator;
		  this.denominator = r1_denominator;
		  simplify();
		  
		  
		  toString_line_1 = String.format("      %03d     %03d        %03d * %03d       %04d       %04d",a,c,a,c,r1_Numerator,this.numerator);
		  toString_line_2 = "     ----- * -----  =  ------------  =  ------  =  ------";
		  toString_line_3 = String.format("      %03d     %03d        %03d * %03d       %04d       %04d",b,d,b,d,r1_denominator, this.denominator);

		  
		 return  new Rational(this.numerator,this.denominator);
		 
		 
	 }
	 
	 
/**
 * 
	 /**
	  * Division of two rational numbers
	  * @param _r2 Rational object
	  * @return the value of the division of a rational number.
	 *  @throws DivideByZeroException when there is a division by zero occurs
	 *  @throws NullArgumentException when Rational object parameter is null
	 */
	 public Rational divide(Rational _r2) throws DivideByZeroException, NullArgumentException
     {
		 
		 if (_r2 == null)
		 {
			 throw new NullArgumentException(NullArgumentException.DIVIDE);
			 
		 }
		 
			// use conventional math symbols as local variables
		  int a = this.numerator;
		  int b = this.denominator;
		  int c = _r2.getNumerator();
		  int d = _r2.getDenominator();
		   
		  // create these for display output
		  int r1_Numerator = a * d; 
		  int r1_denominator = b * c;   
		  
		  // assign to internal fields and simplify
		  this.numerator = r1_Numerator;
		  this.denominator = r1_denominator;
		  simplify();
		  
		  toString_line_1 = String.format("      %03d     %03d        %03d / %03d       %04d       %04d",a,c,a,c,r1_Numerator,this.numerator);
		  toString_line_2 = "     ----- / -----  =  ------------  =  ------  =  ------";
		  toString_line_3 = String.format("      %03d     %03d        %03d / %03d       %04d       %04d",b,d,b,d,r1_denominator, this.denominator);
		  
		  if (d == 0)
		  {
			  throw new DivideByZeroException(DivideByZeroException.DIVBYZERO, this);
		  }
		  
		  
		  
//		  System.out.println("      " + a +  "     " + c  + "        (" + a + " / " + c + ")       " + r1_Numerator + "       " + this.numerator);
//		  System.out.println("     --- / ---  =  ----------  =  ------  =  ------");
//		  System.out.println("      " + b  + "     " + d  + "         " + b + " / " + d + "        " + r1_denominator + "       " + this.denominator);
//		  System.out.println();
		  
		 return  new Rational(this.numerator,this.denominator);
	 }
	 
	 
	 // helper function
	 private int gcd(int _numerator, int _denominator)
	 {
	     if (_denominator == 0)
	     {
	    	 return _numerator;
	     }
	     return gcd(_denominator ,_numerator % _denominator);
	 }

	 /**
	  * reduce fraction to the smallest.
	  */
	 private void simplify() throws DivideByZeroException, NullArgumentException
	 {

	     int commonDenominator = gcd(this.numerator, this.denominator);
	     if (commonDenominator == 0 && this.numerator == 0)
	    	 return;
	     if (commonDenominator == 0)
	    	 throw new DivideByZeroException(DivideByZeroException.DIVBYZERO);
	     this.numerator /= commonDenominator;
	     this.denominator /= commonDenominator; 
	 }
	 
	 
	 private boolean isValidDemoninator()
	 {
	     int commonDenominator = gcd(this.numerator, this.denominator);
	     /*
	     if (commonDenominator == 0 && this.numerator == 0)
	    	 return true;
	     */

	     if (commonDenominator == 0)
	    	 return false;
	     
		 return true;
	 }

	 /**
	  * Reset the object to its original values
	  * Primary use is for testing object
	  */
	 public void reset()
	 {

				 
		 this.numerator = this.orginalNumeratorValue;
		 this.denominator = this.orginalDenominatorValue;
	 }
	 
	 
	
}
