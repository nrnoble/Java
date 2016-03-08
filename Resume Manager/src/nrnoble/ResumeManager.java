package nrnoble;

import java.sql.ResultSet;

import java.sql.SQLException;

import com.mysql.jdbc.CommunicationsException;

/**
 * Handles SQL all queries for the Resume Manager application
 * @author Neal Noble
 *
 */
public class ResumeManager extends SQL
{

	@SuppressWarnings("unused")
	private ResultSet testData_Users = null;
	
	public ResumeManager(String _userName, String _password, String _sqlServerName) throws ClassNotFoundException, SQLException
	{
		super(_userName, _password, _sqlServerName);
		
		TestData testData = new TestData (this.getConnection());
		this.testData_Users =  testData.getUsers();
	}
	
	
	/**
	 * Adds Resume to database
	 * @param _title of resume
	 * @param _name Name of applicant
	 * @param _profile Applicant profile information
	 * @param _email Applicant email
	 * @throws SQLException Exception
	 * @throws ClassNotFoundException Exception
	 */
	public void addResume(String _title, String _name, String _profile, String _email) throws SQLException, ClassNotFoundException
	{
		String query = "INSERT INTO `" + ConnectionSettings.RESUMEDB + "`.`" + ConnectionSettings.RESUME_TABLE +"` (`title`, `name`, `profile`, `email`)  VALUES ('" + _title + "', '" + _name + "', '" + _profile + "', '" + _email + "');";
		this.insert(query);
	}

	
	/**
	 * Gets primary key value for the last record in the Resume table 
	 * @return primary key value
	 * @throws SQLException Exception
	 * @throws ClassNotFoundException Exception
	 */
	public int getLastPkey() throws SQLException, ClassNotFoundException
	{
		String query = "SELECT `pkey` FROM `" + ConnectionSettings.RESUMEDB + "`.`" + ConnectionSettings.RESUME_TABLE +"` ORDER BY pkey DESC LIMIT 1;";
		ResultSet resultset = this.excuteQuery(query);
		resultset.next();
		int lastPkey = Integer.parseInt(resultset.getString(1));
		return  lastPkey;
	}
	
	
	/**
	 * Add resume Job to databse
	 * @param _job Applicant Job
	 * @param _resume_title Applicant resume title
	 * @param _year_started job start state date
	 * @param _year_ended Job end date
	 * @param _position Title of position
	 * @param _fkey primary key
	 * @throws SQLException Exception
	 * @throws ClassNotFoundException Exception
	 */
	public void addResume_experience(int _fkey, String _job, String _resume_title, String _year_started, String _year_ended, String _position) throws SQLException, ClassNotFoundException
	{
		String query = "INSERT INTO `" + ConnectionSettings.RESUMEDB + "`.`" + ConnectionSettings.RESUME_EXPERIENCE_TABLE +"` (`fkey`,`job`, `resume_title`, `year_started`, `year_ended`, `position`) VALUES ('" + _fkey + "', '" + _job  + "', '" + _resume_title + "', '" + _year_started + "', '" + _year_ended + "', '" + _position + "');";
		this.insert(query);
	}
	
	
	/**
	 *  Add resume skill to database
	 * @param _fkey primary key
	 * @param _skill Name of skill
	 * @param _resume_title Resume title
	 * @param _description skill discription
	 * @throws SQLException Exception
	 * @throws ClassNotFoundException Exception
	 */
	public void addResume_skill(int _fkey, String _skill, String _resume_title, String _description) throws SQLException, ClassNotFoundException
	{
		String query = "INSERT INTO `" + ConnectionSettings.RESUMEDB + "`.`" + ConnectionSettings.RESUME_SKILL_TABLE +"` (`fkey`,`skill`, `resume_title`, `description`) VALUES ('" + _fkey + "', '" + _skill + "', '" + _resume_title + "', '" + _description + "')";
		this.insert(query);
	}
	
	
	/**
	 * Displays in the console all resumes in the Resume Table
	 * @throws SQLException Exception 
	 * @throws ClassNotFoundException Exception
	 * @throws CommunicationsException Exception
	 */
	public void showResumeList() throws SQLException, CommunicationsException, ClassNotFoundException
	{
		String query  = "SELECT `pkey`,`title`,`name`,`email` FROM `" + ConnectionSettings.RESUMEDB + "`.`" + ConnectionSettings.RESUME_TABLE +"`";
		ResultSet resultset = this.excuteQuery(query);
		this.displaySQLTable(resultset, 10,25);	
	}
	
	
	/**
	 * Displays in the console the details of one resume 
	 * @param _pkey primay key of the resume
	 * @throws SQLException Exception
	 * @throws ClassNotFoundException Exception
	 */
	public void showResumeDetails(int _pkey) throws SQLException, ClassNotFoundException
	{
		 String query  = "SELECT `title`, `name`, `email`, `profile` FROM `" + ConnectionSettings.RESUMEDB + "`.`" + ConnectionSettings.RESUME_TABLE+"` WHERE `pkey` = '" + _pkey +"'";
		 ResultSet resultSet = this.excuteQuery(query);
		 this.displaySQLTable(resultSet, 7, 50);
		 System.out.println();
		 
		 // Execute a query that gets the skills for a specific resume and display it in the console
		 query  = "SELECT `skill`, `description` FROM `" + ConnectionSettings.RESUMEDB + "`.`" + ConnectionSettings.RESUME_SKILL_TABLE +"` WHERE `fkey` = '" + _pkey +"'";
		 resultSet = this.excuteQuery(query);
		 this.displaySQLTable(resultSet, 7, 50);
		 System.out.println();
		
		 // Execute a query that gets the jop experience for a specific resume and display it in the console
		 query  = "SELECT  `job`, `position`, `year_started`, `year_ended` FROM `" + ConnectionSettings.RESUMEDB + "`.`" + ConnectionSettings.RESUME_EXPERIENCE_TABLE +"` WHERE `fkey` = '" + _pkey +"'";
		 resultSet = this.excuteQuery(query);
		 this.displaySQLTable(resultSet, 7, 50);
		 System.out.println();
		 System.out.println();
		
	}

}
