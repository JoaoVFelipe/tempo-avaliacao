import { Cliente } from './cliente';
import { Produto } from './produto';

export interface Pedido {
    id: number;
    cliente: Cliente;
    produtos: Produto[];
    valor: number;
}