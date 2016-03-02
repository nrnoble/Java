package nrnoble;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
�	createSale(first_name, last_name, sale_date)
o		Adds a new sale record
�	createSaleItem(sale_id, item_id, quantity)
o		Adds a new sale_item record
�	getSalesByDate(sales_date)
o		Returns all sale records for the given date
�	updateQuantity(sale_item_id, quantity)
o		Updates the quantity for the sale_item given
�	deleteSale(sale_id)
o		Deletes all sale_item records AND sale records associated with the given sale_id

*/


public class SaleDataLayer extends SQL
{

	public SaleDataLayer()
	{
		super();
	}
	
	/**
	 * Create SaleDataLayer
	 * @param _user User Name
	 * @param _password User Password
	 * @param _host Host Name
	 * @throws ClassNotFoundException Exception
	 * @throws SQLException Exception
	 */
	public SaleDataLayer (String _user, String _password, String _host) throws ClassNotFoundException, SQLException
	{
		super(_user, _password, _host);
	}
	
	
	/**
	 * Adds a new sale record
	 * @param _first_name First Name
	 * @param _last_name Last Name
	 * @param _sale_date Sale Date
	 * @throws SQLException Exception
	 */
	public void createSale(String _first_name, String _last_name, String _sale_date) throws SQLException
	{
		String query = "INSERT INTO `nnoble_301`.`sale` (`first_name`, `last_name`, `sale_date`)" + 
		"VALUES ('" + _first_name + "', '" + _last_name + "', '" + _sale_date + "')";
				this.insert(query);
	}
	
	
	/**
	 * Adds a new sale_item record
	 * @param _sale_id Sale ID
	 * @param _item_id Item ID
	 * @param _quantity quanity in stock
	 * @throws SQLException Exception
	 */
	public void createSaleItem(int _sale_id, int _item_id, int _quantity) throws SQLException
	{
		String query = "INSERT INTO `nnoble_301`.`sale_item` (`item_id`, `quantity`) VALUES ('"+ _item_id + "', '" +_quantity + "')";
		//System.out.println(query);
		this.insert(query);
	}
	
	/**
	 * Returns all sale records for the given date
	 * @param _date Starting date
	 * @return record found
	 * @throws SQLException  exception
	 */
	public ResultSet getSalesByDate(String _date) throws SQLException
	{
		
		//String query = "SELECT `sale_id`,`first_name`,`last_name`,`sale_date` FROM  `nnoble_301`.sale` WHERE sale_date = '" + _date + "' LIMIT 10";
		String query = "SELECT `sale_id`,`first_name`,`last_name`,`sale_date`  FROM `nnoble_301`.`sale` WHERE `sale_date` like '"+ _date + "' LIMIT 10";
		return this.viewResultSet(query);
	}
	
	/**
	 * Updates the quantity for the sale_item given
	 * @param _sale_item_id item to be updated
	 * @param _quantity to be updated
	 * @throws SQLException Exception
	 */
	public void updateQuantity(int _sale_item_id, int _quantity) throws SQLException
	{
		                       
		String query = "UPDATE `nnoble_301`.`sale_item` SET quantity = '" + _quantity + "' WHERE `sale_item_id` = " + _sale_item_id;
		//String query = "SELECT * FROM sale_item";
		//System.out.println(query);
		this.update(query);
	}

	/**
	 * Deletes all sale_item records AND sale records associated with the given sale_id
	 * @param _sale_id to be deleted
	 * @throws SQLException Exception
	 */
	public void deleteSale(int _sale_id) throws SQLException
	{
		String query = "DELETE FROM `nnoble_301`.`sale_item` WHERE `sale_id`='" + _sale_id + "'";
		this.update(query);
	    query = "DELETE FROM `nnoble_301`.`sale` WHERE `sale_id`='" + _sale_id + "'";
	    
		this.update(query);
	}
	
	
}
