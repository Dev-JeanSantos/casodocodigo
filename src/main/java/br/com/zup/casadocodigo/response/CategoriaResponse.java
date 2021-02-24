package br.com.zup.casadocodigo.response;

import br.com.zup.casadocodigo.entities.Categoria;

public class CategoriaResponse {
	
	private Long id;
	private String nome;
	
	public CategoriaResponse(Categoria entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "CategoriaResponse [id=" + id + ", nome=" + nome + "]";
	}	
	
}
