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

    public String rutaMasCortaDijkstra(int origenIndex, int destinoIndex) {
        boolean[] spt = new boolean[this.maxNodos];
        int[] distance = new int[this.maxNodos];
        int[] etiquetas = new int[this.maxNodos];
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
                            etiquetas[vert2] = vert1;
                        }
                    }
                }
            }
        }
        int index = destinoIndex;
        String ruta = String.valueOf(index);
        while (index != origenIndex) {
            ruta += "," + String.valueOf(etiquetas[index]);
            index = etiquetas[index];
            
        }
        String[] arr_txt = ruta.split(",");
        int i = arr_txt.length - 1;
        String result = String.valueOf(arr_txt[i]);
        boolean found = false;
        while (!found) {
            i --;
            result += "," + String.valueOf(arr_txt[i]);
            if (i == 0) {
                found = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GrafoMA graph = new GrafoMA(5);
        graph.añadirVertice(0, 1, 4);
        graph.añadirVertice(0, 2, 5);
        graph.añadirVertice(2, 1, 1);
        graph.añadirVertice(1, 3, 4);
        graph.añadirVertice(1, 4, 10);
        graph.añadirVertice(3, 4, 3);
        graph.añadirVertice(4, 0, 20);
        String ruta = graph.rutaMasCortaDijkstra(1, 0);
        System.out.println(ruta);
    }

}
