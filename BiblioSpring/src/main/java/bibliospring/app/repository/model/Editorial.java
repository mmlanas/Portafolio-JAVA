package bibliospring.app.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "editorial")
//@SequenceGenerator(name = "editorial_id_editorial_seq", initialValue = 1, allocationSize = 1, sequenceName = "editorial_id_editorial_seq")
public class Editorial {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "editorial_id_editorial_seq")
	@Column(name = "id_editorial")
	private int idEditorial;
	@Column(name = "nombre_editorial")
	private String nombreEditorial;
	private String pais;
	
	public Editorial(int idEditorial, String nombreEditorial, String pais) {
		super();
		this.idEditorial = idEditorial;
		this.nombreEditorial = nombreEditorial;
		this.pais = pais;
	}
	
	public Editorial() {
		super();
	}

	public int getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}
	public String getNombreEditorial() {
		return nombreEditorial;
	}
	public void setNombreEditorial(String nombreEditorial) {
		this.nombreEditorial = nombreEditorial;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return "Editorial [idEditorial=" + idEditorial + ", nombreEditorial=" + nombreEditorial + ", pais=" + pais
				+ "]";
	}
	
}
