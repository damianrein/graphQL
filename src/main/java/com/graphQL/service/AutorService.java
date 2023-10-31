package com.graphQL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphQL.model.Autor;
import com.graphQL.repository.IAutorRepository;

@Service
public class AutorService {

	@Autowired
	private IAutorRepository autorRepo;

	public AutorService(@Autowired IAutorRepository autorRepo) {
		this.autorRepo = autorRepo;
	}
	
	public List<Autor> allAutor (){
		return autorRepo.findAll();
	}
	
	public Autor autorById(Long id) {
		return autorRepo.findById(id).orElseThrow();
	}
	
	public void addAutor(Autor autor) {
		autorRepo.save(autor);
	}
	
	public void deleteAutorId(Long id) {
		autorRepo.deleteById(id);
	}
}
