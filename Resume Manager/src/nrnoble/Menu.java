package nrnoble;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.greenriver.it.console.Console;

/**
 * Helper class. Static method for console menus
 * @author Neal Neal
 * date February 2016
 */
public class Menu
{

	public Menu()
	{
		// not to do here
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
	
	
	public static String inputDefaultData(String _prompt, String _default)
	{
		String inputString = Console.getString(_prompt + ": " + _default);
		if (inputString.isEmpty())
		{
			return _default;
		}
		
		return inputString;
	}
	
	
	/**
	 * 
	 * @return the selected menu item as char
	 */
	public static char applicationMenu()
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
			System.out.println("\r");
			System.out.println("1. Build a new resume.");
			System.out.println("2. View all resumes");
//			System.out.println("3. Sort by Type");
//			System.out.println("4. Sort by Origin");
//			System.out.println("5. Sort by Weight");
//			System.out.println("6. Sort descending order");
//			System.out.println("7. Sort ascending order");
//			System.out.println("8. Delete all sample data from table");
			System.out.println("3. Exit");
			menuSelection = myGetKeyHack ("Enter (default 1)", '1');		
		}
		
		return menuSelection;
	}
	

	
	
	
	
/**
 *  main application loop. 
 * @param sql SQL helper  
 * @throws SQLException Exception
 */
	public static void mainMenu(ResumeManager resumeManager) throws SQLException
	{
		// menu selection 
		char selection = ' ';
		
		
		while (selection != '3')
		{
			//Prompt user to selection a menu option
			selection = nrnoble.Menu.applicationMenu();
			
			// evoke selected menu option
			//Fruit fruit = new Fruit();
			
//			Enter a resume title: My Resume
//			Enter your name: Jose Garcia
//			Enter a profile: I am a hard worker who is interesting in a technical position as a software tester.
//			Enter an email address: jg2001@gmail.com
			if (selection == '1')
			{
				
				
				String title 	= inputDefaultData("Enter a resume title", "Resume2");			
				String name 	= inputDefaultData("Enter your name", "Neal Noble");	
				String profile 	= inputDefaultData("Enter a profile", "I am a hard worker who is interesting in a technical position as a software developer");	
				String email 	= inputDefaultData("Enter an email address", "dev@developer.com");	
				
				// create new resume in DB here
				
				Character addSkill = 'y';
				while (addSkill == 'y')
				{

					String skill 		= inputDefaultData("Skill", "SQL");	
					String description 	= inputDefaultData("Description","Creating and Managing SQL databases");	
					addSkill = myGetKeyHack ("Add a new skill (default Yes)", 'y');
				}
				
				Character addEmployment = 'y';
				while (addEmployment == 'y')
				{

					String employer 	= inputDefaultData("Employer", "Skynet");	
					String startDate 	= inputDefaultData("Start Date","2001-03-19");	
					String endDate 		= inputDefaultData("End date","2005-05-23");	
					String position 	= inputDefaultData("position","SQL developer");	
					addEmployment 		= myGetKeyHack ("Add more employment history (default Yes)", 'y');
				}
				
				
				
			}
			
			//
			if (selection == '2')
			{
				
			}
			
			
					
		}
	}
	

	
	/**
	 * Console data entry entry menu
	 * @return Fruit object
	 */
//	private static Fruit enterDataMenu()
//	{
//		
//		String fruitType = Console.getString("Enter fruit type: ");	
//		String fruitOrigin = Console.getString("Enter origin: ");
//		double fruitWeight = Console.getDouble("Enter weight: ");
//
//		String fruitDescription = Console.getString("Enter description: ");
//		Fruit fruit = new Fruit(fruitType, fruitOrigin, fruitWeight, fruitDescription);
//		
//		return fruit;
//	}


	
	
}
