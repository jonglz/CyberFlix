package edu.txstate.cs3320;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.txstate.cyberflix.data.db.JoMiBi.Cart;
import edu.txstate.cyberflix.data.db.JoMiBi.FilmDAO;
import edu.txstate.cyberflix.data.db.JoMiBi.RentalDAO;
import edu.txstate.cyberflix.data.db.JoMiBi.RentalRecord;
import edu.txstate.internet.cyberflix.data.film.Film;

/**
 * Servlet implementation class CyberFlixAddToCartServlet
 */
@WebServlet("/CyberFlixAddToCartServlet")
public class CyberFlixAddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberFlixAddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
        String action = request.getParameter("action");

        switch (action) {
            case "addToCart":
                this.addToCart(request, response);
                break;
            case "viewCart":
                this.viewCart(request, response);
                break;
            case "checkOut":
                this.checkOut(request, response);
                break;
            case "empty":
                this.empty(request, response);
                break;
            case "delete":
                this.delete(request, response);
                break;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String filmName = request.getParameter("film");
		FilmDAO filmDAO = new FilmDAO();
		
        HttpSession session = request.getSession();
        Cart shoppingCart;
        
        shoppingCart = (Cart) session.getAttribute("cart");
        if(shoppingCart == null){
          shoppingCart = new Cart();
          session.setAttribute("cart", shoppingCart);
        }        

        List<Film> foundFilm = filmDAO.findFilmsByAttributes(filmName,null,0,null);
		
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new ArrayList<Film>());
        }
        
		for(Film film: foundFilm) {
			film = filmDAO.getFilmDetail(film);
			shoppingCart.addItem(film);
		}
        session.setAttribute("cart", shoppingCart);
        request.getRequestDispatcher("startup.jsp").
	    forward(request,  response);
    }
    
    private void viewCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("viewCart.jsp")
                .forward(request, response);
    }
    
    private void checkOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RentalDAO rentalDAO = new RentalDAO();
    	Cart cart = (Cart) request.getSession().getAttribute("cart");
    	int userid = (int) request.getSession().getAttribute("userid");
    	List<Film> films = cart.getFilms();
        request.setAttribute("cart", cart);
        request.setAttribute("film", films);
        for(Film film: films) {
        	RentalRecord rentalRecord = new RentalRecord();
        	rentalRecord.setFilmID(film.getFilmID());
        	//Integer user = Integer.valueOf(userid);
        	rentalRecord.setCustomerID(userid);
        	rentalDAO.save(rentalRecord);
        }
        this.empty(request, response);
        request.getRequestDispatcher("checkOutConfirmation.jsp")
                .forward(request, response);
    }
    
    private void empty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.getSession().removeAttribute("cart");
    }
    
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}