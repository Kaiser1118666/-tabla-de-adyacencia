
package legrafos;
public class GrafoSinLibrerias {
    // cabeza: puntero al primer vértice de la lista de vértices
    private NodoVertice cabeza;

    // Clase interna para representar un vértice del grafo
    class NodoVertice {
        int dato;           // Número que identifica al vértice
        NodoArista aristas; // Puntero a la lista de aristas (conexiones)
        NodoVertice siguiente; // Puntero al siguiente vértice en la lista

        // Constructor del vértice
        NodoVertice(int dato) {
            this.dato = dato;        // Asignar el número del vértice
            this.aristas = null;     // Inicializar sin conexiones
            this.siguiente = null;   // Inicializar sin siguiente vértice
        }
    }

    // Clase interna para representar una arista (conexión entre vértices)
    class NodoArista {
        int destino;        // Vértice destino de la conexión
        NodoArista siguiente; // Puntero a la siguiente arista en la lista

        // Constructor de la arista
        NodoArista(int destino) {
            this.destino = destino;  // Asignar vértice destino
            this.siguiente = null;   // Inicializar sin siguiente arista
        }
    }

    // Constructor del grafo
    public GrafoSinLibrerias() {
        this.cabeza = null;  // Inicializar grafo vacío
    }

    // Método para agregar un vértice al grafo
    public void agregarVertice(int dato) {
        // Crear nuevo vértice con el número especificado
        NodoVertice nuevo = new NodoVertice(dato);
        
        // Si el grafo está vacío, nuevo vértice es la cabeza
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            // Si no está vacío, recorrer hasta el final
            NodoVertice actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;  // Avanzar al siguiente vértice
            }
            actual.siguiente = nuevo;  // Enlazar nuevo vértice al final
        }
    }

    // Método para buscar un vértice por su número
    private NodoVertice buscarVertice(int dato) {
        NodoVertice actual = cabeza;  // Comenzar desde la cabeza
        while (actual != null) {
            if (actual.dato == dato) {
                return actual;  // Retornar vértice si se encuentra
            }
            actual = actual.siguiente;  // Avanzar al siguiente vértice
        }
        return null;  // Retornar null si no se encuentra
    }

    // Método para conectar dos vértices (crear arista)
    public void agregarArista(int origen, int destino) {
        // Buscar vértice origen en la lista
        NodoVertice verticeOrigen = buscarVertice(origen);
        // Buscar vértice destino en la lista
        NodoVertice verticeDestino = buscarVertice(destino);
        
        // Si ambos vértices existen, crear conexión bidireccional
        if (verticeOrigen != null && verticeDestino != null) {
            // Agregar destino a la lista de aristas del origen
            agregarAristaALista(verticeOrigen, destino);
            // Agregar origen a la lista de aristas del destino
            agregarAristaALista(verticeDestino, origen);
        }
    }

    // Método auxiliar para agregar arista a la lista de un vértice
    private void agregarAristaALista(NodoVertice vertice, int destino) {
        // Crear nueva arista hacia el vértice destino
        NodoArista nuevaArista = new NodoArista(destino);
        
        // Si el vértice no tiene aristas, esta es la primera
        if (vertice.aristas == null) {
            vertice.aristas = nuevaArista;
        } else {
            // Si ya tiene aristas, recorrer hasta el final
            NodoArista actual = vertice.aristas;
            while (actual.siguiente != null) {
                actual = actual.siguiente;  // Avanzar a siguiente arista
            }
            actual.siguiente = nuevaArista;  // Enlazar nueva arista al final
        }
    }

    // Método para mostrar la tabla de adyacencia manual
    public void mostrarTablaAdyacencia() {
        System.out.println("Tabla de Adyacencia (SIN Librerías):");
        
        // Recorrer todos los vértices de la lista
        NodoVertice actualVertice = cabeza;
        while (actualVertice != null) {
            // Mostrar el vértice actual
            System.out.print(actualVertice.dato + " -> ");
            
            // Recorrer todas las aristas del vértice actual
            NodoArista actualArista = actualVertice.aristas;
            while (actualArista != null) {
                // Mostrar cada vértice conectado
                System.out.print(actualArista.destino + " ");
                actualArista = actualArista.siguiente;  // Avanzar a siguiente arista
            }
            System.out.println();  // Salto de línea después de cada vértice
            actualVertice = actualVertice.siguiente;  // Avanzar a siguiente vértice
        }
    }

    public static void main(String[] args) {
        // Crear instancia del grafo manual
        GrafoSinLibrerias grafo = new GrafoSinLibrerias();
        
        // Agregar vértices al grafo manual
        grafo.agregarVertice(1);  // Agregar vértice 1 manualmente
        grafo.agregarVertice(2);  // Agregar vértice 2 manualmente
        grafo.agregarVertice(3);  // Agregar vértice 3 manualmente
        grafo.agregarVertice(4);  // Agregar vértice 4 manualmente
        
        // Crear conexiones manualmente
        grafo.agregarArista(1, 2);  // Conectar manualmente 1-2
        grafo.agregarArista(1, 3);  // Conectar manualmente 1-3
        grafo.agregarArista(2, 4);  // Conectar manualmente 2-4
        grafo.agregarArista(3, 4);  // Conectar manualmente 3-4
        
        // Mostrar tabla de adyacencia manual
        grafo.mostrarTablaAdyacencia();
    }
}