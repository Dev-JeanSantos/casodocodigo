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

import br.com.zup.casadocodigo.dto.AutorDTO;
import br.com.zup.casadocodigo.entities.Autor;
import br.com.zup.casadocodigo.exceptions.BloqueiaDuplicidadeEmail;
import br.com.zup.casadocodigo.repositories.AutorRepository;
import br.com.zup.casadocodigo.response.AutorResponse;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository repository;
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private BloqueiaDuplicidadeEmail bloqueiaDuplicidadeEmail;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(bloqueiaDuplicidadeEmail);
	}
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid AutorDTO autorDTO) {		
		Autor autor = autorDTO.saveAuto();
		repository.save(autor);		
	}
	
	@GetMapping
	@Transactional(readOnly = true)
	public List<AutorResponse> buscarTodos(){
		
		return manager.createQuery("SELECT a FROM Autor a", Autor.class)
			.getResultStream().map(AutorResponse::new)
			.collect(Collectors.toList());
		
	}
	

}
