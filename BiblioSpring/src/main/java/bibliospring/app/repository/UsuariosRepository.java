package bibliospring.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bibliospring.app.repository.model.Usuarios;

public interface UsuariosRepository extends CrudRepository<Usuarios, Integer>{
	public List<Usuarios> findByEmail(String email);
}
