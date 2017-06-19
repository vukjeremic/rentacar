package retntACar1;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the auto database table.
 * 
 */
@Entity
@Table(name="auto")
@NamedQuery(name="Auto.findAll", query="SELECT a FROM Auto a")
public class Auto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String registracija;

	private String boja;

	private String gorivo;

	private String marka;

	private String model;

	private int status;

	//bi-directional many-to-one association to Cena
	@ManyToOne
	@JoinColumn(name="idKat")
	private Cena cena;

	//bi-directional many-to-one association to Iznajmljivanje
	@OneToMany(mappedBy="auto")
	private List<Iznajmljivanje> iznajmljivanjes;

	public Auto() {
	}

	public String getRegistracija() {
		return this.registracija;
	}

	public void setRegistracija(String registracija) {
		this.registracija = registracija;
	}

	public String getBoja() {
		return this.boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

	public String getGorivo() {
		return this.gorivo;
	}

	public void setGorivo(String gorivo) {
		this.gorivo = gorivo;
	}

	public String getMarka() {
		return this.marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Cena getCena() {
		return this.cena;
	}

	public void setCena(Cena cena) {
		this.cena = cena;
	}

	public List<Iznajmljivanje> getIznajmljivanjes() {
		return this.iznajmljivanjes;
	}

	public void setIznajmljivanjes(List<Iznajmljivanje> iznajmljivanjes) {
		this.iznajmljivanjes = iznajmljivanjes;
	}

	public Iznajmljivanje addIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		getIznajmljivanjes().add(iznajmljivanje);
		iznajmljivanje.setAuto(this);

		return iznajmljivanje;
	}

	public Iznajmljivanje removeIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		getIznajmljivanjes().remove(iznajmljivanje);
		iznajmljivanje.setAuto(null);

		return iznajmljivanje;
	}

}