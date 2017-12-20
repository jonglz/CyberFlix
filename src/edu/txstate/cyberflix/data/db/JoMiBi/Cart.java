package edu.txstate.cyberflix.data.db.JoMiBi;

import java.util.ArrayList;
import java.util.List;

import edu.txstate.internet.cyberflix.data.film.Film;
/**
 *
 * @author jonathan
 */
public class Cart {
	public Double total;
	private List<Film> films;
	private final double cost = 1.00;
	
	public Cart() {
		this.films = new ArrayList<Film>();
		this.total = new Double(0.00);
	}
	
	public void addItem(Film film) {
		films.add(film);
		this.total += cost;
	}
	
	public void getTotal() {
		this.total.toString();
	}
	
	public List<Film> getFilms(){
		return this.films;
	}
	
	public void emptyCart(){
		this.films = new ArrayList<Film>();
	}
}
   
