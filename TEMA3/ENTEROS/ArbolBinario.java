import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ArbolBinario {
    private NodoBinario raiz;

    // Constructor
    public ArbolBinario() {
        this.raiz = null;
    }

    // Método para insertar un nuevo nodo en el árbol
    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private NodoBinario insertarRecursivo(NodoBinario nodo, int dato) {
        // Si el árbol está vacío, creamos un nuevo nodo y lo hacemos raíz
        if (nodo == null) {
            return new NodoBinario(dato);
        }

        // Insertamos en el subárbol izquierdo si dato es menor que el valor en el nodo actual
        if (dato < nodo.getDato()) {
            nodo.setIzquierda(insertarRecursivo(nodo.getIzquierda(), dato));
        }
        // Insertamos en el subárbol derecho si dato es mayor que el valor en el nodo actual
        else {
            nodo.setDerecha(insertarRecursivo(nodo.getDerecha(), dato));
        }

        return nodo;
    }

    // Método para realizar un recorrido preorden en el árbol
    public void preorden() {
        preordenRecursivo(raiz);
    }

    private void preordenRecursivo(NodoBinario nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preordenRecursivo(nodo.getIzquierda());
            preordenRecursivo(nodo.getDerecha());
        }
    }

    // Método para calcular la altura del árbol
    public int altura() {
        return alturaRecursiva(raiz);
    }

    private int alturaRecursiva(NodoBinario nodo) {
        if (nodo == null) {
            return -1;
        }

        int alturaIzquierda = alturaRecursiva(nodo.getIzquierda());
        int alturaDerecha = alturaRecursiva(nodo.getDerecha());

        return 1 + Math.max(alturaIzquierda, alturaDerecha);
    }

    // Método para contar el número total de nodos en el árbol
    public int tamanyo() {
        return tamanyoRecursivo(raiz);
    }

    private int tamanyoRecursivo(NodoBinario nodo) {
        if (nodo == null) {
            return 0;
        }

        return 1 + tamanyoRecursivo(nodo.getIzquierda()) + tamanyoRecursivo(nodo.getDerecha());
    }

    // Método para imprimir el árbol en forma de árbol binario
    public void imprimirArbol() {
        imprimirArbolRecursivo(raiz, 0);
    }

    /*
     * Este método imprimirArbol utiliza un recorrido inorden inverso (derecha-raiz-izquierda)
     * para imprimir los nodos del árbol de manera que los nodos más profundos estén más
     * a la izquierda y los nodos más superficiales estén más a la derecha.
     * Esto produce una representación visual que se asemeja a un árbol binario, con los nodos
     * más profundos en la parte superior y los nodos más superficiales en la parte inferior.
     */
    private void imprimirArbolRecursivo(NodoBinario nodo, int nivel) {
        if (nodo != null) {
            imprimirArbolRecursivo(nodo.getDerecha(), nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }
            System.out.println(nodo.getDato());
            imprimirArbolRecursivo(nodo.getIzquierda(), nivel + 1);
        }
    }

    // Método para insertar un nuevo nodo en el árbol
    public void insertarIterativo(int valor) {
        NodoBinario nuevoNodo = new NodoBinario(valor);
        if (raiz == null) {
            raiz = nuevoNodo;
            return;
        }

        NodoBinario actual = raiz;
        while (true) {
            if (valor < actual.getDato()) {
                if (actual.getIzquierda() == null) {
                    actual.setIzquierda(nuevoNodo); 
                    return;
                }
                actual = actual.getIzquierda();
            } else {
                if (actual.getDerecha() == null) {
                    actual.setDerecha(nuevoNodo); 
                    return;
                }
                actual = actual.getDerecha();
            }
        }
    }

    // Método iterativo para recorrer el árbol en preorden
    public void recorrerPreordenIterativo() {
        if (raiz == null) {
            return;
        }

        Stack<NodoBinario> pila = new Stack<>();
        pila.push(raiz);

        while (!pila.isEmpty()) {
            NodoBinario actual = pila.pop();
            System.out.print(actual.getDato() + " ");

            if (actual.getDerecha() != null) {
                pila.push(actual.getDerecha());
            }

            if (actual.getIzquierda() != null) {
                pila.push(actual.getIzquierda());
            }
        }
    }

    // Método para imprimir el árbol por niveles
    public void imprimirPorNiveles() {
        if (raiz == null) {
            return;
        }

        Queue<NodoBinario> cola = new LinkedList<>();
        cola.offer(raiz);

        while (!cola.isEmpty()) {
            int nivelSize = cola.size();
            for (int i = 0; i < nivelSize; i++) {                
                NodoBinario actual = cola.poll();
                System.out.print(actual.getDato() + " ");
                if (actual.getIzquierda() != null) {
                    cola.offer(actual.getIzquierda());
                }
                if (actual.getDerecha() != null) {
                    cola.offer(actual.getDerecha());
                }
            }
            System.out.println(); // Cambio de línea después de imprimir todos los nodos en el nivel actual
        }
    }

   
    // Otros métodos...
}
