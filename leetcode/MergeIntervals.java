package leetcode;

import util.CommonUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println("final list of intervals  "+merge(intervals));
        for(int[] interval : intervals) {
            CommonUtilities.arrayPrintHelper(interval);
        }
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals, (p, q) -> Integer.compare(p[0], q[0]));
        List<int[]> result = new ArrayList<>();
        int[] startInterval = intervals[0];
        result.add(startInterval);
        for(int i=1; i<intervals.length ; i++) {
            if(intervals[i][0] <= startInterval[1]) {
                // its overlapping
                startInterval[1] = Math.max(startInterval[1], intervals[i][1]);
            } else {
                startInterval = intervals[i];
                result.add(startInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
