package nrnoble;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 
 * @author Neal Noble<br>
 * IT301<br>
 * Exercises - Throwing Exceptions (Perspective B)<br>
 * January 28nd, 2016<br>
 */
public class Main
{
	
	private static Scanner scanner = new Scanner(System.in);
	private static String firstName = "";
	private static String lastName = "";
	
	/**
	 * Nothing to initialize.
	 */
	public Main()
	{


	}
	/**
	 * Start of program
	 * @param args ignored
	 */
	public static void main(String[] args)
	{
		question3();   
	}
	
	/**
	 * 1. Create a new Scanner object to read input from the Java console. Prompt
	 *  the user for their name, read in their first/last name and then print the 
	 *  their name to console using the following format: "Welcome <i>firstName</i> and <i>lastName</i>!".
	 */
	public static void question1()
	{
		System.out.print("Enter First Name:\t");
		firstName = scanner.nextLine();
		
		System.out.print("Enter Last Name:\t");
		lastName = scanner.nextLine();

		System.out.println("Welcome "+ firstName + " "  +  lastName + "!");
	}
	
	
	/**
	 * 2. Add a try-catch block to your code segment from (1) that catches any 
	 * type of exception that is thrown from the Scanner.nextLine() method. You 
	 * will need to view the API for the method to see what exceptions are thrown, 
	 * found here (Links to an external site.). You should have a different catch 
	 * block for each type of exception. Each catch block should print a message 
	 * that is display for the user. The message should describe what went wrong!
	 * 
	 */
	public static void question2()
	{
		Scanner scanner =  null;
		try
		{
			question1();
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
        
		
	}
	
	
	/**
	 * 3. Test out your try-catch block by closing your Scanner object before reading
	 *  in your console values from (1). This should print the error messages of the 
	 *  exceptions that are thrown.
	 */
	public static void question3()
	{
		scanner.close();
		question2();	
	}

	
	

}
