package grafolistasadyacencia;

// GRAFO CON LISTA ENLAZADA MANUAL - Sin usar librerías de Java
public class GrafoManual {
    
    // Clase interna Nodo - representa cada elemento de la lista enlazada
    class Nodo {
        int valor;          // Almacena el número del nodo al que estamos conectados
        Nodo siguiente;     // Puntero/referencia al siguiente nodo en la lista
        
        // Constructor - se ejecuta cuando creamos un nuevo nodo
        public Nodo(int valor) {
            this.valor = valor;     // Guardamos el valor del nodo destino
            this.siguiente = null;  // Inicializamos el siguiente nodo como null (no apunta a nada)
        }
    }
    
    // Tabla de adyacencia - es un arreglo donde cada posición tiene una lista enlazada
    private Nodo[] tabla;
    
    // Constructor del grafo - crea un grafo con cierta cantidad de nodos
    public GrafoManual(int tamaño) {
        tabla = new Nodo[tamaño];  // Creamos un arreglo del tamaño especificado
    }
    
    // Método para conectar dos nodos entre sí
    public void conectar(int a, int b) {
        // CONEXIÓN a -> b: agregar el nodo b a la lista de conexiones del nodo a
        Nodo nuevoB = new Nodo(b);      // Creamos un nuevo nodo que representa la conexión a b
        nuevoB.siguiente = tabla[a];    // Hacemos que el nuevo nodo apunte al primer nodo actual de la lista
        tabla[a] = nuevoB;              // Actualizamos la cabeza de la lista para que sea el nuevo nodo
        
        // CONEXIÓN b -> a: agregar el nodo a a la lista de conexiones del nodo b (grafo no dirigido)
        Nodo nuevoA = new Nodo(a);      // Creamos un nuevo nodo que representa la conexión a a
        nuevoA.siguiente = tabla[b];    // Hacemos que el nuevo nodo apunte al primer nodo actual de la lista
        tabla[b] = nuevoA;              // Actualizamos la cabeza de la lista para que sea el nuevo nodo
    }
    
    // Método para mostrar todas las conexiones del grafo
    public void mostrarConexiones() {
        System.out.println("=== GRAFO MANUAL (Lista Enlazada Manual) ===");
        // Recorremos cada nodo del grafo (cada posición del arreglo)
        for (int i = 0; i < tabla.length; i++) {
            System.out.print("Nodo " + i + " -> ");  // Mostramos el número del nodo actual
            Nodo actual = tabla[i];                  // Obtenemos la cabeza de la lista de conexiones de este nodo
            // Recorremos toda la lista enlazada de este nodo
            while (actual != null) {                 // Mientras no lleguemos al final de la lista (null)
                System.out.print(actual.valor + " "); // Mostramos el valor del nodo conectado
                actual = actual.siguiente;           // Avanzamos al siguiente nodo en la lista
            }
            System.out.println();  // Salto de línea para separar cada nodo
        }
    }
}