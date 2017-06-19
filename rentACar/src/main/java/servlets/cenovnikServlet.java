package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.cenovnikManager;
import managers.komentarManager;
import managers.registracijaManager;
import retntACar1.Cena;
import retntACar1.Komentari;

/**
 * Servlet implementation class cenovnikServlet
 */
public class cenovnikServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cenovnikServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ime = request.getParameter("ime");
		String komentar = request.getParameter("komentar");
		komentarManager.comment(ime, komentar);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Komentari> komentari = new komentarManager().getKomentari();
		List<Cena> cene=new cenovnikManager().getCenovnik();
		request.getSession().setAttribute("cene", cene);
		request.getSession().setAttribute("komentari", komentari);
		RequestDispatcher rd=request.getServletContext().getRequestDispatcher("/cenovnik/cenovnik.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
