package Classes;

import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class GrafoMA {

    int maxNodos;
    int numVertices;
    public int[][] matrizAdy;
    int V;
    Cola queue = new Cola();
    Pila stack = new Pila();
    static int[][] P;
    int INF = 9999;
    

    public GrafoMA(int n) {
        this.maxNodos = n;
        this.numVertices = 0;
        this.matrizAdy = new int[n][n];
    }
    /**
     * Description: revisa si el grafo esta vacio
     * @return true si esta vacio, false si no lo esta
     */
    public boolean isEmpty() {
        return numVertices == 0;
    }
    /**
     * Description: Añade un vertice al grafo
     * @param i indice del primer vertice (vertical)
     * @param j indice del segundo vertice (horizontal)
     * @param value distancia entre los vertices
     */
    public void añadirVertice(int i, int j, int value) {
        if (matrizAdy[i][j] != 0) {
            matrizAdy[i][j] = value;
        } else {
            matrizAdy[i][j] = value;
            numVertices += 1;
        }
    }
    /**
     * Description: Elimina un vertice del grafo
     * @param i indice del primer vertice (vertical)
     * @param j indice del segundo vertice (horizontal)
     */
    public void eliminarVertice(int i, int j) {
        if (matrizAdy[i][j] != 0) {
            matrizAdy[i][j] = 0;
            numVertices -= 1;
        } else {
            JOptionPane.showMessageDialog(null, "No hay un vertice en esta posición.");
        }
    }
    /**
     * Description: Crea el String de rutas con el formato del txt a partir de las listas
     * @param clientes lista de clientes
     * @param restaurantes lista de restaurantes
     * @return String con todas las rutas del grafo en formate del txt
     */
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
    /**
     * Description: Obtiene el valor minimo en el array de distancias de Dijkstra
     * @param revisados array de los nodos ya revisados (definitivos)
     * @param key array de las distancias
     * @return el indice del vertice de la distancia mínima
     */
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
    /**
     * Description: Genera un string con los indices del grafo de la ruta más corta entre dos indices
     * @param origenIndex indice del nodo origen para buscar la ruta
     * @param destinoIndex indice del nodo destino para llegar con la busqueda
     * @return Un String con los indices del grafo correspondientes a la ruta mas corta
     */
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
            i--;
            result += "," + String.valueOf(arr_txt[i]);
            if (i == 0) {
                found = true;
            }
        }
        return result;
    }

    public void bfs(Nodo node) {
        int contador = 0;
        int valorI = 0;
        int valorj = 0;
        queue.encolar(node);
        for (int i = 0; i < this.maxNodos; i++) {
            for (int j = 0; j < this.maxNodos; j++) {
                if (this.matrizAdy[i][j] == node.valorInt() && queue.buscarEnCola(node.valorInt()) == true) {
                    Nodo nodoI = new Nodo(i);
                    valorI = i;
                    System.out.println(nodoI.valorInt());
                    Nodo nodoj = new Nodo(j);
                    System.out.println(nodoj.valorInt());
                    valorj = j;
                    ++contador;
                    break;
                }
            }
        }

        while (queue.tamanoCola() < this.maxNodos) {
            for (int l = 0; l < this.maxNodos; l++) {
                for (int r = 0; r < this.maxNodos; r++) {
                    if (this.matrizAdy[l][r] == valorI && queue.buscarEnCola(valorI) == false) {
                        Nodo nodito = new Nodo(valorI);
                        queue.encolar(nodito);
                        valorI = r;
                    }
                    if (this.matrizAdy[l][r] == valorj && queue.buscarEnCola(valorj) == false) {
                        Nodo noditoParte2 = new Nodo(valorj);
                        queue.encolar(noditoParte2);
                        valorj = l;
                    }
                }
            }
        }
        queue.printearCola();
    }
    
        public void dfs(int node) {
        int valorI = 0;
        int valorj = 0;
        stack.apilar(node);
        for (int i = 0; i < this.maxNodos; i++) {
            for (int j = 0; j < this.maxNodos; j++) {
                if (this.matrizAdy[i][j] == node && stack.buscar(node) == false) {
                    Nodo nodoI = new Nodo(i);
                    valorI = i;
                    System.out.println(nodoI.valorInt());
                    Nodo nodoj = new Nodo(j);
                    System.out.println(nodoj.valorInt());
                    valorj = j;
                    ++contador;
                    break;
                }
            }
        }

        while (stack.tamaño < this.maxNodos) {
            for (int l = 0; l < this.maxNodos; l++) {
                for (int r = 0; r < this.maxNodos; r++) {
                    if (this.matrizAdy[l][r] == valorI && stack.buscar(node) == false) {
                        stack.apilar(valorI);
                        valorI = l;
                    }
                    if (this.matrizAdy[l][r] == valorj && stack.buscar(node) == false) {
                        Nodo noditoParte2 = new Nodo(valorj);
                        queue.encolar(noditoParte2);
                        valorj = l;
                    }
                }
            }
        }
        queue.printearCola();
        
    }
    
        // Implementing floyd warshall algorithm
    public int[][] FloydAlgo(int[][] M) {
            
            for (int k = 0; k < maxNodos; k++) {
                for (int i = 0; i < maxNodos; i++) {
                    for (int j = 0; j < maxNodos; j++) {
                        // to keep track.;
                        if (M[i][k] + M[k][j] < M[i][j]) {
                            M[i][j] = M[i][k] + M[k][j];
                            P[i][j] = k;
                        }
                    }
                }
            }
        return M;
    }

    
    public void printMatrix(int[][] Matrix) {
	System.out.print("\n\t");
	for (int j = 0; j < maxNodos; j++) {
            System.out.print(j + "\t");
		}
		System.out.println();
		for (int j = 0; j < maxNodos; j++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 0; i < maxNodos; i++) {
			System.out.print(i + " |\t");
			for (int j = 0; j < maxNodos; j++) {
				System.out.print(Matrix[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		System.out.println("\n");
	}

    public int[][] cambioACero(int[][] M) {
        for (int i = 0; i < this.maxNodos; i++) {
            for (int vert2 = 0; vert2 < this.maxNodos; vert2++) {
                if (M[i][vert2] == 0) {
                    M[i][vert2] = INF;
                }
            }
        }
        for (int i = 0; i < this.maxNodos; i++) {
            for (int vert2 = 0; vert2 < this.maxNodos; vert2++) {
                if (i == vert2) {
                    M[i][vert2] = 0;
                }
            }

        }
        return M;
    }

}
