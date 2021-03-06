package com.AplicacionesInteractivas.TP.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AplicacionesInteractivas.TP.entity.User;
import com.AplicacionesInteractivas.TP.exception.ResourceNotFoundException;
import com.AplicacionesInteractivas.TP.repository.UserRepository;
import com.AplicacionesInteractivas.TP.responseEntities.ResponseLogin;

@RestController 
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	//get all users
	@GetMapping
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	
	//get user by id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable (value = "id") long userId) {
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id:"+ userId));
		return user;
	}
	
	//public ResponseLogin login(@RequestBody User user) {
	
	//login
	@GetMapping("/login")
	public ResponseLogin login(@RequestParam("username") String username , @RequestParam("password") String password ) {
		List<User> allUsers = this.userRepository.findAll();
		boolean userEncontrado = false;
		long LoginExitosoId = -1;
		if (allUsers.size() > 0) {
			int contador = 0;
			while ((contador < allUsers.size()) && !userEncontrado) {
				if ( allUsers.get(contador).getUsername().equals(username)  ) {
					userEncontrado = true;
					if (	allUsers.get(contador).getPassword().toString().equals(password)	) {
						LoginExitosoId = allUsers.get(contador).getId();
					}
				}
				contador++;
			}
		}
		return new ResponseLogin(LoginExitosoId);
	}
	
	//login
		@GetMapping("/getByUser")
		public User login(@RequestParam("username") String username ) {
			List<User> allUsers = this.userRepository.findAll();
			boolean userEncontrado = false;
			User user = new User();
			if (allUsers.size() > 0) {
				int contador = 0;
				while ((contador < allUsers.size()) && !userEncontrado) {
					if ( allUsers.get(contador).getUsername().equals(username)  ) {
						userEncontrado = true;
						user = allUsers.get(contador);
					}
					contador++;
				}
			}
			return user;
		}
	
	//create user
	@PostMapping
	public User createUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
	
	//delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser (@PathVariable ("id") long userId){
		User existing = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id:"+ userId));
		this.userRepository.delete(existing);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) {
		User existing = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id:"+ userId));
		if(user.getFirstName() != null) {
			existing.setFirstName(user.getFirstName());
		}
		if(user.getLastName() != null) {
			existing.setLastName(user.getLastName());
		}
		if(user.getEmail() != null) {
			existing.setEmail(user.getEmail());
		}
		if(user.getUsername() != null) {
			existing.setUsername(user.getUsername());
		}
		if(user.getPassword() != null) {
			existing.setPassword(user.getPassword());
		}
		if(user.getCelular() != null) {
			existing.setCelular(user.getCelular());
		}
		if(user.getFirstTime() != null) {
			existing.setFirstTime(user.getFirstTime());
		}
		if(user.getPreguntaSeguridad() != null) {
	    existing.setPreguntaSeguridad(user.getPreguntaSeguridad());
		}
		if(user.getRespuestaSeguridad() != null) {
			existing.setRespuestaSeguridad(user.getRespuestaSeguridad());
		}
	    if(user.getNumeroIdentificacion() != null) {
	    	existing.setNumeroIdentificacion(user.getNumeroIdentificacion());
	    }
	    if(user.getSexo() != null) {
	    	existing.setSexo(user.getSexo());
	    }
	    if(user.getTipoIdentificacion() != null) {
	    	existing.setTipoIdentificacion(user.getTipoIdentificacion());
	    }
	    if(user.getTipoUser() != null) {
	    	existing.setTipoUser(user.getTipoUser());
	    }

	    existing.setDatos_moviles(user.isDatos_moviles());
	    existing.setRecibir_notificaciones(user.isRecibir_notificaciones());
		return this.userRepository.save(existing);
	}
	
	

	
	
}
