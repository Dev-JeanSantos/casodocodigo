package br.com.zup.casadocodigo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.CategoriaDTO;
import br.com.zup.casadocodigo.entities.Categoria;
import br.com.zup.casadocodigo.exceptions.BloqueiaDuplicidadeNome;
import br.com.zup.casadocodigo.repositories.CategoriaRepository;
import br.com.zup.casadocodigo.response.CategoriaResponse;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@PersistenceContext
	private EntityManager manager;
	
	
	@Autowired
	private BloqueiaDuplicidadeNome  bloqueiaDuplicidadeNome;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		
		binder.addValidators(bloqueiaDuplicidadeNome);
	}

	@PostMapping
	public void cadastrar(@RequestBody @Valid CategoriaDTO categoriaDTO) {

		Categoria categoria = categoriaDTO.saveAs();

		repository.save(categoria);

	}
	
	@GetMapping
	@Transactional(readOnly = true)
	public List<CategoriaResponse>buscarTodos(){
		
		return manager.createQuery("SELECT c FROM Categoria c", Categoria.class)
				.getResultStream().map(CategoriaResponse::new)
				.collect(Collectors.toList());
		
	}

}
