package nrnoble;

import java.util.List;


/**
 * Helper class. Static method for console menus
 * @author Neal Neal
 * date February 2016
 */
public class Menu
{

	public Menu()
	{
		// nothing to to do here
	}

	
	/**
	 * Returns the first character from an input string
	 * @param _prompt text displayed to the user.
	 * @param _default value if only {return} is used
	 * @return a single char value
	 */
	public static char myGetKeyHack(String _prompt, char _default)
	{
		String inputString = Console.getString(_prompt);
		if (inputString.isEmpty())
		{
			return _default;
		}
		
		return inputString.charAt(0);
	}
	
	
	/**
	 * Get input string from user
	 * @param _prompt Menu Prompt string
	 * @return User input
	 */
	public static String consoleInput(String _prompt)
	{
		String inputString = "";
		boolean valid = false;
		while (valid == false)
		{
		    inputString = Console.getString(_prompt + ": ");
			valid = Utils.validateInput(inputString);
			
		}
		
		
		return inputString;
	}
	
	
	/**
	 * 	/**
	 * Main menu for application
	 * @return the selected menu item as char
	 * @param _rangeEnd the upper limit of search for prime numbers
	 * @param _threads the number of threads to be used during search
	 */
	public static char applicationMenu(int _threads, int _rangeEnd)
	{
		char menuSelection = ' ';
		while (menuSelection != '1' && 
			   menuSelection != '2' &&
			   menuSelection != '3' &&
			   menuSelection != '4' &&
			   menuSelection != '5' &&
			   menuSelection != '6' &&
			   menuSelection != '7' &&
			   menuSelection != '8' &&
			   menuSelection != '9')
		{
			 System.out.println("----------------------------");
			System.out.println("1. New search for primes numbers");
			System.out.println("2. Show sorted list of primes");
			System.out.println("3. Change number of threads (" + _threads + ")");
			System.out.println("4. Change upper search limit(" + _rangeEnd + ")");
			System.out.println("5. Info");
			System.out.println("6. Exit");
		 	           System.out.println("----------------------------");
			menuSelection = myGetKeyHack ("   Choice (default 1)", '1');
			System.out.println();
			System.out.println();
		}	
		return menuSelection;
	}
	
	
/**
 *  main application loop. 
 * @throws InterruptedException Exception
 */
	public static void mainMenu() throws InterruptedException 
	{
		// menu selection 
		char selection 		= ' ';
		int range_End = Config.RANGE_END;
		int range_Start = Config.RANGE_START;
		int numOfThreads = Config.NUMBEROFTHREADS;
		List <Utils.Points> rangeList = null;

		// Selecting Menu option #6 exits loop
		while (selection != '6')
		{
			System.out.println("\r");
			System.out.println(Config.APPLCATION_TITLE);
			//Prompt user to selection a menu option
			selection = nrnoble.Menu.applicationMenu(numOfThreads,range_End);
			
			/* ----------------------------- */
			// ****   Menu Option #3   *****
			/* ----------------------------- */
			if(selection =='5')
			{
				Main.info();
				continue;
			}
			
			/* ----------------------------- */
			// ****   Menu Option #1   *****
			/* ----------------------------- */
			if (selection == '1')
			{
				PrimesData.ClearPrimeList();
				System.out.println();
				System.out.println(" Search for Primes Numbers");
				System.out.println("--------------------");
								
				rangeList = Utils.RangeList(range_End, numOfThreads);
				PrimesData.findPrimes(rangeList);

				
				int threadIDCount = 0;
				for(Utils.Points  points : rangeList)
				{
					System.out.println("ThreadID-"+ ++threadIDCount + " " 
				                       + String.format(Config.DIGITS, points.getStart()) 
				                       + " .. " + String.format(Config.DIGITS, points.getEnd()));
				}
				System.out.println();
				System.out.println("Prime Number Count: " 
				                   + PrimesData.primeNumberCounter()
				                   + " found between " + range_Start 
				                   + ".." + range_End); 
				
				System.out.println("-------------------------------------------------\r");
				PrimesData.displayPrimesFound(false);
			}
			
			
			/* ----------------------------- */
			// ****   Menu Option #2   *****
			/* ----------------------------- */	
			if (selection == '2')
			{
				// verify that there is a list a prime numbers.
				// if list is null, then do search.
				if (PrimesData.getPrimes().isEmpty() == true)
				{
					rangeList = Utils.RangeList(range_End, numOfThreads);
					PrimesData.findPrimes(rangeList);
				}
				
				System.out.println();
				System.out.println("Prime Number Count: " 
				                   + PrimesData.primeNumberCounter() 
				                   + " found between " 
				                   + Config.RANGE_START 
				                   + ".." + range_End); 
				
				System.out.println("-------------------------------------------------\r");
				PrimesData.displayPrimesFound(true);
			}
			
			
			/* ----------------------------- */
			// ****   Menu Option #4   *****
			/* ----------------------------- */	
			if (selection == '4')
			{		
				range_End = Console.getInt("Enter a new upper range (100 - 1,0000,000)");
				while (range_End < 100 || range_End > 1000000)
				{
					range_End = Console.getInt("Enter a new upper range");
				}
				
				PrimesData.ClearPrimeList();
				
			}
			
			
			/* ----------------------------- */
			// ****   Menu Option #3   *****
			/* ----------------------------- */	
			if (selection == '3')
			{
				numOfThreads = Console.getInt("Enter number of threads (1-10)");
				while (numOfThreads < 1 || numOfThreads > 10)
				{
					numOfThreads = Console.getInt("Enter number of threads (1-10)");
				}
				
				PrimesData.ClearPrimeList();
				
			}
			
			
			
		}
		
	}
	
}
