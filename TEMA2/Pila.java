public class Pila {
    // Atributos
    private int[] datos;
    private int cima;

    // Metodos
    // Metodo Constructor, inicializar los datos
    public Pila(int capacidad) {
        // Colocar tamaño del array
        this.datos = new int[capacidad];
        this.cima = -1;
    }

    // Operaciones
    // Insertar un elemento a la parte superior de la pila
    public void apilar(int valor) {
        if (estaLlena()) {
            throw new IllegalStateException("La pila está llena");
        }        
        this.datos[++cima] = valor;
    }

    // Elimina y devuelve el elemento de la parte superior de la pila
    public int desapilar() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        int valor = this.datos[cima];        
        this.cima--;
        return valor;
    }

    // Verifica que la pila esta vacia, devuelve True si es cierta la condición
    public boolean estaVacia() {
        return (this.cima == -1);        
    }

    // Verifica si la pila esta lleno, devuelve True si es cierta la condición
    public boolean estaLlena() {
        return (this.cima == this.datos.length - 1);
    }

    // Devuelve el valor que esta en la cima sin eliminar
    public int cima() {
        if (estaVacia()) {            
            throw new IllegalStateException("La pila está vacía");
        }
        return this.datos[cima];
    }

    // Vaciar la pila
    public void vaciar() {
        this.cima = -1;
    }

    // Que tamaño tiene la pila
    public int tamanyo() {
        return (this.cima + 1);
    }

    // Imprimir la pila
    public String imprimir() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        } 
        String mensaje = "Elementos de la pila: \n";            
        for (int i = this.cima; i >= 0; i--) {
            mensaje = mensaje + this.datos[i] + "\n";            
        }        
        return mensaje;
    }

    // Método main para probar la clase Vehiculo
    public static void main(String[] args) {
        System.out.println("Testeando Clase Pila");
        // Se define una constante llamada LIMITE
        final int LIMITE = 5;

        // Inicialización de una pila mediante arrays
        Pila numeros = new Pila(LIMITE);

        // Se añaden elementos a la pila de acuerdo al LIMITE y luego se imprime
        for (int i = 0; i < LIMITE; i++) {
            int numeroRandom = (int)Math.floor(Math.random()*20+1);
            numeros.apilar(numeroRandom);
            System.out.print("Se a apilado: " + numeroRandom + "\n");
        }
        System.out.print(numeros.imprimir());

        // Se elimina un elemento y luego se imprime
        System.out.println("Se ha desapilado: " + numeros.desapilar());
        System.out.print(numeros.imprimir());
    }
}
