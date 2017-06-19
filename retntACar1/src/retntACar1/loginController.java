package retntACar1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class loginController {
	
		public static User login(String username, String password){
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("retntACar1");	      
		    EntityManager entitymanager = emfactory.createEntityManager( );
		    entitymanager.getTransaction( ).begin( );
		    Query query=entitymanager.createQuery("select k from User k where k.email=:username and k.pass=:password").
		    	    setParameter("username", username).setParameter("password", password);
		    List<User> l=query.getResultList();
		    if(l.size()==0){
		    	return null;
		    }else{
		    	return l.get(0);
		    }
		    
		}
		
		public static void main(String [] args){
		   User k=loginController.login("admin", "admin");
		   System.out.println(k.getEmail()+" nadjen user");
		}
}
