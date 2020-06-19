package com.br.tempotelecomteste.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.tempotelecomteste.entidades.cliente.Cliente;
import com.br.tempotelecomteste.services.ClienteService;



@RestController
public class ClienteController {
	
	@Autowired
	ClienteService service;
	
	@RequestMapping(value="/clientes/all" ,method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Cliente> findAllClientes() {
		return service.findAllClientes();
	}
	
}