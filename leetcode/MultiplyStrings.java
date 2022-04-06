package leetcode;

import java.util.Arrays;

public class MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String s1, String s2) {
        if(s1.equals("0") || s2.equals("0")) return "0";
        int l1 = s1.length(); int l2 = s2.length();
        int[] prod = new int[l1+l2];
        for(int i = s1.length()-1; i>=0; i--) {
            int d1 = s1.charAt(i)-'0';
            for(int j = s2.length()-1; j>=0; j--) {
                int d2 = s2.charAt(j)-'0';
                int idx = i+j+1;
                int p = (d1*d2)+prod[idx];
                prod[idx] = p%10; prod[idx-1] += p/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(int i = 0; i<prod.length; i++) {
            if(prod[i]==0) continue;
            else {
                start = i;
                break;
            }
        }
        for(int i = start; i<prod.length; i++) {
            sb.append(prod[i]);
        }
        return sb.toString();
    }
}
