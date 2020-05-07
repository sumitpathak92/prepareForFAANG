package codeforces;

import java.util.Scanner;

public class GregWorkout {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int i=0; int j=1; int k=2; int chest = 0; int bic =0; int bac = 0;

        while(i<n) {
            chest+=arr[i];
            i+=3;
        }
        while(j<n){
            bic+=arr[j];
            j+=3;
        }
        while(k<n) {
            bac+=arr[k];
            k+=3;
        }
//        System.out.println(chest + "  " + bac + " " + bic);
        if(chest>bac && chest>bic) System.out.println("chest");
        if(bac>chest && bac>bic) System.out.println("back");
        if(bic>chest && bic>bac) System.out.println("biceps");
    }
}
