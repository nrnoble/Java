package nrnoble;

import java.util.Scanner;

/**
 * 3. Write a driver class that asks the user for their first and 
 * last name from the Java console. Throw a new BadNameException 
 * if the user gives you a first or last name that is shorter than 
 * 3 characters. Does your code compile? If not, explain why.
 *
 * @author  Neal Noble<br>
 * IT301<br>
 * Exercises – Custom Exceptions<br>
 * January 29nd, 2016<br>
 */
 
public class Driver
{
	private String firstName;
	private String lastName;
	
	@SuppressWarnings("resource")
	public Driver() throws BadNameException
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first name");
		firstName = scanner.nextLine(); 
		System.out.println("Enter last name");
		lastName = scanner.nextLine(); 

		if (firstName.length() <=3  || lastName.length() <= 3)
		{
			throw new BadNameException("First and last names must be greater than three characters");
		}
		scanner.close();
	}
	

}
