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

	/**
	 * Busca todos os clientes
	 * 
	 * */
	@Transactional
	public ArrayList<Cliente> findAllClientes() {
		return (ArrayList<Cliente>) repository.findAll();
	}

	
	/**
	 * Salva cliente
	 * 
	 * @param jsonCliente
	 * 				JSONObject com os dados do cliente
	 * 
	 * @return cliente salvo em caso de sucesso, ou null em caso de erro
	 * 
	 * */
	public Cliente saveCliente(JSONObject jsonCliente) {
		Cliente cliente = new Cliente();
		try {
			//Formata data de nascimento
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			Date dataFormatada = formato.parse((String) jsonCliente.get("nascimento"));
			cliente.setNascimento(dataFormatada);
			
			//Seta nome e telefone
			cliente.setNome((String) jsonCliente.get("nome"));
			cliente.setTelefone((String) jsonCliente.get("telefone"));
			
			//Salva
			return repository.save(cliente);
		} 
		catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}
}
