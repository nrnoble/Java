package nrnoble;

public class Discarded
{

	public Discarded()
	{
		
	}
	
	public static enum BitMask
	{
		//b00000000 (0b00000000),
		b00000001 (0b00000001), // 1
		b00000010 (0b00000010), // 2
		b00000100 (0b00000100), // 4
		b00001000 (0b00001000), // 8
		b00010000 (0b00010000), // 16
		b00100000 (0b00100000), // 32
		b01000000 (0b01000000), // 64
		b10000000 (0b10000000); // 128
	
//		b10000000 (0b10000000),
//		b01000000 (0b01000000),
//		b00100000 (0b00100000),
//		b00010000 (0b00010000),
//		b00001000 (0b00001000),
//		b00000100 (0b00000100),
//		b00000010 (0b00000010),
//		b00000001 (0b00000001);

		private int value;

	    private BitMask(int value)
	    {
	        this.value = value;
	    }
	}
	

//	public static void displayIntAsBinaryx (int _bin)
//	{
//		String binString = "";
//		for (BitMask mask : BitMask.values())
//		{
//			int result = _bin & mask.value;
//			binString += bitToString(result);
//		}
//		binString = new StringBuilder(binString).reverse().toString();
//		System.out.println(binString);
//	}

}
