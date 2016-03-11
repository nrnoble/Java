package threading;

public class Main
{

	public Main()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		final int THREAD_COUNT = 5;
		Thread[] threads  = new Thread][THREAD_COUNT];
		{
			threads[i] = new CounterThread();
			
		}
		
		
		for (int i = 0; i < threads.length; i++)
		{
			threads[i].start();
		}
		
		for(int i = 0; i < threads.length; i++)
		{
			threads[i].join();
		}
		
		System.out.println("Result: + CounterThread() ");
		

	}

}
