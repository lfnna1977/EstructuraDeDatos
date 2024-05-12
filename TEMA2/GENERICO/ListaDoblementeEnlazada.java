public class ListaDoblementeEnlazada<T> {
    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;
    private int tamanyo;

    public ListaDoblementeEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.tamanyo = 0;
    }

    public int getTamanyo() {
        return tamanyo;
    }

    public boolean estaVacia() {
        return this.primero == null;
    }

    public void agregarAlFinal(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);
        if (estaVacia()) {
            this.primero = nuevoNodo;
        } else {
            this.ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(this.ultimo);
        }
        this.ultimo = nuevoNodo;
        tamanyo++;
    }

    public void agregarAlInicio(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);
        if (estaVacia()) {
            this.ultimo = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(this.primero);
            this.primero.setAnterior(nuevoNodo);
        }
        this.primero = nuevoNodo;
        tamanyo++;
    }

    public T eliminarAlFinal() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía");
        }
        T dato = this.ultimo.getDato();
        if (this.primero == this.ultimo) {
            this.primero = null;
            this.ultimo = null;
        } else {
            this.ultimo = this.ultimo.getAnterior();
            this.ultimo.setSiguiente(null);
        }
        tamanyo--;
        return dato;
    }

    public T eliminarAlInicio() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía");
        }
        T dato = this.primero.getDato();
        if (this.primero == this.ultimo) {
            this.primero = null;
            this.ultimo = null;
        } else {
            this.primero = this.primero.getSiguiente();
            this.primero.setAnterior(null);
        }
        tamanyo--;
        return dato;
    }


    // Otros métodos como obtener(), buscar(), etc., pueden ser implementados aquí

    // Método para visualizar el contenido de la lista doblemente enlazada
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        NodoDoble<T> actual = this.primero;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) {
                sb.append(", ");
            }
            actual = actual.getSiguiente();
        }
        sb.append("]");
        return sb.toString();
    }
}
