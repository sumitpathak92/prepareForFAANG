package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumIII {

    public static void main(String[] args) {
        int[] A = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(A));
    }

    public static List<List<Integer>> threeSum(int[] A) {
        List<Integer> res;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(A);
        for(int i = 0; i<A.length; i++) {
            if(A[i]>0) break;
            if(i>0 && A[i-1]==A[i])
                continue;
            int j = i+1; int k = A.length-1;
            int a = -A[i];
            while(j<k) {
                if(A[j]+A[k]==a) {
                    res = new ArrayList<>();
                    res.add(A[i]); res.add(A[j]); res.add(A[k]);
                    ans.add(new ArrayList<>(res));
                    while(j<k && A[j]==A[j-1]) j++;
                    while(j<k && A[k]==A[k+1]) k--;
                    j++;
                    k--;
                } else if(A[j]+A[k]<a)
                    j++;
                else
                    k--;
            }
        }
        return ans;
    }
}
