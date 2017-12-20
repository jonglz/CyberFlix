package edu.txstate.cs3320;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import edu.txstate.cyberflix.data.db.JoMiBi.FilmDAO;
import edu.txstate.internet.cyberflix.data.film.Film;

/**
 * Servlet implementation class CyberFlixMovieDetailServlet
 */
@WebServlet("/CyberFlixMovieDetailServlet")
public class CyberFlixMovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberFlixMovieDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filmName = request.getParameter("film");
		FilmDAO filmDAO = new FilmDAO();
		
		List<Film> foundFilm = filmDAO.findFilmsByAttributes(filmName,null,0,null);
		
		for(Film film: foundFilm) {
			film = filmDAO.getFilmDetail(film);
		}
		
		request.setAttribute("films", foundFilm);
		request.getRequestDispatcher("moviedetails.jsp").
	    forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
