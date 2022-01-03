package dynamicProgramming.FinalTake;

public class PrintLCSOfTwoStrings {

    static int[][] t;
    public static void main(String[] args) {
        System.out.println(lcsOfStrings("adbsf", "asf"));
    }

    static String lcsOfStrings(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        t = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) t[i][j] = 0;
                if (j == 0) t[i][j] = 0;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }

        int i = m; int j = n; StringBuilder res = new StringBuilder();
        while(i>0 && j>0) {
            if(X.charAt(i-1) == Y.charAt(j-1)) {
                res.append(X.charAt(i - 1));
                i--; j--;
            }
            else {
                if(t[i][j-1] > t[i-1][j]) j--;
                else i--;
            }
        }
        return res.reverse().toString();
    }

}
