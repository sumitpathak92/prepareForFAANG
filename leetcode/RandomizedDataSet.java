package leetcode;

import java.util.*;

public class RandomizedDataSet {
}


class RandomizedSet {
    // data structure for adding/deleting and getRandom number in O(1)

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insertNumber(int number) {

        return false;
    }

    public boolean removeNumber(int number) {
        return false;
    }

    public int getRandomNumber() {
        return -1;
    }


}