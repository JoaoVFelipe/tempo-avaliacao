import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ClienteComponent } from './pages/cliente/cliente.component';
import { ProdutoComponent } from './pages/produto/produto.component';
import { PedidoComponent } from './pages/pedido/pedido.component';
import { PedidoCadastroComponent } from './pages/pedido/pedido-cadastro/pedido.cadastro.component';
import { ProdutoCadastroComponent } from './pages/produto/produto-cadastro/produto.cadastro.component';
import { ClienteCadastroComponent } from './pages/cliente/cliente-cadastro/cliente.cadastro.component';


const routes: Routes = [ 
  { path: '', component: HomeComponent },
  { path: 'clientes', component: ClienteComponent },
  { path: 'produtos', component: ProdutoComponent },
  { path: 'pedidos', component: PedidoComponent },
  { path: 'clientes/cadastro', component: ClienteCadastroComponent },
  { path: 'produtos/cadastro', component: ProdutoCadastroComponent },
  { path: 'pedidos/cadastro', component: PedidoCadastroComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
}
