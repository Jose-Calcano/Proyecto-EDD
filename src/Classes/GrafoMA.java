package Classes;

/**
 *
 * @author juanc
 */
public class GrafoMA {

    int maxNodos;
    int numVertices;
    int[][] matrizAdy;

    public GrafoMA(int n) {
        this.maxNodos = n;
        this.numVertices = 0;
        this.matrizAdy = new int[n][n];
    }

    public boolean isEmpty() {
        return numVertices == 0;
    }

    public String rutasString(ListaClientes clientes, ListaRestaurantes restaurantes) {
        String rutas = "";
        if (!this.isEmpty()) {
            for (int i = 0; i < maxNodos; i++) {
                for (int j = 0; j < maxNodos; j++) {
                    if (this.matrizAdy[i][j] > 0) {
                        if (i + 1 > clientes.size && j + 1 > clientes.size) {
                            int rest1 = i - clientes.size;
                            int rest2 = j - clientes.size;
                            Restaurante temp1 = restaurantes.first;
                            Restaurante temp2 = restaurantes.first;
                            for (int x = 0; x < rest1; x++) {
                                temp1 = temp1.next;
                            }
                            for (int x = 0; x < rest2; x++) {
                                temp2 = temp2.next;
                            }
                            rutas += Character.toString(temp1.key) + "," + Character.toString(temp2.key) + "," + Integer.toString(this.matrizAdy[i][j]);
                        } else if (i + 1 > clientes.size) {
                            int rest = i - clientes.size;
                            Restaurante temp = restaurantes.first;
                            for (int x = 0; x < rest; x++) {
                                temp = temp.next;
                            }
                            rutas += Character.toString(temp.key) + "," + Integer.toString(j + 1) + "," + Integer.toString(this.matrizAdy[i][j]);
                        } else if (j + 1 > clientes.size) {
                            int rest = j - clientes.size;
                            Restaurante temp = restaurantes.first;
                            for (int x = 0; x < rest; x++) {
                                temp = temp.next;
                            }
                            rutas += Integer.toString(i + 1) + "," + Character.toString(temp.key) + "," + Integer.toString(this.matrizAdy[i][j]);
                        } else {
                            rutas += Integer.toString(i + 1) + "," + Integer.toString(j + 1) + "," + Integer.toString(this.matrizAdy[i][j]);
                        }
                        rutas += "\n";
                    }
                }
            }
        }
        return rutas;

    }

    public void rutaMasCortaDijkstra(Pedido pedido, ListaClientes clientes, ListaRestaurantes restaurantes) {
        int destinoIndex = Integer.parseInt(pedido.llegada) - 1;
        int origenIndex = clientes.size - 1 + restaurantes.getNumOfRestaurant(pedido.salida.charAt(0));
        String ruta = "";
        boolean flag = true;
        int dist = 0;
        for (int i = 0; i < maxNodos; i++) {
            int prueba = this.matrizAdy[origenIndex][i];
            if (prueba > 0 && flag) {
                dist = prueba;
                flag = false;
            } else if (prueba > 0 && prueba < dist) {
                dist = prueba;
            }
        }
    }
}
