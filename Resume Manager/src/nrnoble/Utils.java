package nrnoble;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Utils
{
	private static int COLUMWIDTH = 25;
	private static String DELETEDATAQUERY = "";
	public static String SELECTQUERY = "";
	public Utils()
	{
		// Nothing to do here
	}
	
	/**
	 * Underscore the table column heading
	 * @param _string String to be underscored
	 * @return String of unscores that matches the column heading
	 */
	public static String underScoreColumnHeading (String _string)
	{
		int strLength = _string.length();
		String underScoreString = "";
		for (int idx = 0;  idx < strLength; idx++)
		{
			underScoreString += "-";
		}
		
		return  underScoreString;
		
	}
	
	/**
	 * Underscore the table column heading
	 * @param _strLength String to be underscored
	 * @return String of unscores that matches the column heading
	 */
	public static String underScoreColumnHeading (int _strLength)
	{
		String underScoreString = "";
		for (int idx = 0;  idx < _strLength; idx++)
		{
			underScoreString += "-";
		}	
		return  underScoreString; 
	}
	
	
	/**
	 * 
	 * @param _str string of characters to be padded
	 * @param _padding width of white spaces
	 * @return padded string
	 */
	public static String padRight(String _str, int _padding) 
	{
	     return String.format("%1$-" + _padding + "s", _str);  
	}

	
	/**
	 * Basic date validation for yyyy-MM-dd
	 * @param _inDate date to be validated
	 * @return true\false
	 */
	public static boolean isValidDate(String _inDate) 
	{
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    try 
	    {
	      dateFormat.parse(_inDate.trim());
	    } catch (ParseException pe) 
	    {
	      return false;
	    }
	    return true;
	  }
	
	
	/**
	 * 
	 * @param _str string of characters
	 * @param _padding width of white spaces
	 * @return padded string
	 */
	public static String padLeft(String _str, int _padding) {
	    return String.format("%1$" + _padding + "s", _str);  
	}

	@SuppressWarnings("unused")
	private static int randTestNum(int _low, int _high)
	 {
		  int randNum = 0;
	      while(randNum == 0)
	      { 
	    	  randNum = randInt(_low,_high);
	      }
		 return randNum;
	 }
	 
	 /**
	  * 
	  * @param _min lowest random value
	  * @param _max highest random value
	  * @return random number
	  */
	 public static int randInt(int _min, int _max)
	{
		return ThreadLocalRandom.current().nextInt(_min, _max + 1);
 
	}
	 

	/**
	 *  
	 * @param _connnectToRemoteDB connection to DB
	 * @throws SQLException exception
	 * @return true\false 
	 */
	 public static boolean deleteSampleData(Connection _connnectToRemoteDB) throws SQLException
	 {
		//create a statement and query
		Statement stmt = _connnectToRemoteDB.createStatement();
		return stmt.execute(DELETEDATAQUERY);	
		//return stmt.executeUpdate(DELETEDATAQUERY);	
	 }
	
	 
	/**
	 * Display a basic text SQL Table in console
	 * @param _resultSet SQL table data
	 * @throws SQLException Exception
	 */
	public static void displaySQLTable(ResultSet _resultSet) throws SQLException
	{
		// Get column data
				ResultSetMetaData metadata = _resultSet.getMetaData();
				
				// display column headings
				int columCount = metadata.getColumnCount();
				for (int idx=1; idx <= columCount; idx++)
				{
					String ColumnName = Utils.padRight(metadata.getColumnName(idx),COLUMWIDTH);
					System.out.print(ColumnName);
				}
				
				System.out.println();
				
				// underscore the column headings
				for (int idx=1; idx <= columCount; idx++)
				{
					String ColumnName = nrnoble.Utils.padRight(Utils.underScoreColumnHeading(metadata.getColumnName(idx)),COLUMWIDTH);
					System.out.print(ColumnName);
				}
				
				System.out.println();
				
				// display rows of data
				while(_resultSet.next() != false)
				{
					// display a single row of data
					for (int idx=1; idx <= columCount; idx++)
					{
						String row =_resultSet.getString(idx);
						String columData = Utils.padRight(row,COLUMWIDTH);
						System.out.print(columData);
					}
					System.out.println("");
					
				}
	
				
				
				
	}


	/**
	 * Simple check to validate input string.
	 * @param _userData input string
	 * @return true\fase
	 */
	public static boolean validateInput(String _userData)
	{
		boolean validationCheck = true;
		if (_userData == "")
			validationCheck = false; 
		if (_userData.length()<=1)
			validationCheck = false;
		if (_userData.contains("'")== true)
			validationCheck = false;
	
		return validationCheck;
	}
	
	
	/**
	 * simple check to determin if string maybe a valid email address
	 * @param _userData string containing an email address
	 * @return true\false
	 */
	public static boolean validateEmail(String _userData)
	{
		
		if (_userData.contains("@")== true)
			return true;
		
		return false;
	}

}
