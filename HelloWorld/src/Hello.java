/**  * A Hello World program in Java  */ 
public class Hello
{
     /**      * The entry point for this class; when executed,
      * the program prints �Hello World� and terminates
      * @param args command-line arguments
      */     
	
	public enum Rank 
	{    
		Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
	
	}	
	
	public static void main( String args[] ) 
	{
       
		byte myNumber = 127;
		byte myNumber2 = 10;
		
	//	byte myNumber3 = (myNumber + myNumber2);
		
		//System.out.println( "Hello World" );
     	for (Rank item : Rank.values()) 
    	    System.out.println(item);
     } 
} // HelloWorld