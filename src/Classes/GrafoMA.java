package Classes;

import javax.swing.JOptionPane;

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

    public void añadirVertice(int i, int j, int value) {
        if (matrizAdy[i][j] != 0) {
            matrizAdy[i][j] = value;
        } else {
            matrizAdy[i][j] = value;
            numVertices += 1;
        }
    }

    public void eliminarVertice(int i, int j) {
        if (matrizAdy[i][j] != 0) {
            matrizAdy[i][j] = 0;
            numVertices -= 1;
        } else {
            JOptionPane.showMessageDialog(null, "No hay un vertice en esta posición.");
        }
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

    public int getMinimumVertex(boolean[] revisados, int[] key) {
        int minKey = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i < this.maxNodos; i++) {
            if (revisados[i] == false && minKey > key[i]) {
                minKey = key[i];
                vertex = i;
            }
        }
        return vertex;
    }

    public int[] rutaMasCortaDijkstra(int origenIndex) {
        boolean[] spt = new boolean[this.maxNodos];
        int[] distance = new int[this.maxNodos];
        int inf = Integer.MAX_VALUE;
        for (int i = 0; i < this.maxNodos; i++) {
            distance[i] = inf;
        }
        distance[origenIndex] = 0;
        for (int i = 0; i < this.maxNodos; i++) {
            int vert1 = this.getMinimumVertex(spt, distance);
            spt[vert1] = true;
            for (int vert2 = 0; vert2 < this.maxNodos; vert2++) {
                if (this.matrizAdy[vert1][vert2] > 0) {
                    if (spt[vert2] == false && this.matrizAdy[vert1][vert2] != inf) {
                        int newKey = matrizAdy[vert1][vert2] + distance[vert1];
                        if (newKey < distance[vert2]) {
                            distance[vert2] = newKey;
                        }
                    }
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        GrafoMA grafo = new GrafoMA(5);
        grafo.añadirVertice(0, 1, 2);
        grafo.añadirVertice(2, 4, 4);
        grafo.añadirVertice(0, 2, 3);
        grafo.añadirVertice(1, 4, 22);
        int[] rutas = grafo.rutaMasCortaDijkstra(0);
        for (int i = 0; i < rutas.length; i++) {
            System.out.println(rutas[i]);
        }

    }
}
