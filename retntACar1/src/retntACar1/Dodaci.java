package retntACar1;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the dodaci database table.
 * 
 */
@Entity
@Table(name="dodaci")
@NamedQuery(name="Dodaci.findAll", query="SELECT d FROM Dodaci d")
public class Dodaci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDodatka;

	private BigDecimal cena;

	private String naziv;

	//bi-directional many-to-one association to Iznajmljivanje
	@OneToMany(mappedBy="dodaci")
	private List<Iznajmljivanje> iznajmljivanjes;

	public Dodaci() {
	}

	public int getIdDodatka() {
		return this.idDodatka;
	}

	public void setIdDodatka(int idDodatka) {
		this.idDodatka = idDodatka;
	}

	public BigDecimal getCena() {
		return this.cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Iznajmljivanje> getIznajmljivanjes() {
		return this.iznajmljivanjes;
	}

	public void setIznajmljivanjes(List<Iznajmljivanje> iznajmljivanjes) {
		this.iznajmljivanjes = iznajmljivanjes;
	}

	public Iznajmljivanje addIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		getIznajmljivanjes().add(iznajmljivanje);
		iznajmljivanje.setDodaci(this);

		return iznajmljivanje;
	}

	public Iznajmljivanje removeIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		getIznajmljivanjes().remove(iznajmljivanje);
		iznajmljivanje.setDodaci(null);

		return iznajmljivanje;
	}

}