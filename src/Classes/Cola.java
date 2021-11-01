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

    public boolean isEmpty() {
        return head == null;
    }

    public void empty() {
        this.head = this.tail = null;
        this.size = 0;
    }
    public void encolar(Nodo nuevo){
        if (this.isEmpty()){
            head = tail = nuevo;
        }else{
            tail = nuevo;
        }
        size++;
    } 
    public void desencolar(){
        if (this.isEmpty()){
            System.out.println("La cola esta vacio. ");
        }else if (size == 1){
            this.empty();
        }else{
           size--;
        }
    }
    public String printearCola(){
        if(!this.isEmpty()){
            String printDeCola = "";
            for (int i = 0 ; i < size ; i++){
                Nodo actual = head;
                desencolar();
                printDeCola += actual + ",";
                encolar(actual);
            }
            return printDeCola;
        }
        return null;
    }
}
