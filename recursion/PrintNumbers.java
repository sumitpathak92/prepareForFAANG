package recursion;

public class PrintNumbers {

    public static void main(String[] args) {
        printNumbersBoth(5);
    }

    public static void printNumbers(int n) {
        if(n==0) return;
        System.out.println(n);
        printNumbers(n-1);
    }

    public static void printNumbersReverse(int n) {
        if(n==0) return;
        printNumbersReverse(n-1);
        System.out.println(n);
    }

    public static void printNumbersBoth(int n) {
        if(n==0) return;
        System.out.println(n);
        printNumbersBoth(n-1);
        System.out.println(n);
    }

}
