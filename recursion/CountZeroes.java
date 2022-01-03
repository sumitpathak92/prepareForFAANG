package recursion;

public class CountZeroes {

    public static void main(String[] args) {
        System.out.println(countZero(303201));
    }

    static int countZero(int n) {
        return helper(n, 0);
    }

    // special pattern, how to pass a value to above calls
    static int helper(int n, int c) {
        if(n==0) return c;
        int rem = n%10;
        if(rem == 0) return helper(n/10, c+1);
        return helper(n/10, c);
    }
}
