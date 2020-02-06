/*
 * https://codeforces.com/problemset/problem/231/A
 *
 * */
package codeforces;

import java.util.Scanner;

public class Team {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int count = 0;
        while(tc>0) {
            tc--;
            int a = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());
            int c = Integer.parseInt(sc.next());
            if(a+b+c>=2) count++;
        }
        System.out.println(count);
    }

}
