package nrnoble;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class. Generates test data
 * @author Neal Noble
 *
 */
public class SampleFruitData
{
	
	public List<String>fruitList = new ArrayList<String>();
    private static SampleFruitData sampleData = new SampleFruitData();
    
	public SampleFruitData()
	{
		this.fruitList.add("Apple");
		this.fruitList.add("Apricot");
		this.fruitList.add("Avocado");
		this.fruitList.add("Banana");
		this.fruitList.add("Bilberry");
		this.fruitList.add("Blackberry");
		this.fruitList.add("Blackcurrant");
		this.fruitList.add("Blueberry");
		this.fruitList.add("Boysenberry");
		this.fruitList.add("Cantaloupe");
		this.fruitList.add("Currant");
		this.fruitList.add("Cherry");
		this.fruitList.add("Cherimoya");
		this.fruitList.add("Cloudberry");
		this.fruitList.add("Coconut");
		this.fruitList.add("Cranberry");
		this.fruitList.add("Damson");
		this.fruitList.add("Date");
		this.fruitList.add("Dragonfruit");
		this.fruitList.add("Elderberry");
		this.fruitList.add("Feijoa");
		this.fruitList.add("Fig");
		this.fruitList.add("Goji berry");
		this.fruitList.add("Gooseberry");
		this.fruitList.add("Grape");
		this.fruitList.add("Grape");
		this.fruitList.add("Raisin");
		this.fruitList.add("Grapefruit");
		this.fruitList.add("Guava");
		this.fruitList.add("Huckleberry");
		this.fruitList.add("Jabuticaba");
		this.fruitList.add("Jackfruit");
		this.fruitList.add("Jambul");
		this.fruitList.add("Jujube");
		this.fruitList.add("Juniper berry");
		this.fruitList.add("Kiwi fruit");
		this.fruitList.add("Kumquat");
		this.fruitList.add("Lemon");
		this.fruitList.add("Lime");
		this.fruitList.add("Loquat");
		this.fruitList.add("Mango");
		this.fruitList.add("Lychee");
		this.fruitList.add("Marion berry");
		this.fruitList.add("Melon");
		this.fruitList.add("Cantaloupe");
		this.fruitList.add("Honeydew");
		this.fruitList.add("Watermelon");
		this.fruitList.add("Mulberry");
		this.fruitList.add("Nectarine");
		this.fruitList.add("Olive");
		this.fruitList.add("Orange");
		this.fruitList.add("Blood Orange");
	}


	/**
	 * 
	 * @return a random fruit name
	 */
	public static String getRandomFruit()
	{
		int randIndex = dead.zone.Utilities.randInt(0,sampleData.fruitList.size()-1);
		return sampleData.fruitList.get(randIndex);
	}
}