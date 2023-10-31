package com.graphQL.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Libro {//students

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private Integer paginas;
	
	private String genero;
	private Float precio;
	@ManyToOne(fetch=FetchType.LAZY , targetEntity = Autor.class)
	private Autor autor;
}
