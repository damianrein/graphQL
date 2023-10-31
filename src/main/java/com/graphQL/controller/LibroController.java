package com.graphQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphQL.input.InputLibro;
import com.graphQL.model.Autor;
import com.graphQL.model.Libro;
import com.graphQL.service.AutorService;
import com.graphQL.service.LibroService;

@Controller
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@Autowired
	private AutorService autorService;

	public LibroController(@Autowired LibroService libroService) {
		this.libroService = libroService;
	}
	
	@QueryMapping
	public List<Libro> findAllLibros(){
		return libroService.allLibros();
	}
	
	@QueryMapping
	public Libro libroById(@Argument Long id) {
		return libroService.findLibroById(id);
	}
	
	@MutationMapping
	public String createLibro(@Argument InputLibro libroInput) {
		Autor autor = autorService.autorById(libroInput.getAutor_id());
		
		Libro newLibro = new Libro();
		newLibro.setNombre(libroInput.getNombre());
		newLibro.setPaginas(libroInput.getPaginas());
		newLibro.setGenero(libroInput.getGenero());
		newLibro.setPrecio(libroInput.getPrecio());
		newLibro.setAutor(autor);
		
		libroService.addLibro(newLibro);
		return "Libro creado";
	}
	
	@MutationMapping
	public String deleteLibroById(@Argument Long id) {
		libroService.deleteLibroId(id);
		return "El Libro con id: " + id + "a sido eliminado";
	}
}
