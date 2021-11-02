
package Classes;

/**
 *
 * @author juanc
 */
public class Pedido {
    public String llegada;
    public String salida;
    public String pedido;
    public Pedido next;
    
    public Pedido(String llegada, String salida, String pedido) {
        this.llegada = llegada;
        this.salida = salida;
        this.pedido = pedido;
        this.next = null;
    }
    /**
     * Description: Ordena los atributos de el pedido en forma del txt
     * @return los atributos ordenados en un string separados por comas
     */
    public String getPedidoString() {
        String res = this.llegada + "," + this.salida + "," + this.pedido;
        return res;
    }
}
