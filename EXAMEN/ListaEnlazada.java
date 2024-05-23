public class ListaEnlazada<T> {
    // Atributos
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamanyo;

    // Constructor
    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.tamanyo = 0;
    }

    // Getters y Setters
    public int getTamanyo(){
        return this.tamanyo;
    }

    /* 
     * Métodos
     * Operaciones
    */
    public boolean estaVacia() {
        return primero == null;
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
        tamanyo ++;
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
        tamanyo ++;
    }

    public void visualizar() {
        Nodo<T> actual = primero;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public T verInicio(){
        return primero.dato;
    }

    public T verFinal(){
        return ultimo.dato;
    }

    public T eliminarAlFinal(){
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía, no se puede eliminar el último elemento");
        }
    
        T valorEliminado;
        if (primero == ultimo) {
            // Si la lista tiene un solo elemento, eliminar ese elemento y devolver su valor
            valorEliminado = primero.dato;
            primero = null;
            ultimo = null;
            tamanyo = 0;
        } else {
            // Encontrar el nodo que precede al último nodo
            Nodo<T> actual = primero;
            while (actual.siguiente != ultimo) {
                actual = actual.siguiente;
            }
    
            // Eliminar el último nodo y devolver su valor
            valorEliminado = ultimo.dato;
            tamanyo --;
            actual.siguiente = null;
            ultimo = actual;
        }
        
        return valorEliminado;
    }

    public T eliminarAlInicio(){
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía, no se puede eliminar el primer elemento");
        }
    
        T valorEliminado = primero.dato; // Guardamos el valor del primer nodo a eliminar
        primero = primero.siguiente; // Movemos el puntero al siguiente nodo
    
        // Si después de eliminar el primer nodo, la lista queda vacía, también actualizamos el puntero 'ultimo'
        if (primero == null) {
            ultimo = null;
        }
    
        tamanyo --;
        return valorEliminado;
    }

    public void insertarEn(int posicion, T dato){
        if (posicion < 0) {
            throw new IllegalArgumentException("La posición no puede ser negativa");
        }
    
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (posicion == 0) {
            // Insertar al principio de la lista
            nuevoNodo.siguiente = primero;
            primero = nuevoNodo;
            if (estaVacia()) {
                ultimo = nuevoNodo; // Si la lista estaba vacía, el nuevo nodo también será el último
            }
            tamanyo ++;
        } else {
            // Insertar en una posición diferente al principio
            Nodo<T> actual = primero;
            int contador = 0;
            while (actual != null && contador < posicion - 1) {
                actual = actual.siguiente;
                contador++;
            }
            if (actual == null) {
                throw new IllegalArgumentException("La posición está fuera de rango");
            }
            nuevoNodo.siguiente = actual.siguiente;
            actual.siguiente = nuevoNodo;
            if (actual == ultimo) {
                ultimo = nuevoNodo; // Si se inserta después del último nodo, actualizar el campo 'ultimo'
            }
            tamanyo ++;
        }
    }

    public T eliminarEn(int posicion){
        if (estaVacia()) {
            throw new IllegalStateException("La lista está vacía, no se puede eliminar un elemento");
        }
    
        if (posicion < 0) {
            throw new IllegalArgumentException("La posición no puede ser negativa");
        }
    
        T valorEliminado;
        if (posicion == 0) {
            // Si se quiere eliminar el primer nodo
            valorEliminado = primero.dato;
            primero = primero.siguiente;
            if (primero == null) {
                ultimo = null; // Si la lista quedó vacía, actualizar 'ultimo' también
            }
        } else {
            // Buscar el nodo anterior al que se desea eliminar
            Nodo<T> actual = primero;
            int contador = 0;
            while (actual != null && contador < posicion - 1) {
                actual = actual.siguiente;
                contador++;
            }
            if (actual == null || actual.siguiente == null) {
                throw new IllegalArgumentException("La posición está fuera de rango");
            }
    
            // Eliminar el nodo y devolver su valor
            valorEliminado = actual.siguiente.dato;
            actual.siguiente = actual.siguiente.siguiente;
            if (actual.siguiente == null) {
                ultimo = actual; // Si se eliminó el último nodo, actualizar 'ultimo'
            }
        }
    
        tamanyo --;
        return valorEliminado;
    }

    public int indice(T elemento) {
        Nodo<T> actual = primero;
        int indice = 0;
    
        // Recorremos la lista hasta encontrar el elemento o llegar al final
        while (actual != null) {
            if (actual.dato.equals(elemento)) {
                return indice; // Si encontramos el elemento, devolvemos su índice
            }
            actual = actual.siguiente;
            indice++;
        }
    
        return -1; // Si el elemento no se encuentra en la lista, devolvemos -1
    }

    public T obtenerA(int indice) {
        if (indice < 0) {
            throw new IllegalArgumentException("El índice no puede ser negativo");
        }
    
        Nodo<T> actual = primero;
        int contador = 0;
    
        // Recorremos la lista hasta encontrar el nodo en la posición indicada
        while (actual != null) {
            if (contador == indice) {
                return actual.dato; // Si encontramos el nodo en la posición indicada, devolvemos su dato
            }
            actual = actual.siguiente;
            contador++;
        }
    
        // Si el índice está fuera del rango de la lista, lanzamos una excepción
        throw new IndexOutOfBoundsException("El índice está fuera del rango de la lista");
    }    
}