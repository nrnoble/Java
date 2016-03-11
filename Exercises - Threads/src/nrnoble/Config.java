package nrnoble;

/**
 * Constants used in applcation
 * @author Neal Noble
 *
 */
public class Config
{
	// Name of application
	public static final String APPLCATION_TITLE = "Prime Numbers 2016";
	
	// Start number of where to start looking for prime numbers
	public static final int RANGE_START = 1;
	
	// End number of where to stop looking for prime numbers
	public static final int RANGE_END = 10000;
	
	// Number of width of co for to displaying numbers
	public static final int COLUMN_WIDTH = 4;
	
	// Number of columns for displaying numbers
	public static final int NUM_OF_COLUMNS = 10;
	
	// Justification from the left
	public static final int LEFT_JUSTIFICATION = 5;
	
	// Number of threads used to to find primes.
	public static final int NUMBEROFTHREADS = 5;
	
	// the number of digits in the lagest number in rangs. ie last number
	public static final int NUMBEROFDIGITS = (int) Math.log10(RANGE_END) + 1;
	
	// format string to be use when displaying numbers in console.
	public static final String DIGITS = "%0" + NUMBEROFDIGITS +"d";
	
	public Config()
	{
		// Nothing to do here.
	}

}
