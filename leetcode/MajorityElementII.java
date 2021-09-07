package leetcode;

import java.util.*;

/*
LC Easy : https://leetcode.com/problems/majority-element/
* **/
public class MajorityElementII {

    public static void main(String[] args) {
        int[] nums = {3,2, 3};
        System.out.println(majorityElementII(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i : nums) {
            if(hm.containsKey(i)){
                hm.put(i, hm.get(i)+1);
            } else {
                hm.put(i, 1);
            }
        }

        int max = Collections.max(hm.values());
        List<Integer> keys = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue()==max) {
                keys.add(entry.getKey());
            }
        }
        return keys.get(0);
    }

    public static int majorityElementII(int[] nums) {
        int count = 0;
        int first = Integer.MAX_VALUE;
        for(int num : nums) {
            if(count == 0) first = num;
            if(num == first) {
                count+=1;
            } else count-=1;
        }
        return first;
    }
}
