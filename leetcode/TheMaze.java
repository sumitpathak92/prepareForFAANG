/**
 *  https://www.leetfree.com/problems/the-maze.html
 *
 *  490. The Maze
 *  Description: There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right,
 *               but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 *               Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 */
package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {

    public static void main(String[] args) {
        int[][] maze = {{0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] end = {4, 4};
        System.out.println(hasPath(maze, start, end));
    }

    public static boolean hasPath(int[][] maze, int[] start, int[] end) {
        return bfs(maze, start, end);
    }

    public static boolean bfs(int[][] maze, int[] start, int[] end) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()) {
            int[] s = q.remove();
            if(s[0]==end[0] && s[1]==end[1]) return true;
            for (int[] dir : dirs) {
                int x = s[0]+dir[0];
                int y = s[1]+dir[1];
                while(x>=0 && y>=0 && x<maze.length && y<maze[0].length && maze[x][y]==0) {
                    x+=dir[0];
                    y+=dir[1];
                }
                if(!visited[x-dir[0]][y-dir[1]]) {
                    q.add(new int[]{x-dir[0], y-dir[1]});
                    visited[x-dir[0]][y-dir[1]] = true;
                }
            }
        }
        return false;
    }
}
