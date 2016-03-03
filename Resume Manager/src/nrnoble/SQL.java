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
public class SQL extends JCDB
{
	private String tableName = "";
	private String query = ""; 
	//private JCDB jcdb = null;
	private String user = "";
	private String password = "";
	//private Connection dbConnection;
	private String dbName;
	private ResultSet resultset;
	private ResultSetMetaData metaData;
	private int COLUMNWIDETH = 20;
	private String currentQuery = "";
	
	/**
	 * SQL application driver 
	 * @param _user user id
	 * @param _password user password
	 * @param _host host to SQL server
	 * @throws ClassNotFoundException Exception 
	 * @throws SQLException Exception 
	 */
	public SQL(String _user, String _password, String _host) throws ClassNotFoundException, SQLException
	{
		super(_user,_password,_host);
		
		//this.tableName = _tableName;
		//this.dbName = _dbName;
		//this.jcdb = new JCDB (_user,_password,_host);
		this.user = _user;
		this.password = _password;
		//this.dbConnection = jcdb.getConnection();
	}

	

	/**
	 * Displays query results
	 * @param query to be displayed
	 * @throws SQLException exception
	 * @return resultSet of query;
	 */
	public ResultSet viewResultSet (String query) throws SQLException
	{
		this.currentQuery = query;
	
		Statement stmt = this.sqlConnection.createStatement();
		ResultSet resultSet = stmt.executeQuery(query);	
		return resultSet;
		//displaySQLTable(resultSet,COLUMNWIDETH);
	}
	/**
	 * 
	 * @param insertQuery is a SQL insert string
	 * @return either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
	 * @throws SQLException Exception
	 */
	public int insert(String insertQuery) throws SQLException
	{
		//create a statement and query
	
		this.currentQuery = insertQuery;
		Statement stmt = this.sqlConnection.createStatement();
		return stmt.executeUpdate(insertQuery);	
	}
	
	
	/**
	 * 
	 * @param insertUpdate is a SQL update string
	 * @return either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
	 * @throws SQLException Exception
	 */
	public int update(String insertUpdate) throws SQLException
	{
		//create a statement and query
		this.currentQuery = insertUpdate;
		Statement stmt = this.sqlConnection.createStatement();
		return stmt.executeUpdate(insertUpdate);	
	}
	
	
	
	
	/**
	 * 
	 * @return SQL Connection object
	 */
	public Connection getConnection()
	{
		
		return this.sqlConnection;
	}
	
	/**
	 * Close the database connection
	 * @throws SQLException Exception
	 */

	public String getCurrentQuery()
	{
		return this.currentQuery;
		
	}
	/**
	 * Display SQL Table
	 * @param resultSet SQL table data
	 * @param columnWidth width of each columns in table
	 * @throws SQLException Exception
	 */
		public void displaySQLTable(ResultSet resultSet, int columnWidth) throws SQLException
		{
			// Get column data which will be used to dynamically create 
			// the table headers
			ResultSetMetaData metadata = resultSet.getMetaData();
			
			// display column headings from metadata
			int columCount = metadata.getColumnCount();
			for (int idx=1; idx <= columCount; idx++)
			{
				String ColumnName = Utils.padRight(metadata.getColumnName(idx),columnWidth);
				System.out.print(ColumnName);
			}
			
			System.out.println();
			
			// underscore the column headings to make display
			// look better.
			for (int idx=1; idx <= columCount; idx++)
			{
				String ColumnName = Utils.padRight(Utils.underScore(metadata.getColumnName(idx)),columnWidth);
				System.out.print(ColumnName);
			}
			
			System.out.println();
			
			// display rows of data with each column properly padded so that
			// all the columns line up correctly
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
