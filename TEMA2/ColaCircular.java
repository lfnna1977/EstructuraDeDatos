public class ColaCircular {
    // Atributos
    private static final int MAXTAMQ = 99;
    protected int frente;
    protected int fin;
    protected Object [] listaCola ;

    // Método Constructor, inicializa la cola
    public ColaCircular(){
        this.frente = 0;
        this.fin = (MAXTAMQ -1);
        this.listaCola = new Object[MAXTAMQ];
    }

    // Operaciones

    // Avanza una posición, el indice de la posición
    private int siguiente(int r){
        int resultado = ((r+1) % MAXTAMQ);
        return resultado;
    }

    // Verifica si la cola esta llena
    public boolean colaLlena(){
        boolean resultado = (this.frente == siguiente(siguiente(this.fin)));
        return resultado;
    }

    // Verifica si la cola esta vacia
    public boolean colaVacia(){
        return (this.frente == siguiente(this.fin));
    }

    // Operación de modificación de la cola
    public void insertar(Object elemento) throws Exception{        
        if (!colaLlena()){
            this.fin = siguiente(this.fin);
            this.listaCola[this.fin] = elemento;
        } else {
            throw new Exception("Desbordamiento en la cola");
        }
    }

    // Operación para quitar un elemento de la cola
    public Object quitar() throws Exception{
        if (!colaVacia()){
            Object tm = this.listaCola[this.frente];
            this.frente = siguiente(this.frente);
            return tm;
        } else {
            throw new Exception("Cola vacia");
        }
    }

    // Vaciar la cola
    public void borrarCola(){
        this.frente = 0;
        this.fin = (MAXTAMQ - 1);
    }

    // Muestra el elemento que esta al frente de la cola sin eliminarlo
    public Object frenteCola() throws Exception{
        if (!colaVacia()){
            return this.listaCola[this.frente];
        } else {
            throw new Exception("Cola vacia");
        }
    }

    public static void main(String[] args) {
        ColaCircular cola = new ColaCircular();

        try {
            cola.insertar(10);
            cola.insertar(20);
            cola.insertar(30);
            cola.insertar(40);

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
