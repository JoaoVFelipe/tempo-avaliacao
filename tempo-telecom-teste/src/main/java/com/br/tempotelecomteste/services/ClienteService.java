package com.br.tempotelecomteste.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
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

	public void saveCliente(JSONObject jsonPedido) throws ParseException {
		Cliente cliente = new Cliente();
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date dataFormatada = formato.parse((String) jsonPedido.get("nascimento"));
		cliente.setNascimento(dataFormatada);
		
		cliente.setNome((String) jsonPedido.get("nome"));
		cliente.setTelefone((String) jsonPedido.get("telefone"));
		
		repository.save(cliente);
	}
}
