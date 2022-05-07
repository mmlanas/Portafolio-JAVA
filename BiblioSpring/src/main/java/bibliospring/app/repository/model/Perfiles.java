package bibliospring.app.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "perfiles")
//@SequenceGenerator(name="perfiles_id_perfil_seq", initialValue = 1, allocationSize = 1, sequenceName = "perfiles_id_perfil_seq")
public class Perfiles {
	@Id
	@Column(name = "id_perfil")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfiles_id_perfil_seq")
	private int idPerfil;
	@Column(name = "nombre_perfil")
	private String nombrePerfil;
	@Column(name = "descripcion_perfil")
	private String descripcionPerfil;
	
	public Perfiles() {
		super();
	}

	public Perfiles(int idPerfil, String nombrePerfil, String descripcionPerfil) {
		super();
		this.idPerfil = idPerfil;
		this.nombrePerfil = nombrePerfil;
		this.descripcionPerfil = descripcionPerfil;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombrePerfil() {
		return nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
	}

	public String getDescripcionPerfil() {
		return descripcionPerfil;
	}

	public void setDescripcionPerfil(String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
	}
	
}
