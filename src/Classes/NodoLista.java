package Classes;

/**
 *
 * @author juanc
 */
public class NodoLista {
    int clave;
    NodoLista sig;
    public NodoLista(int dato, NodoLista siguiente) {
        this.clave = dato;
        this.sig = siguiente;
    }

}
