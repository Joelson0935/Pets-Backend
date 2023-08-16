package com.casa.pet.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.casa.pet.modelos.Pet;

@Repository
public interface PetRepositorio extends JpaRepository<Pet, Integer> {

	@Query("select p from Pet p where p.nome like %:nome%")
	List<Pet> buscarPorNome(String nome);
	
	@Query("select count(p) from Pet p")
	Integer buscarTotalDePets();
}
