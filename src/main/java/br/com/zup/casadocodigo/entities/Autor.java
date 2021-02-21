package br.com.zup.casadocodigo.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_autor")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;
	
	private LocalDateTime dataCriacao = LocalDateTime.now();	
	
	@Deprecated
	public Autor() {
		
	}

	public Autor(String nome, String email, String descricao) {

		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
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
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", dataCriacao="
				+ dataCriacao + "]";
	}
	
}
