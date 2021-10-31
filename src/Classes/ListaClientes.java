
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
    
    public boolean isEmpty() {
        return null == this.first;
    }
    
    public void empty() {
        this.first = this.last = null;
        this.size = 0;
    }
    
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
