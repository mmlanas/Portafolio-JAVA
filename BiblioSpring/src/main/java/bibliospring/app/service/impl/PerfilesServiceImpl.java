package bibliospring.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bibliospring.app.repository.PerfilesRepository;
import bibliospring.app.repository.model.Perfiles;
import bibliospring.app.service.PerfilesService;
import bibliospring.app.service.response.ResponseServiceMessage;
import bibliospring.app.service.response.ResponseServiceMessageType;
import bibliospring.app.service.response.ResponseServiceObject;

@Service("perfilesService")
public class PerfilesServiceImpl implements PerfilesService {
	
	@Autowired
	private PerfilesRepository perfilesRepository;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	List<ResponseServiceMessage> messageList = null;
	
	@Override
	public ResponseServiceObject findAll() {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		List<Perfiles> perfiles = new ArrayList<Perfiles>();
		Iterable<Perfiles> itPerfiles = perfilesRepository.findAll();
		itPerfiles.forEach(perfiles::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio finalizado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(perfiles);
		responseServiceObject.setMessageList(this.messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findById(Integer idPerfil) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		Perfiles perfil = new Perfiles();
		responseServiceMessage.setTimestamp(new Date());
		try {
			perfil = perfilesRepository.findById(idPerfil).get();
			
			responseServiceMessage.setCode("200");
			responseServiceMessage.setType(ResponseServiceMessageType.OK);
			responseServiceMessage.setMessage("Búsqueda finalizada");
			
			this.messageList.add(responseServiceMessage);
			
			responseServiceObject.setBody(perfil);
			responseServiceObject.setMessageList(messageList);
			
			return responseServiceObject;
			
		} catch (NoSuchElementException ex) {
			responseServiceMessage.setCode("404");
			responseServiceMessage.setType(ResponseServiceMessageType.ERROR);
			responseServiceMessage.setMessage("No existen registros con el ID " + idPerfil);
			
			this.messageList.add(responseServiceMessage);
			
			responseServiceObject.setMessageList(messageList);
			
			return responseServiceObject;
		} catch (Exception e) {
			throw new ServiceException("Error en el servicio");
		}
	}

	@Override
	public ResponseServiceObject create(Perfiles perfil) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		responseServiceObject.setBody(perfil);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro ingresado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject update(Integer idPerfil, Perfiles perfil) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		perfil.setIdPerfil(idPerfil);
		responseServiceObject.setBody(perfilesRepository.save(perfil));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro actualizado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject delete(Integer idPerfil) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		perfilesRepository.deleteById(idPerfil);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro eliminado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

}
