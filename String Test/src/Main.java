import java.util.Scanner;

public class Main
{

	public Main()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		String abcd = "abcd";
		System.out.println("The length of the string \"" + abcd + "\" is " + abcd.length());

		Scanner scanner = new Scanner(System.in);

		System.out.println ("Enter the first four letters of the alphabit: ");
		abcd = scanner.nextLine();
		System.out.println("The length of the string \"" + abcd + "\" is " + abcd.length());

	}

}
