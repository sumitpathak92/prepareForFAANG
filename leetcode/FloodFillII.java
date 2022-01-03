package leetcode;

import java.util.Arrays;
import java.util.Stack;

/*
LC Easy : https://leetcode.com/problems/flood-fill/
* **/
public class FloodFillII {

    public static void main(String[] args) {
        int[][] image = {{0,0,0}, {0,0,0}};
        System.out.println(Arrays.deepToString(floodFill(image, 0, 0, 2)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        boolean[][] visited = new boolean[image.length][image[0].length];
        helper(image, visited, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public static void helper(int[][] image, boolean[][] visited, int sr, int sc, int newColor, int oldColor) {
        if(sr>=0 && sr<image.length && sc>=0 && sc<image[0].length && !visited[sr][sc] && image[sr][sc]!=newColor && image[sr][sc]==oldColor) {
            visited[sr][sc] = true;
            image[sr][sc] = newColor;
            helper(image, visited, sr+1, sc, newColor, oldColor);
            helper(image, visited, sr-1, sc, newColor, oldColor);
            helper(image, visited, sr, sc+1, newColor, oldColor);
            helper(image, visited, sr, sc-1, newColor, oldColor);
        }
    }
}
