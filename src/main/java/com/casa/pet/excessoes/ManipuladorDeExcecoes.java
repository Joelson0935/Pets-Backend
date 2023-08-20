package com.casa.pet.excessoes;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ManipuladorDeExcecoes {

	@ExceptionHandler(ObjetoNaoEncontrado.class)
	public ResponseEntity<Erro> naoEncontrado(ObjetoNaoEncontrado e, HttpServletRequest request) {
		Erro erro = new Erro(e.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDate.now(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}
