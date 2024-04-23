import java.util.ArrayList;

public class PilaArrayList<T> {
    // Atributos
    private ArrayList<T> elementos;

    // Constructor
    public PilaArrayList() {
        this.elementos = new ArrayList<>();
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    // Método para obtener el tamaño de la pila
    public int tamanyo() {
        return elementos.size();
    }

    // Método para agregar un elemento a la pila
    public void push(T elemento) {
        elementos.add(elemento);
    }

    // Método para eliminar y devolver el elemento superior de la pila
    public T pop() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return elementos.remove(elementos.size() - 1);
    }

    // Método para obtener el elemento superior de la pila sin eliminarlo
    public T peek() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return elementos.get(elementos.size() - 1);
    }

    public static void main(String[] args) {
        /*
         * Clases envolventes (wrapper classes) de tipos primitivos:
         * Integer
         * Byte
         * Short
         * Long
         * Float
         * Double
         * Character
         * Boolean
         * 
         * Objetos de cualquier clase definida por el usuario o de las clases del JDK, por ejemplo:
         * String
         * ArrayList (puedes tener ArrayLists dentro de un ArrayList)
         * LinkedList
         * HashMap
         * HashSet
         * Y cualquier otra clase que desees almacenar en un ArrayList.
         */


        // Crear una pila de enteros
        PilaArrayList<Integer> pilaEnteros = new PilaArrayList<>();

        // Agregar elementos a la pila
        pilaEnteros.push(10);
        pilaEnteros.push(20);
        pilaEnteros.push(30);

        // Mostrar el tamaño de la pila
        System.out.println("Tamaño de la pila de enteros: " + pilaEnteros.tamanyo()); // Debería imprimir 3

        // Mostrar el elemento superior de la pila sin eliminarlo
        System.out.println("Elemento superior de la pila de enteros: " + pilaEnteros.peek()); // Debería imprimir 30

        // Eliminar y mostrar elementos de la pila
        System.out.println("Elementos de la pila de enteros:");
        while (!pilaEnteros.estaVacia()) {
            System.out.println(pilaEnteros.pop());
        }        

        // Verificar si la pila está vacía después de eliminar todos los elementos
        System.out.println("¿La pila de enteros está vacía? " + pilaEnteros.estaVacia()); // Debería imprimir true
    }
}
