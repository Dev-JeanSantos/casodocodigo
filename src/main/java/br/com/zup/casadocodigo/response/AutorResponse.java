package br.com.zup.casadocodigo.response;

import java.time.LocalDateTime;

import br.com.zup.casadocodigo.entities.Autor;

public class AutorResponse {
	
	private Long id;
	private String nome;
	private String email;
	private String descricao;	
	private LocalDateTime dataCriacao;
	
	public AutorResponse(Autor entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.descricao = entity.getDescricao();
		this.dataCriacao = entity.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	@Override
	public String toString() {
		return "AutorResponse [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", dataCriacao=" + dataCriacao + "]";
	}
	
}
