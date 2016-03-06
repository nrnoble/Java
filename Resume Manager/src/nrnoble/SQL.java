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
 *
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
		//this.dbConnection = jcdb.getConnection();
	}

	/**
	 * Displays query results
	 * @param query to be displayed
	 * @throws SQLException exception
	 * @return resultSet of query;
	 * @throws CommunicationsException Exception
	 * @throws ClassNotFoundException Exception
	 */
	public ResultSet excuteQuery (String query) throws SQLException, CommunicationsException, ClassNotFoundException
	{

		
		// handle connection timeout
		try
		{	
			this.currentQuery = query;
			Statement stmt = this.sqlConnection.createStatement();
			return stmt.executeQuery(query);	
		} 
		catch (Exception e)
		{
			disconnectionHandler(e);
		}
		
		
		this.currentQuery = query;
		Statement stmt = this.sqlConnection.createStatement();
		return stmt.executeQuery(query);		
		
	}
	

	
	
	/**
	 * 
	 * @param insertQuery is a SQL insert string
	 * @return either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
	 * @throws SQLException Exception Exception
	 * @throws ClassNotFoundException Exception
	 * @throws CommunicationsException Exception
	 */
	public int insert(String insertQuery) throws SQLException, CommunicationsException, ClassNotFoundException
	{
		//create a statement and query
	

		
		// handle connection timeout
		try
		{
			this.currentQuery = insertQuery;
			Statement stmt = this.sqlConnection.createStatement();
			return stmt.executeUpdate(insertQuery);
			
		} catch (Exception e)
		{
			disconnectionHandler(e);
		}	

		// try again if disconnected
		this.currentQuery = insertQuery;
		Statement stmt = this.sqlConnection.createStatement();
		return stmt.executeUpdate(insertQuery);

	}
	
	
	/**
	 * 
	 * @param insertUpdate is a SQL update string
	 * @return either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
	 * @throws SQLException Exception Exception
	 * @throws ClassNotFoundException Exception
	 * @throws CommunicationsException Exception
	 */
	public int update(String insertUpdate) throws SQLException, CommunicationsException, ClassNotFoundException
	{

		
		// handle connection timeout
		try
		{
			//create a statement and query
			this.currentQuery = insertUpdate;
			Statement stmt = this.sqlConnection.createStatement();
			return stmt.executeUpdate(insertUpdate);
			
		} catch (Exception e)
		{
			disconnectionHandler(e);
		}	

		// try again if disconnected
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
	 * @return the last executed query
	 */
	public String getCurrentQuery()
	{
		return this.currentQuery;	
	}
	

	/**
	 * 
	 * @param resultSet data set from query
	 * @param _minColumnWidth Min colomn width
	 * @param _maxColumnWidth Max colomn width
	 * @return List array of width for each column in dataset.
	 * @throws SQLException Exception
	 */
	private  List<Integer> getColumnWidth(ResultSet resultSet, int _minColumnWidth, int _maxColumnWidth) throws SQLException
	{
		
		// Get column data which will be used to dynamically create 
		// the table headers
		ResultSetMetaData metadata = resultSet.getMetaData();
		
		// display column headings from metadata
		int columCount = metadata.getColumnCount();

		
		// calculate column wideth by finding the widest item in each row
		List<Integer> colwidth = new ArrayList<Integer>();
		
		for (int idx=1; idx <= columCount; idx++)
		{
			resultSet.beforeFirst();
			int widest = metadata.getColumnName(idx).length()+ 5;
			if (_minColumnWidth > widest)
			{
				widest = _minColumnWidth;
			}
			while(resultSet.next() != false)
			{
				String row = resultSet.getString(idx);
				if (row.length() + 5 > widest)
				{
					widest = row.length()+ 5;
				}						
			}
			
			if (widest > _maxColumnWidth)
			{
				widest = _maxColumnWidth;
			}
			
			colwidth.add(widest);
		}
		
		return colwidth;
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
			List<Integer> colwidth = getColumnWidth(_resultSet, _minColumnWidth,_maxColumnWidth);
			
						
			_resultSet.first();
			for (int idx=1; idx <= columCount; idx++)
			{
				_minColumnWidth =  colwidth.get(idx-1);
				String ColumnName = Utils.padRight(metadata.getColumnName(idx),_minColumnWidth);
				System.out.print(ColumnName);
			}
			
			System.out.println();
			
			// underscore the column headings to make display
			// look better.
			for (int idx=1; idx <= columCount; idx++)
			{

				_minColumnWidth =  colwidth.get(idx-1);
				//String ColumnName = Utils.padRight(Utils.underScore(metadata.getColumnName(idx)),_minColumnWidth);
				String ColumnName = Utils.padRight(Utils.underScore(Utils.underScoreColumnHeading(_minColumnWidth-2)),_minColumnWidth);
				
				System.out.print(ColumnName);
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
		
	 public static String escapeString(String x, boolean escapeDoubleQuotes) 
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
