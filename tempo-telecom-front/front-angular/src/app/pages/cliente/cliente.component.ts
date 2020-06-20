import { Component, OnInit } from '@angular/core';
import { ClienteService } from 'src/app/services/cliente.service';
import { Cliente } from 'src/app/models/cliente';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cliente',
  templateUrl: 'cliente.component.html',
  styleUrls: ['cliente.component.css']
})
export class ClienteComponent implements OnInit{
  listaClientes: Cliente[] = [];

  constructor(private router: Router, private clienteService: ClienteService) {
  }

  ngOnInit() {
    this.getClientes();
  }

  // Chama o serviço para obter todos os clientes
  getClientes() {
    this.clienteService.getClientes().subscribe((clientes: Cliente[]) => {
      this.listaClientes =  clientes.map(cliente => {
        cliente.dataFormatada = new Date(cliente.nascimento).toDateString();
        return cliente;
      })
    });
  }

  abrirPaginaCadastro(){
    this.router.navigate(['/clientes/cadastro'])
  }
}

