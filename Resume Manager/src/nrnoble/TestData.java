package nrnoble;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.CommunicationsException;


public class TestData extends SQL
{

	/**
	 * Connection to server with test data Database 
	 * @param connection Existing connection to Database server
	 */
	public TestData (java.sql.Connection connection)
	{
		super(connection);
	}
	
	/**
	 * Connection to server with test data Database 
	 * @param _user User ID
	 * @param _password User Password
	 * @param _host Host server of Dabase
	 * @throws ClassNotFoundException Exception
	 * @throws SQLException Exception
	 */
	public TestData(String _user, String _password, String _host) throws ClassNotFoundException, SQLException
	{
		super(_user, _password, _host);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Get a list of users to be used as test data
	 * @return a resultset of users, first_name, last_name, email
	 * @throws CommunicationsException Exception
	 * @throws ClassNotFoundException Exception
	 * @throws SQLException Exception
	 */
	public ResultSet getUsers() throws CommunicationsException, ClassNotFoundException, SQLException
	{
		String query = "SELECT `first_name`, `last_name`, `email` FROM `" + ConnectionSettings.TESTDATADB + "`.`customer`";
		return this.excuteQuery(query);
	}
	
	
	

}
