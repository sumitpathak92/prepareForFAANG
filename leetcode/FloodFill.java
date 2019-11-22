package leetcode;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        System.out.println(Arrays.deepToString(floodFill(image, 1, 1, 2)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int old = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, old, newColor, visited);
        return image;
    }

    public static void dfs(int[][] image, int sr, int sc, int old, int newColor, boolean[][] visited) {
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || visited[sr][sc] || image[sr][sc]!=old)
            return;
        visited[sr][sc] = true;
        image[sr][sc] = newColor;
        dfs(image, sr-1, sc, old, newColor, visited);
        dfs(image, sr+1, sc, old, newColor, visited);
        dfs(image, sr, sc-1, old, newColor, visited);
        dfs(image, sr, sc+1, old, newColor, visited);
    }
}
