package nrnoble;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.ResultSet;

//�	createSale(first_name, last_name, sale_date)
//o		Adds a new sale record
//�	createSaleItem(sale_id, item_id, quantity)
//o		Adds a new sale_item record
//�	getSalesByDate(sales_date)
//o		Returns all sale records for the given date
//�	updateQuantity(sale_item_id, quantity)
//o		Updates the quantity for the sale_item given
//�	deleteSale(sale_id)
//o		Deletes all sale_item records AND sale records associated with the given sale_id




/**
 * Test driver for SaleDataLayer class
 * @author Neal Noble 
 *
 */
public class TestDriver extends SaleDataLayer
{

	public TestDriver() throws ClassNotFoundException, SQLException
	{
		super("nnoble_301", "J$p1ter2", "nnoble.greenrivertech.net");	
	}

	/**
	 * Testing method "createSale"
	 * @throws SQLException Exception
	 */
	public void testCreateSale() throws SQLException
	{

		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		System.out.println("Testing CreateSale Method");
		this.createSale("neal", "Noble", timeStamp);
		System.out.println(this.getCurrentQuery());
		System.out.println("No Error were thrown. Passed!");
	}
	
	/**
	 * Testing method CreateSaleItem
	 * @throws SQLException Exception
	 */
	public void testCreateSaleItem() throws SQLException
	{
		System.out.println("Testing CreateSaleItem Method");
		this.createSaleItem(12, 1, 2);
		System.out.println(this.getCurrentQuery());
		System.out.println("No Error were thrown. Passed!");
	}
	
	/**
	 * Testing method "GetSalesByDate"
	 * @throws SQLException exception
	 */
	public void testGetSalesByDate() throws SQLException
	{
		System.out.println("Testing GetSalesByDate Method");
		ResultSet resultSet = this.getSalesByDate("2016-03-01");
		System.out.println(this.getCurrentQuery());
		this.displaySQLTable(resultSet, 20);
		System.out.println("No Error were thrown. Passed!");	
	}
	
	/**
	 * Testing method"UpdateQuantity"
	 * @throws SQLException exception
	 */
	public void testUpdateQuantity() throws SQLException
	{
		System.out.println("Testing updateQuantity Method");
		System.out.println(this.getCurrentQuery());
		this.updateQuantity(12, 2);
		System.out.println("No Error were thrown. Passed!");
	}
	
	/**
	 * Testing method "DeleteSale"
	 * @throws SQLException Exception
	 */
	public void testDeleteSale() throws SQLException
	{
		System.out.println("Testing DeleteSale Method");
		System.out.println(this.getCurrentQuery());
		this.deleteSale(12);
		System.out.println("No Error were thrown. Passed!");
	}
	
	
	
	
}
