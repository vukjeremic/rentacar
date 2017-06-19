package listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import retntACar1.User;



/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	public static User u;
	private SimpleDateFormat formatter =new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
        System.out.println("Sesija je kreirana u "+formatter.format(new Date()));
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("Sesija je unistena u "+formatter.format(new Date()));
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	User k=(User)arg0.getValue();
    	System.out.println("logovao se korisnik " +k.getEmail());
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
    	User k=(User)arg0.getValue();
    	System.out.println("izlogovao se korisnik: " +k.getEmail());
    	u=k;
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-g8enerated method stub
    }
    
    public User getUser(HttpSessionBindingEvent arg0){
    	 
        	User k=(User)arg0.getValue();
        	return k;
    }
	
}