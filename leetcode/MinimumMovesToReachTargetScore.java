package leetcode;

/**
 * LC Medium : https://leetcode.com/contest/weekly-contest-276/problems/minimum-moves-to-reach-target-score/
 * **/
public class MinimumMovesToReachTargetScore {

    public static void main(String[] args) {
        System.out.println(minMoves(19, 2));
    }

    public static int minMoves(int target, int maxDoubles) {
        if(maxDoubles==0) {
            return target-1;
        }
        int count=0;
        while(target>0 && maxDoubles>0) {
            if(target%2==0) {
                target/=2;
                count++;
                maxDoubles--;
            } else {
                target--;
                count++;
            }
        }
        return count+target-1;
    }
}
