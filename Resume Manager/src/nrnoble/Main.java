package nrnoble;

import java.sql.SQLException;


/**
 * Start of Resume manager
 * @author Neal
 *
 */
public class Main
{

	public Main()
	{
		// Nothing to do here
	}

	/**
	 * 
	 * @param args not implemented
	 * @throws ClassNotFoundException exception
	 * @throws SQLException exception
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{	
		ResumeManager resumeManager = new ResumeManager(ConnectionSettings.USERNAME, 
														ConnectionSettings.PASSWORD, 
														ConnectionSettings.SQLSERVERNAME);
		
	    // header  
		info();
		
		// Application loop
		Menu.mainMenu(resumeManager);
		
		// Close connnection before exit application.
		System.out.println("Closing database connection");
		System.out.println("Exiting Resume Manager, Good bye!");
		resumeManager.Close();
	}
	

	
	/**
	 * Assignment info
	 */
	public static void info()
	{
		System.out.println("Neal Noble");
		System.out.println("IT 301");
		System.out.println("Assignment: Resume Manager");
		System.out.println("March 2016");
		System.out.println("");
		System.out.println("  server: " + ConnectionSettings.SQLSERVERNAME);
		System.out.println("Database: " + ConnectionSettings.RESUMEDB);
		System.out.println("  Tables: " + ConnectionSettings.RESUME_TABLE);
		System.out.println("          " + ConnectionSettings.RESUME_EXPERIENCE_TABLE);
		System.out.println("          " + ConnectionSettings.RESUME_SKILL_TABLE);
		System.out.println("  status: Connected" );
		System.out.println();
	}

}
