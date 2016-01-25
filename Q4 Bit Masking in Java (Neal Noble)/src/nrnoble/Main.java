package nrnoble;

public class Main
{
	private static final int SHIFT = 0b00000001;
	private static final String EMPTY = "";
	private static final int ZERO = 0;
	private static final int ZEROINDEX = 0;
	private static final String SPACE = " ";

	public Main()
	{
		// Nothing to do here.
	}

	public static void main(String[] args)
	{
		for (int counter = 0b00000000; counter <= 0b00001000; counter++)
		{
			displayAsBinary(counter,0b00001000);
		}
	}
	
	public static void displayAsBinary (int _num, int _numOfbits)
	{
		String binString = EMPTY;	
		int mask = SHIFT;
		
		for (int bitIndex = ZEROINDEX; bitIndex < _numOfbits; bitIndex++)
		{	
			int maskResult = (_num & mask);
			binString += bitToString(maskResult);
			mask =  (mask << SHIFT);
		}
		binString = new StringBuilder(binString).reverse().toString();
		System.out.println(binString + SPACE + "{" + _num + "}");
	}

	public static String bitToString(int bit)
	{
		if (bit == 0)
		{
			return "0";
		}
		return "1";	
	}
}
