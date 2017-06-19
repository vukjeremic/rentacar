package beans;

import java.util.List;

import managers.dodaciManager;
import retntACar1.Dodaci;

public class getDodaciBean {
private List<Dodaci> dodaci;
	
	
	
	public void getDodaciBean(){
		dodaci=new dodaciManager().getDodaci();
	}

	public List<Dodaci> getDodaci() {
		return dodaci;
	}

	public void setDodaci(List<Dodaci> dodaci) {
		this.dodaci = dodaci;
	}
}
