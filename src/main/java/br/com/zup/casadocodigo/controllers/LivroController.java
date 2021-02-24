package br.com.zup.casadocodigo.controllers;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.LivroDTO;
import br.com.zup.casadocodigo.entities.Livro;
import br.com.zup.casadocodigo.response.LivroResponse;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@PersistenceContext
	EntityManager manager;
	
	@PostMapping
	@Transactional
	public String criar(@RequestBody @Valid LivroDTO livroDTO) {
		
		Livro livro = livroDTO.saveAS(manager);
		manager.persist(livro);

		return livro.toString();

	}
	
	@GetMapping
	@Transactional(readOnly = true)
	public List<LivroResponse> buscarLivros(){
		
		return manager.createQuery("select l from Livro l", Livro.class)
                .getResultStream().map(LivroResponse::new).collect(Collectors.toList());
	}
}
