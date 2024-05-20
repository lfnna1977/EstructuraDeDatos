import java.util.*;

class HashMapGraph {
    private Map<String, List<Edge>> adjList;

    // Constructor
    public HashMapGraph() {
        adjList = new HashMap<>();
    }

    // Método para añadir un nodo
    public void addNode(String node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    // Método para añadir una arista
    public void addEdge(String src, String dest, int weight) {
        addNode(src);
        addNode(dest);
        adjList.get(src).add(new Edge(dest, weight));
        adjList.get(dest).add(new Edge(src, weight)); // para grafos no dirigidos
    }

    // Método para comprobar si existe una arista entre start y end
    public Integer containsEdge(String start, String end) {
        if (adjList.containsKey(start)) {
            for (Edge edge : adjList.get(start)) {
                if (edge.node.equals(end)) {
                    return edge.weight;
                }
            }
        }
        return null; // Devuelve null si no existe la arista
    }

    // Método para eliminar una arista entre start y end
    public void removeEdge(String start, String end) {
        if (adjList.containsKey(start)) {
            adjList.get(start).removeIf(edge -> edge.node.equals(end));
        }
        if (adjList.containsKey(end)) {
            adjList.get(end).removeIf(edge -> edge.node.equals(start));
        }
    }

    // Método para imprimir la lista de adyacencia
    public void printGraph() {
        for (String node : adjList.keySet()) {
            System.out.print("Nodo " + node + " está conectado a: ");
            for (Edge edge : adjList.get(node)) {
                System.out.print(edge.node + " (peso " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // Clase interna para representar una arista con un peso
    private static class Edge {
        String node;
        int weight;

        Edge(String node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        HashMapGraph graph = new HashMapGraph();

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 10);
        graph.addEdge("B", "D", 2);
        graph.addEdge("C", "D", 3);

        System.out.println("Representación del grafo usando HashMap:");
        graph.printGraph();

        // Comprobando si existe la arista y obteniendo su peso
        System.out.println("Peso de la arista entre A y B: " + graph.containsEdge("A", "B"));

        // Eliminando una arista
        graph.removeEdge("A", "B");
        System.out.println("Grafo después de eliminar la arista entre A y B:");
        graph.printGraph();
    }
}
