package nrnoble;

// 5. Create a class called BooleanArray. Your class should store a single integer field. 
//    Your class should allow users to assign 1 (true) or 0 (false) to any bit in the integer 
//    field using the following methods:
//
//	     �	void setTrue(int index)
//	     �	void setFalse(int index)
//       �	boolean isTrue(int index) //returns true if the bit is set to one, otherwise false




public class BooleanArray
{
	
	private int bitArray = 0;
	private static final int SHIFT = 0b00000001;
	private static final String EMPTY = "";
	private static final int ZERO = 0;
	private static final int ZEROINDEX = 0;
	private static final String SPACE = " ";
	private static final int  ARRAYSIZE = 16;

	public BooleanArray()
	{
		// Nothing to initialize
	}

	
	public void setTrue(int _index)
	{
		rangeCheck(_index);
		int mask = getMask (_index);
		this.bitArray = this.bitArray | mask;
	}
	
	public void setFalse(int _index)
	{
		rangeCheck(_index);
		int mask = ~getMask (_index);
		this.bitArray = this.bitArray & mask;
	}
	
	public boolean isTrue(int _index)
	{
		rangeCheck(_index);
		int mask = getMask (_index);
		int bitTestResult = this.bitArray & mask;
		if (bitTestResult == 0b00000000)
			return false;
		
		return true;	
	}
	
	public String bitString()
	{
		return this.toBinaryStr(this.bitArray,Integer.SIZE);
	}
	
	private int getMask (int _index)
	{
		int indexPointer = ZEROINDEX;
		int mask = 0b00000001;
		while (indexPointer < _index)
		{
			mask = mask << SHIFT;
			indexPointer++;
		}
		
		return mask;	
	}
	
	private void rangeCheck(int _index)
	{
		if (_index < 0 || _index > 31)
		{
			throw new IllegalArgumentException ("Index is out of range Range: 0 - 31");
		}
				
	}
	
	
	public String toBinaryStr (int _num, int _numOfbits)
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
		return binString;
	}


	
	// Return "1" for all values except "0". Zero returns "0";
	private String bitToString(int _bit)
	{
		if (_bit == 0)
		{
			return "0";
		}
		
		return "1";	
	}
	
}
