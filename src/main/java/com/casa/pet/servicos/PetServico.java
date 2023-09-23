package com.casa.pet.servicos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.casa.pet.modelos.dto.PetDTO;

public interface PetServico {

	PetDTO guardarEntidade(PetDTO pet);

	List<PetDTO> buscarPetPorNome(String nome);

	Page<PetDTO> buscarListaDePets(Pageable pageable);

	List<PetDTO> buscarTodosPetsDoBanco();

	PetDTO buscarPetPorId(Integer id);

	Integer buscarTotalDePets();
}
