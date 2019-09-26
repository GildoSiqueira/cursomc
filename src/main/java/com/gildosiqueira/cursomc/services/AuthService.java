package com.gildosiqueira.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gildosiqueira.cursomc.domain.Cliente;
import com.gildosiqueira.cursomc.repositories.ClienteRepository;
import com.gildosiqueira.cursomc.services.exception.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Cliente cliente = clienteRepository.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado!");
		}
		
		String newPass = NewPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
		
	}

	private String NewPassword() {
		char[] vet = new char[10];
		for (int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {

		int opt = rand.nextInt(3);
		if (opt == 0) { // gera um digito
			return (char) (rand.nextInt(10) + 48);
		} 
		else if (opt == 1) { // gera uma letra maiuscula 
			return (char) (rand.nextInt(26) + 65);
		} 
		else { // gerar letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
	}
}







