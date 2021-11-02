package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose_
 */
public class Cola {

    public Nodo head;
    public Nodo tail;
    public int size;

    public Cola() {
        this.head = this.tail = null;
        this.size = 0;
    }
    /**
     * Description: Revisa si la cola esta vacia
     * @return true si esta vacia, false si no lo esta
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * Description: vacia la cola
     */
    public void empty() {
        this.head = this.tail = null;
        this.size = 0;
    }
    /**
     * Description: Añade un nodo a la cola de la Cola
     * @param nuevo el nodo a añadir
     */
    public void encolar(Nodo nuevo){
        if (this.isEmpty()){
            head = tail = nuevo;
        }else{
            tail = nuevo;
        }
        size++;
    } 
    /**
     * Description: Elimina el elemento de la cola
     */
    public void desencolar(){
        if (this.isEmpty()){
            System.out.println("La cola esta vacio. ");
        }else if (size == 1){
            this.empty();
        }else{
           size--;
        }
    }
    /**
     * Description: Genera un string con los elementos de la cola
     * @return El string de elementos
     */
    public String printearCola(){
        if(!this.isEmpty()){
            String printDeCola = "";
            for (int i = 0 ; i < size ; i++){
                Nodo actual = head;
                desencolar();
                printDeCola += actual.valorInt() + ",";
                encolar(actual);
            }
            return printDeCola;
        }
        return null;
    }
    /**
     * Description: Regresa el tamaño de la cola
     * @return el tamaño como entero
     */
    public int tamanoCola(){
        return size;
    }
    /**
     * Description: Revisa si un nodo con el elemento "numerito" esta en la cola
     * @param numerito el elemento del nodo
     * @return true si se encuentra en la cola, false si no se encuentra en ella
     */
    public boolean buscarEnCola(int numerito) {
        boolean boleano = false;
        for (int i = 0; i < size; i++) {
            Nodo actual = head;
            desencolar();
            if (numerito == actual.valorInt()) {
                boleano = true;
            }
            encolar(actual);
        }

        if (boleano == true) {
            return true;
        } else {
            return boleano;
        }
    }
}
