package edu.txstate.cs3320;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.txstate.cyberflix.data.db.JoMiBi.FilmDAO;
import edu.txstate.internet.cyberflix.data.DataSource;
import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.film.Film.FilmRating;
import edu.txstate.internet.cyberflix.utils.ServletUtils;

/**
 * Servlet implementation class CyberFlixServlet
 */
@WebServlet("/CyberFlixServlet")
public class CyberFlixServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CyberFlixServlet() {
		super();

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ServletUtils.setAbsolutePath(config);
		DataSource.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filmTitle = request.getParameter("film_title");
		String filmDescription = request.getParameter("film_description");
		String runTime = request.getParameter("run_time");
		String rating = request.getParameter("rating");
		int runT = Integer.parseInt(runTime);
		FilmRating rate = null;
		
		FilmDAO filmDAO = new FilmDAO();
				
		if(rating != "") {
			rate = FilmRating.valueOf(rating);
		}
		else 
			rate = null;
		
		if (filmTitle != null) {
			List <Film> foundFilms = filmDAO.findFilmsByAttributes(filmTitle,filmDescription,runT,rate);
			System.out.println("\n\nSearch Movies Attributes");
			for(Film film: foundFilms) {
				System.out.println(film.toString());
			}
			
			if ((foundFilms != null) && (!foundFilms.isEmpty())) {
				request.setAttribute("films", foundFilms);
				request.setAttribute("detailServlet",   
						   "http://localhost:8080/cyberflixtemp/CyberFlixMovieDetailServlet");
				request.getRequestDispatcher("moviesearchresults.jsp").
			    forward(request,  response);
			} else {
				request.getRequestDispatcher("nomoviesfound.jsp").
			    forward(request,  response);
			}
		}
	}
}
