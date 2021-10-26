/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author juanc
 */
public class ListaPedidos {
    Pedido first;
    Pedido last;
    int size;
    
    public ListaPedidos() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    /**
     * Description: Determina si la lista esta vacia
     * @return "true" si esta vacia, "false" si tiene elementos
     */
    public boolean isEmpty() {
        return first == null;
    }
    /**
     * Description: Añade un pedido al final de la lista
     * @param newPedido el nuevo pedido a añadir
     */
    public void addAtTheEnd(Pedido newPedido) {
        if (this.isEmpty()) {
            first = last = newPedido;
        } else {
            last.next = newPedido;
            last = newPedido;
        }
        size ++;
    }
}
