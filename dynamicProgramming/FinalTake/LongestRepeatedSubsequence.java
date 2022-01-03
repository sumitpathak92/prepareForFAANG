package dynamicProgramming.FinalTake;

public class LongestRepeatedSubsequence {

    public static void main(String[] args) {
        System.out.println(longestRepeatedSubsequence("afghabfh"));
    }

    public static int longestRepeatedSubsequence(String s) {
        String r = s;
        int m = s.length(); int n = r.length();
        int[][] t = new int[m+1][n+1];

        for(int j=0; j<n+1;j++) {
            t[0][j] = 0;
        }
        for(int i=0; i<m+1; i++) {
            t[i][0] = 0;
        }

        for(int i = 1; i<m+1; i++) {
            for(int j = 1; j<n+1; j++) {
                if(s.charAt(i-1) == r.charAt(j-1) && i!=j)
                    t[i][j] = 1+t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
            }
        }
        return t[m][n];
    }
}
