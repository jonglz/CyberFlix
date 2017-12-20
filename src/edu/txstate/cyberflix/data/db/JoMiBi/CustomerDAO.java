package edu.txstate.cyberflix.data.db.JoMiBi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class CustomerDAO extends DAO {
	private final static Logger LOGGER = Logger.getLogger(ActorDAO.class.getName());
	
	private static final int    CUSTOMER_ID_COLUMN          = 1;
	private static final int    CUSTOMER_FNAME_COLUMN       = 2;
	private static final int    CUSTOMER_LNAME_COLUMN		= 3;
	private static final int    CUSTOMER_EMAIL_COLUMN       = 4;
	private static final int    CUSTOMER_PASSWORD_COLUMN	= 5;
	
	private static final String CUSTOMER_SELECT_STRING = "SELECT customer_id, first_name, last_name, email, password "
			+ "FROM sakila.customer WHERE email = ";

	public Customer customerValidation (String email) {
		StringBuilder stringBuilder = new StringBuilder(CUSTOMER_SELECT_STRING);
		stringBuilder.append("'" + email + "';");
		String selectString = stringBuilder.toString();
		System.out.println(selectString);
		Customer customer = null;
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			Statement statement 	= dbConnection.createStatement();
			ResultSet results       = statement.executeQuery(selectString);
			customer = buildResults (results);
			dbConnection.close();
		} catch (SQLException e) {
			System.err.println("CustomerDAO.CustomerValidation: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}
		return customer;
	}

	private Customer buildResults(ResultSet results) {
		Customer customer = null;
		try {
			while (results.next()) {	
				int    id 			= results.getInt(CUSTOMER_ID_COLUMN);
				String firstName 	= results.getString(CUSTOMER_FNAME_COLUMN);
				String lastName 	= results.getString(CUSTOMER_LNAME_COLUMN);
				String emailAddress = results.getString(CUSTOMER_EMAIL_COLUMN);
				String password 	= results.getString(CUSTOMER_PASSWORD_COLUMN);
				
				customer = new Customer(id, firstName, lastName, emailAddress, password);
			}
		} catch (SQLException e) {
			LOGGER.severe(e.toString());
		}
		return customer;
	}	
	
	@Override
	public void save (Object anObject) {
		if ((anObject instanceof Customer) == false)
			return;
		Customer customer = (Customer)anObject;
		String insertString1 = 
		"INSERT INTO CUSTOMER (customer_id,store_id, first_name,last_name, email, address_id, " +
		                       "password, active,create_date,last_update) ";
		
		String insertString2 = " VALUES (null, 1, ?, ?, ?, ?, ?, 1, now(), null)";
		System.out.print(insertString2);
		StringBuilder stringBuilder = new StringBuilder(insertString1).append(insertString2);
		String customerInsertString = stringBuilder.toString();
		LOGGER.info(customerInsertString);
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			PreparedStatement insertStatement = dbConnection.prepareStatement(customerInsertString);
			insertStatement.setString (CUSTOMER_ID_COLUMN,customer.getFirstName());
			insertStatement.setString (CUSTOMER_FNAME_COLUMN, customer.getLastName());
			insertStatement.setString (CUSTOMER_LNAME_COLUMN,customer.getEmail());
			insertStatement.setInt    (CUSTOMER_EMAIL_COLUMN, randomAddress());
			insertStatement.setString (CUSTOMER_PASSWORD_COLUMN,customer.getPassword());	
			int results = insertStatement.executeUpdate();
			LOGGER.info(String.valueOf(results));
			dbConnection.close();
		} catch (SQLException e) {
			System.err.println("CustomerDAO.insertCustomer: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}
	}
	
	private int randomAddress() {
		// There are 603 addresses in the Sakila database, pick one
		// to assign to this customer
		int randomAddressId = (int) (Math.random() * 603);
		return randomAddressId;
	}
}