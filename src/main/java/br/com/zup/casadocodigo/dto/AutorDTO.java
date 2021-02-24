package br.com.zup.casadocodigo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casadocodigo.entities.Autor;
import br.com.zup.casadocodigo.entities.Livro;

public class AutorDTO {
	
	@NotBlank(message = "O campo nome não deve ser vazio")
	private String nome;
	@NotBlank(message = "O campo email não deve ser vazio")
	@Email(message = "Email inválido")
	private String email;
	@NotBlank(message = "O campo descrição não deve ser vazio")
	@Size(max = 400, message = "O campo descrição não deve ultrapasar 400 caracteres")
	private String descricao;
	
	@OneToMany(mappedBy = "autor")
	private List<Livro> livros = new ArrayList<>();
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
	public List<Livro> getLivros() {
		return livros;
	}

	public Autor saveAuto() {
		
		return new Autor(nome, email, descricao);
	}
	
}
