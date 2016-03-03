package nrnoble;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 
 * @author Neal Noble
 *
 */
public class JCDB
{

	private String username;
	private String password;
	private String host;
	protected Connection sqlConnection = null;
	
	/**
	 * Creates SQL connection object
	 * @param username SQL User Name
	 * @param password SQL Password
	 * @param host SQL 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public JCDB(String username, String password, String host) throws SQLException, ClassNotFoundException
	{
		this.username = username;
		this.password = password;
		this.host = host;
		
		Properties props = new Properties();

		// credentials
		props.put("user", username);
		props.put("password", password);

		// reference the Connector/J jar file
		Class.forName("com.mysql.jdbc.Driver");

		// get a connection using a "connection string"
		this.sqlConnection = DriverManager.getConnection(
				"jdbc:mysql://" + host + ":3306/", props);
		
		
	}

	/**
	 * Gets a SQL connection
	 * @return SQL connection to database
	 * @throws ClassNotFoundException exception
	 * @throws SQLException exception
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		return this.sqlConnection;
	}
	
	/**
	 * Tests SQL Connection
	 * @param _dbConnection connection to SQL DB
	 * @throws SQLException Exception
	 */
	public void testConnection(Connection _dbConnection) throws SQLException
	{
		
		//create a statement and query
		Statement stmt = _dbConnection.createStatement();
		String query = "SELECT title, length, release_year FROM nnoble_sakila.film";
		
		//get our results
		ResultSet results = stmt.executeQuery(query);
		
		//print our results
		while (results.next()) //do we have another record? ok! move to it!
		{
			//retrieve the field data for the current record
			String title = results.getString("title");
			double length = results.getDouble("length");
			int year = results.getInt("release_year");
			
			System.out.println(title + " (" + year + ") - " + length + " minutes");
		}
	}
	
	/**
	 * Closes connection to SQL database
	 * @throws SQLException Exception
	 */
	public void Close() throws SQLException
	{
		this.sqlConnection.close();
	}
	
	
}
