package managers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import retntACar1.Auto;
import retntACar1.Dodaci;
import retntACar1.Iznajmljivanje;
import retntACar1.Klijent;
import retntACar1.Cena;

public class iznajmljivanjeManager {

	public boolean iznajmiVozilo(String registracija, String idDodatka, String jmbg, int trajanje , String datumPreuzimanja){
		try{
			EntityManager em = JPAUtil.getEntityManager();
			Iznajmljivanje i=new Iznajmljivanje();
			
			Auto a = em.getReference(Auto.class, registracija);
			
			int jmbgint=Integer.parseInt(jmbg);
			Klijent k=em.getReference(Klijent.class, jmbgint);
			
			int idDodatkaint=Integer.parseInt(idDodatka); System.out.println("id dodatka je " +idDodatkaint);
			Dodaci d=em.getReference(Dodaci.class, idDodatkaint);
			
			i.setAuto(a);
			i.setDodaci(d);
			i.setDatumPreuzimanja(datumPreuzimanja);
			i.setKlijent(k);
			i.setTrajanjeNajma(trajanje);
			
			
			
			em.getTransaction().begin();			
			em.persist(i);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public int getCenaIznajmljivanja(int idIznajmljivanja){
		try{
			EntityManager em = JPAUtil.getEntityManager();
			Iznajmljivanje i=em.getReference(Iznajmljivanje.class, idIznajmljivanja);
			int trajanje=i.getTrajanjeNajma();
			
			Auto a=i.getAuto();
			Cena cenaAuta=a.getCena();
			BigDecimal cenaAut=cenaAuta.getCena();
			int cenaA=cenaAut.intValue();
			
			Dodaci d=i.getDodaci();
			BigDecimal cenaDodatka=d.getCena();
			int cenaDod=cenaDodatka.intValue();
			System.out.println("trajanje: "+trajanje+"cenaDodatka je "+cenaDod+ "cena auta "+cenaA);
			int rezultat=trajanje * (cenaDod+cenaA);
			return rezultat;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public int getCenaTrenutnogIznajmljivanja(int trajanje, int cenaDod, int cenaA){
		try{
			EntityManager em = JPAUtil.getEntityManager();
			int rezultat=trajanje * (cenaDod+cenaA);
			return rezultat;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public String getPodaciIznajmljivanja(int idIznajmljivanja){
		try{
			EntityManager em = JPAUtil.getEntityManager();
			Iznajmljivanje i=em.getReference(Iznajmljivanje.class, idIznajmljivanja);
			int jmbg=i.getKlijent().getJmbg();
			String ime=i.getKlijent().getIme();
			String prezime=i.getKlijent().getPrezime();
			String preuzet = i.getDatumPreuzimanja();
			String registracija = i.getAuto().getRegistracija();
			String ispis=("Automobil sa registracionim oznakama "+registracija+" preuzet "+preuzet+
					" od strane "+ime+" "+prezime+" "+jmbg);
			
			
			return ispis;
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	public List<Iznajmljivanje> getIznajmljivanje(){
		EntityManager em=JPAUtil.getEntityManager();
		Query q=em.createQuery("from Iznajmljivanje i");
		List<Iznajmljivanje> iznajmljivanje=q.getResultList();
		em.close();
		System.out.println(iznajmljivanje);
		return iznajmljivanje;
		
	}
	
	public String emailKlijenta(int idIznajmljivanja){
		try{
			EntityManager em = JPAUtil.getEntityManager();
			Iznajmljivanje i=em.getReference(Iznajmljivanje.class, idIznajmljivanja);
			String email=i.getKlijent().getUser().getEmail();
			return email;
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	public static void main(String[] args){
		iznajmljivanjeManager im=new iznajmljivanjeManager();
	//	Date datumRodjenja;
		try {

			
			System.out.println("cenaIznajmljivanja je"+im.getCenaIznajmljivanja(4));
			im.getIznajmljivanje();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
