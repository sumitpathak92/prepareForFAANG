package leetcode;

import util.CommonUtilities;

import java.util.HashMap;

public class SortColors {

    public static void main(String[] args) {
        int[] input = {2,0,2,1,1,0};
        CommonUtilities.arrayPrintHelper(sortColors(input));
    }

    public static int[] sortColors(int[] A) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : A) {
            if(hm.containsKey(i)) {
                hm.put(i, hm.get(i)+1);
            } else {
                hm.put(i, 1);
            }
        }
        int i=0;
        while(i<A.length) {
            int p = hm.getOrDefault(0, 0);
            int q = hm.getOrDefault(1, 0);
            int r = hm.getOrDefault(2, 0);
            int count = 0;
            while(count<p) {
                A[count] = 0;
                count++;
            }
            i = count;
            System.out.println( " i value   "+i);
            while(i<=p+q-1) {
                A[i] = 1;
                i++;
            }
            while(i<p+q+r) {
                A[i] = 2;
                i++;
            }
        }
        return A;
    }
}
