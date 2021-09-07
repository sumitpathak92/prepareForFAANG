package leetcode;

/*
LC Easy: https://leetcode.com/problems/power-of-two/
* **/
public class IsPowerOfTwo {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(isPowerOfTwoII(n));
    }

    public static boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        if(n==0) return false;
        if(n%2 != 0) return false;
        return isPowerOfTwo(n/2);
    }

    public static boolean isPowerOfTwoII(int n) {
        if(n==0) return false;
        while(n%2==0) n/=2;
        return n==1;
    }
}
