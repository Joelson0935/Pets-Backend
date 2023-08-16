package com.casa.pet.servicos.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.casa.pet.excessoes.PetNaoEncontrado;
import com.casa.pet.modelos.Pet;
import com.casa.pet.repositorios.PetRepositorio;
import com.casa.pet.servicos.PetServico;

@Service
public class PetServicoImpl implements PetServico {

	@Autowired
	private PetRepositorio petRepositorio;

	public String uploadImagem(MultipartFile imagem) {
		try {
			if (!imagem.isEmpty()) {
				File caminho = new File("src\\main\\resources\\static");
				byte[] bytes = imagem.getBytes();
				Path path = Paths.get(caminho + "\\" + imagem.getOriginalFilename());
				Files.write(path, bytes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imagem.getOriginalFilename();
	}

	@Override
	public Pet guardarEntidade(Pet pet) {
		return petRepositorio.save(pet);
	}

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
		Pet pet = petRepositorio.findById(id).orElseThrow(() -> new PetNaoEncontrado("Pet não encontrado " + id));
		return pet;
	}

	@Override
	public Integer buscarTotalDePets() {
		return petRepositorio.buscarTotalDePets();
	}

	public String buscarFoto() {
		return null;
	}

}
