package br.com.zup.casadocodigo.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String titulo;
	private @NotBlank @Size(max = 500) String resumo;
	private @NotNull String sumario;
	private @NotNull @Min(20) BigDecimal preco;
	private @NotNull @Min(100) int numeroPaginas;
	private @NotBlank String isbn;
	private @Future @NotNull LocalDate dataPublicacao;
	private @NotNull @ManyToOne Categoria categoria;
	private @NotNull @ManyToOne Autor autor;

	
	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotNull String sumario,
			@NotBlank @Min(20) BigDecimal preco, @NotBlank @Min(100) int numeroPaginas, @NotBlank String isbn,
			@Future @NotNull LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
				this.titulo = titulo;
				this.resumo = resumo;
				this.sumario = sumario;
				this.preco = preco;
				this.numeroPaginas = numeroPaginas;
				this.isbn = isbn;
				this.dataPublicacao = dataPublicacao;
				this.categoria = categoria;
				this.autor = autor;
		
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", numero=" + numeroPaginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", categoria=" + categoria + ", autor=" + autor + "]";
	}
	
}
