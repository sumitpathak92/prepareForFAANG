package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {

    public static void main(String[] args) {

    }


}


class WordDistance {

    Map<String, List<Integer>> indexMap ;

    public WordDistance(String[] wordsDict) {
        indexMap = new HashMap<>();
        for(int i = 0; i<wordsDict.length; i++) {
            if(indexMap.containsKey(wordsDict[i])){
                indexMap.get(wordsDict[i]).add(i);
            } else {
                List<Integer> idx = new ArrayList<>();
                idx.add(i);
                indexMap.put(wordsDict[i], idx);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> l1 = indexMap.get(word1); List<Integer> l2 = indexMap.get(word2);

        int mini = Integer.MAX_VALUE;
        for(int i: l1) {
            for(int j : l2) {
                mini = Math.min(mini, Math.abs(i-j));
            }
        }
        return mini;
    }
}