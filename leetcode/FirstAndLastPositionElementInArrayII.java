package leetcode;

import java.util.Arrays;

/*
LC Medium : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
* **/
public class FirstAndLastPositionElementInArrayII {

    public static void main(String[] args) {
        int[] A = {};
        System.out.println(Arrays.toString(searchRange(A, 6)));
    }

    public static int[] searchRange(int[] A, int target) {
        int[] ans = new int[]{-1, -1};
        if(A.length==0) return new int[]{-1, -1};
        ans[0] = search(A, target, true);
        if(ans[0]!=-1) {
            ans[1] = search(A, target, false);
        }
        return ans;
    }

    private static int search(int[] A, int target, boolean getStartIndex) {
        int start = 0; int end = A.length-1; int ans = -1;
        while(start<=end) {
            int mid = start+(end-start)/2;
            if(A[mid]>target) end = mid-1;
            else if(A[mid]<target) start = mid+1;
            else {
                // potential answer
                ans = mid;
                if(getStartIndex) end = mid-1;
                else start = mid+1;
            }
        }
        return ans;
    }
}
