package edu.txstate.cyberflix.data.db.JoMiBi;

import java.util.List;

import edu.txstate.cyberflix.data.db.JoMiBi.FilmDAO;
import edu.txstate.internet.cyberflix.data.actor.Actor;
import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.film.FilmCategory;
public class Driver {
	
	public static void main(String[] args) {
		List <Film> films = null;
		FilmDAO filmDAO = new FilmDAO();
		
		/*
		 * Case:1
		 * Splash page query to get the first 5 movie entries.
		 * */
		films = filmDAO.findNewestFilms(5);
		System.out.println("\n\nSplash page movies");
		for(Film film: films) {
			System.out.println(film.toString());
		}
		
		/*
		 * Case:2
		 * Queries to search through a set of attributes, 
		 * displays all films with the word "land" in it. 
		 * */
		films = filmDAO.findFilmsByAttributes("land",null,0,null);
		System.out.println("\n\nSearch Movies Attributes");
		for(Film film: films) {
			System.out.println(film.toString());
		}
		
		/*
		 * Case:3
		 * Queries to search by category, displays all movies 
		 * with the category of ACTION.
		 * */		
		films = filmDAO.findFilmsByCategory(FilmCategory.ACTION);
		System.out.println("\n\nSearch Movies Categories");
		for(Film film: films) {
			System.out.println(film.toString());
		}
		
		/*
		 * Case:4
		 * Queries to search by alphabetical values, displays all movies 
		 * that start with the letter C.
		 * */		
		films = filmDAO.findFilmsAlphabetically("C");
		System.out.println("\n\nSearch Movies Alphabetically");
		for(Film film: films) {
			System.out.println(film.toString());
		}
		
		/*
		 * Case:5
		 * Queries to show movie details, gets the first 
		 * film by year then displays deat's.
		 * */		
		films = filmDAO.findNewestFilms(1);
		for(Film film: films) {
			film = filmDAO.getFilmDetail(film);
			System.out.println("\n\nShow Movie Details");
			System.out.println(film.toString2()); // uses toString2() because it print the details with the category
			List <Actor> actors = film.getActors();
			for(Actor actor: actors) {
				System.out.println(actor.toString());
			}
		}
		
		/*
		 * Case:6
		 * */
		//Nothing yet...
		
		/*
		 * Case:7
		 * Queries through three customers and returns 
		 * a customer object if found, if not the returns null.
		 * */
		String maryEmail = "MARY.SMITH@sakilacustomer.org";
		String patriciaEmail = "PATRICIA.JOHNSON@sakilacustomer.org";	
		String youGmail = "you@gmail.com";
		CustomerDAO customerDAO = new CustomerDAO();
		
		Customer customer = null;
		customer = customerDAO.customerValidation(maryEmail);
		if(customer != null) {
			System.out.println("\n\nCustomer Validation");
			System.out.println(customer);
		} else {
			System.out.println("\n\nCustomer Validation");
			System.out.println("No Customer Found");
		}
		
		
		customer = null;
		customer = customerDAO.customerValidation(patriciaEmail);
		if(customer != null) {
			System.out.println("\n\nCustomer Validation");
			System.out.println(customer);
		} else {
			System.out.println("\n\nCustomer Validation");
			System.out.println("No Customer Found");
		}
		
		customer = null;
		customer = customerDAO.customerValidation(youGmail);
		if(customer != null) {
			System.out.println("\n\nCustomer Validation");
			System.out.println(customer);
		} else {
			System.out.println("\n\nCustomer Validation");
			System.out.println("No Customer Found");
		}
	}
}
