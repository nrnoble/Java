package nrnoble;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate sample data for Origin
 * @author Neal Noble
 *
 */
	public class Origin
	{
		
		public List<String>originList = new ArrayList<String>();
	    private static Origin sampleData = new Origin();
	    
	    
	    // populate with state names
		public Origin()
		{
			this.originList.add("Alabama");
			this.originList.add("Alaska");
			this.originList.add("Arizona");
			this.originList.add("Arkansas");
			this.originList.add("California");
			this.originList.add("Colorado");
			this.originList.add("Connecticut");
			this.originList.add("Delaware");
			this.originList.add("Florida");
			this.originList.add("Georgia");
			this.originList.add("Hawaii");
			this.originList.add("Idaho");
			this.originList.add("Illinois");
			this.originList.add("Indiana");
			this.originList.add("Kansas");
			this.originList.add("Kentucky");
			this.originList.add("Louisiana");
			this.originList.add("Maryland");
			this.originList.add("Maine");
			this.originList.add("Massachusetts");
			this.originList.add("Michigan");
			this.originList.add("Minnesota");
			this.originList.add("Mississippi");
			this.originList.add("Missouri");
			this.originList.add("Montana");
			this.originList.add("Nebraska");
			this.originList.add("New Hampshire");
			this.originList.add("New Jersey");
			this.originList.add("New Mexico");
			this.originList.add("Nevada");
			this.originList.add("North Carolina");
			this.originList.add("North Dakota");
			this.originList.add("Ohio");
			this.originList.add("Oklahoma");
			this.originList.add("Oregon");
			this.originList.add("Pennsylvania");
			this.originList.add("Rhode Island");
			this.originList.add("South Carolina");
			this.originList.add("South Dakota");
			this.originList.add("Tennessee");
			this.originList.add("Texas");
			this.originList.add("Utah");
			this.originList.add("Vermont");
			this.originList.add("Virginia");
			this.originList.add("Washington");
			this.originList.add("Wyoming");

		}

		/**
		 * 
		 * @return a random State name
		 */
		public static String getRandomOrigin()
		{
			int randIndex = Utils.randInt(0,sampleData.originList.size()-1);
			return sampleData.originList.get(randIndex);
		}
	}

