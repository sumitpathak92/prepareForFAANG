/*
* https://www.codechef.com/JAN20B/problems/BRKBKS
* */



package codechef;

import java.util.*;
public class BreakingBricks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-->0) {
            int s = sc.nextInt();
            int w1 = sc.nextInt();
            int w2 = sc.nextInt();
            int w3 = sc.nextInt();
            if(s<w1 ||s<w2||s<w3)
            {
                System.out.println(0);
            }
            else if(s>=w1+w2+w3)
            {
                System.out.println(1);
            }
            else if(s>=w1+w2 || s>=w2+w3)
            {
                System.out.println(2);
            }
            else if(s>=w1 || s>=w3)
            {
                System.out.println(3);
            }
        }
    }
}
