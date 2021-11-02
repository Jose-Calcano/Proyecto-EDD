
package Classes;

/**
 *
 * @author juanc
 */
public class ListaClientes {
    public Cliente first;
    public Cliente last;
    public int size;
    
    public ListaClientes() {
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
     * Description: Vacia la lista de clientes
     */
    public void empty() {
        this.first = this.last = null;
        this.size = 0;
    }
    /**
     * Description añade un cliente al final de la lista
     * @param newCliente cliente nuevo a añadir
     */
    public void addAtTheEnd(Cliente newCliente) {
        if (this.isEmpty()) {
            first = last = newCliente;
        } else {
            last.next = newCliente;
            this.last = newCliente;
        }
        this.size ++;
    }
}
