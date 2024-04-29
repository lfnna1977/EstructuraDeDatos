public class PilaLineal {
    // Atributos
    private static final int TAMPILA = 5;
    private Object[] datos;
    private int cima;
    
    // Getters y setters
    public static int getTampila() {
        return TAMPILA;
    }

    // Metodo Constructor, inicializar los datos
    public PilaLineal() {
        // Colocar tamaño del array
        this.datos = new Object[TAMPILA];
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
    public Object desapilar() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        Object valor = this.datos[cima];        
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
    public Object cima() {
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

    public static void main(String[] args) {
        System.out.println("Testeando Clase Pila");        

        // Inicialización de una pila mediante arrays
        PilaLineal numeros = new PilaLineal();

        try {
            // Se añaden elementos a la pila de acuerdo al LIMITE y luego se imprime
            for (int i = 0; i < PilaLineal.getTampila(); i++) {
                int numeroRandom = (int)Math.floor(Math.random()*20+1);
                numeros.apilar(numeroRandom);
                System.out.print("Se a apilado: " + numeroRandom + "\n");
            }
            System.out.print(numeros.imprimir());

            // Se elimina un elemento y luego se imprime
            System.out.println("Se ha desapilado: " + numeros.desapilar());
            System.out.print(numeros.imprimir());    
        } catch (Exception e) {            
            System.out.println("Error: " + e.getMessage());
        }        
    }
}
