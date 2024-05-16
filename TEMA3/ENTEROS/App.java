import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Árbol Binario de Números Enteros");

        // Creamos un árbol binario de enteros
        ArbolBinario arbol = new ArbolBinario();

        // Insertamos algunos valores en el árbol
        /*
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);
        */

        arbol.insertarIterativo(50);
        arbol.insertarIterativo(30);
        arbol.insertarIterativo(70);
        arbol.insertarIterativo(20);
        arbol.insertarIterativo(40);
        arbol.insertarIterativo(60);
        arbol.insertarIterativo(80);

        // Realizamos un recorrido preorden para imprimir los nodos del árbol
        System.out.println("Recorrido preorden:");
        arbol.preorden();
        System.out.println();

        // Calculamos e imprimimos la altura del árbol
        System.out.println("Altura del árbol: " + arbol.altura());

        // Calculamos e imprimimos el tamaño del árbol
        System.out.println("Tamaño del árbol: " + arbol.tamanyo());

        // Imprimir el árbol
        arbol.imprimirArbol();

        // Realizamos un recorrido preorden para imprimir los nodos del árbol
        System.out.println("Recorrido preorden iterativo:");
        arbol.recorrerPreordenIterativo();
        System.out.println();

        // Realiza el recorrido por niveles recursivo del árbol
        arbol.imprimirPorNiveles();
    }    
}
