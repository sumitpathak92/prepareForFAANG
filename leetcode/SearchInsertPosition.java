package leetcode;

/*
LC easy : https://leetcode.com/problems/search-insert-position/
* **/
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0; int r = nums.length-1;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(target == nums[mid]) return mid;
            else if(target>nums[mid]) {
                l = mid+1;
            } else if(target<nums[mid]) {
                r = mid-1;
            }
        }
        return l;
    }
}
