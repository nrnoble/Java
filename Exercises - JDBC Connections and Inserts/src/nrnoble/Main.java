package nrnoble;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Start of application
 * @author Neal Noble
 *
 */
public class Main
{
	
	
	public Main()
	{
		// nothing to do here
	}

	/**
	 * 
	 * @param args not implemented
	 * @throws ClassNotFoundException Exception
	 * @throws SQLException Exception
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		System.out.println("Connecting to nnoble.greenrivertech.net....");

		SQL sql = new SQL("nnoble_301","J$p1ter2","nnoble.greenrivertech.net");
		
		System.out.println("Successfully connected to nnoble.greenrivertech.net!");
		
		// application loop
		Menu.mainMenu(sql);
		

		sql.getConnection().close();
		System.out.println("Closing Connection....");
		System.out.println("All done, good bye!...");
	}
	
}


