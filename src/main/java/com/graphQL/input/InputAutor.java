package com.graphQL.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InputAutor {

	private Long id;
	private String nombre;
	private String apellido;
	private Integer publicaciones;
}
