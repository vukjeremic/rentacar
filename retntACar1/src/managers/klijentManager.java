package managers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;


import retntACar1.Auto;
import retntACar1.Cena;
import retntACar1.Dodaci;
import retntACar1.Iznajmljivanje;
import retntACar1.Klijent;
import retntACar1.User;

public class klijentManager {

	public static boolean dodajKlijenta(String ime, String prezime, String jmbg, String d, String email){
		try{
			EntityManager em = JPAUtil.getEntityManager();
//			User u = em.find(User.class, email);
			User u = new User();
			u=em.getReference(User.class, email);
			int jmbgint=Integer.parseInt(jmbg);
			Klijent provera = em.find(Klijent.class, jmbgint);
			if(provera==null){
				Klijent k=new Klijent();
				
				k.setIme(ime); System.out.println(ime);
				k.setPrezime(prezime); System.out.println(prezime);
				k.setDatumRodjenja(d); System.out.println(d);
				k.setJmbg(jmbgint); System.out.println(jmbgint);
		    	k.setUser(u); System.out.println(u.getEmail());
				
				
				em.getTransaction().begin();			
				em.persist(k);
				em.getTransaction().commit();
				em.close();
				return true;
			}else{
				
				
				provera.setIme(ime); System.out.println(ime);
				provera.setPrezime(prezime); System.out.println(prezime);
				provera.setDatumRodjenja(d); System.out.println(d);
//				provera.setJmbg(jmbgint); System.out.println(jmbgint);
		    	provera.setUser(u); System.out.println(u.getEmail());
				
				
				em.getTransaction().begin();			
				em.persist(provera);
				em.getTransaction().commit();
				em.close();
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean proveriKlijenta(int jmbg){
		try{
			EntityManager em = JPAUtil.getEntityManager();
			Klijent k = new Klijent();
			k=em.find(Klijent.class, jmbg);
			if (k!=null){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	public static void main(String[] args){
		klijentManager km=new klijentManager();
	//	Date datumRodjenja;
		try {
//			datumRodjenja = sdf.parse("1982-05-13");
//			Clan c=cm.saveClan("Petar", "Petrovic", "Bulevar Cara Lazara 3, Novi Sad",datumRodjenja, new Date(),1);
//			if(c!=null)
//				System.out.println("Clan je uspesno sacuvan, clanski broj je "+c.getClanskibroj());
			
			km.dodajKlijenta("zivko", "zivkovic", "123", "12/12/2012","klijent@klijent.com");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
