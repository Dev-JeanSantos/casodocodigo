package br.com.zup.casadocodigo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;
	
	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros = new ArrayList<>();
	
	@Deprecated
	public Categoria() {
		
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public List<Livro> getLivros() {
		return livros;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}
}
