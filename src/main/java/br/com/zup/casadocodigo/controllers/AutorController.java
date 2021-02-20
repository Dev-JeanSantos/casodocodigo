package br.com.zup.casadocodigo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.dto.AutorDTO;
import br.com.zup.casadocodigo.entities.Autor;
import br.com.zup.casadocodigo.repositories.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository repository;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid AutorDTO autorDTO) {
		
		Autor autor = autorDTO.saveAuto();
		
		repository.save(autor);
		
		
	}
}
