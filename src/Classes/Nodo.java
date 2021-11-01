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
    public int valorInt(){
        return integer;
    }
}
