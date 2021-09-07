package Algorithms.Recursion;

// calculating factorial using recursion
public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    // recursive method to get factorial of a number
    static int factorial(int n) {
        // base case
        if(n==0) return 1;
        // recursive case
        return n*factorial(n-1);
    }

}
