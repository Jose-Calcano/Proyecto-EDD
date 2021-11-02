/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class ListaPedidos {
    public Pedido first;
    public Pedido last;
    public int size;
    
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
    
        public void eliminar(String ped) {
        if (!this.isEmpty()) {
            if (this.first.getPedidoString().equals(ped)) {
                this.first = this.first.next;
                size--;
                JOptionPane.showMessageDialog(null, "Pedido eliminado de la lista de pendientes");
            } else {
                Pedido temp = this.first;
                boolean found = false;
                while (temp.next != null) {
                    if (temp.next.getPedidoString().equals(ped)) {
                        found = true;
                        temp.next = temp.next.next;
                        size--;
                    } else {
                        temp = temp.next;
                    }
                }
                if (found) {
                    JOptionPane.showMessageDialog(null, "Pedido eliminado de la lista de pendientes");
                } else {
                    
                }
            }

        }
    }
}
