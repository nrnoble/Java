package nrnoble;



public class Main
{

	public Main()
	{
		// Nothing to do here
	}

	/**
	 * Start of this application
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException
	{
		info();		
		Menu.mainMenu();
		
		
		System.out.println("Application has exited, good-bye!");
	}
	
	
	
	/**
	 * Assignment information
	 */
	public static void info()
	{
		System.out.println("Neal Noble");
		System.out.println("IT 301");
		System.out.println("Assignment: Threads");
		System.out.println("March 2016");

	}


}
