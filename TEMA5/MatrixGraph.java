class MatrixGraph {
    private int V; // número de vértices
    private int[][] adjMatrix;

    // Constructor
    public MatrixGraph(int V) {
        this.V = V;
        adjMatrix = new int[V][V];
    }

    // Método para añadir una arista
    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1; // para grafos no dirigidos
    }

    // Método para imprimir la matriz de adyacencia
    public void printGraph() {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para comprobar si existe una arista entre start y end
    public boolean containsEdge(int start, int end) {
        return adjMatrix[start][end] != 0;
    }

    // Método para eliminar una arista entre start y end
    public void removeEdge(int start, int end) {
        adjMatrix[start][end] = 0;
        adjMatrix[end][start] = 0; // para grafos no dirigidos
    }

    public static void main(String[] args) {
        int V = 5; // número de vértices
        MatrixGraph graph = new MatrixGraph(V);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Representación del grafo usando matriz de adyacencia:");
        graph.printGraph();

        // Comprobando si existe la arista
        System.out.println("¿Existe la arista entre 1 y 3? " + graph.containsEdge(1, 3));

        // Eliminando una arista
        graph.removeEdge(1, 3);
        System.out.println("Grafo después de eliminar la arista entre 1 y 3:");
        graph.printGraph();
    }
}
