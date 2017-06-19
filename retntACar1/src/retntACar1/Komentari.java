package retntACar1;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the komentari database table.
 * 
 */
@Entity
@Table(name="komentari")
@NamedQuery(name="Komentari.findAll", query="SELECT k FROM Komentari k")
public class Komentari implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String ime;

	private String komentar;

	public Komentari() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

}