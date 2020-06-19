import { Component, OnInit } from '@angular/core';
import { ClienteService } from 'src/app/services/cliente.service';
import { Cliente } from 'src/app/models/cliente';

@Component({
  selector: 'app-cliente',
  templateUrl: 'cliente.component.html',
  styleUrls: ['cliente.component.css']
})
export class ClienteComponent implements OnInit{
  listaClientes: Cliente[] = [];

  constructor(private clienteService: ClienteService) {
  }

  ngOnInit() {
    this.getClientes();
  }

  // Chama o serviço para obter todos os clientes
  getClientes() {
    this.clienteService.getClientes().subscribe((clientes: Cliente[]) => {
      this.listaClientes = clientes;
    });
  }
}

