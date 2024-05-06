public class Pila<T> {
    private Nodo<T> cima;

    public Pila() {
        this.cima = null;
    }

    public Nodo<T> getCima() {
        return cima;
    }

    public void setCima(Nodo<T> cima) {
        this.cima = cima;
    }      

    public void push(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    public T pop() {
        if (cima == null) {
            throw new IllegalStateException("La pila está vacía");
        }
        T dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    public T peek() {
        if (cima == null) {
            throw new IllegalStateException("La pila está vacía");
        }
        return cima.dato;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public String mostrar() {
        Nodo<T> actual = cima;
        String salida = "";
        while (actual != null) {
            salida += (actual.dato + "\n");            
            actual = actual.siguiente;
        }
        return (salida);
    }

    public void limpiar() {
        cima = null;
    }
}
