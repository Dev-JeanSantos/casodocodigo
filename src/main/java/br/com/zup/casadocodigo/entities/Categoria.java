package br.com.zup.casadocodigo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Deprecated
	public Categoria() {
		
	}

	@NotBlank
	private String nome;
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}
}
