package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
LC Easy : https://leetcode.com/problems/min-cost-climbing-stairs/
* **/
public class MinCostClimbingStairsII {

    private static Map<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        return Math.min(helper(cost, 0), helper(cost, 1));
    }

    private static int helper(int[] cost, int index) {
        if(hm.containsKey(index)) return hm.get(index);
        if(index+2>=cost.length) return cost[index];
        hm.put(index, cost[index]+Math.min(helper(cost, index+1), helper(cost, index+2)));
        return hm.get(index);
    }
}
