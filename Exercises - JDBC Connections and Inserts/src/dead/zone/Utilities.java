package dead.zone;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.concurrent.ThreadLocalRandom;

import nrnoble.Fruit;

public class Utilities
{

	public Utilities()
	{
		// nothing to do here
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

	
	/**
	 * 
	 * @param str string of characters
	 * @param padding width of white spaces
	 * @return padded string
	 */
	public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);  
	}
	
	
	/**
	 * Generate a random numbers between RANDOMLOW and RANDOMHIGH
	 * excluding zero from the random numbers to reduce division 
	 * by zero errors
	 * @return a random number, excluding zero
	 */
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
	  * @return
	  */
	 public static int randInt(int _min, int _max)
	{
		return ThreadLocalRandom.current().nextInt(_min, _max + 1);
	 
	}
	 
	/**
	 *  
	 * @param connnectToRemoteDB connection to DB
	 * @param _fruit fruit object
	 * @return status of insert query
	 * @throws SQLException exception
	 */
	public static int insertFruit(Connection connnectToRemoteDB, Fruit _fruit) throws SQLException
	{
		//create a statement and query
		Statement stmt = connnectToRemoteDB.createStatement();
		return stmt.executeUpdate(_fruit.sqlInsertQuery());	
	}
	/**
	 *  
	 * @param connnectToRemoteDB connection to DB
	 * @param _fruit fruit object
	 * @return status of insert query
	 * @throws SQLException exception
	 * @return ResultSet
	 */
	public static ResultSet viewFruit(Connection connnectToRemoteDB, Fruit _fruit) throws SQLException
	{
		//create a statement and query
		Statement stmt = connnectToRemoteDB.createStatement();
		return stmt.executeQuery(_fruit.sqlSelectQuery());	
	}
	
}
	 
	 

