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
		// TODO Auto-generated constructor stub
	}
	
	public static String underScore (String _string)
	{
		int strLength = _string.length();
		String underScoreString = "";
		for (int idx = 0;  idx < strLength; idx++)
		{
			underScoreString += "-";
		}
		
		return  underScoreString;
		
	}
	
	
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
	 * @param str string of characters
	 * @param padding width of white spaces
	 * @return padded string
	 */
	public static String padRight(String str, int padding) 
	{
	     return String.format("%1$-" + padding + "s", str);  
	}

	
	public static boolean isValidDate(String inDate) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    try {
	      dateFormat.parse(inDate.trim());
	    } catch (ParseException pe) {
	      return false;
	    }
	    return true;
	  }
	
	
	/**
	 * 
	 * @param str string of characters
	 * @param padding width of white spaces
	 * @return padded string
	 */
	public static String padLeft(String str, int padding) {
	    return String.format("%1$" + padding + "s", str);  
	}

	 @SuppressWarnings("unused")
	private static int randTestNum(int low, int high)
	 {
		  int randNum = 0;
	      while(randNum == 0)
	      { 
	    	  randNum = randInt(low,high);
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
	 * @param connnectToRemoteDB connection to DB
	 * @throws SQLException exception
	 * @return true\false 
	 */
	public static boolean deleteSampleData(Connection connnectToRemoteDB) throws SQLException
	{
		//create a statement and query
		Statement stmt = connnectToRemoteDB.createStatement();
		return stmt.execute(DELETEDATAQUERY);	
		//return stmt.executeUpdate(DELETEDATAQUERY);	
	}
	
	

/**
 * Display a basic text SQL Table in console
 * @param resultSet SQL table data
 * @throws SQLException Exception
 */
	public static void displaySQLTable(ResultSet resultSet) throws SQLException
	{
		// Get column data
				ResultSetMetaData metadata = resultSet.getMetaData();
				
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
					String ColumnName = nrnoble.Utils.padRight(Utils.underScore(metadata.getColumnName(idx)),COLUMWIDTH);
					System.out.print(ColumnName);
				}
				
				System.out.println();
				
				// display rows of data
				while(resultSet.next() != false)
				{
					// display a single row of data
					for (int idx=1; idx <= columCount; idx++)
					{
						String row =resultSet.getString(idx);
						String columData = Utils.padRight(row,COLUMWIDTH);
						System.out.print(columData);
					}
					System.out.println("");
					
				}
		
	}
}
