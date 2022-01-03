package leetcode;

public class ShortestCommonSupersequence {

    static int[][] t;
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequenceLength("abac", "cab"));
    }

    public static String shortestCommonSupersequenceLength(String x, String y) {
        int m = x.length(); int n = y.length();
        t = new int[m+1][n+1];
        for(int i = 0; i<m+1; i++) {
            for(int j=0; j<n+1; j++) {
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 0;
            }
        }
        for(int i = 1; i<=m; i++) {
            for(int j = 1; j<=n; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    t[i][j] = 1+t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        int i = m; int j = n; StringBuilder ans = new StringBuilder();
        while(i>0 && j>0) {
            if(x.charAt(i-1) == y.charAt(j-1)) {
                ans.append(x.charAt(i-1));
                i--; j--;
            } else {
                if(t[i][j-1]>t[i-1][j]) {
                    ans.append(y.charAt(j-1));
                    j--;
                } else {
                    ans.append(x.charAt(i - 1));
                    i--;
                }
            }
        }
        while(i>0) {
            ans.append(x.charAt(i-1));
            i--;
        }
        while(j>0) {
            ans.append(y.charAt(j-1));
            j--;
        }
        return ans.reverse().toString();
    }

    // bottom-up DP approach
//    static int longestCommonSubsequenceII(String x, String y) {
//        int m = x.length(); int n = y.length();
//        t = new int[m+1][n+1];
//        for(int i = 0; i<m+1; i++) {
//            for(int j=0; j<n+1; j++) {
//                if(i==0) t[i][j] = 0;
//                if(j==0) t[i][j] = 0;
//            }
//        }
//        for(int i = 1; i<=m; i++) {
//            for(int j = 1; j<=n; j++) {
//                if(x.charAt(i-1) == y.charAt(j-1)) {
//                    t[i][j] = 1+t[i-1][j-1];
//                } else {
//                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
//                }
//            }
//        }
//        return t[m][n];
//    }
}
