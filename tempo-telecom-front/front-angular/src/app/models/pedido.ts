import { Cliente } from './cliente';
import { Produto } from './produto';

export interface Pedido {
    id: number;
    cliente: Cliente;
    data: string;
    hora: string;
    produtos: Produto[];
    valor: number;
}