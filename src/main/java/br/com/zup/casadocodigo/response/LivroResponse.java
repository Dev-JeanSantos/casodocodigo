package br.com.zup.casadocodigo.response;

import br.com.zup.casadocodigo.entities.Livro;

public class LivroResponse {
	
	private Long id;
	private String titulo;
	
	public LivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public LivroResponse() {
		
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	@Override
	public String toString() {
		return "LivroResponse [id=" + id + ", titulo=" + titulo + "]";
	}

}
