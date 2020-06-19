package com.br.tempotelecomteste.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.tempotelecomteste.entidades.cliente.Cliente;
import com.br.tempotelecomteste.services.ClienteService;



@RestController
public class ClienteController {
	
	@Autowired
	ClienteService service;
	
	@CrossOrigin 
	@GetMapping(value="/clientes/all")
	public ArrayList<Cliente> findAllClientes() {
		return service.findAllClientes();
	}
	
}