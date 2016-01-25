package nrnoble;

public class Main
{

	public Main()
	{
		// Nothing to initialize.
	}

	public static void main(String[] args)
	{
		
		BooleanArray bitArray = new BooleanArray();
		System.out.println("Starting Bit Tests");
		System.out.println();
		
		showBits(bitArray);
		
		System.out.println("Turning on bits: 0,5,6,8,24,31");
		bitArray.setTrue(0);
		bitArray.setTrue(5);
		bitArray.setTrue(6);
		bitArray.setTrue(8);
		bitArray.setTrue(24);
		bitArray.setTrue(31);
		
		showBitStatus(bitArray);
		
		System.out.println("Turning off bits: 0,5,6,8,24,31");
		bitArray.setFalse(0);
		bitArray.setFalse(5);
		bitArray.setFalse(6);
		bitArray.setFalse(8);
		bitArray.setFalse(24);
		bitArray.setFalse(31);
		
		showBitStatus(bitArray);
		
		System.out.println(".... Tests are done");

	}
	
	// Test helper
	private static void showBitStatus(BooleanArray _bitArray)
	{
		for (int index = 0; index  <= 31; index++ )
			if (_bitArray.isTrue(index))
			{
				System.out.println("Bit "+ index + " is True");
			}
			else
			{
				System.out.println("Bit "+ index + " is False");
			}
		
		showBits(_bitArray);

	}
	
	// Test helper
	private static void showBits(BooleanArray _bitArray)
	{
		System.out.println("           FEDCBA9876543210FEDCBA9876543210");
		System.out.println("Show Bits: " + _bitArray.bitString());
		System.out.println();
	}
	

}
