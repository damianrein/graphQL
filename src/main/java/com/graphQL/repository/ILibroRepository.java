package com.graphQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphQL.model.Libro;

public interface ILibroRepository extends JpaRepository<Libro, Long>{

}
