package br.com.zupacademy.lucas.casadocodigo.controllers.livro;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.lucas.casadocodigo.controllers.exceptions.NotFoundException;
import br.com.zupacademy.lucas.casadocodigo.dto.LivroDetalhadoDto;
import br.com.zupacademy.lucas.casadocodigo.dto.LivroResponseDto;
import br.com.zupacademy.lucas.casadocodigo.model.Livro;
import br.com.zupacademy.lucas.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {	
	
	// Repositories
	@Autowired
	private LivroRepository livroRepo;
	
	@GetMapping
	public ResponseEntity<List<LivroResponseDto>> listarLivros(){
		List<Livro> livros = livroRepo.findAll();
		List<LivroResponseDto> livrosDto = livros.stream().map(LivroResponseDto::new).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(livrosDto);
		
	}
	
	@GetMapping(value = "/detalhar/{id}")
	public ResponseEntity<LivroDetalhadoDto> detalhar(@PathVariable Long id){
		Livro livro = livroRepo.findById(id).orElseThrow(() -> new NotFoundException("Livro não encontrado, cujo id é: " + id));
		
		LivroDetalhadoDto livroDto = new LivroDetalhadoDto(livro);
		
		return ResponseEntity.ok().body(livroDto);
	}
}
