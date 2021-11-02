/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author jose_
 */
public class Nodo {
    int integer;
    Nodo next;

    public Nodo(int integer) {
        this.integer = integer;
        this.next = null;
    }
    /**
     * Description: regresa el valor del integer
     * @return el valor de integer
     */
    public int valorInt(){
        return integer;
    }
    /**
     * Description: regresa el valor del siguiente nodo
     * @return el siguiente nodo
     */
    public Nodo getSiguiente() {
        return next;
    }
}
