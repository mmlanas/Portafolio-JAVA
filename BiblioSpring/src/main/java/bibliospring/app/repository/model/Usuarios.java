package bibliospring.app.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
//@SequenceGenerator(name="users_id_user_seq", initialValue = 1, allocationSize = 1, sequenceName = "users_id_user_seq")
public class Usuarios {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_user_seq")
	@Column(name = "id_usuario")
	private int idUsuario;
	private String nickname;
	private String name;
	private String email;
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "id_perfil")
	private Perfiles perfil;

	public Usuarios() {
		super();
	}

	public Usuarios(int idUsuario, String nickname, String name, String email, String password, Perfiles perfil) {
		super();
		this.idUsuario = idUsuario;
		this.nickname = nickname;
		this.name = name;
		this.email = email;
		this.password = password;
		this.perfil = perfil;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Perfiles getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfiles perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + ", nickname=" + nickname + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", perfil=" + perfil.getNombrePerfil() + "]";
	}
	
}
