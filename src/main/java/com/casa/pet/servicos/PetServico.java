package com.casa.pet.servicos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.casa.pet.modelos.Pet;

public interface PetServico {

	Pet guardarEntidade(Pet pet);

	List<Pet> buscarPetPorNome(String nome);

	Page<Pet> buscarListaDePets(Pageable pageable);

	List<Pet> buscarTodosPetsDoBanco();

	Pet buscarPetPorId(Integer id);

	Integer buscarTotalDePets();
}
