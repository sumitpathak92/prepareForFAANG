package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class FlipImage {

    public static void main(String[] args) {
        int[][] input = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(flipImage(input)));
    }

    private static int[][] flipImage(int[][] input) {
        horizontally(input);
        System.out.println("after horizontal arrangement  "+ Arrays.deepToString(input));

        return invert(input);
    }

    private static void horizontally(int[][] input) {
        for(int i = 0; i<input.length; i++) {
            input[i] = reverse(input[i]);
        }
    }

    private static int[][] invert(int[][] input) {
        for(int i = 0; i<input.length; i++) {
            for(int j = 0; j<input[i].length; j++) {
                if(input[i][j] == 1) input[i][j] = 0;
                else input[i][j] = 1;
            }
        }
        return input;
    }

    private static int[] reverse(int[] input) {
        Stack<Integer> st = new Stack<>();
        for (int value : input) {
            st.push(value);
        }
        for(int i = 0 ; i<input.length; i++) {
            input[i] = st.pop();
        }
        return input;
    }

}
