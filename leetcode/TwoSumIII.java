package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
LC Easy : https://leetcode.com/problems/two-sum/
* **/
public class TwoSumIII {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 13};
        System.out.println(Arrays.toString(twoSum(nums, 3)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length ; i++) {
            int cmp = target - nums[i];
            if(hm.containsKey(cmp)) return new int[] {hm.get(cmp), i};
            hm.put(nums[i], i);
        }
        return null;
    }
}
