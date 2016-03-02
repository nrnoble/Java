package nrnoble;

public class Main
{
	public static String DIVIDER = "  --------";;

	public static enum Operand
	{
		AND, OR, XOR;
	}
	public Main()
	{
	
	}


	public static void main(String[] args)
	{
		Question1();
		System.out.println ();
		System.out.println ();
		
		Question2();
		System.out.println ();
		System.out.println ();
		
		Question3();
 		System.out.println ();
		System.out.println ();
		
		Question4();	
		System.out.println ();
		System.out.println ();

		Question5();
		System.out.println ();
		System.out.println ();
				
	}
	
	public static void Question1()
	{
		System.out.println("1. Give the result of each of the following logical operations.");	
		System.out.println ("Q1a");
		bitWiseOperation(0b10101111, 0b11011101, Operand.AND);	
		System.out.println ();
		System.out.println ("Q1b");
		bitWiseOperation(0b10111001, 0b01011110, Operand.OR);
		System.out.println ();
		System.out.println ("Q1c");
		bitWiseOperation(0b11101010, 0b01011110, Operand.XOR);
		
	}
	
	public static void Question2()
	{
		System.out.println("2. What bit mask and logical operator would you use to 'select' the right 4 bits in an 8-bit binary number? ");	
		System.out.println("   Answer: bit mask = '00001111', logical operator = 'AND' '&'");
	
	}
	
	
	public static void Question3()
	{
		System.out.println("3. Use your bit mask and logical operator on the following binary numbers. Show the resulting binary number. ");	
		System.out.println("Q3a");	
		bitWiseOperation(0b11001011, 0b00001111, Operand.AND);
		
		System.out.println("Q3b");	
		bitWiseOperation(0b11110001, 0b00001111, Operand.AND);

		System.out.println("Q3c");	
		bitWiseOperation(0b10111011, 0b00001111, Operand.AND);
		
	}

	
	
	// Combine bitwise operations into a single function
	public static void bitWiseOperation (int _bin1, int _bin2, Operand _operand)
	{
		

		int result = 0;
		String operand = "";
		
		switch (_operand)
		{
			case AND:
				result = _bin1 & _bin2;
				operand = "&";
				break;
			case OR:
				result = _bin1 | _bin2;
				operand = "|";
				break;
			case XOR:
				result  = _bin1 ^ _bin2;
				operand = "^";
				break;
		}
		
		System.out.println ("  " + stringBin(_bin1) + " {"+ _bin1 +"}");
		System.out.println (operand + " " + stringBin(_bin2) + " {"+ _bin2 +"}");
		System.out.println (DIVIDER);
		System.out.println ("  " + stringBin(result) + " {"+ result +"}");

		
		
	}
	
	public static void Question4()
	{
		System.out.println("4. What bit mask and logical operator would you use to 'assign' the value one to the two left-most bits in a binary number.");	
		System.out.println("   Answer: bit mask = '11000000', logical operator = 'OR', '|' ");
		//bitWiseOperation(0b10111001, 0b00001111, Operand.AND);
	}
	
	public static void Question5()
	{
		System.out.println("5. Use your bit mask and logical operator on the following binary numbers. Show the resulting binary number.");	
		System.out.println("Q5a");	
		bitWiseOperation(0b00011110, 0b11000000, Operand.OR);

		System.out.println("Q5b");	
		bitWiseOperation(0b11001011, 0b11000000, Operand.OR);

		System.out.println("Q5c");	
		bitWiseOperation(0b10111011, 0b11000000, Operand.OR);
		System.out.println ();
	}
		
	
	
	// String helper to format binary numbers
	public static String stringBin(int _num)
	{
		return String.format("%8s",Integer.toBinaryString(_num)).replace(' ', '0');
		
	}

}
