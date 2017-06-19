package retntACar1;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the files database table.
 * 
 */
@Entity
@Table(name="files")
@NamedQuery(name="File.findAll", query="SELECT f FROM File f")
public class File implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private byte[] file;

	public File() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getFile() {
		return this.file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}