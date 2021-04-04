package br.com.zupacademy.lucas.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.zupacademy.lucas.casadocodigo.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

	@Transactional(readOnly = true)
	Autor findByEmail(String value);
	
}
