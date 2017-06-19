package managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import retntACar1.Auto;
import retntACar1.Dodaci;

public class dodaciManager {

	public List<Dodaci> getDodaci(){
		EntityManager em=JPAUtil.getEntityManager();
		Query q=em.createQuery("from Dodaci d");
		List<Dodaci> dodaci=q.getResultList();
		em.close();
		return dodaci;
	}
	
	public int getCenaDodatka(String idDodatka){
		EntityManager em=JPAUtil.getEntityManager(); 
		try{
				em.getTransaction().begin();
				int idInt=Integer.parseInt(idDodatka);
				Dodaci d = em.find(Dodaci.class, idInt);
				int cena=d.getCena().intValue();
				return cena;			
			}catch(Exception e){
				e.printStackTrace();
				return 0;
			}
	}
	
	public static void main(String[] args){
		dodaciManager cm=new dodaciManager();
	//	Date datumRodjenja;
		try {
//			datumRodjenja = sdf.parse("1982-05-13");
//			Clan c=cm.saveClan("Petar", "Petrovic", "Bulevar Cara Lazara 3, Novi Sad",datumRodjenja, new Date(),1);
//			if(c!=null)
//				System.out.println("Clan je uspesno sacuvan, clanski broj je "+c.getClanskibroj());
			
			List<Dodaci> clanovi=cm.getDodaci();
			for(Dodaci cl:clanovi)
				System.out.println(cl.getIdDodatka()+" "+cl.getNaziv());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
