package leetcode;

public class CountGoodNumbers {

    public static void main(String[] args) {

    }

    public static int countGoodNumbers(long n) {
        return -1;
    }

    static boolean isEven(int n) {
        return n%2==0;
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
