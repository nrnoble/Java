package nrnoble;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import Exceptions.DivideByZeroException;
import Exceptions.NullArgumentException;
import java.util.concurrent.ThreadLocalRandom;



/**
 * 
 * @author Neal Noble<br>
 * IT301<br>
 * Assignment - Exceptions<br>
 * Feb 5th, 2016<br>
 */

public class Driver
{

	private static int  RANDOMLOW = -25; // used for creating random numbers 
    private static int RANDOMHIGH = 25; // used for creating random numbers 
	public List <Rational> rationalNums_R1 = new ArrayList<Rational>();
	public List <Rational> rationalNums_R2 = new ArrayList<Rational>();
	private Rational r1 = null;
	private Rational r2 = null;
	private Rational r3 = null;
	

	
	
	
	public Driver()
	{

		
		// Create some test objects using random numbers
		for (int index = 0; index < 3; index++)
		{

				rationalNums_R1.add(new Rational(randTestNum(), randTestNum()));
				rationalNums_R2.add(new Rational(randTestNum(), randTestNum()));

		 }
		
		rationalNums_R1.add(new Rational(Constants.ZERO, randTestNum()));
		rationalNums_R2.add(new Rational(Constants.ZERO, randTestNum()));
		

			  
			  
			  
			//rationalNums_R1.add(new Rational(randTestNum(),Constants.ONE));
			//rationalNums_R1.add(new Rational(randTestNum(),randTestNum()));
			//rationalNums_R1.add(new Rational(Constants.LOW,Constants.HIGH));
			//rationalNums_R2.add(new Rational(randTestNum(), Constants.ONE));
			// rationalNums_R2.add(new Rational(Constants.ZERO, randTestNum()));
			//rationalNums_R2.add(new Rational(randTestNum(), Constants.LOW));
			//rationalNums_R2.add(new Rational (r3,r3));
			
	}


	

	 public  void test_Constructors()
	 {
		 	
		 
		 		// creating valid objects to best used during the 
		 		Rational r2;
				Rational r3;
	
					// testing of constructor parameters
				    @SuppressWarnings("unused")
					Rational r1 = new Rational(10,10);  
					r2 = new Rational(2,6); 
					r3 = null;
					System.out.println("Starting Constructor Tests....\r");
					
					System.out.println("  Rational r1 = new Rational(10,10)");  
					System.out.println("  Rational r2 = new Rational(2,6)"); 
					System.out.println("  Rational r3 = null;"); 
					//System.out.println("Rational r4 = null;");
					System.out.println();
	
		 		
		 		// Tests below
				try
				{
					@SuppressWarnings("unused")
					 Rational r4 = new Rational(null,r3);	
				} 
				catch (NullArgumentException e)
				{
					System.out.println("  Test-1: Rational r4 = new Rational(r3,null)");
					System.out.println("  Result: Constructor Exception: " + e.getMessage());
					System.out.println();
					
				}
				
				try
				{@SuppressWarnings("unused")
					Rational r6 = new Rational(r2,r3);	
				} 
				catch (NullArgumentException e)
				{
					
					System.out.println("  Test-2: Rational r5 = new Rational(r2,r3);");
					System.out.println("  Result: Constructor Exception: " + e.getMessage());
					System.out.println();
				}
				
				try
				{
					@SuppressWarnings("unused")
					Rational r6 = new Rational(r3,r2);	
				} 
				catch (NullArgumentException e)
				{
					
					System.out.println("  Test-3: Rational r6 = new Rational(r3,r2);");
					System.out.println("  Result: Constructor Exception: " + e.getMessage());
					System.out.println();
					//System.out.println("Constructor Exception trapped: " + e.getMessage());
				}
				
				try
				{
					
					@SuppressWarnings("unused")
					Rational r7 = new Rational(1,0);	
				} 
				catch (DivideByZeroException e)
				{
					
					System.out.println("  Test-4: Rational r7 = new Rational(1,0);");
					System.out.println("  Result: Constructor Exception: " + e.getMessage());
					System.out.println();
					//System.out.println("Constructor Exception trapped: " + e.getMessage());
				}
				catch (Exception e)
				{
					System.out.println("  Test-4: Rational r7 = new Rational(1,0);");
					System.out.println("  Result: Constructor Exception: " + e.getMessage());
					System.out.println();
		
				}
				
				
				
				System.out.println();
				System.out.println("Constructor Tests....Done\r");
				System.out.println();
		
		 	
	 }


	 public  void test_Add()
	 {
		
		System.out.println("Starting Add Tests....\r");
		for (Rational r1 : rationalNums_R1)
			 for (Rational r2 : rationalNums_R2)
			 {
				try
				{
					r1.reset();
					r1.add(r2);
					System.out.println(r1.toString());
				} 
				catch (NullArgumentException e)
				{
						System.out.println("Add Exception trapped: " + e.getMessage());
				}
				catch (DivideByZeroException e)
				{
					System.out.println("Add Exception trapped: " + e.getMessage());;
				}
				catch (Exception e)
				{
					System.out.println("Add Exception trapped: " + e.getMessage());;
				}
			 }
		
			try
			{
				// intentionally throw an null exception
				Rational r3 = null;
				Rational r1 = new Rational(randTestNum(),randTestNum());
				r1.add(r3);
			} catch (NullArgumentException e)
			{
				Driver.console ("Test: Check when parameter object is null;");
				Driver.console ("      Rational r3 = null;");
				Driver.console ("      Rational r1 = new Rational(randTestNum(),randTestNum());");
				Driver.console ("      r1.add(r3);");
				 Driver.console("      Add Exception trapped: " + e.getMessage());
				//Driver.console("Add Exception trapped: " + e.getMessage());
			}
		
		System.out.println();
		System.out.println("Add Tests....Done\r");
		System.out.println();
	
		 
	 }
	 
		 
     public void test_Subtract()
	 {
		System.out.println("Starting Subtract Tests....\r");
		for (Rational r1 : rationalNums_R1)
			 for (Rational r2 : rationalNums_R2)
			 {
				try
				{
					// reset r1 back to original numerator & denominator
					r1.reset();
					r1.subtract(r2);
					System.out.println (r1.toString());
				} 
				catch (NullArgumentException e)
				{
						System.out.println("Exception: " + e.getMessage());
				}
				catch (DivideByZeroException e)
				{
					System.out.println("Exception: " + e.getMessage());;
				}
				catch (Exception e)
				{
					System.out.println("Exception: " + e.getMessage());;
				}
			 }
		
		
		try
		{
			// intentionally throw an null exception
			Rational r3 = null;
			Rational r1 = new Rational(randTestNum(),randTestNum());
			r1.subtract(r3);
		} catch (NullArgumentException e)
		{
			Driver.console ("Test: Check when parameter object is null;");
			Driver.console ("      Rational r3 = null;");
			Driver.console ("      Rational r1 = new Rational(randTestNum(),randTestNum());");
			Driver.console ("      r1.subtract(r3);");		
			
			 Driver.console("      Subtract Exception trapped: " + e.getMessage());
			
		}
		System.out.println();
		System.out.println("Subtract Tests....Done\r");
		System.out.println();
		
	 }
	 

	 public void test_Multiply()
	 {
		System.out.println("Starting Multiply Tests....\r");
		for (Rational r1 : rationalNums_R1)
			 for (Rational r2 : rationalNums_R2)
			 {
				try
				{
					r1.reset();
					r1.multiply(r2);
					System.out.println(r1.toString());
				} 
				catch (NullArgumentException e)
				{
						System.out.println("Multiply Exception trapped: " + e.getMessage());
				}
				catch (DivideByZeroException e)
				{
					System.out.println("Multiply Exception trapped: " + e.getMessage());;
				}
				catch (Exception e)
				{
					System.out.println("Multiply Exception trapped: " + e.getMessage());;
				}
			 }
		
		try
		{
			// intentionally throw an null exception
			Rational r3 = null;
			Rational r1 = new Rational(randTestNum(),randTestNum());
			r1.multiply(r3);
		} catch (NullArgumentException e)
		{
			Driver.console ("Test: Check when parameter object is null;");
			Driver.console ("      Rational r3 = null;");
			Driver.console ("      Rational r1 = new Rational(randTestNum(),randTestNum());");
			Driver.console ("      r1.multiply(r3);");		
			
			 Driver.console("      multiple Exception trapped: " + e.getMessage());
			
		}
		
		System.out.println();
		System.out.println("Multiply Tests....Done\r");
		System.out.println();
		
		 
	 }
	  
	 
	 public void test_Division()
	 {
		System.out.println("Starting Division Tests....\r");
		for (Rational r1 : rationalNums_R1)
			 for (Rational r2 : rationalNums_R2)
			 {
				try
				{
					r1.reset();
					r1.divide(r2);
					System.out.println(r1.toString());
				} 
				catch (NullArgumentException e)
				{
;		
					
					 Driver.console("      Division Exception trapped: " + e.getMessage());
					 continue;
					
						
				}
				catch (DivideByZeroException e)
				{
					System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
					System.out.println("       Division Exception trapped: " + e.getMessage());;
					// Rational errorObject = e.getRational();
					
//					if (errorObject != null)
//					{	
//						errorObject.toString();
//						System.out.println(errorObject.toString_line_1);
//						System.out.println(errorObject.toString_line_2);
//						System.out.println(errorObject.toString_line_3);
//
//					}
					System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
					System.out.println();
					System.out.println();
					continue;

				}
				catch (Exception e)
				{
					System.out.println("Division Exception trapped: " + e.getMessage());;
				}
			 }
		
		try
		{
			// intentionally throw an null exception
			Rational r3 = null;
			Rational r1 = new Rational(randTestNum(),randTestNum());
			r1.divide(r3);
		} catch (NullArgumentException e)
		{
			Driver.console ("Test: Check when parameter object is null;");
			Driver.console ("      Rational r3 = null;");
			Driver.console ("      Rational r1 = new Rational(randTestNum(),randTestNum());");
			Driver.console ("      r1.Division(r3);");
			 Driver.console("      Division Exception trapped: " + e.getMessage());
		}
		
		System.out.println();
		System.out.println("Division Tests....Done\r");
		 
	 }
	 
	private static void console(String msg)
	{
		System.out.println(msg);	
	}
	 
	
	/**
	 * Generate a random numbers between RANDOMLOW and RANDOMHIGH
	 * excluding zero from the random numbers to reduce division 
	 * by zero errors
	 * @return a random number, excluding zero
	 */
	 private static int randTestNum()
	 {
		  int randNum = 0;
	      while(randNum == 0)
	      { 
	    	  randNum = randInt(RANDOMLOW,RANDOMHIGH);
	      }
		 return randNum;
	 }
	 
	 private static int randInt(int _min, int _max)
	{
		return ThreadLocalRandom.current().nextInt(_min, _max + 1);
	 
	}
	  
	 
}
