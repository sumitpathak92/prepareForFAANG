package leetcode;

/*
LC Easy : https://leetcode.com/problems/power-of-three/
* **/
public class IsPowerOfThree {

    public static void main(String[] args) {
        int n = 0;
        System.out.println(isPowerOfThree(n));
    }

    public static boolean isPowerOfThree(int n) {
        if(n==1) return true;
        if(n==0) return false;
        if(n%3!=0) return false;
        return isPowerOfThree(n/3);
    }
}
