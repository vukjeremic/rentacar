package retntACar1;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the klijent database table.
 * 
 */
@Entity
@Table(name="klijent")
@NamedQuery(name="Klijent.findAll", query="SELECT k FROM Klijent k")
public class Klijent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jmbg;

	@Column(name="datum_rodjenja")
	private String datumRodjenja;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Iznajmljivanje
	@OneToMany(mappedBy="klijent")
	private List<Iznajmljivanje> iznajmljivanjes;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="email")
	private User user;

	public Klijent() {
	}

	public int getJmbg() {
		return this.jmbg;
	}

	public void setJmbg(int jmbg) {
		this.jmbg = jmbg;
	}

	public String getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Iznajmljivanje> getIznajmljivanjes() {
		return this.iznajmljivanjes;
	}

	public void setIznajmljivanjes(List<Iznajmljivanje> iznajmljivanjes) {
		this.iznajmljivanjes = iznajmljivanjes;
	}

	public Iznajmljivanje addIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		getIznajmljivanjes().add(iznajmljivanje);
		iznajmljivanje.setKlijent(this);

		return iznajmljivanje;
	}

	public Iznajmljivanje removeIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		getIznajmljivanjes().remove(iznajmljivanje);
		iznajmljivanje.setKlijent(null);

		return iznajmljivanje;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}