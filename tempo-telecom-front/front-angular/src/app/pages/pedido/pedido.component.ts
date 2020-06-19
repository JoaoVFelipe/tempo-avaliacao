import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PedidosService } from 'src/app/services/pedidos.service';
import { Pedido } from 'src/app/models/pedido';

@Component({
  selector: 'app-pedido',
  templateUrl: 'pedido.component.html',
  styleUrls: ['pedido.component.css']
})
export class PedidoComponent {
  listaPedidos: Pedido[];

  constructor(private router: Router, private pedidoService: PedidosService) {
    this.getPedidos();
  }

  // Chama o serviço para obter todos os clientes
  getPedidos() {
    this.pedidoService.getPedidos().subscribe((pedidos: Pedido[]) => {
      this.listaPedidos = pedidos;
    });
  }

  abrirPaginaCadastro(){
    this.router.navigate(['/pedidos/cadastro'])
  }
}
