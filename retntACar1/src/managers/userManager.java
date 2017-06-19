package managers;

import retntACar1.User;

public class userManager {

	
	public boolean isAdmin(User u){
		if(u.getEmail().equalsIgnoreCase("admin") && u.getPass().equalsIgnoreCase("admin")){
			return true;
		}else{
			return false;
		}
	}
	
	
	
}
