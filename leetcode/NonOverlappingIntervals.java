package leetcode;

import util.CommonUtilities;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println("no of intervals to be removed is : "+eraseOverlapIntervals(intervals));
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
        // Steps to follow
        // 1. sort the interval array by END(very important)
        sortIntervalsByEnd(intervals);
        // 2. iterate through the list of intervals
        int count = 0;
        int lastValidIndex = 0;
        for(int i = 1; i < intervals.length; i++) {
            // 3. if interval we are looking at overlaps with the previously looked value, then we have to exclude this interval by increasing the count
            //    also we have to update the current interval value to compare with the next appearance
            if(intervalsOverlap(intervals[lastValidIndex], intervals[i])) {
                count++;
            } else {
                lastValidIndex = i;
            }
        }
        return count;
    }

    private static void sortIntervalsByEnd(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] -b[1]);
    }

    private static boolean intervalsOverlap(int[] p, int[] q) {
            return p[1] > q[0];
    }
}
