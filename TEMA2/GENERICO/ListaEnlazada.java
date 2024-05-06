public class ListaEnlazada<T> {
    private Nodo<T> primero;

    public ListaEnlazada() {
        this.primero = null;
    }

    public void insertarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = primero;
        primero = nuevoNodo;
    }

    public void eliminarAlInicio() {
        if (primero != null) {
            primero = primero.siguiente;
        }
    }

    public void visualizar() {
        Nodo<T> actual = primero;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.insertarAlInicio(3);
        lista.insertarAlInicio(7);
        lista.insertarAlInicio(9);

        System.out.println("Lista enlazada:");
        lista.visualizar(); // Output: 9 7 3

        lista.eliminarAlInicio();
        System.out.println("Lista después de eliminar el primer nodo:");
        lista.visualizar(); // Output: 7 3
    }
}
