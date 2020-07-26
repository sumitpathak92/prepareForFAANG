package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * LC Medium : #78 https://leetcode.com/problems/subsets/
 * */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(":::: output ::::  "+subsets(nums).toString());
    }

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> curr : result) {
                temp.add(new ArrayList<Integer>(curr){{add(i);}});
            }
            result.addAll(temp);
        }
        return result;
    }
}
