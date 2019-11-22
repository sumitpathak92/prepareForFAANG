package udemyMasterTheCodingInterview;

import java.util.HashSet;

public class FirstRecurringCharacter {

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 16, 2, 4, 8, 9};
        System.out.println("first recurring char is -->  "+firstRecurringCharacterInArray(array));
    }

    static int firstRecurringCharacterInArray(int[] array) {
        if(array.length < 2) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i : array) {
            if(hs.contains(i)) return i;
            hs.add(i);
        }
        return 0;
    }

    static int secondRecurringCharacterInArray(int[] array) {

        return 0;
    }
}
