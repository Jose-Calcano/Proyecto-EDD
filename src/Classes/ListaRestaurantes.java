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
public class ListaRestaurantes {

    public Restaurante first;
    public Restaurante last;
    public int size;

    public ListaRestaurantes() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    /**
     * Description: revisa si la lista esta vacia
     * @return true si esta vacia, false si no lo esta
     */
    public boolean isEmpty() {
        return null == this.first;
    }
    /**
     * Description: vacia la lista
     */
    public void empty() {
        this.first = this.last = null;
        this.size = 0;
    }
    /**
     * Description: Añade un restaurante al final de la lista
     * @param newRestaurante el nuevo restaurante que añadir
     */
    public void addAtTheEnd(Restaurante newRestaurante) {
        if (this.isEmpty()) {
            first = last = newRestaurante;
        } else {
            last.next = newRestaurante;
            this.last = newRestaurante;
        }
        this.size++;
    }
    /**
     * Description: Busca el valor de indice para el grafo de la key dada
     * @param key key del restaurante
     * @return numero de indice correspondiente en el grafo
     */
    public int getNumOfRestaurant(char key) {
        Restaurante temp = this.first;
        int count = 1;
        while (temp.key != key) {
            count += 1;
            temp = temp.next;
        }
        return count;
    }

}
