package com.casa.pet.servicos.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.casa.pet.excessoes.ObjetoNaoEncontrado;
import com.casa.pet.modelos.Pet;
import com.casa.pet.modelos.dto.PetDTO;
import com.casa.pet.repositorios.PetRepositorio;
import com.casa.pet.servicos.PetServico;

import jakarta.transaction.Transactional;

@Service
public class PetServicoImpl implements PetServico {

	@Autowired
	private PetRepositorio petRepositorio;

	@Override
	public PetDTO guardarEntidade(PetDTO pet) {
		Pet petEntidade = new Pet();
		BeanUtils.copyProperties(pet, petEntidade);
		petRepositorio.save(petEntidade);
		return pet;
	}

	@Transactional
	@Override
	public List<PetDTO> buscarPetPorNome(String nome) {
		List<Pet> pets = petRepositorio.buscarPorNome(nome);
		List<PetDTO> petsDTO = new ArrayList<>();
		pets.forEach(pet -> {
			PetDTO dto = new PetDTO();
			BeanUtils.copyProperties(pet, dto);
			petsDTO.add(dto);
		});

		return petsDTO;
	}

	@Override
	public Page<PetDTO> buscarListaDePets(Pageable pageable) {
		Page<Pet> pets = petRepositorio.findAll(pageable);
		Page<PetDTO> petsDTO = pets.map(pet -> entidadeParaDto(pet));
		return petsDTO;
	}

	@Override
	public List<PetDTO> buscarTodosPetsDoBanco() {
		List<Pet> pets = petRepositorio.findAll();
		List<PetDTO> petsDTO = new ArrayList<>();
		pets.forEach(pet -> {
			PetDTO dto = new PetDTO();
			BeanUtils.copyProperties(pet, dto);
			petsDTO.add(dto);
		});
		return petsDTO;
	}

	@Override
	public PetDTO buscarPetPorId(Integer id) {
		Pet pet = petRepositorio.findById(id).orElseThrow(() -> new ObjetoNaoEncontrado("Pet não encontrado " + id));
		PetDTO dto = new PetDTO();
		BeanUtils.copyProperties(pet, dto);
		return dto;
	}

	@Override
	public Integer buscarTotalDePets() {
		return petRepositorio.buscarTotalDePets();
	}

	private PetDTO entidadeParaDto(Pet pet) {
		PetDTO dto = new PetDTO(pet.getId(), pet.getFoto(), pet.getNome(), pet.getSexo(), pet.getCor(), pet.getRaca());
		return dto;
	}

}
