package bibliospring.app.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seccion")
public class Seccion {
	
	@Id
	@Column(name = "id_seccion")
	private int idSeccion;
	@Column(name = "nombre_seccion")
	private String nombreSeccion;
	
	public Seccion(int idSeccion, String nombreSeccion) {
		super();
		this.idSeccion = idSeccion;
		this.nombreSeccion = nombreSeccion;
	}

	public Seccion() {
		super();
	}

	public int getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}

	public String getNombreSeccion() {
		return nombreSeccion;
	}

	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}
	
}
