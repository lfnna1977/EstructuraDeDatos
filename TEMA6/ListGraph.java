import java.util.LinkedList;

public class ListGraph {
    private int V; // número de vértices
    private LinkedList<Integer> adjListArray[];

    // Constructor
    @SuppressWarnings("unchecked")
    public ListGraph(int V) {
        this.V = V;        
        adjListArray = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    // Método para añadir una arista en el grafo
    public void addEdge(int src, int dest) {
        adjListArray[src].add(dest);
        adjListArray[dest].add(src); // para grafos no dirigidos
    }

    // Método para imprimir la lista de adyacencia
    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.println("Lista de adyacencia del vértice " + v);
            System.out.print("head");
            for (Integer pCrawl : adjListArray[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

    // Método para comprobar si existe una arista entre start y end
    public boolean containsEdge(int start, int end) {
        return adjListArray[start].contains(end);
    }

    // Método para eliminar una arista entre start y end
    public void removeEdge(int start, int end) {
        adjListArray[start].remove((Integer) end);
        adjListArray[end].remove((Integer) start); // para grafos no dirigidos
    }

    // DFS
    private void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int x : adjListArray[v]) {
            if (!visited[x]) {
                DFSUtil(x, visited);
            }
        }
    }

    public void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    // BFS
    public void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            for (int x : adjListArray[s]) {
                if (!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
    }

    public static void main(String[] args) {
        int V = 5; // número de vértices
        ListGraph graph = new ListGraph(V);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Representación del grafo usando lista de adyacencia:");
        graph.printGraph();

        // Comprobando si existe la arista
        System.out.println("¿Existe la arista entre 1 y 3? " + graph.containsEdge(1, 3));

        // Eliminando una arista
        graph.removeEdge(1, 3);
        System.out.println("Grafo después de eliminar la arista entre 1 y 3:");
        graph.printGraph();
    }
}
