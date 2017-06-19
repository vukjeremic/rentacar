package beans;

import java.io.Serializable;
import java.util.List;

import managers.vozniParkManager;
import retntACar1.Auto;


public class getVozniParkBean implements Serializable{
	private List<Auto> auta;
	
	
	
	public void getVozniParkBean(){
		auta=new vozniParkManager().getVozniPark();
	}

	public List<Auto> getAuta() {
		return auta;
	}

	public void setVozniPark(List<Auto> auta) {
		this.auta = auta;
	}
	
	
}
