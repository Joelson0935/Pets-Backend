package com.casa.pet.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casa.pet.modelos.Pet;
import com.casa.pet.servicos.PetServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pet")
@CrossOrigin(origins = { "https://my-little-pet.netlify.app/", "http://127.0.0.1:5500/" })
public class PetControlador {

	@Autowired
	private PetServico petServico;

	@PostMapping("/guardar-objeto")
	public ResponseEntity<Pet> guardarEntidade(@Valid @RequestBody Pet pet) {
		return new ResponseEntity<Pet>(petServico.guardarEntidade(pet), HttpStatus.CREATED);
	}

	@GetMapping("/buscar-objeto-por-nome")
	public ResponseEntity<List<Pet>> buscarPetPorNome(@RequestParam(name = "nome") String nome) {
		return ResponseEntity.ok(petServico.buscarPetPorNome(nome));
	}

	@GetMapping("/buscar-lista-paginada")
	public ResponseEntity<Page<Pet>> buscarListaDePets(
			@PageableDefault(page = 0, size = 5, sort = "id", direction = Direction.ASC) Pageable pageable) {
		return ResponseEntity.ok(petServico.buscarListaDePets(pageable));
	}

	@GetMapping("/buscar-lista-completa")
	public ResponseEntity<List<Pet>> buscarTodosOsPetsDoBanco() {
		return ResponseEntity.status(HttpStatus.OK).body(petServico.buscarTodosPetsDoBanco());
	}

	@GetMapping("/buscar-total-pets")
	public ResponseEntity<Integer> buscarTotalDePets() {
		return ResponseEntity.status(HttpStatus.OK).body(petServico.buscarTotalDePets());
	}

	@GetMapping("/buscar-pet-por-id/{id}")
	public ResponseEntity<Pet> buscarPetPorId(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(petServico.buscarPetPorId(id));
	}
}
