public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            this.frente = nuevoNodo;
        } else {
            this.fin.setSiguiente(nuevoNodo);
        }
        this.fin = nuevoNodo;
    }

    public T desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        T dato = this.frente.getDato();
        this.frente = this.frente.getSiguiente();
        if (this.frente == null) {
            this.fin = null;
        }
        return dato;
    }

    public boolean estaVacia() {
        return this.frente == null;
    }

    public int tamanyo() {
        int tamanyo = 0;
        Nodo<T> actual = this.frente;
        while (actual != null) {
            tamanyo++;
            actual = actual.getSiguiente();
        }
        return tamanyo;
    }

    public T frente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return this.frente.getDato();
    }

    public void limpiar() {
        this.frente = null;
        this.fin = null;
    }

    public static void main(String[] args) {
        Cola<String> cola = new Cola<>();
        cola.encolar("A");
        cola.encolar("B");
        cola.encolar("C");        

        System.out.println("Frente de la cola: " + cola.frente());
        System.out.println("Desencolando elementos:");
        while (!cola.estaVacia()) {
            System.out.println(cola.desencolar());
        }
    }
}
