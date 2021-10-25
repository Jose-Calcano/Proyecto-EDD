
package Classes;

/**
 *
 * @author juanc
 */
public class Pedido {
    String salida;
    String llegada;
    String pedido;
    Pedido next;
    
    public Pedido(String salida, String llegada, String pedido) {
        this.salida = salida;
        this.llegada = llegada;
        this.pedido = pedido;
        this.next = null;
    }
}
