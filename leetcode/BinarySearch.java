package leetcode;

/*
LC Easy : https://leetcode.com/problems/binary-search/
* **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 2));
    }

    public static int search(int[] nums, int target) {
        int l = 0; int r = nums.length-1;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(nums[mid] == target) return mid;
            if(target>nums[mid]) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return -1;
    }
}
