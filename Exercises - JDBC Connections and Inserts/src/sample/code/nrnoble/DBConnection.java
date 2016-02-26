package sample.code.nrnoble;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection
{
	public static void main(String[] args)
	{

		// create a statement to perform queries
		try
		{
			// get a DB connection
			Connection dbConnection = getConnection();
			System.out.println("Connected!");
			
			//create a statement and query
			Statement stmt = dbConnection.createStatement();
			String query = "SELECT title, length, release_year FROM jarcher_sakila.film";
			
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
		catch (SQLException ex)
		{
			System.out.println("SQL exception: " + ex.getMessage());
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println("Class not found: " + ex.getMessage());
		}
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Properties props = new Properties();

		// credentials
		props.put("user", "jarcher_user");
		props.put("password", "myPassword!");

		// reference the Connector/J jar file
		Class.forName("com.mysql.jdbc.Driver");

		// get a connection using a "connection string"
		Connection myConnection = DriverManager.getConnection(
				"jdbc:mysql://jarcher.greenrivertech.net:3306/", props);

		return myConnection;
	}
}
