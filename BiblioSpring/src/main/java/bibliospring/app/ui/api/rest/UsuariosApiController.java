package bibliospring.app.ui.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bibliospring.app.delegate.UsuariosDelegate;

@RestController
@RequestMapping("/usuarios")
public class UsuariosApiController {
	
	@Autowired
	private UsuariosDelegate usuariosDelegate;
	
}
