package com.in28minutes.rest.webservices.restfulwebservices.congresotabla;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



// no es todo
public interface CongresoRepository extends JpaRepository<TablaCongreso, String> {

	// that's it ... no need to write any code LOL!
   Optional<TablaCongreso> findById(String username);
	List<TablaCongreso> findByUsername(String username);


}
