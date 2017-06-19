package managers;

import java.io.Console;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import retntACar1.Auto;
import retntACar1.Iznajmljivanje;
import retntACar1.User;

public class registracijaManager {

	public boolean register(String username, String password){
		
	    
		    try{
		    	EntityManager em = JPAUtil.getEntityManager();
					User u= new User();
					u.setEmail(username);
					u.setPass(password);
					em.getTransaction().begin();			
					em.persist(u);
					em.getTransaction().commit();
					em.close();
				
					return true;
				
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
	    }

	public static void main(String[] args) {
		//register("test6@gmail.com", "test");
	}
}
