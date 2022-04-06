package leetcode;


import java.util.*;

/**
LC Medium : https://leetcode.com/problems/course-schedule/
@author : Sumit Pathak
*
**/
public class CourseSchedule {

    public static void main(String[] args) {
        int n = 2;
        int[][] preReq = {{1, 0}, {0,1}};
        System.out.println(canFinish(n, preReq));
    }

    public static boolean canFinish(int n, int[][] prerequisites) {
        boolean[] visited = new boolean[n];
        boolean[] dfsVisited = new boolean[n];
        Arrays.fill(visited, false);
        Arrays.fill(dfsVisited, false);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(i, new ArrayList<>());
        }
        for(int[] row : prerequisites) {
            addEdge(row[1], row[0], adj);
        }
        System.out.println(adj);
        for(int i = 0; i<n; i++) {
            if(!visited[i]) {
                if(checkCycleDFS(i, visited, dfsVisited, adj)) return false;
            }
        }
        return true;
    }

    private static void addEdge(int s, int d, ArrayList<ArrayList<Integer>> adjList) {
        adjList.get(s).add(d);
    }

    public static boolean checkCycleDFS(int s, boolean[] visited, boolean[] dfsVis, ArrayList<ArrayList<Integer>> adjList) {
        visited[s]=true;
        dfsVis[s]=true;
        for(int i : adjList.get(s)){
            if(!visited[i]) {
                if(checkCycleDFS(i, visited, dfsVis, adjList))
                    return true;
            } else if(dfsVis[i]) return true;
        }
        dfsVis[s]=false;
        return false;
    }

}

