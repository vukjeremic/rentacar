package managers;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import retntACar1.Auto;
import retntACar1.Cena;

public class cenovnikManager {

	public List<Cena> getCenovnik(){
		EntityManager em=JPAUtil.getEntityManager();
		Query q=em.createQuery("from Cena c");
		List<Cena> cene=q.getResultList();
		em.close();
		return cene;
	}
	
	public boolean promeniCenu(int idKat, BigDecimal cena){
		EntityManager em=JPAUtil.getEntityManager(); 
		try{
				em.getTransaction().begin();
				Cena c = em.find(Cena.class, idKat);
//				a.setStatus(1);
				c.setCena(cena);
				em.persist(c);
				em.getTransaction().commit();
				return true;			
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	}
	
}
