package nrnoble;

import java.io.IOException;
import java.util.Scanner;


/**
 *  
 * 2. Create a custom exception class called BadNameException. Your class 
 * should be a checked exception and should include the following methods:
 *       public BadNameException(String message, String theBadName)
 *       public BadNameException(String theBadName)
 *       public String getBadName()
 *
 * @author  Neal Noble<br>
 * IT301<br>
 * Exercises – Custom Exceptions<br>
 * January 29nd, 2016<br>
 */
public class BadNameException extends IOException
{
	private static String defaultMessage = "Default error message";
	
	/**
	 * see IOException
	 */
	public BadNameException()
	{
		super(defaultMessage);
	}

	/**
	 * see IOException
	 * @param message
	 * @param theBadName
	 */
    public BadNameException(String message, String theBadName)
    {
    	
    }
    /**
     * see IOException
     * @param theBadName
     */
    public BadNameException(String theBadName)
    {
    	super(theBadName);
    }

    /**
     * 4. Move your driver code to a method called getUserInput(). Invoke your 
     * getUserInput() method in your main() method and add a try-catch block to 
     * handle any BadNameException that is thrown. Your catch block should print 
     * the bad name that was given back to the console.
     * @return
     */
    @SuppressWarnings("resource")
	public String getBadName()
    {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first name");
		String firstName = scanner.nextLine(); 
		System.out.println("Enter last name");
		String lastName = scanner.nextLine(); 
		
		// make it 4 when checking for 3 characters because scanner.nextLine 
		// adds a return characters to end of line
		if (firstName.length() < 4 || lastName.length() < 4)
		{
			try
			{
				throw new BadNameException("First and last names must be greater than three characters");
			} 
			catch (BadNameException e)
			{
				
				e.printStackTrace();
			}
		}
		scanner.close();
    	return firstName + " " + lastName;
    }

    /**
     * see IOException
     * @param arg0
     */
	public BadNameException(Throwable arg0)
	{
		super(arg0);

	}
	/**
	 * see IOException
	 * @param arg0
	 * @param arg1
	 */
	public BadNameException(String arg0, Throwable arg1)
	{
		super(arg0, arg1);
		
	}

}
