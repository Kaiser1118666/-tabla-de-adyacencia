package grafolistasadyacencia;

// CLASE PRINCIPAL - Punto de entrada del programa
public class Main {
    // Método main - se ejecuta automáticamente cuando iniciamos el programa
    public static void main(String[] args) {
        // Mostrar título del laboratorio
        System.out.println("LABORATORIO: GRAFOS CON LISTAS DE ADYACENCIA\n");
        
        // ========== PARTE 1: LISTA ENLAZADA MANUAL ==========
        System.out.println("1. LISTA ENLAZADA MANUAL:");
        // Crear un grafo manual con 5 nodos (0, 1, 2, 3, 4)
        GrafoManual grafoManual = new GrafoManual(5);
        
        // Crear conexiones entre los nodos
        grafoManual.conectar(0, 1);  // Conectar nodo 0 con nodo 1
        grafoManual.conectar(0, 2);  // Conectar nodo 0 con nodo 2
        grafoManual.conectar(1, 3);  // Conectar nodo 1 con nodo 3
        grafoManual.conectar(2, 4);  // Conectar nodo 2 con nodo 4
        grafoManual.conectar(3, 4);  // Conectar nodo 3 con nodo 4
        
        // Mostrar todas las conexiones del grafo manual
        grafoManual.mostrarConexiones();
        
        // Línea separadora para mejor visualización
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // ========== PARTE 2: CON LIBRERÍAS JAVA ==========
        System.out.println("2. CON LIBRERÍAS JAVA:");
        // Crear un grafo usando librerías (no necesita tamaño inicial)
        GrafoLibrerias grafoLibrerias = new GrafoLibrerias();
        
        // Crear conexiones entre los nodos
        grafoLibrerias.conectar(0, 1);  // Conectar nodo 0 con nodo 1
        grafoLibrerias.conectar(0, 2);  // Conectar nodo 0 con nodo 2
        grafoLibrerias.conectar(1, 3);  // Conectar nodo 1 con nodo 3
        grafoLibrerias.conectar(2, 4);  // Conectar nodo 2 con nodo 4
        grafoLibrerias.conectar(3, 4);  // Conectar nodo 3 con nodo 4
        grafoLibrerias.conectar(1, 4);  // Conectar nodo 1 con nodo 4 (conexión extra)
        
        // Mostrar todas las conexiones del grafo con librerías
        grafoLibrerias.mostrarConexiones();
        
        // Mensaje final
        System.out.println("\n=== FIN DEL LABORATORIO ===");
    }
}