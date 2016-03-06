package nrnoble;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.CommunicationsException;

public class TestData extends SQL
{

	public TestData(String _user, String _password, String _host) throws ClassNotFoundException, SQLException
	{
		super(_user, _password, _host);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @return a resultset of users, first_name, last_name, email
	 * @throws CommunicationsException Exception
	 * @throws ClassNotFoundException Exception
	 * @throws SQLException Exception
	 */
	public ResultSet getUsers() throws CommunicationsException, ClassNotFoundException, SQLException
	{
		String query = "SELECT 'first_name', 'last_name', 'email' FROM 'nnoble_sakila'.'customers'";
		return this.excuteQuery(query);
	}

}
