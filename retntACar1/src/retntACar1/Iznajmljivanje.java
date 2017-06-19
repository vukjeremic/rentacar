package retntACar1;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the iznajmljivanje database table.
 * 
 */
@Entity
@Table(name="iznajmljivanje")
@NamedQuery(name="Iznajmljivanje.findAll", query="SELECT i FROM Iznajmljivanje i")
public class Iznajmljivanje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIznajmljivanja;

	@Column(name="datum_preuzimanja")
	private String datumPreuzimanja;

	@Column(name="trajanje_najma")
	private int trajanjeNajma;

	//bi-directional many-to-one association to Auto
	@ManyToOne
	@JoinColumn(name="registracija")
	private Auto auto;

	//bi-directional many-to-one association to Dodaci
	@ManyToOne
	@JoinColumn(name="idDodatka")
	private Dodaci dodaci;

	//bi-directional many-to-one association to Klijent
	@ManyToOne
	@JoinColumn(name="jmbg")
	private Klijent klijent;

	public Iznajmljivanje() {
	}

	public int getIdIznajmljivanja() {
		return this.idIznajmljivanja;
	}

	public void setIdIznajmljivanja(int idIznajmljivanja) {
		this.idIznajmljivanja = idIznajmljivanja;
	}

	public String getDatumPreuzimanja() {
		return this.datumPreuzimanja;
	}

	public void setDatumPreuzimanja(String datumPreuzimanja) {
		this.datumPreuzimanja = datumPreuzimanja;
	}

	public int getTrajanjeNajma() {
		return this.trajanjeNajma;
	}

	public void setTrajanjeNajma(int trajanjeNajma) {
		this.trajanjeNajma = trajanjeNajma;
	}

	public Auto getAuto() {
		return this.auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Dodaci getDodaci() {
		return this.dodaci;
	}

	public void setDodaci(Dodaci dodaci) {
		this.dodaci = dodaci;
	}

	public Klijent getKlijent() {
		return this.klijent;
	}

	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}

}