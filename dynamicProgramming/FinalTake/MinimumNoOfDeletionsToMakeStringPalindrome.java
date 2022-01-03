package dynamicProgramming.FinalTake;

public class MinimumNoOfDeletionsToMakeStringPalindrome {

    public static void main(String[] args) {
        System.out.println(minimumDeletions("agbcba"));
    }

    public static int minimumDeletions(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return minimumDeletionHelper(s, rev);
    }

    static int minimumDeletionHelper(String s, String r) {
        int m = s.length(); int n = r.length();
        int[][] t = new int[m+1][n+1];
        for(int i = 0; i<m+1; i++) {
            for(int j = 0; j<n+1; j++) {
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 0;
            }
        }

        for(int i = 1; i<m+1; i++) {
            for(int j = 1; j<n+1; j++){
                if(s.charAt(i-1)==r.charAt(j-1)) {
                    t[i][j] = 1+t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return s.length() - t[m][n];
    }
}
