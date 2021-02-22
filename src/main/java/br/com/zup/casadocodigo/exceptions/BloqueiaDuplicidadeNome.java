package br.com.zup.casadocodigo.exceptions;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.dto.CategoriaDTO;
import br.com.zup.casadocodigo.entities.Categoria;
import br.com.zup.casadocodigo.repositories.CategoriaRepository;

@Component
public class BloqueiaDuplicidadeNome implements  Validator{
	
	@Autowired
	private CategoriaRepository repository;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return CategoriaDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		CategoriaDTO categoriaDTO = (CategoriaDTO) target;
		Optional<Categoria> talvezCategoria = repository.findByNome(categoriaDTO.getNome());
		
		if(talvezCategoria.isPresent()) {
			errors.rejectValue("nome", "", "Já existe categoria com o nome " + categoriaDTO.getNome() + " cadastrada");
		}
		
	}

}
