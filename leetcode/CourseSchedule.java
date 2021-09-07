package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
LC Medium : https://leetcode.com/problems/course-schedule/
@author : Sumit Pathak
*
*/
public class CourseSchedule {

    public static void main(String[] args) {
        int n = 2;
        int[][] preReq = {{1, 0}};
        System.out.println(canFinish(n, preReq));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<numCourses; i++) adjList.add(new LinkedList<>());
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        for(int[] edge : prerequisites) {
            addEdge(edge[0], edge[1], adjList);
        }
        for(int i = 0; i<numCourses; i++) {
            if(dfs(i, visited, recStack, adjList))
                return false;
        }
        return true;
    }

    private static void addEdge(int s, int d, List<List<Integer>> adjList) {
        adjList.get(s).add(d);
    }
    public static boolean dfs(int s, boolean[] visited, boolean[] recStack, List<List<Integer>> adjList) {
        if(recStack[s])
            return true;
        if(visited[s])
            return false;

        // mark as visited and part of stack
        recStack[s] = true;
        visited[s] = true;
        List<Integer> children = adjList.get(s);
        for(Integer c : children) {
            if(dfs(c, visited, recStack, adjList))
                return true;
        }
        recStack[s] = false;
        return false;
    }
}

