/*
 * https://www.codechef.com/problems/IOC
 * */

package codechef;

import java.util.*;

public class IcingOnTheCake {

    public static void main(String[] args) throws java.lang.Exception {
        try {
            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();
            int K = sc.nextInt();
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int l = sc.nextInt();
                int b = sc.nextInt();
                res.add(Math.max(l, b) * 2);
            }
            Collections.sort(res);
            int len = res.size();
            long sum = 0;
            for (long i = 0; i < K; i++) {
                sum += res.get(len - 1);
                len--;
            }
            System.out.println(sum);
        } catch (Exception e) {
            return;
        }
    }

}
