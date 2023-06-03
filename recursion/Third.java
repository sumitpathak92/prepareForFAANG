package recursion;

import java.util.ArrayList;
import java.util.List;

public class Third {

    static int[] arr = {1,2,1};
    static int k = 2;
    public static void main(String[] args) {
        f1(0, new ArrayList<>(), 0);
        System.out.println(f2(0,0));
    }

    public static void f(int i, List<Integer> ds, int sum) {
        if(i == arr.length) {
            if(sum == k) {
                System.out.println("printing subsequence ::::  " + ds);
            }
            return;
        }
        // pick
        ds.add(arr[i]);
        sum+=arr[i];
        f(i+1, ds, sum);

        // not pick
        sum-=arr[i];
        ds.remove(ds.size()-1);
        f(i+1, ds, sum);
    }

    public static boolean f1(int i, List<Integer> ds, int sum) {
        if(i == arr.length) {
            if(sum == k) {
                System.out.println(ds);
                return true;
            } else return false;
        }
        // pick
        ds.add(arr[i]);
        sum+=arr[i];
        if(f1(i+1, ds, sum)) {
            return true;
        }

        // not pick
        sum-=arr[i];
        ds.remove(ds.size()-1);
        if(f1(i+1, ds, sum)) {
            return true;
        }
        return false;
    }

    public static int f2(int i, int sum) {
        if(i == arr.length) {
            if(sum == k) {
                return 1;
            } else return 0;
        }
        sum+=arr[i];
        return f2(i+1, sum+arr[i]) + f2(i+1, sum-arr[i]);
    }
}
