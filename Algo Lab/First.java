import java.util.*;

class Graph{
    static final int N=100009;

    static List<Integer>[] G = new ArrayList[N];

    public Graph() {
        for(int i=0;i<N;i++){
            G[i] = new ArrayList<>();
        }
    }

    

    void Add_Node(int u, int v ){
        G[u].add(v);
        G[v].add(u);
    }

    void BFS(int node){
        boolean[] visited = new boolean[N];

        Queue<Integer> Q = new LinkedList<>();

        visited[node] = true;

        Q.add(node);

        while(!Q.isEmpty()){
            int parent = Q.poll();

            for(int child : G[parent]){
                if(!visited[child]){
                    Q.add(child);
                    visited[child]=true;
                }
            }
        }
    }

}
public class First{
    public static void main(String[] args) {
        
        
    }
}