package nrnoble;


/**
 * 
 * @author Neal Noble<br>
 * IT301<br>
 * Exercises - Throwing Exceptions (Perspective A)<br>
 * January 27nd, 2016<br>
 */
public class Main
{

	public Main()
	{
		// Nothing to do here
	}

	/**
	 * run exercise tests
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		// notYetImplemented();
		
		// division (0,0);
		
		int accountID = 1000 ;
		String firstName = "Neal";
		String LastName = "Noble";
		int balance = -10;
		
		BankAccount(accountID, firstName, LastName, balance);
		
	}
	
	/**
	 * 1. Write a method called public void notYetImplemented(). 
	 *    The method should throw an UnsupportedOperationException 
	 *    when the method is called. Call your method and submit a 
	 *    screenshot of the error message you get on the Java console.
	 * @param _a any value
	 * @param _b any value
	 * @return division value
	 */
	public static void notYetImplemented()
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * 2. Write a program that asks the user on the Java console for two 
	 *    numbers "a" and "b" and prints the result of a / b. Your program 
	 *    should throw an ArithmeticException, with an appropriate message, 
	 *    if the user tries to divide by zero.
	 * @param _accountID any value
	 * @param _firstName any value
	 * @param _lastName any value
	 * @param _accountBalance any value
	 */
	public static int division (int _a, int _b)
	{
	
			if (_a == 0 ||_b == 0)
			{
				ArithmeticException exception = new ArithmeticException("Division by zero");
				throw exception;
			}
			return _a / _b;	
	}
	
	/**
	 * 3. Write a BankAccount class that stores a bank account id 
	 *    (a number between 1000-9999), an account holders first/last 
	 *    name and an account balance. Your class should have a constructor 
	 *    that passes in all four field values. For each of the following 
	 *    bad inputs to your constructor, throw the exception type listed:
	 *    Input	Exception type
	 *		Account id outside the range 1000-9999	RuntimeException
	 * 		First name or last name null or empty	NullPointerException
	 *		A negative account balance	IllegalStateException
	 *    
	 * @param _accountID any value
	 * @param _firstName any value
	 * @param _lastName any value
	 * @param _accountBalance any value
	 */
	public static void BankAccount (int _accountID, String _firstName, String _lastName, int _accountBalance)
	{

		if (_accountID < 1000 || _accountID > 9999)
		{
			throw new RuntimeException ("Account number out of range");
		}
		
		if ((_firstName == "") || (_firstName == null))
		{
			throw new NullPointerException ("First name can not be empty");
		}
		
		if ((_lastName == "") || (_lastName == null))
		{
			throw new NullPointerException ("Last name can not be empty");
		}
		
		if (_accountBalance < 0)
		{
			throw new IllegalStateException ("Account balance can not be negitive");
		}		
	}
}
		
		
	

