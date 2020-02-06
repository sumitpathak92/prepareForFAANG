/*
 * https://www.codechef.com/problems/SUBINC
 * */

package codechef;

import java.util.Scanner;

public class CountSubarrays {

    public static void main(String[] args) throws java.lang.Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int tc = sc.nextInt();
            while(tc>0) {
                tc--;
                int N = sc.nextInt();
                int[] A = new int[N];
                for (int i = 0; i < N; i++) {
                    A[i] = sc.nextInt();
                }
                long ans = 0;
                int count = 1;
                for (int i = 1; i < N; i++) {
                    if (A[i] >= A[i - 1]) {
                        count++;
                        continue;
                    }
                    ans += ((long) count * (count + 1) / 2);
                    count = 1;
                }
                ans += ((long) (count) * (count + 1) / 2);
                System.out.println(ans);
            }
        } catch (Exception e) {
            return;
        }
    }
}
