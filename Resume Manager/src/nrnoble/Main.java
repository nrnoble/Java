package nrnoble;

import java.sql.SQLException;

public class Main
{

	public Main()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		// Test Driver handles SQL connection
		// Test driver extends from SaleDataLayer object
		TestDriver testDriver = new TestDriver();
		testDriver.testConnection(testDriver.sqlConnection);
		
		testDriver.Close();
	}

}
