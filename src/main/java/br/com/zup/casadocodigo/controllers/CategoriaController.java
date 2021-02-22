package br.com.zup.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.CategoriaDTO;
import br.com.zup.casadocodigo.entities.Categoria;
import br.com.zup.casadocodigo.exceptions.BloqueiaDuplicidadeNome;
import br.com.zup.casadocodigo.repositories.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
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
}
