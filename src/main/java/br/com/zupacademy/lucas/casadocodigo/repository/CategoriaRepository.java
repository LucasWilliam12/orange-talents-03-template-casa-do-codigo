package br.com.zupacademy.lucas.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.zupacademy.lucas.casadocodigo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	@Transactional(readOnly = true)
	Categoria findByNome(String nome);
}
