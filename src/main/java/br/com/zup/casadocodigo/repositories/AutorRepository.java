package br.com.zup.casadocodigo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.casadocodigo.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

	Optional<Autor> findByEmail(String email);	
}
