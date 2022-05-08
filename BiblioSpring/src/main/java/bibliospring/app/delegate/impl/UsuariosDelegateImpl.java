package bibliospring.app.delegate.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bibliospring.app.delegate.UsuariosDelegate;
import bibliospring.app.repository.model.Usuarios;
import bibliospring.app.service.UsuariosService;
import bibliospring.app.service.response.ResponseServiceObject;

@Component("usuariosDelegate")
public class UsuariosDelegateImpl implements UsuariosDelegate {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@Override
	public ResponseServiceObject findAll() {
		return usuariosService.findAll();
	}

	@Override
	public ResponseServiceObject findById(Integer idUsuario) throws ServiceException {
		return usuariosService.findById(idUsuario);
	}

	@Override
	public ResponseServiceObject create(Usuarios usuario) {
		return usuariosService.create(usuario);
	}

	@Override
	public ResponseServiceObject update(Integer idUsuario, Usuarios usuario) {
		return usuariosService.update(idUsuario, usuario);
	}

	@Override
	public ResponseServiceObject delete(Integer idUsuario) {
		return usuariosService.delete(idUsuario);
	}

}
