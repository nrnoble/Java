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
	 * Main menu for Resume Manager 
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
			System.out.println("1. Build a new resume");
			System.out.println("2. List Resumes");
			System.out.println("3. Info");
			System.out.println("4. Exit");
		 	           System.out.println("------------------------");
			menuSelection = myGetKeyHack ("   Choice (default 1)", '1');
			System.out.println();
			System.out.println();
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
		
		String 	title, 
				name, 
				profile, 
				email 		= "";
		
		String 	skill, 
				description, 
				employer,
				startDate,
				endDate,
				position	= "";



		// Selecting Menu option #4 exits loop
		while (selection != '4')
		{
			System.out.println("*** RESUME MANAGER 2016 ***\r");
			//Prompt user to selection a menu option
			selection = nrnoble.Menu.applicationMenu();
			
			/* ----------------------------- */
			// ****   Menu Option #3   *****
			/* ----------------------------- */
			if(selection =='3')
			{
				Main.info();
				continue;
			}
			
			/* ----------------------------- */
			// ****   Menu Option #1   *****
			/* ----------------------------- */
			if (selection == '1')
			{
				System.out.println();
				System.out.println(" Add Resume");
				System.out.println("--------------------");
 				
				 title 		= consoleInput(" * Enter a resume title");
				 name 		= consoleInput(" * Enter your name");	
				 profile 	= consoleInput(" * Enter a profile");	
				 email 		= consoleInput(" * Enter an email address");	
				
				// create new resume in DB here
				resumeManager.addResume(title, name, profile, email);
				int pkey = resumeManager.getLastPkey();
				
				System.out.println();
				System.out.println();
				System.out.println(" Add Resume Skills");
				System.out.println("--------------------");
				
				
				/* ----------------------------- */
				// ****  Add resume skills *****
				/* ----------------------------- */
				
				while (addSkill == 'y')
				{
					skill 		= consoleInput(" * Skill");	
					description = consoleInput(" * Description");
					System.out.println();
					resumeManager.addResume_skill(pkey, skill, title, description);							
					addSkill 	= myGetKeyHack ("Add a new skill (default Yes)", 'y');
				}
				
				System.out.println();
				System.out.println("---------------- End of adding skills ----------------");
				System.out.println();
				
				
				/* ----------------------------- */
				// ****  Add Experience  *****
				/* ----------------------------- */
				
				System.out.println(" Add Employment Experience");
				System.out.println("----------------------------");
				
				// Add Resume Experience
				Character addEmployment = 'y';
				while (addEmployment == 'y')
				{
					 employer 		= consoleInput(" * Employer");						
					 startDate 		= consoleInput(" * Start Date");	
					 boolean validDate = Utils.isValidDate(startDate); 
					 while (validDate != true)
					 {
						 startDate 		= consoleInput(" * Start Date");
						 validDate 		= Utils.isValidDate(startDate); 
					 }
					 
					 endDate 		= consoleInput(" * End date");	
					 validDate 		= Utils.isValidDate(endDate);
					 
					 while (!validDate)
					 {
						 endDate 		= consoleInput(" * End date");	
						 validDate 		= Utils.isValidDate(endDate);
					 }
					 position 		= consoleInput(" * position");	
					
					 System.out.println();
					 
					 resumeManager.addResume_experience(pkey, employer, title, startDate, endDate, position);
					 addEmployment 	= myGetKeyHack ("Add more employment history (default Yes)", 'y');
				}

				System.out.println();
				System.out.println("---------------- End of Employment History ----------------");
				System.out.println();
				System.out.println();
				
			}
			
			
			/* ----------------------------- */
			// ****   Menu Option #2   *****
			/* ----------------------------- */
			
			if (selection == '2')
			{
				resumeManager.showResumeList();
				
				int selectedOption = 2;
				while (selectedOption != 0)
				{
					System.out.println();
					System.out.println("Menu: Resume Details"); 
					System.out.println("---------------------------------------"); 
					System.out.println("    Enter a pkey # to view details");
					System.out.println(" 2. Show List of resumes ");
					System.out.println(" 0. Return to previous menu");
					System.out.println("---------------------------------------"); 
					selectedOption = Console.getInt("    Choice");
					
					if (selectedOption == 0)
					{
						 break;
					}
					else if (selectedOption == 2)
					{
						System.out.println();
						System.out.println();
						resumeManager.showResumeList();
						continue;
					}
					else
					{
						System.out.println();
						System.out.println();
						resumeManager.showResumeDetails(selectedOption);
					}
				}	
			}
		}
	}
	
}
