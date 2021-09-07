package leetcode;

import java.util.Arrays;

/*
LC Medium : https://leetcode.com/problems/the-maze-ii/
* **/
public class TheMazeIII {

    private static int[][] movements = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = {0,4}; int[] dest = {4,4};
        System.out.println(shortestDistance(maze, start, dest));
    }

    public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int x = maze.length; int y = maze[0].length;
        int dist[][] = new int[x][y];
        for(int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        dfs(maze, start, dist);
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }

    private static void dfs(int[][] maze, int[] s, int[][] dist) {
        for(int[] m : movements) {
            int X = s[0] + m[0];
            int Y = s[1] + m[1];
            int count = 0;
            while(X>=0 && X<maze.length && Y>=0 && Y<maze[0].length && maze[X][Y] == 0) {
                X+=m[0];
                Y+=m[1];
                count++;
            }
            if(dist[s[0]][s[1]] + count < dist[X-m[0]][Y-m[1]]){
                dist[X-m[0]][Y-m[1]] = dist[s[0]][s[1]] + count;
                dfs(maze, new int[]{X-m[0], Y-m[1]}, dist);
            }
        }
    }
}
