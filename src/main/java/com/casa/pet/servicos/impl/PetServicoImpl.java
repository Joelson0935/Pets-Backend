package com.casa.pet.servicos.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.casa.pet.excessoes.ObjetoNaoEncontrado;
import com.casa.pet.modelos.Pet;
import com.casa.pet.repositorios.PetRepositorio;
import com.casa.pet.servicos.PetServico;

import jakarta.transaction.Transactional;

@Service
public class PetServicoImpl implements PetServico {

	@Autowired
	private PetRepositorio petRepositorio;

	@Override
	public Pet guardarEntidade(Pet pet) {
		return petRepositorio.save(pet);
	}

	@Transactional
	@Override
	public List<Pet> buscarPetPorNome(String nome) {
		return petRepositorio.buscarPorNome(nome);
	}

	@Override
	public Page<Pet> buscarListaDePets(Pageable pageable) {
		Page<Pet> pets = petRepositorio.findAll(pageable);
		return pets;
	}

	@Override
	public List<Pet> buscarTodosPetsDoBanco() {
		return petRepositorio.findAll();
	}

	@Override
	public Pet buscarPetPorId(Integer id) {
		Pet pet = petRepositorio.findById(id).orElseThrow(() -> new ObjetoNaoEncontrado("Pet não encontrado " + id));
		return pet;
	}

	@Override
	public Integer buscarTotalDePets() {
		return petRepositorio.buscarTotalDePets();
	}

}
