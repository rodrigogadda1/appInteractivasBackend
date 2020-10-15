package com.AplicacionesInteractivas.TP.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.fasterxml.jackson.annotation.JsonInclude;

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
		user.setFirstTime("true");
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
	
	//create user
	@PostMapping
	public User createUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
	
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) {
		User existing = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id:"+ userId));
	    existing.setFirstName(user.getFirstName());
	    existing.setLastName(user.getLastName());
	    existing.setEmail(user.getEmail());
	    existing.setUsername(user.getUsername());
	    existing.setPassword(user.getPassword());
		return this.userRepository.save(existing);
	}
	
//	
//	//delete user by id
//	@DeleteMapping("/{id}")
//	public ResponseEntity<User> deleteUser (@PathVariable ("id") long userId){
//		User existing = this.userRepository.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("User not found with id:"+ userId));
//		this.userRepository.delete(existing);
//		return ResponseEntity.ok().build();
//	}
	
	
}