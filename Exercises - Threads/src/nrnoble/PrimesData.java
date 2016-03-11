package nrnoble;

import java.util.ArrayList;
import java.util.List;

public class PrimesData 
{
	
	private static List<PrimesData.Prime> primesList = new ArrayList<PrimesData.Prime>();
	//private static List<Integer> primesList_2 = new ArrayList<Integer>();
	
	public PrimesData()
	{
		
	}
	
	
	/**
	 * removed all data from prime number list
	 */
	public static void ClearPrimeList()
	{
		primesList.removeAll(primesList);
	}
	
	/**
	 * Add a prime number to list
	 * @param _threadID the thread ID that found the prime number
	 * @param _prime Prime Number
	 */
	public synchronized static void add(int _threadID, int _prime)
	{
		PrimesData.Prime primeNumber =  new PrimesData().new Prime(_threadID, _prime);		
		primesList.add(primeNumber);
	}
	
	/**
	 * 
	 * @return the list of prime numbers
	 */
	public synchronized static List<PrimesData.Prime> getPrimes()
	{
		return primesList;
	}
	
	/**
	 * 
	 * @return the number of prime number found
	 */
	public static int primeNumberCounter()
	{
		
		return primesList.size();
		
	}
	
	
//	public static void sort()
//	{
//		primesList.sort(null);
//	}

	/**
	 * Holds a prime number and the thread ID used to find it.
	 * @author Neal
	 *
	 */
	public class Prime
	{
		private int thread;
		private int primeNumber;
		
		
		public Prime(int _thread, int _prime)
		{
			this.thread = _thread;
			this.primeNumber = _prime;
		}
		
		public int getThreadID()
		{
			return this.thread;
		}
		
		
		public int getPrimeNumber()
		{
			return this.primeNumber;
		}
		
		
		
	}
	
	/**
	 * Displays the current list of primes.
	 * @param _sorted true\false. If true then the list of prime numbers in order, otherwise the order is listed according to when it was found by multiple thread.
	 */
	public static void displayPrimesFound(boolean _sorted)
	{
		
		int columnCount = 0;
		if (_sorted == true)
		{
		
			int threadcount = 0;
			
			// This is a total hack. PrimeList should be class that contains
			// a property with the total number of threads used.
			for (PrimesData.Prime primesList : primesList)
			{
				int threadId = primesList.getThreadID(); 
				if (threadId > threadcount)
				{
					threadcount =  threadId;
				}
			}
			
			// Display primes ordered by thread ID. This create and ordered
			// list if acsending prime numbers.
			for (int threadID = 1; threadID <= threadcount; threadID++)
			{
				System.out.println("Primes found by thread-" + threadID);
				System.out.println("--------------------------");

				for (int idx = 0; idx < primesList.size(); idx++)
				{
					
					PrimesData.Prime prime = primesList.get(idx);
					if (prime.getThreadID() == threadID)
					{
						//String thread_ID = String.format ("%02d",prime.getThreadID());
						int primeNum =  prime.getPrimeNumber();
						String sPrime = String.format(Config.DIGITS, primeNum);
						System.out.print(sPrime + "  ");
						
						if (++columnCount >= Config.NUM_OF_COLUMNS)
						{
							columnCount = 0;
					
							System.out.println("...");
							
						}
					}
				}
				columnCount = 0;
				System.out.println("...");
				System.out.println();
			}
			
			return;
		}
		
		
		
		columnCount = 0;
		for (PrimesData.Prime primeNumber : primesList)
		{
			String threadID = String.format ("%02d",primeNumber.getThreadID());
			int prime =  primeNumber.getPrimeNumber();
			String sPrime = String.format(Config.DIGITS, prime);
			System.out.print("T" + threadID + ":" + sPrime + "  ");
			
			if (++columnCount >= Config.NUM_OF_COLUMNS)
			{
				columnCount = 0;
		
				System.out.println("...");
				
			}
		}
	}

	
	/**
	 * Finds prime numbers
	 * @param _rangeList a group of ranges to search using multiple threads
	 * @throws InterruptedException Exception
	 */
	public static void findPrimes (List<Utils.Points> _rangeList) throws InterruptedException
	{
		SynchronizedPrimeWorker threads = new SynchronizedPrimeWorker();
		
		int threadID = 1;
		for(Utils.Points points : _rangeList)
		{
			PrimeWorker primeworker = new PrimeWorker(points.getStart(),
														points.getEnd(),
														threadID++);
			Thread thread = new Thread(primeworker);
			threads.add(thread);
		}
		
		// Start all threads searching for primes numbers
		threads.startThreads();
		
		// wait until all threads have exited.
		threads.waits();
	}
	
	
}
