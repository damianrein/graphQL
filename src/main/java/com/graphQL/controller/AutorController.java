package com.graphQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphQL.input.InputAutor;
import com.graphQL.model.Autor;
import com.graphQL.service.AutorService;

@Controller
public class AutorController {

	@Autowired
	private AutorService autorService;

	public AutorController(@Autowired AutorService autorService) {
		this.autorService = autorService;
	}
	@QueryMapping
	public Autor autorById(@Argument Long id) {
		return autorService.autorById(id);
	}
	
	@QueryMapping
	public List<Autor> findAllAutor(){
		return autorService.allAutor();
	}
	
	@MutationMapping
	public String createAutor(@Argument InputAutor autorInput) {
		Autor autor = new Autor();
		autor.setNombre(autorInput.getNombre());
		autor.setApellido(autorInput.getApellido());
		autor.setPublicaciones(autorInput.getPublicaciones());
		
		return "Autor Creado";
	}
	
	@MutationMapping
	public String deleteAutorById(@Argument Long id) {
		autorService.deleteAutorId(id);
		return "El Autor con id:" + id + "a sido eliminado";
	}
}
