package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Taxi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] A = new int[tc];
        int i=0, sum=0;
        while (i<tc){
            A[i] = Integer.parseInt(sc.next());
            i++;
        }
        for(int j=0; j<tc; j++) {
            sum += A[j];
        }
        int res = sum/4;
        if(sum%4==0) System.out.println(res);
        else System.out.println(res+1);
    }
}
