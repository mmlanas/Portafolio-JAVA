package bibliospring.app.service;

import bibliospring.app.repository.model.Perfiles;
import bibliospring.app.service.response.ResponseServiceObject;

public interface PerfilesService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject findById(Integer idPerfil);
	public ResponseServiceObject create(Perfiles perfil);
	public ResponseServiceObject update(Integer idPerfil, Perfiles perfil);
	public ResponseServiceObject delete(Integer idPerfil);
}
