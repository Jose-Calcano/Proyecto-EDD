
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
}
