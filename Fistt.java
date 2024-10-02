import java.util.*;

class Graph {
    static final int N = 100009;
    static List<Integer>[] G = new ArrayList[N];
    static int nodes, edges;
    static int[] par = new int[N];
    static int[] dist = new int[N];

    // Constructor to initialize the graph from console input
    public Graph(Scanner sc) {
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<>();
            dist[i] = -1;  // Initialize distance array
        }

        // Reading nodes and edges
        nodes = sc.nextInt();
        edges = sc.nextInt();

        // Read edges and add to the graph
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            Add_Node(u, v);
        }
    }

    // Add an undirected edge between nodes u and v
    void Add_Node(int u, int v) {
        G[u].add(v);
        G[v].add(u);
    }

    // Perform BFS starting from a given node and return the traversal order
    List<Integer> BFS(int node) {
        boolean[] visited = new boolean[N];
        Queue<Integer> Q = new LinkedList<>();
        List<Integer> traverse = new ArrayList<>();
        
        visited[node] = true;
        dist[node] = 0;  // Initialize the distance of the source node
        Q.add(node);

        while (!Q.isEmpty()) {
            int parent = Q.poll();
            traverse.add(parent);

            // Traverse through all adjacent nodes
            for (int child : G[parent]) {
                if (!visited[child]) {
                    Q.add(child);
                    visited[child] = true;
                    dist[child] = dist[parent] + 1; // Set distance
                    par[child] = parent; // Set parent
                }
            }
        }
        return traverse;
    }

    // Get vertices connected to a specific node
    List<Integer> Get_vertices(int node) {
        return G[node];
    }

    // Display the adjacency list of the graph
    void display() {
        for (int i = 1; i <= nodes; i++) {
            System.out.print(i + ": ");
            for (int x : G[i]) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
    List<Integer> path(int node, int source) {
        List<Integer> Path = new ArrayList<>();
        while (node != source) {
            Path.add(node);
            node = par[node];
        }
        Path.add(source);
        Collections.reverse(Path);
        return Path;
    }
}

public class Fistt {
    public static void main(String[] args) {
        try {
            // Create a scanner object for taking input from console
            Scanner sc = new Scanner(System.in);

            // Create the graph and process the input from the console
            Graph graph = new Graph(sc);

            // Perform BFS starting from node 1 (you can modify the node as needed)
            List<Integer> bfsOrder = graph.BFS(1);
            System.out.println("BFS Traversal Order: " + bfsOrder);

            // Example to get the path from node 5 to 1
            int targetNode = 5; // Change this to the desired target node
            List<Integer> path = graph.path(targetNode, 1);
            System.out.println("Path from 1 to " + targetNode + ": " + path);

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
