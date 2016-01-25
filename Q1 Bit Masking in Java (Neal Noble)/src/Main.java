
public class Main
{
	
	private static final int SHIFT = 0b00000001;
	private static final String EMPTY = "";
	private static final int ZERO = 0;
	private static final int ZEROINDEX = 0;
	private static final String SPACE = " ";
	
	
	private static enum Balls
	{
		RED 	(0b00000001), // 1
		WHITE 	(0b00000010), // 2
		BLUE	(0b00000100); // 4
		
		@SuppressWarnings("unused")
		private int value;

	    private Balls(int value)
	    {
	        this.value = value;
	    }
	}
	
	// Constructor
	public Main()
	{
		//Nothing to do here
	}

	@SuppressWarnings("unused") 
	public static void main(String[] args)
	
	{
		int subSets = ZERO;
		
		// Calculate total possible subsets
		for (Balls ball : Balls.values())
		{
			subSets = (subSets << SHIFT ) | 0b00000001 ;
		}
		
		int numOfBits = Balls.values().length;
		for (int subset = ZEROINDEX; subset <= subSets; subset++)
		{
			String itemsInSet = EMPTY;
			String binStr = toBinaryStr (subset,numOfBits);
			itemsInSet = getSetItems(subset, numOfBits);
			System.out.println(binStr + SPACE + itemsInSet);
		}
	}
	
	// Get items in the set based on what bits are set
	private static String getSetItems (int subSetNum,int _numOfbits)
	{
		int mask = 0b00000001;
		String setItems = EMPTY;
		
		// Check each bit, if bit is set, then get set time.		
		for (int setItemIndex = ZEROINDEX; setItemIndex < _numOfbits; setItemIndex++)
		{	
			int maskResult = (subSetNum & mask);
			if (isTrue(maskResult))
			{
				setItems = setItems + Balls.values()[setItemIndex] + SPACE;
			}
			
			// shift mask one bit to the left 
			mask =  mask << 0b00000001;
		}	
		return setItems;
	}
	
	// Convert a Int value to a binary string
	private static String toBinaryStr (int _num, int _numOfbits)
	{
		String binString = EMPTY;	
		int mask = 0b00000001;
		for (int bitCount = ZEROINDEX; bitCount < _numOfbits; bitCount++)
		{	
			int maskResult = (_num & mask);
			binString += bitToString(maskResult);
			mask =  mask << 0b00000001;
		}
		
		binString = new StringBuilder(binString).reverse().toString();
		//System.out.println(binString);
		return binString;
	}

	// Returns true for any value other than 0;
	private static boolean isTrue(int _num)
	{
		if (_num == 0)
		{
			return false;
		}
		
		return true;
	}
	
	// Return "1" for all values except "0". Zero returns "0";
	private static String bitToString(int _bit)
	{
		if (isTrue (_bit))
		{
			return "1";
		}
		
		return "0";	
	}


}
