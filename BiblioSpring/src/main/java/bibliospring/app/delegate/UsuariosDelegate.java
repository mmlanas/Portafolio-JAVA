package bibliospring.app.delegate;

import bibliospring.app.repository.model.Usuarios;
import bibliospring.app.service.response.ResponseServiceObject;

public interface UsuariosDelegate {
	public ResponseServiceObject findAll();
	public ResponseServiceObject findById(Integer idUsuario);
	public ResponseServiceObject create(Usuarios usuario);
	public ResponseServiceObject update(Integer idUsuario, Usuarios usuario);
	public ResponseServiceObject delete(Integer idUsuario);
}
