package com.gildosiqueira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gildosiqueira.cursomc.domain.Cliente;
import com.gildosiqueira.cursomc.repositories.ClienteRepository;
import com.gildosiqueira.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"O Objeto não foi encontrado! Id: "+ id + ", Tipo: " + Cliente.class.getName()));
	}
}
