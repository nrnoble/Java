package nrnoble;


/**
 * 
 * @author Neal Noble<br>
 * IT301<br>
 * Exercises - Throwing Exceptions (Perspective B, Question 4)<br>
 * January 28nd, 2016<br>
 */
public class BankAccount 
{
	/**
	 * 
	 * @param _accountID  range 1000 - 9999
	 * @param _firstName valid string
	 * @param _lastName valid string
	 * @param _accountBalance not a negative number
	 */
	public BankAccount(int _accountID, String _firstName, String _lastName,  int _accountBalance)
	{
		super();
		
		
		// This logic works to meet the object of the exercise, but I think it
		// could be done much better. Ideally like a SQL transaction where all
		// the parameter are checked and report back all the values that cause
		// the transaction to fail, not just the first parameter that causes 
		// the transaction to fail. 
		
		if (_accountID < 1000 || _accountID > 9999)
		{
			throw  new RuntimeException ("Account number out of range");
		}
		
		if ((_firstName.isEmpty()) || (_firstName == null))
		{
			throw  new NullPointerException ("First name can not be empty");
		}
		
		if ((_lastName.isEmpty()) || (_lastName == null))
		{
			throw  new NullPointerException ("Last name can not be empty");
		}
		
		if (_accountBalance < 0)
		{
			throw  new IllegalStateException ("Account balance can not be negitive");
		}
		
		
			
		this.firstName = _firstName;
		this.lastName = _lastName;
		this.accountID = _accountID;
		this.accountBalance = _accountBalance;
	}

	private String firstName;
	private String lastName;
	private int accountID;
	private int accountBalance;
	
	// Variables for an unimplemented idea of trapping multiple exceptions
	/* private Exception firstNameException;
	   private Exception lastNameException;
	   private Exception accountIDException;
	   private Exception accountBalanceException;
	  */
	
	
	protected BankAccount()
	{
		
	}



}
