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

    public void insertarAlFinal(T dato) {
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

    public void insertarAlInicio(T dato) {
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

    public void insertarEn(int index, T dato) {
        if (index < 0 || index > tamanyo) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);

        if (index == 0) {
            if (primero == null) {
                primero = nuevoNodo;
                ultimo = nuevoNodo;
            } else {
                nuevoNodo.setSiguiente(primero);
                primero.setAnterior(nuevoNodo);
                primero = nuevoNodo;
            }
        } else if (index == tamanyo) {
            insertarAlFinal(dato);
            return;
        } else {
            NodoDoble<T> actual = primero;
            for (int i = 0; i < index - 1; i++) {
                actual = actual.getSiguiente();
            }
            NodoDoble<T> siguiente = actual.getSiguiente();
            actual.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(actual);
            nuevoNodo.setSiguiente(siguiente);
            if (siguiente != null) {
                siguiente.setAnterior(nuevoNodo);
            }
        }
        tamanyo++;
    }
    
    public void eliminarEn(int index) {
        if (index < 0 || index >= tamanyo) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        if (index == 0) {
            if (primero != null) {
                primero = primero.getSiguiente();
                if (primero != null) {
                    ultimo.setAnterior(null);
                } else {
                    ultimo = null;
                }
            }
        } else {
            NodoDoble<T> actual = primero;
            for (int i = 0; i < index - 1; i++) {
                actual = actual.getSiguiente();
            }
            NodoDoble<T> nodoAEliminar = actual.getSiguiente();
            NodoDoble<T> siguiente = nodoAEliminar.getSiguiente();
            actual.setSiguiente(siguiente);
            if (siguiente != null) {
                siguiente.setAnterior(actual);
            } else {
                ultimo = actual;
            }
        }
        tamanyo--;
    }

    public int indice(T dato) {
        NodoDoble<T> actual = primero;
        int indice = 0;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return indice;
            }
            actual = actual.getSiguiente();
            indice++;
        }
        return -1; // Retorna -1 si el dato no se encuentra en la lista
    }

    public T obtenerA(int index) {
        if (index < 0 || index >= tamanyo) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        NodoDoble<T> actual = primero;
        for (int i = 0; i < index; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }
   
    public void mostrarLista() {
        NodoDoble<T> actual = primero;
        while (actual != null) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
}