package leetcode;


/*
LC Medium : https://leetcode.com/problems/the-maze/
* **/
public class TheMazeII {

    private static boolean res = false;
    private static int[][] dirs = {{0,1}, {0,-1}, {-1, 0}, {1,0}};
    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = {0,4}; int[] dest = {4,4};
        System.out.println(hasPath(maze, start, dest));
    }

    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int x = maze.length; int y = maze[0].length;
        if(x==0 || y==0) return false;
        boolean[][] visited = new boolean[x][y];
        return dfs(maze, start[0], start[1], destination[0], destination[1], visited);
    }

    private static boolean dfs(int[][] maze, int sRow, int sCol, int dRow, int dCol, boolean[][] visited) {
       if(sRow == dRow && sCol == dCol) return true;
       if(sRow<0 || sCol<0 || sRow>maze.length || sCol>maze[0].length || visited[sRow][sCol]) return false;
       visited[sRow][sCol] = true;
       for(int[] d : dirs) {
           int X = sRow+d[0];
           int Y = sCol+d[1];
           while(X>=0 && X<maze.length && Y>=0 && Y<maze[0].length && maze[X][Y] == 0) {
               X += d[0];
               Y += d[1];
           }
           if(dfs(maze, X-d[0], Y-d[1], dRow, dCol, visited)) return true;
       }
       return false;
    }
}
