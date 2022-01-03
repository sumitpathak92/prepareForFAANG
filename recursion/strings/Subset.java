package recursion.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

    public static void main(String[] args) {
        int[] A = {1,2,2};
        System.out.println(getSubsetWithDuplicates(A));
    }

    static List<List<Integer>> getSubset(int[] A) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int i : A) {
            int n = outer.size();
            for(int j = 0; j<n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(i);
                outer.add(internal);
            }
        }
        return outer;
    }

    static List<List<Integer>> getSubsetWithDuplicates(int[] A) {
        Arrays.sort(A);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0; int end = 0;
        for(int i =0 ; i< A.length; i++) {
            start = 0;
            // if current and previous is same, s=e+1
            if(i>0 && A[i]==A[i-1])
                start = end+1;
            end = outer.size()-1;
            int n = outer.size();
            for(int j = start; j<n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(A[i] );
                outer.add(internal);
            }
        }
        return outer;
    }
}
