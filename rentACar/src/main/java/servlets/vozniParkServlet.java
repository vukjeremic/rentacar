package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.vozniParkManager;
import retntACar1.Auto;

/**
 * Servlet implementation class vozniParkServlet
 */
public class vozniParkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vozniParkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
//		request.getSession().setAttribute("auta", auta);
//		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/vozniPark/vozniPark.jsp");
//		rd.forward(request, response);
		
//		request.setAttribute("auta", auta);
//		request.getRequestDispatcher("vozniPark/vozniPark.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Auto> auta=new vozniParkManager().getVozniPark();
		request.getSession().setAttribute("auta", auta);
		RequestDispatcher rd=request.getRequestDispatcher("/vozniPark/vozniPark.jsp");
		rd.forward(request, response);
	
		
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
