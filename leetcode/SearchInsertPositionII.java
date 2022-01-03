package leetcode;

/*
LC Easy : https://leetcode.com/problems/search-insert-position/
* **/
public class SearchInsertPositionII {

    public static void main(String[] args) {
        int[] nums = {1,3, 5, 6};
        System.out.println(searchInsert(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0; int r = nums.length-1;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(nums[mid] == target) return mid;
            if(target<nums[mid]) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
}
