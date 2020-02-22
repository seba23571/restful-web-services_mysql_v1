package com.in28minutes.rest.webservices.restfulwebservices.congresotabla;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CongresoJpaResource {
	
	

	@Autowired
	private CongresoRepository congresoRepository;

	
	@GetMapping("/jpa/congreso/users/{username}/todos")
	public List<TablaCongreso> getAllTodos(@PathVariable String username){
		return congresoRepository.findByUsername(username);
		//return todoService.findAll();
	}

	@GetMapping("/jpa/congreso/users/{username}/todos/{id}")
	public TablaCongreso getTodo(@PathVariable String username, @PathVariable String id){
		return congresoRepository.findById(id).get();
		//return todoService.findById(id);
	}

	// DELETE /users/{username}/todos/{id}
	@DeleteMapping("/jpa/congreso/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(
			@PathVariable String username, @PathVariable String id) {

		congresoRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}
	

	//Edit/Update a Todo
	//PUT /users/{user_name}/todos/{todo_id}
	@PutMapping("/jpa/congreso/users/{username}/todos/{id}")
	public ResponseEntity<TablaCongreso> updateTodo(
			@PathVariable String username,
			@PathVariable String id, @RequestBody TablaCongreso  tablaCongreso){
		
		tablaCongreso.setUsername(username);
		
		TablaCongreso todoUpdated = congresoRepository.save(tablaCongreso);
		
		return new ResponseEntity<TablaCongreso>(todoUpdated, HttpStatus.OK);
	}
	
	@PostMapping("/jpa/congreso/users/{username}/todos")
	public ResponseEntity<Void> createTodo(
			@PathVariable String username, @RequestBody TablaCongreso  tablaCongreso){
		
		tablaCongreso.setUsername(username);
		
		TablaCongreso createdTodo = congresoRepository.save(tablaCongreso);
		
		//Location
		//Get current resource url
		///{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTodo.getUsername()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
		
}
