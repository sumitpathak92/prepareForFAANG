package codechef.feblong2020;

import java.util.Arrays;
import java.util.Scanner;

public class SchoolOfGeometry {

    public static void main(String[] args) throws java.lang.Exception {
        try{
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0) {
                int N = sc.nextInt();
                long[] A = new long[N];
                long[] B = new long[N];
                for(int i = 0; i<N; i++) {
                    A[i] = sc.nextInt();
                }
                for(int i = 0; i<N; i++) {
                    B[i] = sc.nextInt();
                }
                Arrays.sort(A);
                Arrays.sort(B);
                long s = 0;
                for(int i = 0 ; i< N; i++) {
                    s+=Math.min(A[i],B[i]);
                }
                System.out.println(s);
            }
        } catch (Exception e) {
            return;
        }
    }
}
