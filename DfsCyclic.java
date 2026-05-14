import java.util.*;

class DfsCyclic{
    private int vertices;
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    DfsCyclic(int v)
    {
        vertices = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;++i)
        {
            adj[i] = new LinkedList<>();
        }
    }
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
    private boolean isCyclicUtil(int node,boolean visited[],boolean recStack[])
    {
        if(!visited[node])
        {
            visited[node] = true;
            recStack[node] = true;
        }
        for(int neighbor : adj[node])
        {
            if(!visited[neighbor] && isCyclicUtil(neighbor,visited,recStack))
              return true;
            else if(recStack[neighbor])
            return true;
        }
        recStack[node]= false;
        return false;
    }
    boolean isCyclic()
    {
        boolean visited[] = new boolean[vertices];
        boolean recStack[] = new boolean[vertices];

        for(int i=0;i<vertices;i++)
        {
            if(isCyclicUtil(i,visited,recStack))
             return true;
        }
        return false;
    }
    public static void main(String s[])
    {
        DfsCyclic graph = new DfsCyclic(4); 
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3);
        if(graph.isCyclic())
        System.out.println("graph contains a cyclic");
        else
        System.out.println("graph doesn't contain a cyclic");
    }
}