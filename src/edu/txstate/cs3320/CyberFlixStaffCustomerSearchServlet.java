package edu.txstate.cs3320;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.txstate.cyberflix.data.db.JoMiBi.Customer;
import edu.txstate.cyberflix.data.db.JoMiBi.CustomerDAO;
import edu.txstate.cyberflix.data.db.JoMiBi.RentalDAO;
import edu.txstate.cyberflix.data.db.JoMiBi.RentalRecord;

/**
 * Servlet implementation class CyberFlixStaffCustomerSearchServlet
 */
@WebServlet("/CyberFlixStaffCustomerSearchServlet")
public class CyberFlixStaffCustomerSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberFlixStaffCustomerSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("customer");
		CustomerDAO customerDAO = new CustomerDAO();
		RentalDAO rentalDAO = new RentalDAO();
		
		Customer customer = customerDAO.customerValidation(userEmail);
		List<RentalRecord> rentalRecords = rentalDAO.findRentalByCustomer(customer);
		//if ((rentalRecords != null) && (!rentalRecords.isEmpty())) {
			request.setAttribute("rentalInfo", rentalRecords);
			request.getRequestDispatcher("rentalcustomerresults.jsp").
		    forward(request,  response);
		//} else {
			//request.getRequestDispatcher("nomoviesfound.jsp").
		    //forward(request,  response);
		//}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RentalDAO rentalDAO = new RentalDAO();
		
		List<RentalRecord> rentalRecords = rentalDAO.findCheckedOutRentals();
		//if ((rentalRecords != null) && (!rentalRecords.isEmpty())) {
			request.setAttribute("rentalInfo", rentalRecords);
			request.getRequestDispatcher("rentalallresults.jsp").
		    forward(request,  response);
		//} else {
			//request.getRequestDispatcher("nomoviesfound.jsp").
		    //forward(request,  response);
		//}
	}

}
