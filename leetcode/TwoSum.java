package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 *
 * problem : https://leetcode.com/problems/two-sum/
 * */
public class TwoSum {

    public static void main(String[] args) {
        int[] A = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(A, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i<nums.length; i++) {
            int toFind = target - nums[i];
            if(hm.containsKey(toFind)) {
                return new int[] {i, hm.get(toFind)};
            }
            hm.put(nums[i], i);
        }
        return null;
    }
}
