package br.com.zupacademy.lucas.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.lucas.casadocodigo.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
