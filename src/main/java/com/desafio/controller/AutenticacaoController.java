package com.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.dto.TokenDTO;
import com.desafio.form.AutenticacaoForm;
import com.desafio.service.AutenticacaoService;

@RestController
@RequestMapping("v1/login")
public class AutenticacaoController {

	@Autowired
	AutenticacaoService autenticacaoService;
	
	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody AutenticacaoForm authForm){
		
		try {
			return ResponseEntity.ok(autenticacaoService.autenticar(authForm));
		}catch (AuthenticationException ae) {
			ae.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
	}


}
