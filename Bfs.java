import java.util.*;
class Bfs {
    public static void main(String[] args) {
        Bfs graph = new Bfs(6); 
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("bfs: ");
        graph.BFS(0);
    }
    int vertices; 
    LinkedList<Integer> adj[]; 
    Bfs(int v) {
        vertices = v;
        adj = new LinkedList[v]; 
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>(); 
    }
    void addEdge(int v, int w) {
        adj[v].add(w); 
    }

    void BFS(int startNode) {
        boolean visited[] = new boolean[vertices]; 
        LinkedList<Integer> queue = new LinkedList<>(); 
        visited[startNode] = true; 
        queue.add(startNode); 
        while (!queue.isEmpty()) {
            int node = queue.poll(); 
            System.out.println(node); 
            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; 
                    queue.add(neighbor); 
                }
            }
        }
    }
}
