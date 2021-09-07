package leetcode;


import java.util.Arrays;

/**
 * LC Medium : https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1393/
 * */
public class FloodFillI {

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        System.out.println(Arrays.deepToString(floodFill(image, 1, 1, 2)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        int n = image[0].length;
        int currColor = image[sr][sc];
        dfs(image, sr, sc, newColor, currColor);
        return image;
    }

    public static void dfs(int[][] image, int r, int c, int nc, int oc) {
        if(r<0 || c<0 || r>=image.length || c>=image[0].length || image[r][c] == nc || image[r][c]!=oc)
            return;
        image[r][c] = nc;

        dfs(image, r+1, c, nc, oc);
        dfs(image, r-1, c, nc, oc);
        dfs(image, r, c+1, nc, oc);
        dfs(image, r, c-1, nc, oc);
    }
}
