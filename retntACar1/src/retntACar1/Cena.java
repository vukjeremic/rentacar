package retntACar1;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the cena database table.
 * 
 */
@Entity
@Table(name="cena")
@NamedQuery(name="Cena.findAll", query="SELECT c FROM Cena c")
public class Cena implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKat;

	private BigDecimal cena;

	@Column(name="ime_kategorije")
	private String imeKategorije;

	//bi-directional many-to-one association to Auto
	@OneToMany(mappedBy="cena")
	private List<Auto> autos;

	public Cena() {
	}

	public int getIdKat() {
		return this.idKat;
	}

	public void setIdKat(int idKat) {
		this.idKat = idKat;
	}

	public BigDecimal getCena() {
		return this.cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public String getImeKategorije() {
		return this.imeKategorije;
	}

	public void setImeKategorije(String imeKategorije) {
		this.imeKategorije = imeKategorije;
	}

	public List<Auto> getAutos() {
		return this.autos;
	}

	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}

	public Auto addAuto(Auto auto) {
		getAutos().add(auto);
		auto.setCena(this);

		return auto;
	}

	public Auto removeAuto(Auto auto) {
		getAutos().remove(auto);
		auto.setCena(null);

		return auto;
	}

}