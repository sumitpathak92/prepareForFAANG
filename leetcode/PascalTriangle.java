package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
LC Easy : https://leetcode.com/problems/pascals-triangle/
* **/
public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> all = new ArrayList<List<Integer>>();

        for(int i = 0; i<n; i++) {
            List<Integer> row = new ArrayList<>(Arrays.asList(1));
            for(int j = 1; j<i; j++) {
                row.add(all.get(i-1).get(j-1) + all.get(i-1).get(j));
            }
            if(i>0) row.add(1);
            all.add(new ArrayList<>(row));
        }
        return all;
    }
}
