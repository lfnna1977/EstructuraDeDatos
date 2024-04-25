import java.util.Stack;

public class App {
    
    public static void main(String[] args) throws Exception {
        // Crear una instancia de Stack
        Stack<Integer> pila = new Stack<>();

        // Agregar elementos a la pila
        pila.push(10);
        pila.push(20);
        pila.push(30);

        // Mostrar la pila
        System.out.println("Contenido de la pila: " + pila);

        // Obtener y eliminar el elemento en la parte superior de la pila
        int elementoEliminado = pila.pop();
        System.out.println("Elemento eliminado: " + elementoEliminado);

        // Mostrar la pila después de la eliminación
        System.out.println("Contenido de la pila después de la eliminación: " + pila);

        // Obtener (pero no eliminar) el elemento en la parte superior de la pila
        int elementoSuperior = pila.peek();
        System.out.println("Elemento en la parte superior de la pila: " + elementoSuperior);

        // Verificar si la pila está vacía
        boolean estaVacia = pila.empty();
        System.out.println("¿La pila está vacía? " + estaVacia);
    }
}
