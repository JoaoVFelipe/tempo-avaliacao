package com.br.tempotelecomteste.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tempotelecomteste.entidades.cliente.Cliente;
import com.br.tempotelecomteste.repositorios.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;

	@Transactional
	public ArrayList<Cliente> findAllClientes() {
		return (ArrayList<Cliente>) repository.findAll();
	}
}
