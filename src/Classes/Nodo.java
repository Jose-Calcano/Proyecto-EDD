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

    Object info;
    Nodo next;

    public Nodo(Object info) {
        this.info = info;
        this.next = null;
    }
}
