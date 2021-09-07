package leetcode;

/*
LC Easy : https://leetcode.com/problems/power-of-four/
* **/
public class PowerOfFour {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(0));
    }

    public static boolean isPowerOfFour(int n) {
        if(n==0 || n==1) return true;
        if(n%4!=0) return false;
        return isPowerOfFour(n/4);
    }
}
