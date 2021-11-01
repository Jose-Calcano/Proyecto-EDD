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
public class Pila {

    Nodo cima;
    int tamaño;

    public Pila() {
        this.tamaño = 0;
        this.cima = null;
    }

    public void destructor() {
        while (cima != null) {
            this.cima = cima.next;
        }
        this.tamaño = 0;
    }

    public boolean esVacio() {
        return tamaño == 0;
    }

    public void apilar(String s ) {
        Nodo newNode = new Nodo(s);
        newNode.next = this.cima;
        this.cima = newNode;
        this.tamaño++;
    }

    public void desapilar() {
        this.cima = this.cima.next;
        this.tamaño--;
    }

    public Object cima() {
        return this.cima.info;
    }
}
