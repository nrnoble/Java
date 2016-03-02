package nrnoble;


/**
 * 1. Create a custom exception class called BadAddressException.
 *  Your class should be an unchecked exception and should include 
 *  the following methods:
 *   public BadAddressException(String message)
 *   public BadAddressException()
 *   
 * @author  Neal Noble<br>
 * IT301<br>
 * Exercises – Custom Exceptions<br>
 * January 29nd, 2016<br>
 */
@SuppressWarnings("serial")
public class BadAddressException extends Exception
{

	static String defaultMessage = "Default error message";
	/**
	 * see Exception
	 * @param message custom Error message
	 */
	public BadAddressException(String message)
	{
		super(message);	
	}
	/**
	 * see Exception
	 */
	public BadAddressException()
	{
		super(defaultMessage);
	}
	
	/**
	 * see Exception
	 * @param message custom Error message
	 * @param cause custom throw
	 * @param enableSuppression enable\disable suppression
	 * @param writableStackTrace stacktrace
	 */
	public BadAddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);

	}

	/**
	 * see Exception
	 * @param message custom Error message
	 * @param cause Throwable
	 */
	public BadAddressException(String message, Throwable cause)
	{
		super(message, cause);
		
	}
	/**
	 * see Exception
	 * @param cause Throwable cause
	 */
	public BadAddressException(Throwable cause)
	{
		super(cause);	
	}

}

