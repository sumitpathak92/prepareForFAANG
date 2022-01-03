package leetcode;

/*
LC Easy : https://leetcode.com/problems/first-bad-version/
* **/
public class FirstBadVersionII {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while(l<r) {
            int mid = l+(r-l)/2;
            if(isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }

    private static boolean isBadVersion(int i) {
        return true;
    }
}
