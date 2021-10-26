
package Classes;

/**
 *
 * @author juanc
 */
public class Pedido {
    String llegada;
    String salida;
    String pedido;
    Pedido next;
    
    public Pedido(String llegada, String salida, String pedido) {
        this.llegada = llegada;
        this.salida = salida;
        this.pedido = pedido;
        this.next = null;
    }
}
