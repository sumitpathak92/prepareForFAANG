package leetcode;

public class SingleElementInSortedArray {

    public static void main(String[] args) {
        int[] A = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(A));
    }

    public static int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        return getElementByBS(nums);
    }

    private static int getElementByBS(int[] A) {
        int l = 0; int h = A.length-1;
        while(l<h) {
            int mid = l+(h-l)/2;
            if(A[mid]==A[mid+1]) mid=mid-1;
            if((mid-l+1)%2!=0) {
                // element in first half
                h=mid;
            } else {
                // element in second half
                l = mid + 1;
            }
        }
        return A[l];
    }
}
