package edu.txstate.cs3320;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.txstate.cyberflix.data.db.JoMiBi.Customer;
import edu.txstate.cyberflix.data.db.JoMiBi.CustomerDAO;

/**
 * Servlet implementation class CyberFlixLoginServlet
 */
@WebServlet("/CyberFlixLoginServlet")
public class CyberFlixLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberFlixLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		
		CustomerDAO customerDAO = new CustomerDAO();
		
		Customer customer = customerDAO.customerValidation(userName);
		if(customer != null) {
			request.setAttribute("user", customer);
			request.getRequestDispatcher("loginSuccess.jsp").
		    forward(request,  response);
		} else {
			request.getRequestDispatcher("loginFail.jsp").
		    forward(request,  response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		
		CustomerDAO customerDAO = new CustomerDAO();
		
		Customer customer = customerDAO.customerValidation(userName);
		if(customer != null) {
			HttpSession session = request.getSession();
			request.setAttribute("user", customer);
			session.setAttribute("username", customer.getFirstName());
			session.setAttribute("userid", customer.getCustomerId());
			request.getRequestDispatcher("success.jsp").
		    forward(request,  response);
		} else {
			request.getRequestDispatcher("loginFail.jsp").
		    forward(request,  response);
		}
	}
}
