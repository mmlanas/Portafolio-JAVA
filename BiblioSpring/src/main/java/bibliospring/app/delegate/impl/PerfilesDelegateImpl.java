package bibliospring.app.delegate.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bibliospring.app.delegate.PerfilesDelegate;
import bibliospring.app.repository.model.Perfiles;
import bibliospring.app.service.PerfilesService;
import bibliospring.app.service.response.ResponseServiceObject;

@Component("perfilesDelegate")
public class PerfilesDelegateImpl implements PerfilesDelegate {
	
	@Autowired
	private PerfilesService perfilesService;
	
	@Override
	public ResponseServiceObject findAll() {
		return perfilesService.findAll();
	}

	@Override
	public ResponseServiceObject findById(Integer idPerfil) throws ServiceException {
		return perfilesService.findById(idPerfil);
	}

	@Override
	public ResponseServiceObject create(Perfiles perfil) {
		return perfilesService.create(perfil);
	}

	@Override
	public ResponseServiceObject update(Integer idPerfil, Perfiles perfil) {
		return perfilesService.update(idPerfil, perfil);
	}

	@Override
	public ResponseServiceObject delete(Integer idPerfil) {
		return perfilesService.delete(idPerfil);
	}

}
