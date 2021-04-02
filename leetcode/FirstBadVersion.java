package leetcode;


/**
 *
 * problem : https://leetcode.com/problems/first-bad-version/
 *
 * */


public class FirstBadVersion extends VersionControl{

    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        int i = 0; int j = n;
        while(i<j) {
            int mid = i + (j-i)/2;
            if(isBadVersion(mid)) {
                j = mid;
            } else {
                i=mid+1;
            }
        }
        return i;
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return true;
    };
}
