package nrnoble;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.greenriver.it.console.Console;

/**
 * Helper class. Static method for console menus
 * @author Neal Neal
 * @date February 2016
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
			System.out.println("1. Enter a new fruit. (Randomly generated data)");
			System.out.println("2. View fruit.");
			System.out.println("3. Sort by Type");
			System.out.println("4. Sort by Origin");
			System.out.println("5. Sort by Weight");
			System.out.println("6. Sort descending order");
			System.out.println("7. Sort ascending order");
			System.out.println("8. Delete all sample data from table");
			System.out.println("9. Exit");
			menuSelection = myGetKeyHack ("Enter (default 1)", '1');		
		}
		
		return menuSelection;
	}
	

/**
 *  main application loop. 
 * @param sql SQL helper  
 * @throws SQLException Exception
 */
	public static void mainMenu(SQL sql) throws SQLException
	{
		// menu selection 
		char selection = ' ';
		
		
		while (selection != '9')
		{
			selection = nrnoble.Menu.applicationMenu();
			Fruit fruit = new Fruit();
			if (selection == '1')
			{
				System.out.println("Executing SQL query: \n" + fruit.sqlInsertQuery());
				sql.Insert(fruit.sqlInsertQuery());
				System.out.println();
			}
			
			if (selection =='2' )
			{		
				System.out.println("");	
				sql.viewResultSet(Fruit.sqlSelectQuery());
			}
			
			// Sort by type
			if (selection =='3' )
			{	
				System.out.println("");	
				sql.viewResultSet(Fruit.querySortBy("type","ASC"));
			}
			
			
			// Sort by type Origin
			if (selection =='4' )
			{
				System.out.println("");	
				sql.viewResultSet(Fruit.querySortBy("Origin","ASC"));
			}
			
			// Sort by type weight
			if (selection =='5' )
			{
				System.out.println("");	
				sql.viewResultSet(Fruit.querySortBy("weight","ASC"));
			}
			
			// sort by descending
			if (selection =='6' )
			{
				System.out.println("");	
				sql.viewResultSet(Fruit.querySortBy("type", "DESC"));
			}
			
			
			// sort by ascending
			if (selection =='7' )
			{
				System.out.println("");	
				sql.viewResultSet(Fruit.querySortBy("type", "ASC"));
			}
			
			// Delete all data in the table.
			if (selection == '8')
			{
				Utils.deleteSampleData (sql.getConnection());
			}
			
			// Exit Main Menu loop
			else if (selection == '9')
			{
				break;
			}
		
		}
	}
	

	
	/**
	 * Console data entry entry menu
	 * @return Fruit object
	 */
	private static Fruit enterDataMenu()
	{
		
		String fruitType = Console.getString("Enter fruit type: ");	
		String fruitOrigin = Console.getString("Enter origin: ");
		double fruitWeight = Console.getDouble("Enter weight: ");

		String fruitDescription = Console.getString("Enter description: ");
		Fruit fruit = new Fruit(fruitType, fruitOrigin, fruitWeight, fruitDescription);
		
		return fruit;
	}


	
	
}
