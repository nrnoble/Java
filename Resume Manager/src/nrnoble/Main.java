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
		
		ResumeManager resumeManager = new ResumeManager();
		
		Menu.mainMenu(resumeManager);
		
		
		
		resumeManager.Close();
	}

}
