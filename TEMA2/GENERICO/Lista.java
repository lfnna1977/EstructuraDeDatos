public class Lista<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public Lista() {
        this.primero = null;
        this.ultimo = null;
    }

    public void insertarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            nuevoNodo.siguiente = primero;
            primero = nuevoNodo;
        }
    }

    public void insertarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        }
    }

    public T eliminarAlFinal(){
        if (estaVacia()) {
            throw new IllegalStateException("La lista esta vacia");
        }
        T resultado = ultimo.dato;
        Nodo<T> nodoPrevio = primero;
        while (nodoPrevio.siguiente != ultimo) {
            nodoPrevio = nodoPrevio.siguiente;
        }
        nodoPrevio.siguiente = null;
        ultimo = nodoPrevio;
        tamanyo--;
        return resultado;
    }

    public void visualizar() {
        Nodo<T> actual = primero;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public boolean estaVacia() {
        return primero == null;
    }

    // Otros métodos de la lista (eliminar, buscar, etc.) pueden ser implementados aquí
}
