package leetcode.ThirtyDaysChallenge.Week1;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println("solution   "+isHappy(19));
    }

    public static boolean isHappy(int num) {
        int x = getSum(num);
        return x != -1;
    }

    public static int getSum(int n) {
        int ans = 0;
        if(n==1) return ans;
        while(n>0) {
            int x = n%10;
            ans += x*x;
            n=n/10;
        }
        if(ans<10 && ans!=1 && ans!=7) return -1;
        else return getSum(ans);
    }
}
