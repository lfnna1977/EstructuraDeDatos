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
    public void insertar(Object elemento) throws Exception{
        if (!colaLlena()){
            this.listaCola[++fin] = elemento;
        } else {
            throw new Exception("Desbordamiento en la cola");
        }
    }

    // Elimina y devuelve el elemento al frente de la cola
    public Object quitar() throws Exception {
        if (!colaVacia()){
            return this.listaCola[frente++];
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
    public Object frenteCola() throws Exception{
        if (!colaVacia()){
            return this.listaCola[frente];
        } else {
            throw new Exception("Cola vacia");
        }
    }

    // Método main para probar la clase ColaLineal
    public static void main(String[] args) {
        ColaLineal cola = new ColaLineal();

        try {
            // Insertar elementos en la cola
            cola.insertar(10);
            cola.insertar(20);
            cola.insertar(30);            

            // Mostrar el frente de la cola
            System.out.println("Frente de la cola: " + cola.frenteCola());

            // Quitar elementos de la cola y mostrarlos
            System.out.println("Quitando elementos de la cola:");
            while (!cola.colaVacia()) {
                System.out.println(cola.quitar());
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
