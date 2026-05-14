import java.util.*;

class DfsRecursive{
    private int vertices;
    private LinkedList<Integer> adj[];
    private int time;

    @SuppressWarnings("unchecked")
    DfsRecursive(int v)
    {
        vertices =v;
        adj = new LinkedList[v];
        for(int i=0;i<v;++i)
        {
            adj[i]= new LinkedList<>();
        }
    }

    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    void DFSUtil(int node,boolean visited[], int[] discoveryTime,int[] finishTime)
    {
        visited[node]=true;
        discoveryTime[node]=++time;
        System.out.println("visited node:" +node+" d : "+discoveryTime[node]);
        
        for(int neighbor : adj[node])
        {
            if(!visited[neighbor])
            {
              DFSUtil(neighbor,visited,discoveryTime,finishTime);
            }
        }
        finishTime[node]=++time;
        System.out.println("node : "+node+"finished time : "+finishTime);
    }

    void Dfs(int startNode)
    {
        boolean visited[]=new boolean[vertices];
        int[] discoveryTime = new int[vertices];
        int[] finishTime = new int[vertices];
        
        time=0;

        DFSUtil(startNode ,visited,discoveryTime,finishTime);
    }
    public static void main(String[] args)
    {
        DfsRecursive graph = new DfsRecursive(6);
        graph.addEdge(0,1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 5);
        System.out.println("Dfs recusively : ");
        graph.Dfs(0);
    }
}
