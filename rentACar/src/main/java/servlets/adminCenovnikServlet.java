package servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.cenovnikManager;
import managers.komentarManager;
import managers.userManager;
import managers.vozniParkManager;
import retntACar1.Cena;
import retntACar1.Komentari;
import retntACar1.User;

/**
 * Servlet implementation class adminCenovnikServlet
 */
public class adminCenovnikServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminCenovnikServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// TODO Auto-generated method stub
//				String ime = request.getParameter("ime");
//				String komentar = request.getParameter("komentar");
//				komentarManager.comment(ime, komentar);
////				response.getWriter().append("Served at: ").append(request.getContextPath());
//				List<Komentari> komentari = new komentarManager().getKomentari();
				User u= (User) request.getSession().getAttribute("user");
				boolean isAdmin=new userManager().isAdmin(u);
				if(!isAdmin){
					request.getRequestDispatcher("/admin/pagenotfound.jsp").forward(request, response);
				}
		
		
				List<Cena> cene=new cenovnikManager().getCenovnik();
				request.getSession().setAttribute("cene", cene);
//				request.getSession().setAttribute("komentari", komentari);
				RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/admin/cene.jsp");
				rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String kateg=request.getParameter("kategorija");
		int kategorija = Integer.parseInt(kateg);
		String cena=request.getParameter("cena");
		int cenaint = Integer.parseInt(cena);
		System.out.println(cenaint);
		BigDecimal d = BigDecimal.valueOf(cenaint);
		System.out.println(kategorija);
		
		boolean promenjeno = new cenovnikManager().promeniCenu(kategorija, d);
		doGet(request, response);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin/cene.jsp");
		rd.forward(request, response);
		
		
	}

}
