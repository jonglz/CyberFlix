package edu.txstate.cyberflix.data.db.JoMiBi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class StaffDAO extends DAO {
	private final static Logger LOGGER = Logger.getLogger(ActorDAO.class.getName());
	
	private static final int    STAFF_ID_COLUMN          = 1;
	private static final int    STAFF_FNAME_COLUMN       = 2;
	private static final int    STAFF_LNAME_COLUMN		= 3;
	private static final int    STAFF_USERNAME_COLUMN       = 4;
	private static final int    STAFF_PASSWORD_COLUMN	= 5;
	
	private static final String STAFF_SELECT_STRING = "SELECT staff_id, first_name, last_name, username, password "
			+ "FROM sakila.staff WHERE username = ";

	public Staff staffValidation (String username) {
		StringBuilder stringBuilder = new StringBuilder(STAFF_SELECT_STRING);
		stringBuilder.append("'" + username + "';");
		String selectString = stringBuilder.toString();
		System.out.println(selectString);
		Staff staff = null;
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			Statement statement 	= dbConnection.createStatement();
			ResultSet results       = statement.executeQuery(selectString);
			staff = buildResults (results);
			dbConnection.close();
		} catch (SQLException e) {
			System.err.println("CustomerDAO.CustomerValidation: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}
		return staff;
	}

	private Staff buildResults(ResultSet results) {
		Staff staff = null;
		try {
			while (results.next()) {	
				int    id 			= results.getInt(STAFF_ID_COLUMN);
				String firstName 	= results.getString(STAFF_FNAME_COLUMN);
				String lastName 	= results.getString(STAFF_LNAME_COLUMN);
				String username		= results.getString(STAFF_USERNAME_COLUMN);
				String password 	= results.getString(STAFF_PASSWORD_COLUMN);
				
				staff = new Staff(id, firstName, lastName, username, password);
			}
		} catch (SQLException e) {
			LOGGER.severe(e.toString());
		}
		return staff;
	}	
	
	@Override
	public void save (Object anObject) {}
}
