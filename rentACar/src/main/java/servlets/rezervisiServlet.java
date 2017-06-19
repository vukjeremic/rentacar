package servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import listener.SessionListener;
import managers.dodaciManager;
import managers.iznajmljivanjeManager;
import managers.klijentManager;
import managers.vozniParkManager;
import retntACar1.Auto;
import retntACar1.Dodaci;
import retntACar1.Iznajmljivanje;
import retntACar1.Klijent;
import retntACar1.User;

/**
 * Servlet implementation class rezervisiServlet
 */
public class rezervisiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rezervisiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				List<Auto> autalista=new vozniParkManager().getSlobodanVozniPark();
				request.getSession().setAttribute("autalista", autalista);
				
				
				
				List<Dodaci> dodacilista=new dodaciManager().getDodaci();
				request.getSession().setAttribute("dodacilista", dodacilista);
				

				
				
				RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/rezervisi/rezervisi.jsp");
				rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		
		String ime = request.getParameter("ime");
		String prezime = request.getParameter("prezime");
		String jmbgString = request.getParameter("jmbg");
		int jmbg = Integer.parseInt(jmbgString);
		String datumRodjenjaString = request.getParameter("datumRodjenja");
		User u= (User) request.getSession().getAttribute("user");
		String email=u.getEmail();
		System.out.println(email + "user je ovaj"+jmbgString+"je jmbg");
		
		klijentManager.dodajKlijenta(ime, prezime, jmbgString, datumRodjenjaString, email);
		
		String registracija = request.getParameter("vozniPark");
		String idDodatka = request.getParameter("dodaci");
		String datumPreuzimanja = request.getParameter("datumPreuzimanja");
		String trajanjeString=request.getParameter("trajanjeNajma");
		int trajanje=Integer.parseInt(trajanjeString);
		
		System.out.println(registracija+"   "+idDodatka+"   "+datumPreuzimanja+trajanjeString);
		
		boolean iznajmljen= new iznajmljivanjeManager().iznajmiVozilo(registracija, idDodatka, jmbgString, trajanje, datumPreuzimanja);
		
		boolean zaduzen = new vozniParkManager().setZauzetAuto(registracija);
		
		String poruka=null;
		
		int cenaA=new vozniParkManager().getCenaAuta(registracija);
		int cenaDod=new dodaciManager().getCenaDodatka(idDodatka);
		
		int rezultat=new iznajmljivanjeManager().getCenaTrenutnogIznajmljivanja(trajanje, cenaDod, cenaA);
		if(iznajmljen && zaduzen){
			poruka="Uspesno ste rezervisali vozilo, Vas racun iznosi: "+rezultat+"e";
			
		}else{
			poruka="Dogodila se greska prilikom rezervacije, obratite se nasem call centru 021/123456";
		}
		request.getSession().setAttribute("poruka", poruka);
		
		doGet(request, response);
		RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/rezervisi/rezervisi.jsp");
		rd.forward(request, response);
	}

}
