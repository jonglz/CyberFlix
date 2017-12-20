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

/**
 * Servlet implementation class CyberFlixStartServlet
 */
@WebServlet("/CyberFlixStartServlet")
public class CyberFlixStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberFlixStartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDAO filmDAO = new FilmDAO();
		
		List <Film> foundFilms = filmDAO.findNewestFilms(8);		

		request.setAttribute("films", foundFilms);
		request.setAttribute("detailServlet",   
				   "http://localhost:8080/cyberflixtemp/CyberFlixMovieDetailServlet");
		request.getRequestDispatcher("/index.jsp").
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
