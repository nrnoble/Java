package nrnoble;

import java.util.ArrayList;

public class SynchronizedPrimeWorker extends ArrayList<Thread>
{
	private static final long serialVersionUID = 1L;
	
	
	public SynchronizedPrimeWorker()
	{
		// Nothing to do here.
	}
	
	
	/**
	 * Start all threads
	 */
	public void startThreads()
	{
		for (Thread thread : this)
		{
			thread.start();
		}
	}
	
	
	/**
	 * Wait until all threads have completed.
	 * @throws InterruptedException Exception
	 */
	public void waits() throws InterruptedException
	{
		while (aliveThreads()== true)
		{
			Thread.sleep(50);
			
		}
	}
	
	/**
	 * Check if one or more threads is still alive
	 * @return true\false 
	 */
	public boolean aliveThreads()
	{
		/*
		 * Iterate through threads, return true upon finding
		 * an active thread
		 */
		for (Thread thread : this)
		{
			if (thread.isAlive() == true)
			{
				return true;
			}
		}
		
		// Upon reaching this point all threads
		// have exited
		return false;
	}
	
}
