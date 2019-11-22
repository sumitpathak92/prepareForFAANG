package commonDataStructures;

import java.util.*;

public class Graph {

    public int V;
    public LinkedList[] adj;

    public Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for(int i = 0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int d) {
        adj[s].add(d);
    }

    public void bfs(int v) {

        // mark all nodes as unvisited
        boolean[] visited = new boolean[this.V];
        LinkedList<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.offer(v);
        while(!q.isEmpty()) {
            v = q.poll();
            System.out.println(v+ " ");
            Iterator<Integer> it = adj[v].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if(!visited[n]) {
                    q.offer(n);
                    visited[n] = true;
                }
            }
        }
    }

    public void dfs(int s) {
        boolean[] visited = new boolean[this.V];
        Stack<Integer> st = new Stack<>();
        visited[s] = true;
        st.push(s);
        System.out.println("using dfs -->  ");
        while(!st.isEmpty()) {
            s = st.pop();
            System.out.println(s + " ");
            Iterator<Integer> it = adj[s].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if(!visited[n]) {
                    st.push(n);
                    visited[n] = true;
                }
            }
        }
    }

    public boolean detectCycle(int s) {
        boolean[] visited = new boolean[this.V];
        for(int i=0;i<this.V;i++) {
            if(!visited[i] && isCyclicConnected(adj, i, this.V-1, visited)) return true;
        }
        return false;
    }

    private boolean isCyclicConnected(LinkedList[] adj, int i, int v, boolean[] visited) {
        int[] parent = new int[v];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new LinkedList<>();
        System.out.println("v value  "+v);
        visited[v] = true;
        q.add(v);
        while(!q.isEmpty()) {
            int u = q.poll();
            for(int j = 0; j<adj[u].size(); j++) {
                int k = (int) adj[u].get(i);
                if(!visited[k]) {
                    visited[k] = true;
                    q.add(k);
                    parent[k] = u;
                } else if(parent[u]!=v) return true;
            }
        }
        return false;
    }
}
