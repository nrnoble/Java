

public class CounterThread extends Thread
{
 
	private static int count;
	private static Object  lock = new Object();

	
	public CounterThread()
	{
		// do nothing
	}
	
	
	public void run()
	{
		for (int i= 1; i<=10000; i++)
		{
			
			count++;
		}
		
	}
	
	
	public static  void updateCount()
	{
		//synchronized(CounterThread.class)
		synchronized(lock)
		{
			count++;
		}
	}
	
	public static int  getcount()
	{
		
		return count;
	}
}
