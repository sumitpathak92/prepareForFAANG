package geeksforgeeks;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {

    public static void main(String[] args) {
        int[][] A = {{1, 0, 0, 0},
                     {1,1,0,1},
                     {1,1,0,0},
                     {0,1,1,1}};
        System.out.println(findPath(A, A.length));
    }

    public static ArrayList<String> findPath(int[][] A, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        String currPath = "";
        if(A[0][0]==0 || A[n-1][n-1]==0) {
            res.add("-1");
            return res;
        }
        boolean[][] visited = new boolean[A.length][A.length];
        pathHelper(A, res, currPath, visited, 0, 0);
        return res;
    }

    public static void pathHelper(int[][] A, List<String> res, String path, boolean[][] visited, int i, int j) {
        if(i==A.length-1 && j==A.length-1) {
            res.add(path);
            return;
        }

        if(i<0 || i>=A.length || j<0 || j>=A.length || visited[i][j] || A[i][j]==0) {
            return;
        }
        visited[i][j] = true;
        pathHelper(A, res, path+"D", visited, i+1, j);
        pathHelper(A, res, path+"L", visited, i, j-1);
        pathHelper(A, res, path+"R", visited, i, j+1);
        pathHelper(A, res, path+"U", visited, i-1, j);
        visited[i][j] = false;
    }
}
