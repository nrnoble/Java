package Exceptions;

import nrnoble.Rational;

@SuppressWarnings("serial")
public class DivideByZeroException extends RuntimeException
{
	Rational rational = null;
	
	public static final String DIVBYZERO ="Division by zero. Demominator is zero or undefined";
	
	public DivideByZeroException()
	{
		
	}

	
	public DivideByZeroException(String _message)
	{
		super(_message);
	}

	
	public DivideByZeroException(String _message,Rational _rational)
	{
		super(_message);
		this.rational = _rational;
	}
	
	public Rational getRational()
	{
		return this.rational;
	}
	
	
	
	/**
	 *  Not Implemented
	 * @param cause Not Implemented
	 */
	public DivideByZeroException(Throwable cause)
	{
		super(cause);
		
	}

	
	
	
	/**
	 * Not Implemented
	 * @param message Not Implemented
	 * @param cause Not Implemented
	 */
	public DivideByZeroException(String message, Throwable cause)
	{
		super(message, cause);
		
	}

	/**
	 * Not Implemented
	 * @param message Not Implemented
	 * @param cause Not Implemented
	 * @param enableSuppression  Not Implemented
	 * @param writableStackTrace Not Implemented
	 */
	public DivideByZeroException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

}
