package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {

    public static void main(String[] args) {
        int[] input = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println("output is  -> "+majorityElement(input));
    }

    static List<Integer> majorityElement(int[] nums) {
        // using hashtable approach
        int appearanceCount = nums.length/3;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : nums) {
            if(hm.containsKey(i)) {
                hm.put(i, hm.get(i)+1);
            } else {
                hm.put(i, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(HashMap.Entry<Integer, Integer> entry : hm.entrySet()) {
            if(entry.getValue() > appearanceCount) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
