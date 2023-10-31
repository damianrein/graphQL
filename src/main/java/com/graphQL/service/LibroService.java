package com.graphQL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphQL.model.Libro;
import com.graphQL.repository.ILibroRepository;

@Service
public class LibroService {

	@Autowired
	private ILibroRepository libroRepo;

	public LibroService(@Autowired ILibroRepository libroRepo) {
		this.libroRepo = libroRepo;
	}
	
	public List<Libro> allLibros(){
		return libroRepo.findAll();
	}
	
	public Libro findLibroById(Long id) {
		return libroRepo.findById(id).orElseThrow();
	}
	
	public void addLibro(Libro libro) {
		libroRepo.save(libro);
	}
	
	public void deleteLibroId(Long id) {
		libroRepo.deleteById(id);
	}
}
