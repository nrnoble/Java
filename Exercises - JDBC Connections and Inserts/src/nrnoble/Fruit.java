package nrnoble;


/**
 * Generate random sample Fruit data
 * @author Neal Neal Noble
 *
 */
public class Fruit
{
	private String fruitType = "";
	private String origin = "";
	private double weight;
	private String discription = "";
	public Fruit()
	{
		this.fruitType = SampleFruitData.getRandomFruit();
		this.origin = Origin.getRandomOrigin();
		this.weight = sample.code.nrnoble.Utilities.randInt(1,25);
		this.discription = "Sample Description";
	}

	/**
	 * 
	 * @param _fruitType type of fruit
	 * @param _origin where the fruit originated
	 * @param _weight The total weight of the fruit
	 * @param _discription additional information
	 */
	public Fruit(String _fruitType, String _origin, double _weight,String _discription )
	{
		this.fruitType = _fruitType;
		this.origin = _origin;
		this.weight = _weight;
		this.discription = _discription;
	}

	/**
	 * 
	 * @return type of fruit
	 */
	public String getFruitType()
	{
		return fruitType;
	}

	/**
	 * 
	 * @param fruitType type of fruit
	 */
	public void setFruitType(String fruitType)
	{
		this.fruitType = fruitType;
	}

	/**
	 * 
	 * @return where the fruit originated
	 */
	public String getOrigin()
	{
		return origin;
	}

	/**
	 * 
	 * @param origin where the fruit originated
	 */
	public void setOrigin(String origin)
	{
		this.origin = origin;
	}

	/**
	 * 
	 * @return weight The total weight of the fruit
	 */
	public double getWeight()
	{
		return weight;
	}

	/**
	 * 
	 * @param weight weight The total weight of the fruit
	 */
	public void setWeight(double weight)
	{
		this.weight = weight;
	}

	/**
	 * 
	 * @return additional information
	 */
	public String getDiscription()
	{
		return discription;
	}
    
	/**
	 * 
	 * @param discription additional information
	 */
	public void setDiscription(String discription)
	{
		this.discription = discription;
	}
	
	/**
	 * 
	 * @return query string
	 */
	public String sqlInsertQuery()
	{
		return  insertQuery();
	}
	
	/**
	 * 
	 * @return INSERT query string
	 */
	public String insertQuery()
	{
		return  "INSERT INTO `nnoble_301`.`fruit` (`type`, `origin`, `weight`, `description`)\r"
				+ "VALUES ('" + this.getFruitType() + "', '" + this.getOrigin()  + "', '" 
				+ this.getWeight() + "', '" + this.getDiscription() + "')";
	}
	
	/**
	 * SELECT query
	 * @return query string
	 */
	public static String sqlSelectQuery()
	{
		return  "SELECT `type`, `origin`, `weight`, `description` \rFROM nnoble_301.fruit";

	}
	
	/**
	 * 
	 * @param columnName sort column
	 * @param orderBy "ASC" or "DESC" for sort order
	 * @return query string
	 */
	public static String querySortBy(String columnName, String orderBy)
	{
		
		
		return  "SELECT `type`, `origin`, `weight`, `description` \rFROM nnoble_301.fruit ORDER BY " + columnName + " " + orderBy;

	}
	
	
	
}
