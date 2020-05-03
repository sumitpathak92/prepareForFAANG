package codechef.maylong2020;

import java.util.Arrays;
import java.util.Scanner;

public class COVID19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        System.out.println("tc "+T);
        while(T-->0) {
            int N = sc.nextInt();
            int[] pos = new int[N];
            for(int i =0; i<N; i++) {
                pos[i] = sc.nextInt();
            }
            int[] dist = new int[N-1];
            for(int i=0;i<N-1; i++) {
                dist[i] = Math.abs(pos[i+1]-pos[i]);
            }
            System.out.println(Arrays.toString(dist));
            int min = 1, max = 1, count=1;
            for(int i : dist) {
                if(i==2 || i==1) {
                    count++;
                } else {
                    if(count>max) max = count;
                    if(count<max && count>min) min = count;
                }
            }
            System.out.println(min + " " +max);
        }
    }

}
