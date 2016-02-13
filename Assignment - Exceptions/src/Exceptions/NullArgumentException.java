package Exceptions;

import nrnoble.Rational;

public class NullArgumentException extends RuntimeException
{
	public static final String NUMERATOR_DENOMINATOR  = "Parameters Numerator and Denominator objects can not be null";
	public static final String NUMERATOR =  "Parameter Numerator object can not be null";
	public static final String DENOMINATOR = "Parameter Denominator object can not be null";
	public static final String ADD = "Can not complete addition operation because parameter is null";
	public static final String SUBTRACT ="Can not complete subtraction operation because parameter is null";
	public static final String MULTIPLY ="Can not complete multiply operation because parameter is null";
	public static final String DIVIDE ="Can not complete division operation. Parameter is null";

	public static final String NULL = "Rational object can not be null";
	
	Rational r1 = null;
	
	
	public NullArgumentException()
	{
		
	}

	public NullArgumentException(String arg0)
	{
		super(arg0);
	
	}

	public NullArgumentException(String arg0, Rational _r1)
	{
		super(arg0);
	    this.r1 = _r1;
	}
	
	
	
	public NullArgumentException(Throwable arg0)
	{
		super(arg0);
		
	}

	public NullArgumentException(String arg0, Throwable arg1)
	{
		super(arg0, arg1);
		
	}

	public NullArgumentException(String arg0, Throwable arg1, boolean arg2, boolean arg3)
	{
		super(arg0, arg1, arg2, arg3);

	}

}
