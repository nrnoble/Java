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

	
	public ResumeManager(String _userName, String _password, String _sqlServerName) throws ClassNotFoundException, SQLException
	{
		super(_userName, _password, _sqlServerName); 
		
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
		// INSERT INTO `nnoble_301`.`resume` (`title`, `name`, `profile`, `email`) 
		// VALUES ('Java Developer', 'Cal Orson', 'Java Developer LEVEL 2', 'corson@email.com');
		
		String query = "INSERT INTO `nnoble_301`.`resume` (`title`, `name`, `profile`, `email`)  VALUES ('" + _title + "', '" + _name + "', '" + _profile + "', '" + _email + "');";
		
		//System.out.println(query);
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
		String query = "SELECT `pkey` FROM `nnoble_301`.`resume` ORDER BY pkey DESC LIMIT 1;";
		ResultSet resultset = this.excuteQuery(query);
		resultset.next();
		int lastPkey = Integer.parseInt(resultset.getString(1));
		//System.out.println("lastPkey: " + lastPkey);
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
		// INSERT INTO `nnoble_301`.`resume_experience` (`job`, `resume_title`, `year_started`, `year_ended`, `position`) 
		// VALUES ('XYZ', 'Java Developer', '2011-03-03', '2016-07-08', 'Java Level II');
		//Integer.parseInt("1234");
		String query = "INSERT INTO `nnoble_301`.`resume_experience` (`fkey`,`job`, `resume_title`, `year_started`, `year_ended`, `position`) VALUES ('" + _fkey + "', '" + _job  + "', '" + _resume_title + "', '" + _year_started + "', '" + _year_ended + "', '" + _position + "');";
		//System.out.println(query);
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

		//INSERT INTO `nnoble_301`.`resume_skill` (`skill`, `resume_title`, `description`) VALUES ('SQL', 'resume Title', 'skill Description');
		String query = "INSERT INTO `nnoble_301`.`resume_skill` (`fkey`,`skill`, `resume_title`, `description`) VALUES ('" + _fkey + "', '" + _skill + "', '" + _resume_title + "', '" + _description + "')";
		System.out.println(query);
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
	
		String query  = "SELECT `pkey`,`title`,`name`,`email` FROM `nnoble_301`.`resume`";
		ResultSet resultset = this.excuteQuery(query);
		this.displaySQLTable(resultset, 10,25);
		
	}
	
	/**
	 * Displays in the console the details of one resume 
	 * @param pkey primay key of the resume
	 * @throws SQLException Exception
	 * @throws ClassNotFoundException Exception
	 */
	public void showResumeDetails(int pkey) throws SQLException, ClassNotFoundException
	{
		
		 String query  = "SELECT `title`, `name`, `email`, `profile` FROM `nnoble_301`.`resume` WHERE `pkey` = '" + pkey +"'";
		 query  = "SELECT `title`, `name`, `email`, `profile` FROM `nnoble_301`.`resume` WHERE `pkey` = '" + pkey +"'";
		 //System.out.println(query);
		 ResultSet resultSet = this.excuteQuery(query);
		 this.displaySQLTable(resultSet, 7, 35);
		 System.out.println();
		 
		  // Execute a query that gets the skills for a specific resume and display it in the console
		  query  = "SELECT `skill`, `description` FROM `nnoble_301`.`resume_skill` WHERE `fkey` = '" + pkey +"'";
		 //System.out.println(query);
		  resultSet = this.excuteQuery(query);
		 this.displaySQLTable(resultSet, 7, 20);
		 System.out.println();
		
		// Execute a query that gets the jop experience for a specific resume and display it in the console
		  query  = "SELECT  `position`, `year_started`, `year_ended` FROM `nnoble_301`.`resume_experience` WHERE `fkey` = '" + pkey +"'";
		 //System.out.println(query);
		  resultSet = this.excuteQuery(query);
		 this.displaySQLTable(resultSet, 7, 20);
		 System.out.println();
		 System.out.println();
		 

		 

		
	}
	
	
}
