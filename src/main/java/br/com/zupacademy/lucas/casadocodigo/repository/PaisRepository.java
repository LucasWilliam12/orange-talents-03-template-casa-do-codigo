package br.com.zupacademy.lucas.casadocodigo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.zupacademy.lucas.casadocodigo.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{
	
	@Transactional(readOnly = true)
	@Query(value = "SELECT p FROM Pais p INNER JOIN Estado e ON p.id = e.pais WHERE LOWER(e.nome) = LOWER(:nome) AND p.id = :idPais")
	Optional<Pais> findByEstadosNome(@Param("nome") String nome, @Param("idPais") Long idPais);
	
}
