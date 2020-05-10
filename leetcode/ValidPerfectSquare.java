package leetcode;

public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1));
    }

    public static boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        return (sqrt(num)- Math.floor(sqrt(num))) == 0;
    }

    public static double sqrt(int num) {
        double tmp;
        double sr = num/2;
        do {
            tmp = sr;
            sr = (tmp+(num/tmp)) / 2;
        } while((tmp-sr)!=0);

        return sr;
    }
}
