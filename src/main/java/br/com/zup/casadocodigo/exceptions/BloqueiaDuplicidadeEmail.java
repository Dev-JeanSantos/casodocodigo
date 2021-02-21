package br.com.zup.casadocodigo.exceptions;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.dto.AutorDTO;
import br.com.zup.casadocodigo.entities.Autor;
import br.com.zup.casadocodigo.repositories.AutorRepository;

@Component
public class BloqueiaDuplicidadeEmail implements Validator{
	
	@Autowired
	private AutorRepository repository;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return AutorDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		
		AutorDTO autorDTO = (AutorDTO) target;
		Optional<Autor> talvezAutor = repository.findByEmail(autorDTO.getEmail());
		
		if(talvezAutor.isPresent()) {
			errors.rejectValue("email", null, "Já existe Autor(a) com o email " + autorDTO.getEmail() + " cadastrado");
		}
	}
	 
	
}
