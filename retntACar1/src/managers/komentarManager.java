package managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import retntACar1.Cena;
import retntACar1.Komentari;

public class komentarManager {

	public static void comment(String ime, String komentar){
		
	    
	    try{
	    	EntityManager em = JPAUtil.getEntityManager();
	    	Komentari k=new Komentari();
			k.setIme(ime);
			k.setKomentar(komentar);
			em.getTransaction().begin();			
			em.persist(k);
			em.getTransaction().commit();
			em.close();
		}catch(Exception e){
			e.printStackTrace();
		
		}
    }
	
	public List<Komentari> getKomentari(){
		EntityManager em=JPAUtil.getEntityManager();
		Query q=em.createQuery("from Komentari k");
		List<Komentari> komentari=q.getResultList();
		em.close();
		return komentari;
	}
	
	public static void main(String[] args){
		comment("milan", "jeftine cene, dobri automobili");
	}
	
}
