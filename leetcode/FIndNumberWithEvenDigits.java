package leetcode;

public class FIndNumberWithEvenDigits {

    public static void main(String[] args) {
        int[] nums = {1, 2, 43433, 672, 33, 999, 898989};
        System.out.println(findNumbers(nums));
    }

    public static int findNumbers(int[] nums) {
        int c = 0;
        for(int n : nums) {
            int l = 0;
            int tmp = 1;
            while(tmp<=n) {
                l++;
                tmp*=10;
            }
            if(l%2==0) c++;
        }
        return c;
    }
}
