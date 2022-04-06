package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindMissingRanges {

    public static void main(String[] args) {
        int[] A = {};
        System.out.println(findMissingRanges(A, 1, 1));
    }

    public static List<String> findMissingRanges(int[] A, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        int previous = lower-1;
        for(int i = 0; i<=A.length; i++) {
            int current = (i<A.length)?A[i]:upper+1;
            if(previous+1<=current-1) {
                ans.add(formatString(previous+1, current-1));
            }
            previous = current;
        }
        return ans;
    }

    static String formatString(int lower, int upper) {
        if(lower==upper)
            return String.valueOf(lower);
        return lower+"->"+upper;
    }
}
