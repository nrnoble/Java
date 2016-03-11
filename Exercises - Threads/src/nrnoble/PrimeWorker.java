package nrnoble;

import java.util.ArrayList;
import java.util.List;

/**
 * Worker Class that is used to find prime numbers
 * @author Neal Noble
 *
 */
public class PrimeWorker implements Runnable
{
	int rangeStart = 0;
	int rangeEnd = 0;
	int threadID = 0;
	public static int printCount;
	Boolean isAlive = null;
	private List<Integer> primeNumbers = null;
	
	public PrimeWorker(int _rangeStart, int _rangeEnd, int _threadID)
	{
		this.threadID = _threadID;
		this.rangeStart = _rangeStart;
		this.rangeEnd = _rangeEnd;
	}

	/**
	 * Start of thread
	 */
	@Override
	public void run()
	{
		//System.out.println("Starting PrimeWork Thread '" + this.threadID + "'");
		//System.out.println("Number range " + this.rangeStart + " ... " + this.rangeEnd);
		this.primeNumbers = this.findPrimes(this.rangeStart, this.rangeEnd);
		//System.out.println("PrimeWork Thread '" + this.threadID + "' has finished");
		this.isAlive = false;
	}

	
	/**
	 * @return List Array of prime numbers 
	 */
	public List<Integer> getPrimes()
	{
		this.run();
		return this.primeNumbers;
	}
	
	
	/**
	 * Check if thread is still active
	 * @return
	 */
	public boolean getIsAlive()
	{
		return this.isAlive;
	}

	
	private List<Integer> findPrimes(int _start, int _end)
	{
		List<Integer> primeNumbers = new ArrayList<Integer>();
		for (int num = _start; num <= _end; num++)
		{
			if (isPrime(num))
			{
				//System.out.print("ID" + this.threadID+ ":"+ String.format("%04d",  num) + "  ");
				
//				synchronized(this)
//				{
//					incrementPrintCount();
//					if (PrimeWorker.printCount > 15)
//					{
//						//System.out.println("...");
//						PrimeWorker.printCount = 0;
//						PrimesData.add(num);	
//					}
//				}
				
				PrimesData.add(this.threadID,num);
				primeNumbers.add(num);
			
			}
		}
		
		return primeNumbers;
	}
	
	
	/**
	 * Check to determine if a number is a Prime number
	 * @param num Number to be checked
	 * @return true\false if the number is prime
	 */
	private boolean isPrime(int num) 
	{
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
	}
	
	
}

	