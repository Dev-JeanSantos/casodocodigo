package br.com.zup.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casadocodigo.entities.Autor;
import br.com.zup.casadocodigo.entities.Categoria;
import br.com.zup.casadocodigo.entities.Livro;
import br.com.zup.casadocodigo.validations.ExistsId;
import br.com.zup.casadocodigo.validations.UniqueValue;

public class LivroDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Já existe Livro com esse titulo cadastrado")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotNull
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco;
	@NotNull
	@Min(100)
	private int numeroPaginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "Já existe Livro com esse ISBN cadastrado")
	private String isbn;
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "id", message = "O Novo livro cadastrado aind não possui categoria cadastrad0(a)")
	private Long idCategoria;
	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName = "id", message = "O Novo livro cadastrado ainda não possui autor(a) cadastrad0(a)")
	private Long idAutor;
	
	public LivroDTO(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotNull String sumario,
			@NotBlank @Min(20) BigDecimal preco, @NotBlank @Min(100) int numeroPaginas, @NotBlank String isbn, @NotNull Long idCategoria, @NotNull Long idAutor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}
	
	//Foi necessário o uso desse unico setter pois sem o mesmo o Jackson não serialiaza a data de publicação.
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	@Override
	public String toString() {
		return "LivroDTO [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco=" + preco
				+ ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao + ", idCategoria="
				+ idCategoria + ", idAutor=" + idAutor + "]";
	}

	public Livro saveAS(EntityManager manager) {		
		
		@NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
		@NotNull Autor autor = manager.find(Autor.class, idAutor);
		
		Assert.state(autor!= null, "VOCE ESTÁ CADASTRANDO UM LIVRO COM UM AUTOR(A) QUE NÃO EXISTE " +idAutor);
		Assert.state(categoria!= null, "VOCE ESTÁ CADASTRANDO UM LIVRO COM UMA CATEGORIA QUE NÃO EXISTE " +idCategoria);
		
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
	}	
	
}
