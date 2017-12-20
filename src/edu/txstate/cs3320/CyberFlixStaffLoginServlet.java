package edu.txstate.cs3320;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.txstate.cyberflix.data.db.JoMiBi.Staff;
import edu.txstate.cyberflix.data.db.JoMiBi.StaffDAO;

/**
 * Servlet implementation class CyberFlixStaffLoginServlet
 */
@WebServlet("/CyberFlixStaffLoginServlet")
public class CyberFlixStaffLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CyberFlixStaffLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		
		StaffDAO staffDAO = new StaffDAO();
		
		Staff staff = staffDAO.staffValidation(userName);
		if(staff!= null) {
			request.setAttribute("user", staff);
			request.getRequestDispatcher("StaffHomePage.jsp").
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
