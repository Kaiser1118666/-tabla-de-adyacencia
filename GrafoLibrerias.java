package grafolistasadyacencia;

// Importamos las librerías que vamos a usar
import java.util.HashMap;    // Para almacenar pares clave-valor (nodo -> lista de conexiones)
import java.util.LinkedList; // Para crear listas enlazadas de manera automática

// GRAFO CON LIBRERÍAS JAVA - Usando las clases que ya vienen en Java
public class GrafoLibrerias {
    
    // Tabla de adyacencia usando HashMap y LinkedList
    // HashMap: almacena cada nodo (clave) con su lista de conexiones (valor)
    // LinkedList: lista que crece automáticamente cuando agregamos elementos
    private HashMap<Integer, LinkedList<Integer>> tabla;
    
    // Constructor - crea un grafo vacío
    public GrafoLibrerias() {
        tabla = new HashMap<>();  // Creamos un HashMap vacío para almacenar nuestros nodos
    }
    
    // Método para conectar dos nodos entre sí
    public void conectar(int a, int b) {
        // Verificamos si el nodo 'a' ya existe en el HashMap
        if (!tabla.containsKey(a)) {
            tabla.put(a, new LinkedList<>());  // Si no existe, lo creamos con una LinkedList vacía
        }
        // Verificamos si el nodo 'b' ya existe en el HashMap
        if (!tabla.containsKey(b)) {
            tabla.put(b, new LinkedList<>());  // Si no existe, lo creamos con una LinkedList vacía
        }
        
        // Agregamos la conexión en ambas direcciones (grafo no dirigido)
        tabla.get(a).add(b);  // Añadimos 'b' a la lista de conexiones de 'a'
        tabla.get(b).add(a);  // Añadimos 'a' a la lista de conexiones de 'b'
    }
    
    // Método para mostrar todas las conexiones del grafo
    public void mostrarConexiones() {
        System.out.println("=== GRAFO CON LIBRERÍAS (HashMap + LinkedList) ===");
        // tabla.keySet() devuelve un conjunto con todas las claves (números de nodo) del HashMap
        for (int nodo : tabla.keySet()) {  // Para cada nodo en el grafo...
            // Mostramos el nodo y su lista completa de conexiones
            System.out.println("Nodo " + nodo + ": " + tabla.get(nodo));
        }
    }
}