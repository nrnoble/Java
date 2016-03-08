package nrnoble;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.CommunicationsException;


/**
 * Object that encapulates the SQL functions for this assignment
 * @author Neal Noble
 */
public class SQL extends JCDB
{
	@SuppressWarnings("unused")
	private String tableName = "";
	@SuppressWarnings("unused")
	private String query = ""; 
	//private JCDB jcdb = null;
	@SuppressWarnings("unused")
	private String user = "";
	@SuppressWarnings("unused")
	private String password = "";
	//private Connection dbConnection;
	@SuppressWarnings("unused")
	private String dbName;
	@SuppressWarnings("unused")
	private ResultSet resultset;
	@SuppressWarnings("unused")
	private ResultSetMetaData metaData;
	@SuppressWarnings("unused")
	private int COLUMNWIDETH = 20;
	private String currentQuery = "";
	@SuppressWarnings("unused")
	private String host = "";
	
	
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
		this.user = _user;
		this.password = _password;
		this.host = _host;
	
	}

	
	/**
	 * Use an existing connection
	 * @param connection connection to a DB
	 */
	public SQL (Connection connection)
	{
		super (connection);
	}
	

	/**
	 * Displays query results
	 * @param _query to be displayed
	 * @throws SQLException exception
	 * @return resultSet of query;
	 * @throws CommunicationsException Exception
	 * @throws ClassNotFoundException Exception
	 */
	public ResultSet excuteQuery (String _query) throws SQLException, CommunicationsException, ClassNotFoundException
	{

		
		// handle connection timeout
		try
		{	
			this.currentQuery = _query;
			Statement stmt = this.sqlConnection.createStatement();
			return stmt.executeQuery(_query);	
		} 
		catch (Exception e)
		{
			disconnectionHandler(e);
		}
		
		
		this.currentQuery = _query;
		Statement stmt = this.sqlConnection.createStatement();
		return stmt.executeQuery(_query);		
		
	}
	

	/**
	 * 
	 * @param _insertQuery is a SQL insert string
	 * @return either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
	 * @throws SQLException Exception Exception
	 * @throws ClassNotFoundException Exception
	 * @throws CommunicationsException Exception
	 */
	public int insert(String _insertQuery) throws SQLException, CommunicationsException, ClassNotFoundException
	{
		// handle connection timeout
		try
		{
			this.currentQuery = _insertQuery;
			Statement stmt = this.sqlConnection.createStatement();
			return stmt.executeUpdate(_insertQuery);
			
		} catch (Exception e)
		{
			disconnectionHandler(e);
		}	

		// try again if disconnected
		this.currentQuery = _insertQuery;
		Statement stmt = this.sqlConnection.createStatement();
		return stmt.executeUpdate(_insertQuery);

	}
	
	
	/**
	 * 
	 * @param _insertUpdate is a SQL update string
	 * @return either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
	 * @throws SQLException Exception Exception
	 * @throws ClassNotFoundException Exception
	 * @throws CommunicationsException Exception
	 */
	public int update(String _insertUpdate) throws SQLException, CommunicationsException, ClassNotFoundException
	{
		// handle connection timeout
		try
		{
			//create a statement and query
			this.currentQuery = _insertUpdate;
			Statement stmt = this.sqlConnection.createStatement();
			return stmt.executeUpdate(_insertUpdate);
			
		} catch (Exception e)
		{
			disconnectionHandler(e);
		}	

		// try again if disconnected
		this.currentQuery = _insertUpdate;
		Statement stmt = this.sqlConnection.createStatement();
		return stmt.executeUpdate(_insertUpdate);	
	}
	
	
	/**
	 * Get the current connection to the Database
	 * @return SQL Connection object
	 */
	public Connection getConnection()
	{
		return this.sqlConnection;
	}
	
	
	/**
	 * Close current database connection
	 * @return the last executed query
	 */
	public String getCurrentQuery()
	{
		return this.currentQuery;	
	}
	

	/**
	 * Dynamically calculates the width of each column by finding longest string from all the rows returned
	 * @param _resultSet data set from query
	 * @param _minColumnWidth Min colomn width
	 * @param _maxColumnWidth Max colomn width
	 * @return List array of width for each column in dataset.
	 * @throws SQLException Exception
	 */
	private  List<Integer> getColumns_Width(ResultSet _resultSet, int _minColumnWidth, int _maxColumnWidth) throws SQLException
	{
		
		// Get column data which will be used to dynamically create 
		// the table headers
		ResultSetMetaData metadata = _resultSet.getMetaData();
		
		// display column headings from metadata
		int columCount = metadata.getColumnCount();

		
		// calculate column width by finding the widest item in each row
		List<Integer> columns_width = new ArrayList<Integer>();
		
		//Loop through all the columns in the resultset
		for (int idx=1; idx <= columCount; idx++)
		{		
			_resultSet.beforeFirst();
			
			// initialize the width to the column heading with some padding added 
			int widest = metadata.getColumnName(idx).length()+ 5;
		
			if (_minColumnWidth > widest)
			{
				widest = _minColumnWidth;
			}
			
			// interate through all the rows setting the width to column to
			// the row with the most data.
			while(_resultSet.next() != false)
			{
				String row = _resultSet.getString(idx);
				if (row.length() + 5 > widest)
				{
					widest = row.length()+ 5;
				}						
			}
			
			// Reset the column width if the width is larger
			// than max width.
			if (widest > _maxColumnWidth)
			{
				widest = _maxColumnWidth;
			}
			
			columns_width.add(widest);
		}
		
		return columns_width;
	}
	
	
	/**
	 * Display SQL Table
	 * @param _resultSet SQL table data
	 * @param _minColumnWidth min width of each columns in table
	 * @param _maxColumnWidth max width of each columns in table
	 * @throws SQLException Exception
	 */
	 public void displaySQLTable(ResultSet _resultSet, int _minColumnWidth, int _maxColumnWidth) throws SQLException
	 {
		// Get table data which will be used to dynamically create 
		// the table headers
		ResultSetMetaData metadata = _resultSet.getMetaData();
		
		// get the number of columns in the table
		int columCount = metadata.getColumnCount();


		// calculate column widith by finding the widest item in each row
		List<Integer> colwidth = getColumns_Width(_resultSet, _minColumnWidth,_maxColumnWidth);
		
					
		_resultSet.first();
		for (int idx=1; idx <= columCount; idx++)
		{
			_minColumnWidth =  colwidth.get(idx-1);
			String ColumnName = Utils.padRight(metadata.getColumnName(idx),_minColumnWidth);
			System.out.print(ColumnName.toUpperCase());
		}
		
		System.out.println();
		
		// underscore the column headings to make display
		// look better.
		for (int idx=1; idx <= columCount; idx++)
		{

			_minColumnWidth =  colwidth.get(idx-1);
			//String ColumnName = Utils.padRight(Utils.underScore(metadata.getColumnName(idx)),_minColumnWidth);
			String underscoreColumnHeading = Utils.padRight(Utils.underScoreColumnHeading(Utils.underScoreColumnHeading(_minColumnWidth-2)),_minColumnWidth);
			
			System.out.print(underscoreColumnHeading);
		}
		
		System.out.println();
		
		// display rows of data with each column properly padded so that
		// all the columns line up correctly
		_resultSet.beforeFirst();
		while(_resultSet.next() != false)
		{
			// display a single row of data
			for (int idx=1; idx <= columCount; idx++)
			{
				_minColumnWidth =  colwidth.get(idx-1);
				String row =_resultSet.getString(idx);
				String columData = Utils.padRight(row,_minColumnWidth);
				System.out.print(columData);
			}
			System.out.println("");
			
		}
		
		
		
	 }

		
	 private void disconnectionHandler(Exception e) throws ClassNotFoundException, SQLException
	 {
		System.out.println("Connection has timed out...");
		System.out.println("reconnecting");
		this.establishConnection();
		System.out.println("re-established connection to database");
	 }
	
	 
	 @SuppressWarnings("unused")
	 private static String escapeString(String x, boolean escapeDoubleQuotes) 
	 {
	        StringBuilder sBuilder = new StringBuilder(x.length() * 11/10);

	        int stringLength = x.length();

	        for (int i = 0; i < stringLength; ++i) {
	            char c = x.charAt(i);

	            switch (c) {
	            case 0: /* Must be escaped for 'mysql' */
	                sBuilder.append('\\');
	                sBuilder.append('0');

	                break;

	            case '\n': /* Must be escaped for logs */
	                sBuilder.append('\\');
	                sBuilder.append('n');

	                break;

	            case '\r':
	                sBuilder.append('\\');
	                sBuilder.append('r');

	                break;

	            case '\\':
	                sBuilder.append('\\');
	                sBuilder.append('\\');

	                break;

	            case '\'':
	                sBuilder.append('\\');
	                sBuilder.append('\'');

	                break;

	            case '"': /* Better safe than sorry */
	                if (escapeDoubleQuotes) {
	                    sBuilder.append('\\');
	                }

	                sBuilder.append('"');

	                break;

	            case '\032': /* This gives problems on Win32 */
	                sBuilder.append('\\');
	                sBuilder.append('Z');

	                break;

	            case '\u00a5':
	            case '\u20a9':
	                // escape characters interpreted as backslash by mysql
	                // fall through

	            default:
	                sBuilder.append(c);
	            }
	        }

	        return sBuilder.toString();
	  }
		
		
}
