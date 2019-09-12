package com.gildosiqueira.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gildosiqueira.cursomc.domain.Pedido;
import com.gildosiqueira.cursomc.repositories.PedidoRepository;
import com.gildosiqueira.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
			"O Objeto não foi encontrado! Id: "+ id + ", Tipo: " + Pedido.class.getName()));
	}
}
