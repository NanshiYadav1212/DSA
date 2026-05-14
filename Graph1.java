import java.util.*;
class Pair<U,V>{
    public final U first;
    public final V second;
    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}
class Graph1{
    public static void main(String s[]){
        int n=5;
        int m=6;
      /*  ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
             adj.add(new ArrayList<>());
        }
        // unweighted undirected adjacency list representation
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        System.out.println("Adjacency List:");
        for(int i=1;i<=n;i++){
            System.out.print(i + ": ");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
        */
        // Weighted undirected graph using Pair class
        ArrayList<ArrayList<Pair<Integer,Integer>>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        // Adding edges with weights
        adj.get(1).add(new Pair<>(2, 4));
        adj.get(2).add(new Pair<>(1, 4));
        adj.get(1).add(new Pair<>(3, 2));
        adj.get(3).add(new Pair<>(1, 2));
        adj.get(2).add(new Pair<>(4, 1));
        adj.get(4).add(new Pair<>(2, 1));   
        adj.get(3).add(new Pair<>(4, 3));
        adj.get(4).add(new Pair<>(3, 3));
        System.out.println("Weighted Adjacency List:");
        for(int i=1;i<n;i++){
            System.out.print(i + ": ");
            for(int j=0;j<adj.get(i).size();j++){
                Pair<Integer, Integer> edge = adj.get(i).get(j);
                System.out.print("(" + edge.first + ", " + edge.second + ") ");
            }
            System.out.println();
        }
    }
}