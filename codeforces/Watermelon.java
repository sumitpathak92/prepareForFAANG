/*
 * https://codeforces.com/problemset/problem/4/A
 *
 * */

package codeforces;

import java.util.Scanner;

public class Watermelon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        System.out.println(getResult(tc));
    }

    private static String getResult(int w) {
        if(w%2 == 0 && w!=2) return "YES";
        return "NO";
    }


}
