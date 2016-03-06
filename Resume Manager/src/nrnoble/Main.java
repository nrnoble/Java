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
		// Test Driver handles SQL connection
		// Test driver extends from SaleDataLayer object
		// TestDriver testDriver = new TestDriver();
		
		
		ResumeManager resumeManager = new ResumeManager(ConnectionSettings.USERNAME, 
														ConnectionSettings.PASSWORD, 
														ConnectionSettings.SQLSERVERNAME);
		System.out.println("Connected to database...");
		System.out.println();
		Menu.mainMenu(resumeManager);
		
		System.out.println();
		System.out.println();
		System.out.println("Closing database connection");
		System.out.println("Exiting Resume Manager");
		resumeManager.Close();
	}

}
