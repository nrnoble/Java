package nrnoble;

/**
 * @author  Neal Noble<br>
 * IT301<br>
 * Exercises – Custom Exceptions<br>
 * January 29nd, 2016<br>
 */
public class Main
{

	public Main()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{

		// Driver driver = new Driver();
		BadNameException badNameException = new BadNameException();
		badNameException.getBadName();
		System.out.println("Finished!");
	}

}
