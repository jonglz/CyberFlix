package edu.txstate.cs3320;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.txstate.cyberflix.data.db.JoMiBi.Customer;
import edu.txstate.cyberflix.data.db.JoMiBi.CustomerDAO;

/**
 * Servlet implementation class CyberFlixRegisterServlet
 */
@WebServlet("/CyberFlixRegisterServlet")
public class CyberFlixRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberFlixRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
		CustomerDAO customerDAO = new CustomerDAO();
		
		Customer customer = new Customer(0, fname, lname, email, password);
		customerDAO.save(customer);
		if(customer != null) {
			request.setAttribute("user", customer);
			request.getRequestDispatcher("loginSuccess.jsp").
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
