package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.iznajmljivanjeManager;
import managers.userManager;
import retntACar1.Iznajmljivanje;
import retntACar1.User;

/**
 * Servlet implementation class pregledIznajmljivanjaServlet
 */
public class pregledIznajmljivanjaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pregledIznajmljivanjaServlet() {
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
		List<Iznajmljivanje> iznjamljivanjeLista=new iznajmljivanjeManager().getIznajmljivanje();
		request.getSession().setAttribute("iznjamljivanjeLista", iznjamljivanjeLista);
		
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin/iznajmljivanje.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idIznajmljivanjaString=request.getParameter("idIznajmljivanja");
		int idIznajmljivanja=Integer.parseInt(idIznajmljivanjaString);
		int cenaIznajmljivanja=new iznajmljivanjeManager().getCenaIznajmljivanja(idIznajmljivanja);
		int cenaIznajmljivanjaDin=cenaIznajmljivanja*123;
		String podaciIznajmljivanja=new iznajmljivanjeManager().getPodaciIznajmljivanja(idIznajmljivanja);
		String cenaIspis="Cena iznajmljivanja iznosi "+cenaIznajmljivanja+"e";
		String uplataIspis="Uplatu mozete izvršiti na račun 123-456789123456-789 u dinarskoj protivvrednosti. ("+cenaIznajmljivanjaDin+"din)";
		request.getSession().setAttribute("podaciIznajmljivanja", podaciIznajmljivanja);
		request.getSession().setAttribute("cenaIspis", cenaIspis);
		request.getSession().setAttribute("uplataIspis", uplataIspis);
		System.out.println(idIznajmljivanja+" je id a cena je "+cenaIznajmljivanja);
		
		String email=new iznajmljivanjeManager().emailKlijenta(idIznajmljivanja);
		request.getSession().setAttribute("email", email); System.out.println("email je "+email);
		
		doGet(request, response);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin/iznajmljivanje.jsp");
		rd.forward(request, response);
	}

}
