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

    Restaurante first;
    Restaurante last;
    int size;

    public ListaRestaurantes() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return null == this.first;
    }

    public void empty() {
        this.first = this.last = null;
        this.size = 0;
    }

    public void addAtTheEnd(Restaurante newRestaurante) {
        if (this.isEmpty()) {
            first = last = newRestaurante;
        } else {
            last.next = newRestaurante;
            this.last = newRestaurante;
        }
        this.size++;
    }

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
