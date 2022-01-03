package leetcode;

import java.util.*;

/*
LC Easy : https://leetcode.com/problems/contains-duplicate/
* **/
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(Integer num:nums) set.add(num);
        return !(set.size()==nums.length);
    }
}
