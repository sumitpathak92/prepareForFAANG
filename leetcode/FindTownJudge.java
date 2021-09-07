package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
LC Easy : https://leetcode.com/problems/find-the-town-judge/
* **/
public class FindTownJudge {

    private static List<List<Integer>> adjList = new ArrayList<>();
    public static void main(String[] args) {
        int n = 4; int[][] trust = {{1,3},{1, 4},{2,3},{2, 4},{4, 3}};
        System.out.println(findJudgeII(n, trust));
    }

    public static int findJudge(int n, int[][] trust) {
        int[] inComing = new int[n+1];
        int[] outGoing = new int[n+1];
        for(int[] t : trust) {
            outGoing[t[0]]++;
            inComing[t[1]]++;
        }
        for(int i = 1; i<n+1; i++) {
            if(outGoing[i] == 0 && inComing[i]==n-1)
                return i;
        }
        return -1;
    }

    public static int findJudgeII(int n, int[][] trust) {
        int[] count = new int[n+1];
        for(int[] t : trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for(int i=1; i<n+1; i++) {
            if(count[i] == n-1)
                return i;
        }
        return -1;
    }

}
