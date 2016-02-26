package dead.zone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionV2
{
	private String username;
	private String password;
	private String host;
	
	public DBConnectionV2(String username, String password, String host)
	{
		this.username = username;
		this.password = password;
		this.host = host;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Properties props = new Properties();

		// credentials
		props.put("user", username);
		props.put("password", password);

		// reference the Connector/J jar file
		Class.forName("com.mysql.jdbc.Driver");

		// get a connection using a "connection string"
		Connection myConnection = DriverManager.getConnection(
				"jdbc:mysql://" + host + ":3306/", props);

		return myConnection;
	}
}
