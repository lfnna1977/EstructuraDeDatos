public class ColaLineal {
    // Atributos
    private static final int MAXTAMQ = 39;
    protected int frente;
    protected int fin;
    protected Object[] listaCola;

    // Método constructor
    public ColaLineal(){
        this.frente = 0;
        this.fin = -1;
        this.listaCola = new Object[MAXTAMQ];
    }

    // Operaciones

    // Verifica si la cola esta llena
    public boolean colaLlena() {
        return (this.fin == MAXTAMQ -1);
    }

    // Verifica si la cola esta vacias
    public boolean colaVacia(){
        return (this.frente > this.fin);
    }

    // Inserta un elemento a la cola
    public void encolar(Object elemento) throws Exception {
        if (!colaLlena()){
            this.listaCola[++fin] = elemento;
        } else {
            throw new Exception("Desbordamiento en la cola");
        }
    }

    // Elimina y devuelve el elemento al frente de la cola
    public Object desencolar() throws Exception {
        if (!colaVacia()){
            return this.listaCola[this.frente++];
        } else {
            throw new Exception("Cola vacia");
        }
    }

    // Pone a su estado inicial a la cola
    public void borrarCola(){
        this.frente = 0;
        this.fin = -1;
    }

    // Muestra el elemento que esta al frente de la cola sin eliminarlo
    public Object frenteCola() throws Exception {
        if (!colaVacia()){
            return this.listaCola[this.frente];
        } else {
            throw new Exception("Cola vacia");
        }
    }

    public String imprimirCola(){
        String resultado = "";
        if (colaVacia()){
            return resultado = "La cola esta vacia";
        } else {
            for (int i = this.frente; i < (this.fin + 1); i++){
                resultado += "[" + i + "]" + this.listaCola[i] + "\n";
            }
            return resultado;
        }
    }

    // Método main para probar la clase ColaLineal
    public static void main(String[] args) {
        ColaLineal cola = new ColaLineal();

        try {
            // Insertar elementos en la cola
            cola.encolar(10);
            cola.encolar(20);
            cola.encolar(30);            

            // Mostrar el frente de la cola
            System.out.println("Frente de la cola: " + cola.frenteCola());

            // Quitar elementos de la cola y mostrarlos
            System.out.println("Quitando elementos de la cola:");
            while (!cola.colaVacia()) {
                System.out.println(cola.desencolar());
            }

            // Verificar si la cola está vacía
            if (cola.colaVacia()) {
                System.out.println("La cola está vacía");
            } else {
                System.out.println("La cola no está vacía");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
