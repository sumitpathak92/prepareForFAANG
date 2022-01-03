package leetcode;

/*
LC Easy : https://leetcode.com/problems/contains-duplicate-ii/
* **/
public class ContainsDuplicateII {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3}; int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i<nums.length-k; i++) {
            int end = i + k;
            if(nums[i] == nums[end]) return true;
        }
        return false;
    }
}
