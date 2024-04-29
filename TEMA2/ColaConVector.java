import java.util.Vector;

public class ColaConVector<T> {
    // Atributo
    private Vector<T> elementos;

    // Constructor
    public ColaConVector() {
        elementos = new Vector<>();
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    // Método para obtener el tamaño de la cola
    public int tamanyo() {
        return elementos.size();
    }

    // Método para agregar un elemento al final de la cola
    public void encolar(T elemento) {
        elementos.add(elemento);
    }

    // Método para eliminar y devolver el elemento al frente de la cola
    public T desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos.remove(0);
    }

    // Método para obtener el elemento al frente de la cola sin eliminarlo
    public T frente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos.get(0);
    }

    // Método principal para probar la cola
    public static void main(String[] args) {
        ColaConVector<Integer> colaDeEnteros = new ColaConVector<>();
        colaDeEnteros.encolar(10);
        colaDeEnteros.encolar(20);
        colaDeEnteros.encolar(30);

        System.out.println("Elemento al frente de la cola: " + colaDeEnteros.frente());

        System.out.println("Tamaño de la cola: " + colaDeEnteros.tamanyo());

        System.out.println("Desencolando elementos:");
        while (!colaDeEnteros.estaVacia()) {
            System.out.println(colaDeEnteros.desencolar());
        }

        System.out.println("Tamaño de la cola: " + colaDeEnteros.tamanyo());

        ColaConVector<String> colaDeStrings = new ColaConVector<>();
        colaDeStrings.encolar("Hola");
        colaDeStrings.encolar("Mundo");

        System.out.println("Elemento al frente de la cola: " + colaDeStrings.frente());

        System.out.println("Desencolando elementos:");
        while (!colaDeStrings.estaVacia()) {
            System.out.println(colaDeStrings.desencolar());
        }
    }
}
