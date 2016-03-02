package nrnoble;

import java.sql.SQLException;

public class Main
{

	public Main()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		// Test Driver handles SQL connection
		// Test driver extends from SaleDataLayer object
		TestDriver testDriver = new TestDriver();
		
		testDriver.testCreateSale();
		System.out.println("");
		
		testDriver.testCreateSaleItem();
		System.out.println("");
		
		testDriver.testUpdateQuantity();
		System.out.println("");
		
		testDriver.testDeleteSale();
		System.out.println("");
		
		testDriver.testGetSalesByDate();
		System.out.println("");
		
		testDriver.closeConnection();
		System.out.println("Done...");

		
		
		
	}

}
