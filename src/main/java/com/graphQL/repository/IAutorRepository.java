package com.graphQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphQL.model.Autor;

public interface IAutorRepository extends JpaRepository<Autor, Long> {

}
