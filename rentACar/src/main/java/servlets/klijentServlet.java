package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.klijentManager;

/**
 * Servlet implementation class klijentServlet
 */
public class klijentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd = null;
	String nemaKlijenta=null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public klijentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		
		rd = request.getServletContext().getRequestDispatcher("/admin/izvestaji.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jmbgString = request.getParameter("jmbgKlijent");
		try {
			int jmbg = Integer.parseInt(jmbgString);
			boolean proveriKlijenta = new klijentManager().proveriKlijenta(jmbg);
			if(proveriKlijenta){
				Map dbTable = new HashMap();
				dbTable.put("jmbg", jmbg);

				request.getSession().setAttribute("dbTable", dbTable);
				rd = request.getServletContext().getRequestDispatcher("/admin/report2.jsp");
			}else{
				nemaKlijenta="Klijent sa unetim JMBGom ne postoji u bazi.";
				
				rd = request.getServletContext().getRequestDispatcher("/admin/izvestaji.jsp");
			}
			
		} catch (NumberFormatException e) {
			System.out.println(e);
			nemaKlijenta="JMBG nije unet pravilno.";
//			request.getSession().setAttribute("nemaKlijenta", nemaKlijenta);
			rd = request.getServletContext().getRequestDispatcher("/admin/izvestaji.jsp");
		}
		request.getSession().setAttribute("nemaKlijenta", nemaKlijenta);
		rd.forward(request, response);
	}

}
