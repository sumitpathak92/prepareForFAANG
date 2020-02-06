/**
 *
 * https://www.codechef.com/problems/MAXDIFF
 * */


package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumWeightDifference {

    public static void main(String[] args)  throws java.lang.Exception {
        try {
            Scanner sc = new Scanner(System.in);
            int tc = sc.nextInt();
            while (tc > 0) {
                tc--;
                int N = Integer.parseInt(sc.next());
                int K = Integer.parseInt(sc.next());
                int[] weights = new int[N];
                for (int i = 0; i < N; i++) {
                    weights[i] = Integer.parseInt(sc.next());
                }
                Arrays.sort(weights);
                int s = 0, r = 0;
                for (int i = K; i < N; i++) {
                    r += weights[i];
                }
                for (int i = 0; i < K; i++) {
                    s += weights[i];
                }
                int m1 = Math.abs(s - r);
                s = 0;
                r = 0;
                for (int i = N - 1; i >=N-K; i--) {
                    s += weights[i];
                }
                for (int i = N - K - 1; i >= 0; i--) {
                    r += weights[i];
                }
                int m2 = Math.abs(s - r);
                if (m1 > m2 || m1 == m2) System.out.println(m1);
                else System.out.println(m2);
            }
        } catch (Exception e) {
            return;
        }
    }
}
