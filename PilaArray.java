public class PilaArray {
    // Atributos
    private int[] datos;
    private int cima;

    // Metodos
    // Metodo Constructor, inicializar los datos
    public PilaArray(int capacidad) {
        // Colocar tamaño del array
        datos = new int[capacidad];
        cima = -1;
    }

    // Insertar un elemento a la parte superior de la pila
    public void apilar(int valor) {
        if (cima == datos.length - 1) {
            System.out.println("Pila llena");
            return;
        }
        cima++;
        datos[cima] = valor;
    }

    // Elimina y devuelve el elemento de la parte superior de la pila
    public int desapilar() {
        if (cima == -1) {
            System.out.println("Pila vacía");
            return -1;
        }
        int valor = datos[cima];
        cima--;
        return valor;
    }

    // Verificar que esta vacia
    public boolean estaVacia() {
        return cima == -1;
    }

    // Verificar si esta la pila llena
    public boolean estaLlena() {
        return cima == datos.length - 1;
    }

    // Verificar si esta la pila  vacia
    public int cima() {
        if (cima == -1) {
            System.out.println("Pila vacía");
            return -1;
        }
        return datos[cima];
    }

    // Vaciar la pila
    public void vaciar() {
        cima = -1;
    }

    // Que tamaño tiene la pila
    public int tamanyo() {
        return cima + 1;
    }

    // Imprimir la pila
    public void imprimir() {
        if (cima == -1) {
            System.out.println("La pila está vacía");
        } else {
            System.out.println("Elementos de la pila: ");
            for (int i = cima; i >= 0; i--) {
                System.out.println(datos[i]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Testeando Clase PilaArray");
        // Se define una constante llamada LIMITE
        final int LIMITE = 5;

        // Inicialización de una pila mediante arrays
        PilaArray numeros = new PilaArray(LIMITE);

        // Se añaden elementos a la pila de acuerdo al LIMITE y luego se imprime
        for (int i = 0; i < LIMITE; i++) {
            int numeroRandom = (int)Math.floor(Math.random()*20+1);
            numeros.apilar(numeroRandom);
            System.out.print("Se a apilado: " + numeroRandom + "\t\n");
        }
        numeros.imprimir();

        // Se elimina un elemento y luego se imprime
        System.out.println("Se ha desapilado: " + numeros.desapilar());
        numeros.imprimir();
    }
}
