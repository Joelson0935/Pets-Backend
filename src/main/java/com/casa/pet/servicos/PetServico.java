package com.casa.pet.servicos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.casa.pet.modelos.Pet;

public interface PetServico {

	String uploadImagem(MultipartFile imagem);

	Pet guardarEntidade(Pet pet);

	List<Pet> buscarPetPorNome(String nome);

	Page<Pet> buscarListaDePets(Pageable pageable);

	List<Pet> buscarTodosPetsDoBanco();

	Pet buscarPetPorId(Integer id);
	
	Integer buscarTotalDePets();
}
