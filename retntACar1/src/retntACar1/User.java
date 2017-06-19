package retntACar1;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String email;

	private String pass;

	//bi-directional many-to-one association to Klijent
	@OneToMany( mappedBy="user")
	private List<Klijent> klijents;

	public User() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Klijent> getKlijents() {
		return this.klijents;
	}

	public void setKlijents(List<Klijent> klijents) {
		this.klijents = klijents;
	}

	public Klijent addKlijent(Klijent klijent) {
		getKlijents().add(klijent);
		klijent.setUser(this);

		return klijent;
	}

	public Klijent removeKlijent(Klijent klijent) {
		getKlijents().remove(klijent);
		klijent.setUser(null);

		return klijent;
	}

}