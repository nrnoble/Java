package nrnoble;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Object that encapulates the SQL functions for this assignment
 * @author Neal Noble
 *
 */
public class SQL
{
	private String tableName = "";
	private String query = ""; 
	private JCDB jcdb = null;
	private String user = "";
	private String password = "";
	private Connection dbConnection;
	private String dbName;
	private ResultSet resultset;
	private ResultSetMetaData metaData;
	private COLUMNWIDETH = 20;
	
	
	/**
	 * SQL application driver 
	 * @param _user user id
	 * @param _password user password
	 * @param _host host to SQL server
	 * @throws ClassNotFoundException
	 * @throws SQLException Exception
	 */
	public SQL(String _user, String _password, String _host) throws ClassNotFoundException, SQLException
	{
		super();
		//this.tableName = _tableName;
		//this.dbName = _dbName;
		this.jcdb = new JCDB (_user,_password,_host);
		this.user = _user;
		this.password = _password;
		this.dbConnection = jcdb.getConnection();
	}

	
	public SQL()
	{
		// nothing to do here
	}
	
	/**
	 * Displays query results
	 * @param query to be displayed
	 * @throws SQLException exception
	 */
	public void viewResultSet (String query) throws SQLException
	{
		Statement stmt = this.dbConnection.createStatement();
		ResultSet resultSet = stmt.executeQuery(query);	
		displaySQLTable(resultSet,20);
	}
	/**
	 * 
	 * @param insertQuery is a SQL insert string
	 * @return either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
	 * @throws SQLException
	 */
	public int Insert(String insertQuery) throws SQLException
	{
		//create a statement and query
		Statement stmt = this.dbConnection.createStatement();
		return stmt.executeUpdate(insertQuery);	
	}
	
	/**
	 * 
	 * @return SQL Connection object
	 */
	public Connection getConnection()
	{
		return this.dbConnection;
	}
	
	
	/**
	 * Display SQL Table
	 * @param resultSet SQL table data
	 * @throws SQLException Exception
	 */
		private void displaySQLTable(ResultSet resultSet, int columnWidth) throws SQLException
		{
			// Get column data
					ResultSetMetaData metadata = resultSet.getMetaData();
					
					// display column headings
					int columCount = metadata.getColumnCount();
					for (int idx=1; idx <= columCount; idx++)
					{
						String ColumnName = Utils.padRight(metadata.getColumnName(idx),columnWidth);
						System.out.print(ColumnName);
					}
					
					System.out.println();
					
					// underscore the column headings
					for (int idx=1; idx <= columCount; idx++)
					{
						String ColumnName = nrnoble.Utils.padRight(Utils.underScore(metadata.getColumnName(idx)),columnWidth);
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
							String columData = Utils.padRight(row,columnWidth);
							System.out.print(columData);
						}
						System.out.println("");
						
					}
		}



	
	

}
