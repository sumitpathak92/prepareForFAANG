package leetcode;

/**
 *
 * problem : https://leetcode.com/problems/add-binary/
 *
 * */

public class AddBinary {
    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        System.out.println("output is ::::   "+addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        if(a.length()==0) return b;
        if(b.length()==0) return a;
        int l1 = a.length()-1; int l2 = b.length()-1; int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(l1>=0 || l2>=0) {
            int sum=0;
            if(l1>=0 && l2<0) sum = a.charAt(l1) - '0' + carry;
            if(l2>=0 && l1<0) sum = b.charAt(l2) - '0' + carry;
            if(l1>=0 && l2>=0) sum = a.charAt(l1) - '0' + b.charAt(l2) - '0' + carry;
            System.out.println("sum is :  "+sum);
            if(sum == 0) {
                sb.append('0');
                carry = 0;
            } else if(sum == 1) {
                sb.append('1');
                carry=0;
            } else if(sum==2) {
                sb.append('0');
                carry = 1;
            } else {
                sb.append('1');
                carry = 1;
            }
            l1-=1; l2-=1;
        }
        if(carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }
}
