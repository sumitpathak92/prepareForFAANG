package random;

public class LargestCommonSubsequence {

    public static void main(String[] args) {
        String X = "XMJYAUZ";
        String Y = "MZJAWXU";
        System.out.println(lcsLengthSpaceOptimized(X, Y));
    }

    // recursive solution
    public static int LCSLengthRecursive(String X, String Y, int m , int n) {
        if(m==0 || n==0) return 0; // if any of the string is empty
        if(X.charAt(m-1)==Y.charAt(n-1)) { // last character matches
            return LCSLengthRecursive(X, Y, m-1, n-1) + 1;
        }
        return Math.max(LCSLengthRecursive(X, Y, m-1, n), LCSLengthRecursive(X, Y, m,n-1));
    }

    // dynamic programming solution
    public static int lcsLengthDPSolution(String X, String Y, int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for(int i = 0; i<=m; i++) {
            for(int j = 0; j<=n; j++) {
                if(i==0 || j==0) dp[i][j] = 0;
                else if(X.charAt(i-1)==Y.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    // space optimized version
    public static int lcsLengthSpaceOptimized(String X, String Y) {
        int m = X.length(), n = Y.length();
        int[] curr = new int[n+1];
        int[] prev = new int[n+1];

        // fill lookup table, bottom up
        for(int i = 0; i<=m ; i++) {
            for(int j = 0; j<=n ; j++) {
                if(i>0 && j>0) {
                    if(X.charAt(i-1)==Y.charAt(j-1)) {
                        curr[j] = prev[j-1]+1;
                    } else {
                        curr[j] = Integer.max(prev[j], curr[j-1]);
                    }
                }
            }
            System.arraycopy(curr, 0, prev, 0, n+1);
        }
        return curr[n];
    }
}
