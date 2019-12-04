package random;

public class LeastCommonSubsequence {

    public static void main(String[] args) {
        String X = "ADFDSD";
        String Y = "BDCABA";
        System.out.println(LCSLengthRecursive(X, Y, X.length(), Y.length()));
    }

    // recursive solution
    public static int LCSLengthRecursive(String X, String Y, int m , int n) {
        if(m==0 || n==0) return 0; // reached end of either of string
        if(X.charAt(m-1)==Y.charAt(n-1)) { // last character matches
            return LCSLengthRecursive(X, Y, m-1, n-1) + 1;
        }
        return Math.max(LCSLengthRecursive(X, Y, m-1, n), LCSLengthRecursive(X, Y, m,n-1));
    }

    // dynamic programming solution
    public static int lcsLengthDPSolution(String X, String Y, int m, int n) {
        int dp[][] = new int[m][n];
        if(m==0 || n==0) return 0;
        if(X.charAt())
    }
}
