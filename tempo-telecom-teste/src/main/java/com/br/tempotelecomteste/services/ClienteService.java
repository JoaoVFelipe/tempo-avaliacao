package com.br.tempotelecomteste.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.tempotelecomteste.repositorios.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
}
