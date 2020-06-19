package com.br.tempotelecomteste.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.br.tempotelecomteste.services.ClienteService;
import com.br.tempotelecomteste.services.PedidosService;



@RestController
public class PedidosController {
	
	@Autowired
	PedidosService service;
	
	
}