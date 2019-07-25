package Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import DTO.UserDTO;
import Entidades.User;
import Service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserService serviceCamada;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> todosOsUsuarios() {
		return serviceCamada.findAll();

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> todosOsUsuariosComDTO() {
		List<UserDTO> lista = (List<UserDTO>) todosOsUsuarios().stream().map(x -> new UserDTO(x));
		return lista;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> buscarUsuarioPor(@PathVariable Long id) {
		return serviceCamada.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> addUsuario(@RequestBody User user) {
		serviceCamada.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{Id}", method = RequestMethod.POST)
	public ResponseEntity<Void> deletarUsuarioPor(@RequestBody User user) {
		serviceCamada.delete(user.getId());
		return ResponseEntity.noContent().build();

	}

}
