package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * LC Medium: https://leetcode.com/explore/featured/card/recursion-i/251/scenario-i-recurrence-relation/3234/
 *
 * */
public class PascalTriangleII {

    private static HashMap<Pair, Integer> hm = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) {
            return new ArrayList<Integer>(){{add(1);}};
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<=rowIndex; i++) {
            res.add(pascalTriangle(rowIndex, i));
        }
        return res;
    }

    public static int pascalTriangle(int r, int c) {
        Pair pair = new Pair(r, c);
        if(hm.containsKey(pair)) return hm.get(pair);
        int res = (r == 0 || c == 0 || r == c) ? 1 : pascalTriangle(r-1, c-1) + pascalTriangle(r-1, c);
        hm.put(pair, res);

        return res;
    }
}

class Pair {
    int r;
    int c;
    public Pair(int row, int col) {
        r = row;
        c = col;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;
        return r == pair.r && c == pair.c;
    }
}
