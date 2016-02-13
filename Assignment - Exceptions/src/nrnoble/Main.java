package nrnoble;

/**
 * 
 * @author Neal Noble<br>
 * IT301<br>
 * Assignment - Exceptions<br>
 * Feb 5th, 2016<br>
 */
public class Main
{

	/**
	 * Not implemented, so make it private
	 */
	public Main()
	{
		// Nothing to do here
	}

	
	/**
	 * Application starts here
	 * @param args not in use
	 */
	public static void main(String[] args)
	{


			Driver driver = new Driver();
			
			driver.test_Constructors();
			
			driver.test_Add();
			driver.test_Subtract();
			driver.test_Multiply();
			driver.test_Division();
			
			System.out.println("All testing is complete. Scroll up to review results");
			System.out.println("Good bye!");


	}

}
