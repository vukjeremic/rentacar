package managers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import retntACar1.Auto;

public class vozniParkManager {
	
	public List<Auto> getVozniPark(){
		EntityManager em=JPAUtil.getEntityManager();
		Query q=em.createQuery("from Auto a");
		List<Auto> auta=q.getResultList();
		em.close();
		return auta;
	}
	
	public List<Auto> getSlobodanVozniPark(){
		EntityManager em=JPAUtil.getEntityManager();
		Query q=em.createQuery("from Auto a where a.status=:v").setParameter("v", 0);
		List<Auto> auta=q.getResultList();
		em.close();
		return auta;
	}
	
	public List<Auto> getZauzetVozniPark(){
		EntityManager em=JPAUtil.getEntityManager();
		Query q=em.createQuery("from Auto a where a.status=:v").setParameter("v", 1);
		List<Auto> auta=q.getResultList();
		em.close();
		return auta;
	}
	
	public boolean setSlobodanAuto(String registracija){
		EntityManager em=JPAUtil.getEntityManager(); 
		try{
				em.getTransaction().begin();
				Auto a = em.find(Auto.class, registracija);
				a.setStatus(0);
				em.persist(a);
				em.getTransaction().commit();
				return true;			
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}	
	}
	
	public boolean setZauzetAuto(String registracija){
		EntityManager em=JPAUtil.getEntityManager(); 
		try{
				em.getTransaction().begin();
				Auto a = em.find(Auto.class, registracija);
				a.setStatus(1);
				em.persist(a);
				em.getTransaction().commit();
				return true;			
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}
	
	public int getCenaAuta(String registracija){
		EntityManager em=JPAUtil.getEntityManager(); 
		try{
				em.getTransaction().begin();
				Auto a = em.find(Auto.class, registracija);
				int cena=a.getCena().getCena().intValue();
				return cena;			
			}catch(Exception e){
				e.printStackTrace();
				return 0;
			}
	}
	
	public static void main(String[] args){
		vozniParkManager cm=new vozniParkManager();
	//	Date datumRodjenja;
		try {
//			datumRodjenja = sdf.parse("1982-05-13");
//			Clan c=cm.saveClan("Petar", "Petrovic", "Bulevar Cara Lazara 3, Novi Sad",datumRodjenja, new Date(),1);
//			if(c!=null)
//				System.out.println("Clan je uspesno sacuvan, clanski broj je "+c.getClanskibroj());
			
			List<Auto> clanovi=cm.getVozniPark();
			for(Auto cl:clanovi){
				System.out.println(cl.getBoja()+" "+cl.getMarka());
				cm.setZauzetAuto(cl.getRegistracija());
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
