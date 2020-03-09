//Problem statement

/*
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
   Return the answer in an array.
 * */


/*
*
* Input: nums = [8,1,2,2,3]
* Output: [4,0,1,1,3]
* Explanation : For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
                For nums[1]=1 does not exist any smaller number than it.
                For nums[2]=2 there exist one smaller number than it (1).
                For nums[3]=2 there exist one smaller number than it (1).
                For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

**/
package leetcode;

import java.util.Arrays;

public class SmallerNumbersThanCurrent {

    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        System.out.println(Arrays.toString(tmp));
        for(int i = 0; i<nums.length; i++) {
            res[i] = findFirstOccurrence(nums, tmp[i]);
        }
        return res;
    }

    public static int findFirstOccurrence(int[] nums, int x)
    {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < x) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
