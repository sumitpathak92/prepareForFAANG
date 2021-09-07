package leetcode;

/*
LC Medium : https://leetcode.com/problems/find-the-celebrity/
* **/
public class FindCelebrity {

    public static void main(String[] args) {

    }

    public static int findCelebrity(int n) {
        int[] in = new int[n+1];
        int[] out = new int[n+1];

        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n; j++) {
                if(knows(i, j)) {
                    out[i] ++;
                    in[j] ++;
                }
            }
        }
        for(int i = 0; i<n; i++) {
            if(in[i] == n-1 && out[i] == 0) return i;
        }
        return -1;
    }

    public static boolean knows(int a, int b) {
        return true;
    }
}
