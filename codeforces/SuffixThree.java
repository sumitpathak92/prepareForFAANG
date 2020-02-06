/*
* https://codeforces.com/problemset/problem/1281/A
*
* */

package codeforces;
import java.util.Scanner;


public class SuffixThree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc>0) {
            String input = sc.next();
            System.out.println(input);
            String[] inputs = input.split("_");
            System.out.println(inputs.toString());
            suffixThree(inputs);
        }
    }

    public static int suffixThree(String[] inputs) {
        if(inputs.length==0) {
            return 0;
        }
        for(String input : inputs) {
            System.out.println(input);
        }
        return -1;
    }


    public void getSuffixTree(String str) {

    }
}
