package nrnoble;

import java.sql.SQLException;


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
	
	public static String inputDefaultData(String _prompt)
	{
		String inputString = Console.getString(_prompt + ": ");
		return inputString;
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
			//System.out.println("\r");
			System.out.println("1. Build a new resume.");
			System.out.println("2. List Resumes");
//			System.out.println("3. Sort by Type");
//			System.out.println("4. Sort by Origin");
//			System.out.println("5. Sort by Weight");
//			System.out.println("6. Sort descending order");
//			System.out.println("7. Sort ascending order");
//			System.out.println("8. Delete all sample data from table");
			System.out.println("3. Exit");
		 	           System.out.println("------------------------");
			menuSelection = myGetKeyHack ("   Choice (default 1)", '1');		
		}
		
		return menuSelection;
	}

	
	
/**
 *  main application loop. 
 * @param resumeManager ResumeManager object
 * @throws SQLException Exception Expection
 * @throws ClassNotFoundException Expection
 */
	public static void mainMenu(ResumeManager resumeManager) throws SQLException, ClassNotFoundException
	{
		// menu selection 
		char selection 		= ' ';
		Character addSkill 	= 'y';
		
		String title 		= "";			
		String name 		= "";	
		String profile 		= "";	
		String email 		= "";	
		
		
		String skill		= "";
		String description 	= "";
		
		String employer 	= "";	
		String startDate 	= "";	
		String endDate 		= "";	
		String position 	= "";	

		
		while (selection != '3')
		{
			System.out.println("*** RESUME MANAGER 2016 ***\r");
			//Prompt user to selection a menu option
			selection = nrnoble.Menu.applicationMenu();
			
			if (selection == '1')
			{
				System.out.println();
				System.out.println(" Add Resume");
				System.out.println("--------------------");
				
				

//				 title 		= inputDefaultData(" * Enter a resume title", "Resume2");			
//				 name 		= inputDefaultData(" * Enter your name", "Neal Noble");	
//				 profile 	= inputDefaultData(" * Enter a profile", "I am a hard worker who is interesting in a technical position as a software developer");	
//				 email 		= inputDefaultData(" * Enter an email address", "dev@developer.com");	
				
				title 		= inputDefaultData(" * Enter a resume title");			
				 name 		= inputDefaultData(" * Enter your name");	
				 profile 	= inputDefaultData(" * Enter a profile");	
				 email 		= inputDefaultData(" * Enter an email address");	
				
				
				
				// create new resume in DB here
				resumeManager.addResume(title, name, profile, email);
				int pkey = resumeManager.getLastPkey();
				
				System.out.println();
			
				System.out.println();
				System.out.println(" Add Resume Skills");
				System.out.println("--------------------");
				
				// Add resume skills
				while (addSkill == 'y')
				{
//					skill 		= inputDefaultData(" * Skill", "SQL");	
//					description = inputDefaultData(" * Description","Creating and Managing SQL databases");

					skill 		= inputDefaultData(" * Skill");	
					description = inputDefaultData(" * Description");

					
					System.out.println();
					
					resumeManager.addResume_skill(pkey, skill, title, description);		
					
					addSkill 	= myGetKeyHack ("Add a new skill (default Yes)", 'y');
				
				}
				
		
				
				
				
				System.out.println();
				System.out.println("---------------- End of adding skills ----------------");
				System.out.println();
				System.out.println(" Add Employment Experience");
				System.out.println("----------------------------");
				
				// Add Resume Experience
				Character addEmployment = 'y';
				while (addEmployment == 'y')
				{
//					 employer 		= inputDefaultData(" * Employer", "Skynet");	
//					 startDate 		= inputDefaultData(" * Start Date","2001-03-19");	
//					 endDate 		= inputDefaultData(" * End date","2005-05-23");	
//					 position 		= inputDefaultData(" * position","SQL developer");	
					
					 employer 		= inputDefaultData(" * Employer");	
					
					 startDate 		= inputDefaultData(" * Start Date");	
					 boolean validDate = Utils.isValidDate(startDate); 
					 while (validDate != true)
					 {
						 startDate 		= inputDefaultData(" * Start Date");
						 validDate 		= Utils.isValidDate(startDate); 
					 }
					 
					 endDate 		= inputDefaultData(" * End date");	
					 validDate = Utils.isValidDate(endDate);
					 
					 while (!validDate)
					 {
						 endDate 		= inputDefaultData(" * End date");	
						 validDate = Utils.isValidDate(endDate);
					 }
					 position 		= inputDefaultData(" * position");	
					
					 System.out.println();
					 
					 resumeManager.addResume_experience(pkey, employer, title, startDate, endDate, position);
					 addEmployment 	= myGetKeyHack ("Add more employment history (default Yes)", 'y');
				}

				System.out.println();
				System.out.println("---------------- End of Employment History ----------------");
				System.out.println();
				System.out.println();
				
			}
			
			//
			if (selection == '2')
			{
				

					resumeManager.showResumeList();
					
				
				
				int selectedOption = 2;
				while (selectedOption != 0)
				{
					System.out.println();
					System.out.println("Menu: Resume Details"); 
					System.out.println("----------------------------"); 
					System.out.println("    Select a resume # ");
					System.out.println(" 2. Show List of resumes ");
					System.out.println(" 0. Return to previous menu");
					System.out.println("----------------------------"); 
					selectedOption = Console.getInt("    Choice");
					
					 
					if (selectedOption == 0)
					{
						 break;
					}
					else if (selectedOption == 2)
					{
						resumeManager.showResumeList();
						continue;
					}
					else
					{
						resumeManager.showResumeDetails(selectedOption);
					}

				}
				
			}
			
//			
//			if (selection == 32)
//			{
//				break;
//			}
//			
			
					
		}
	}
	
}
