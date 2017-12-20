package edu.txstate.cs3320;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.txstate.cyberflix.data.db.JoMiBi.FilmDAO;
import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.film.FilmCategory;

/**
 * Servlet implementation class CyberFlixAlphaSearchSevlet
 */
@WebServlet("/CyberFlixAlphaSearchSevlet")
public class CyberFlixAlphaSearchSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberFlixAlphaSearchSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String alpha = request.getParameter("alpha");
		
		FilmDAO filmDAO = new FilmDAO();

		List <Film> foundFilms = filmDAO.findFilmsAlphabetically(alpha);
		System.out.println("\n\nSearch Movies Alphabetically");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
