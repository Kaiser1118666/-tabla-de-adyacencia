
package legrafos;


import java.util.LinkedList;    // Importar LinkedList para listas de adyacencia
import java.util.HashMap;       // Importar HashMap para tabla de vértices
import java.util.Map;           // Importar Map para manejar entradas

public class GrafoConLibrerias {
    // HashMap: guarda cada vértice como clave y su lista de conexiones como valor
    private Map<Integer, LinkedList<Integer>> listaAdyacencia;

    public GrafoConLibrerias() {
        // Crear nuevo HashMap vacío para almacenar el grafo
        listaAdyacencia = new HashMap<>();
    }

    // Método para agregar un vértice al grafo
    public void agregarVertice(int vertice) {
        // putIfAbsent: agrega el vértice solo si no existe
        // new LinkedList<>(): crea lista vacía para sus conexiones
        listaAdyacencia.putIfAbsent(vertice, new LinkedList<>());
    }

    // Método para conectar dos vértices (crear arista)
    public void agregarArista(int origen, int destino) {
        // get(origen): obtiene la lista de conexiones del vértice origen
        // add(destino): agrega el vértice destino a esa lista
        listaAdyacencia.get(origen).add(destino);
        
        // get(destino): obtiene la lista de conexiones del vértice destino  
        // add(origen): agrega el vértice origen a esa lista (grafo no dirigido)
        listaAdyacencia.get(destino).add(origen);
    }

    // Método para mostrar todas las conexiones del grafo
    public void mostrarConexiones() {
        System.out.println("Lista de Adyacencia (CON Librerías):");
        
        // entrySet(): obtiene todas las parejas vértice-lista del HashMap
        for (Map.Entry<Integer, LinkedList<Integer>> entrada : listaAdyacencia.entrySet()) {
            // getKey(): obtiene el número del vértice
            System.out.print(entrada.getKey() + " -> ");
            
            // getValue(): obtiene la LinkedList de vértices conectados
            // for-each: recorre cada vértice en la lista de conexiones
            for (int vecino : entrada.getValue()) {
                System.out.print(vecino + " ");
            }
            System.out.println();  // Salto de línea después de cada vértice
        }
    }

    public static void main(String[] args) {
        // Crear instancia del grafo
        GrafoConLibrerias grafo = new GrafoConLibrerias();
        
        // Agregar vértices al grafo
        grafo.agregarVertice(1);  // Agrega vértice 1
        grafo.agregarVertice(2);  // Agrega vértice 2
        grafo.agregarVertice(3);  // Agrega vértice 3
        grafo.agregarVertice(4);  // Agrega vértice 4
        
        // Crear conexiones entre vértices
        grafo.agregarArista(1, 2);  // Conectar vértice 1 con vértice 2
        grafo.agregarArista(1, 3);  // Conectar vértice 1 con vértice 3
        grafo.agregarArista(2, 4);  // Conectar vértice 2 con vértice 4
        grafo.agregarArista(3, 4);  // Conectar vértice 3 con vértice 4
        
        // Mostrar todas las conexiones del grafo
        grafo.mostrarConexiones();
    }
}