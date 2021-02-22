package br.com.zup.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.entities.Categoria;

public class CategoriaDTO {
	
	@NotBlank(message = "Campo nome é Obrigatório")
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public Categoria saveAs() {
		return new Categoria(nome);
	}

	
}
