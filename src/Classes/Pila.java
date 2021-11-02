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

    public void apilar(int s ) {
        Nodo newNode = new Nodo(s);
        newNode.next = this.cima;
        this.cima = newNode;
        this.tamaño++;
    }

    public void desapilar() {
        this.cima = this.cima.next;
        this.tamaño--;
    }

    
    public boolean buscar(int referencia){
        // Crea una copia de la pila.
        Nodo aux = cima;
        // Bandera para verificar si existe el elemento a buscar.
        boolean existe = false;
        // Recorre la pila hasta llegar encontrar el nodo o llegar al final
        // de la pila.
        while(existe != true && aux != null){
            // Compara si el valor del nodo es igual que al de referencia.
            if (referencia == aux.valorInt()) {
                // Cambia el valor de la bandera.
                existe = true;
            }
            else{
                // Avanza al siguiente nodo.
                aux = aux.getSiguiente();
            }
        }
        // Retorna el valor de la bandera.
        return existe;
}
}
