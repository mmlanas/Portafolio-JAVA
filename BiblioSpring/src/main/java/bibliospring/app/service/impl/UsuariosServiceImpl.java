package bibliospring.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bibliospring.app.repository.UsuariosRepository;
import bibliospring.app.repository.model.Usuarios;
import bibliospring.app.service.UsuariosService;
import bibliospring.app.service.response.ResponseServiceMessage;
import bibliospring.app.service.response.ResponseServiceMessageType;
import bibliospring.app.service.response.ResponseServiceObject;

@Service("usuariosService")
public class UsuariosServiceImpl implements UsuariosService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	List<ResponseServiceMessage> messageList = null;
	
	@Override
	public ResponseServiceObject findAll() {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		Iterable<Usuarios> itUsuarios = usuariosRepository.findAll();
		itUsuarios.forEach(usuarios::add);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio finalizado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(usuarios);
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findById(Integer idUsuario) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		Usuarios usuario = new Usuarios();
		responseServiceMessage.setTimestamp(new Date());
		
		try {
			usuario = usuariosRepository.findById(idUsuario).get();
			
			responseServiceMessage.setCode("200");
			responseServiceMessage.setType(ResponseServiceMessageType.OK);
			responseServiceMessage.setMessage("Búsqueda finalizada");
			
			this.messageList.add(responseServiceMessage);
			
			responseServiceObject.setBody(usuario);
			responseServiceObject.setMessageList(messageList);
			
			return responseServiceObject;
			
		} catch (NoSuchElementException ex) {
			responseServiceMessage.setCode("404");
			responseServiceMessage.setType(ResponseServiceMessageType.ERROR);
			responseServiceMessage.setMessage("No existen registros con el ID " + idUsuario);
			
			this.messageList.add(responseServiceMessage);
			
			responseServiceObject.setMessageList(messageList);
			
			return responseServiceObject;
		} catch (Exception e) {
			throw new ServiceException("Error en el servicio");
		}
	}

	@Override
	public ResponseServiceObject create(Usuarios usuario) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		responseServiceObject.setBody(usuario);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro ingresado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject update(Integer idUsuario, Usuarios usuario) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		usuario.setIdUsuario(idUsuario);
		responseServiceObject.setBody(usuariosRepository.save(usuario));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro actualizado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject delete(Integer idUsuario) {
		this.messageList = new ArrayList<ResponseServiceMessage>();
		usuariosRepository.deleteById(idUsuario);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro eliminado correctamente");
		
		this.messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

}
