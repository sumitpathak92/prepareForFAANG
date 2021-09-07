package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * LC Medium : https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1363/
 * */

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length==1) return new int[]{0};
        int[] res = new int[temperatures.length];
        for(int i = 0; i<temperatures.length; i++) {
            int tmp = temperatures[i];
            int j = i+1;
            while(j<temperatures.length) {
                if(temperatures[j]>tmp){
                    res[i] = j-i;
                    break;
                } else j++;
            }
        }
        return res;
    }

}
