/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author juanc
 */
public class GrafoLA {
    boolean dirigido;
    int maxNodos;
    int numVertices;
    Lista[] listaAdy;
    
    public GrafoLA(int n, boolean d) {
        this.dirigido = d;
        this.maxNodos = n;
        this.numVertices = 0;
        this.listaAdy = new Lista[n];
    }
    
    public void insertarArista(int i, int j) {
        
    }
    
    public void eliminarArista(int i, int j) {
        
    }
    
    public void insertarVertice(int n) {
        
    }
    
    public void eliminarVertice() {
        
    }
    
    public void imprimirGrafo() {
        
    }
}
