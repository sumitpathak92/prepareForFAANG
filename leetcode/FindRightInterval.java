package leetcode;

import java.util.*;

/*
LC Medium : https://leetcode.com/problems/find-right-interval/
* **/
public class FindRightInterval {

    public static void main(String[] args) {
        int[][] intervals = {{4,5}, {2,3}, {1,2}};
        System.out.println(Arrays.toString(findRightInterval(intervals)));
    }

    public static int[] findRightInterval(int[][] intervals) {
        if(intervals.length == 1) return new int[]{-1};
        int[] ans = new int[intervals.length];
        List<Integer> start = new ArrayList<>();
        Map<Integer, Integer> positionMap = new HashMap<>(); int i=0;
        for(int[] interval : intervals) {
            positionMap.put(interval[0], i);
            start.add(interval[0]);
            i++;
        }
        Collections.sort(start);
        for(int j = 0; j<intervals.length; j++) {
//            System.out.println(" "+ Arrays.toString(start) +" " +intervals[j][1]);
            int end_1 = binarySearch(start, intervals[j][1]);
            if(end_1<intervals[j][1])
                ans[j] = -1;
            else ans[j] = positionMap.get(end_1);
        }
//        System.out.println(Arrays.toString(start));
//        System.out.println(Arrays.toString(end));

        return ans;
    }

    private static int binarySearch(List<Integer> A, int target) {
        int i = 0; int j = A.size()-1;
        while(i<j) {
            int mid = i+(j-i)/2;
            if(A.get(mid)<target)
                i=mid+1;
            else
                j=mid;
        }
        return A.get(i);
    }
}
