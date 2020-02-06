/**
 * https://www.codechef.com/problems/CHEFSIGN
 * */

package codechef;

import java.util.Scanner;

public class ChefSign {

    public static void main(String[] args) throws java.lang.Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t > 0) {
                t--;
                String s = sc.next();
                System.out.println(getChefSign(s));
            }
        } catch (Exception e) {
            return;
        }
    }

    private static int getChefSign(String pattern) {
        int ans = 0, curr = 0;
        char last = '?';
        for(int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(c=='=') continue;
            if(c!=last) {
                ans = Math.max(ans, curr);
                curr = 1;
                last = c; // last encountered character
            }
            else ++curr;
        }
        ans = Math.max(ans, curr);
        return ans+1;
    }
}
