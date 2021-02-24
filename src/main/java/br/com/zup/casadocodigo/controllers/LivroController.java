package br.com.zup.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.LivroDTO;
import br.com.zup.casadocodigo.entities.Livro;

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
}
