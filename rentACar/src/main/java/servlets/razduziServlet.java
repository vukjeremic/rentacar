package servlets;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.iznajmljivanjeManager;
import managers.userManager;
import managers.vozniParkManager;
import retntACar1.Auto;
import retntACar1.Iznajmljivanje;
import retntACar1.User;

/**
 * Servlet implementation class razduziServlet
 */
public class razduziServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public razduziServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User u= (User) request.getSession().getAttribute("user");
		boolean isAdmin=new userManager().isAdmin(u);
		if(!isAdmin){
			request.getRequestDispatcher("/admin/pagenotfound.jsp").forward(request, response);
		}
		
		
		List<Auto> autalista=new vozniParkManager().getZauzetVozniPark();
		request.getSession().setAttribute("autalista", autalista);
		
		
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin/razduzi.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Auto auto = (Auto)request.getParameter("vozniPark");
		String registracija=request.getParameter("vozniPark");
		System.out.println(registracija);
//		System.out.println(auto);
//		System.out.println(auto.getRegistracija());
//		if (auto!=null)
//		new vozniParkManager().setSlobodanAuto(auto.getRegistracija());
		boolean razduzen = new vozniParkManager().setSlobodanAuto(registracija);
		doGet(request, response);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin/razduzi.jsp");
		rd.forward(request, response);
		
	}

}
