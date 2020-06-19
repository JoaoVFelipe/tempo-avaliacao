package com.br.tempotelecomteste.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.br.tempotelecomteste.services.ClienteService;



@RestController
public class ClienteController {
	
	@Autowired
	ClienteService service;
	
	
}