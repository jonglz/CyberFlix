package edu.txstate.cyberflix.data.db.JoMiBi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import edu.txstate.internet.cyberflix.data.actor.Actor;
import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.helper.ActorFactory;

public class ActorDAO extends DAO {
	private final static Logger LOGGER = Logger.getLogger(ActorDAO.class.getName());
	
	private static final int    ACTOR_ID_COLUMN          = 1;
	private static final int    ACTOR_FNAME_COLUMN       = 2;
	private static final int    ACTOR_LNAME_COLUMN		 = 3;
	
	private static final String ACTOR_SELECT_STRING = "SELECT actor.actor_id, actor.first_name, actor.last_name FROM sakila.actor "
			+ "WHERE actor.actor_id IN (SELECT film_actor.actor_id FROM sakila.film_actor WHERE film_id = ";
	
	public List <Actor> findActorsInFilm (Film film) {
		StringBuilder stringBuilder = new StringBuilder(ACTOR_SELECT_STRING);
		stringBuilder.append(film.getFilmID());
		stringBuilder.append(");"); 
		String selectString = stringBuilder.toString();
		List <Actor> actors = null;
		Connection dbConnection = null;
		try {
			dbConnection = DAO.getDBConnection();
			Statement statement 	= dbConnection.createStatement();
			ResultSet results       = statement.executeQuery(selectString);
			actors = buildResults (results);
			dbConnection.close();
		} catch (SQLException e) {
			System.err.println("ActorDAO.findActorsInFilm: " + e.toString());
			LOGGER.severe(e.toString());
			closeQuietly(dbConnection);
		}
		return actors;
	}

	@Override
	public void save(Object anObject) throws SQLException {
		// This will be a no-op because we won't allow changes to films
	}
	
	private List<Actor> buildResults (ResultSet results) {
		ArrayList <Actor> actors  = new ArrayList <Actor> ();
		ActorFactory actorFactory = new ActorFactory ();
		try {
			while (results.next()) {
				int    id 			=  results.getInt(ACTOR_ID_COLUMN);
				String firstName 	= results.getString(ACTOR_FNAME_COLUMN);
				String lastName 	= results.getString(ACTOR_LNAME_COLUMN);
				Actor actor = actorFactory.makeActor(id, firstName, lastName);
				actors.add(actor);
			}
		} catch (SQLException e) {
			LOGGER.severe(e.toString());
		}
		return actors;
	}	
}