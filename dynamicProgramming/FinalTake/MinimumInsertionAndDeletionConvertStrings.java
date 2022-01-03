package dynamicProgramming.FinalTake;

/**
 * Problem Statement : We need to convert one string A to string B. The only operations allowed are insertion and deletion.
 * We have to find the minimum no of insertions and deletions to derive string B from string A.
 *
 * Solution : Variation of the Classic LCS problem
 *
 * **/
public class MinimumInsertionAndDeletionConvertStrings {

    public static void main(String[] args) {
        System.out.println(minimumInsertsAndDeletesToConvertStrings("heap", "pea"));
    }

    static int minimumInsertsAndDeletesToConvertStrings(String X, String Y) {
        int lcsLength = LCS(X, Y);
        int deletions = X.length()-lcsLength;
        int insertions = Y.length()-lcsLength;
        System.out.println(deletions + " :::: " +insertions);
        return deletions+insertions;
    }

    static int LCS(String x, String y) {
        int m = x.length(); int n = y.length();
        int[][] t = new int[m+1][n+1];
        for(int i = 0; i<m+1; i++) {
            for(int j = 0; j<n+1; j++) {
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 0;
            }
        }

        for(int i=1; i<m+1; i++) {
            for(int j = 1; j<n+1; j++) {
                if(x.charAt(i-1)==y.charAt(j-1))
                    t[i][j] = 1+t[i-1][j-1];
                else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
}
