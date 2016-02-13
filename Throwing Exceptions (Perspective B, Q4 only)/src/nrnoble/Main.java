package nrnoble;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 
 * @author Neal Noble<br>
 * IT301<br>
 * Exercises - Throwing Exceptions (Perspective B, Question 4)<br>
 * Question #4
 * January 27nd, 2016<br>
 */
public class Main
{
	private static Scanner scanner = new Scanner(System.in);
	private static BankAccount bankAccount;
	
	/**
	 *  Nothing to initialize
	 */
	public Main()
	{
		// Nothing to initialize 
	}

	/**
	 * start of program
	 * @param args ignored
	 */
	public static void main(String[] args)
	{
		try
		{
			question4();
		}
		catch (Exception e)
		{
			System.out.println("Unable to create bank account");
			e.printStackTrace();
		}
		System.out.println("All done!");
		
		
	}

	
	/**
	 * 4. Write a driver program that allows the user to create Bank Account 
	 * objects from Exercises - Throwing Exceptions (Perspective A) by entering 
	 * values to the Java console. Your driver program should have a try catch 
	 * block that handles all types of exceptions that can be thrown in the 
	 * BankAccount constructor.
	 */
	public static void question4()
	{
		
		String firstName;
		String lastName;
		int accountID;
		int accountBalance;
		
		try
		{
			System.out.println("Enter First Name: ");
			firstName = scanner.nextLine();
			System.out.println("Enter Last Name: ");
			lastName = scanner.nextLine();
			System.out.println("Enter Account ID: ");
			accountID = scanner.nextInt();
			System.out.println("Enter Account Balance: ");
			accountBalance = scanner.nextInt();
			
	
		} 
		catch (NoSuchElementException e)
		{
			//e.printStackTrace();
			throw new NoSuchElementException("Scanner object is no longer available");
		}
		
		
		catch (IllegalStateException e)
		{
			//e.printStackTrace();
			throw new IllegalStateException("Scanner object is closed");		
		}
		
		
		try
		{
			bankAccount = new BankAccount(accountID, firstName, lastName, accountBalance);
		}
		catch(Exception e)
		{
			throw new RuntimeException (e) ;
		}

		
		
		
	
	}
	

}
