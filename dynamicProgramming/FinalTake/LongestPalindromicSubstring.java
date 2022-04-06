package dynamicProgramming.FinalTake;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("eabcb"));
    }

    public static String longestPalindromicSubstring(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();
        String rev = sb.toString();
        int m = s.length(); int n = rev.length();
        int[][] t = new int[m+1][n+1];
        for(int i = 0; i<m+1; i++) {
            for(int j = 0; j<n+1; j++) {
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 0;
            }
        }

        for(int i = 1; i<m+1; i++) {
            for(int j = 1; j<n+1; j++) {
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = 0;
                }
            }
        }
        for(int i = 0; i<m+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        int i = m; int j = n; StringBuilder ans = new StringBuilder();
        while(i>0 && j>0) {
            if(s.charAt(i-1)==rev.charAt(j-1)) {
                ans.append(s.charAt(i-1));
                i--; j--;
            } else {
                if(t[i][j-1] > t[i-1][j])
                    j--;
                else
                    i--;
            }
        }
//        int max = Integer.MIN_VALUE;
//        for(int i = 0; i<m+1; i++) {
//            for(int j = 0; j<n+1; j++) {
//                if(t[i][j]>max){
//                    max = t[i][j];
//                }
//            }
//        }
        return ans.reverse().toString();
    }

}
