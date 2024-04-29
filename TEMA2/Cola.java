public class Cola {
    private static final int CAPACIDAD_INICIAL = 10;
    private int[] elementos;
    private int tamaño;
    private int frente;
    private int finalCola;

    // Constructor
    public Cola() {
        elementos = new int[CAPACIDAD_INICIAL];
        tamaño = 0;
        frente = 0;
        finalCola = -1; // Inicialmente la cola está vacía
    }

    // Método para verificar si la cola está vacía
    public boolean estaVacia() {
        return tamaño == 0;
    }

    // Método para obtener el tamaño de la cola
    public int tamaño() {
        return tamaño;
    }

    // Método para agregar un elemento al final de la cola
    public void encolar(int elemento) {
        if (tamaño == elementos.length) {
            aumentarCapacidad();
        }
        finalCola = (finalCola + 1) % elementos.length; // Manejo de circularidad
        elementos[finalCola] = elemento;
        tamaño++;
    }

    // Método para eliminar y devolver el elemento al frente de la cola
    public int desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        int elemento = elementos[frente];
        frente = (frente + 1) % elementos.length; // Manejo de circularidad
        tamaño--;
        return elemento;
    }

    // Método para obtener el elemento al frente de la cola sin eliminarlo
    public int frente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return elementos[frente];
    }

    // Método para aumentar la capacidad del array cuando la cola está llena
    private void aumentarCapacidad() {
        int nuevaCapacidad = elementos.length * 2;
        int[] nuevoArray = new int[nuevaCapacidad];
        // Copiar elementos al nuevo array
        for (int i = 0; i < tamaño; i++) {
            nuevoArray[i] = elementos[(frente + i) % elementos.length];
        }
        elementos = nuevoArray;
        frente = 0;
        finalCola = tamaño - 1;
    }

    // Método principal para probar la cola
    public static void main(String[] args) {
        Cola cola = new Cola();
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);

        System.out.println("Elemento al frente de la cola: " + cola.frente());

        System.out.println("Desencolando elementos:");
        while (!cola.estaVacia()) {
            System.out.println(cola.desencolar());
        }
    }
}
