package com.graphQL.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputLibro {

	private Long id;
	
	private String nombre;
	
	private Integer paginas;
	
	private String genero;
	private Float precio;
	private Long autor_id;
}
