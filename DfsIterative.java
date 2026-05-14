import java.util.*;
class DfsIterative{
    private int vertices;
    private LinkedList<Integer> adj[];
    private int time;

    @SuppressWarnings("unchecked")
    DfsIterative(int v)
    {
        vertices = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;++i)
        {
            adj[i]= new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w); 
    }

    void Dfs(int startNode)
    {
        boolean visited[] = new boolean[vertices];
        int[] discoveryTime = new int[vertices];
        int[] finishTime = new int[vertices];

        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        time =0;
        int[] currentState = new int[vertices];

        while(!stack.isEmpty())
        {
            int node= stack.peek();
            if(!visited[node])
            {
                visited[node]=true;
                discoveryTime[node]=++time;
                System.out.println("Visited node " + node + ", discovery time: " + discoveryTime[node]);    
            }
            boolean hasUnvisitedNeighbor = false;
            for(int neighbor  :adj[node])
            {
                if(!visited[neighbor])
                {
                    stack.push(neighbor);
                    hasUnvisitedNeighbor = true;
                    break;
                }
            }
            if(!hasUnvisitedNeighbor)
            {
                stack.pop();
                finishTime[node]=++time;
                System.out.println("Finished node " + node + ", finish time: " + finishTime[node]);  
            }
        }
    }
    public static void main(String[] args) {
        {
            DfsIterative graph=new DfsIterative(6);
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 3);
            graph.addEdge(1, 4);
            graph.addEdge(2, 5);
            System.out.println("Iterative DFS with timestamps starting from node 0:");
            graph.Dfs(0);
        }
    }
}