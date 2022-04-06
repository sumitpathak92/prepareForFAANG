package leetcode;

import java.util.Arrays;

public class SmallestValueOfRearrangedNumber {

    public static void main(String[] args) {
        System.out.println(smallestNumber(310));
    }

    public static long smallestNumber(long num) {
        String number = ""; boolean f = false;
        if(num>0) {
            number = String.valueOf(num);
        } else {
            number = String.valueOf(num*-1);
            f = true;
        }
        char[] tmp = number.toCharArray();
        int[] tmpArray = new int[number.length()];
        for(int i = 0; i<number.length(); i++) {
            tmpArray[i] = Character.getNumericValue(tmp[i]);
        }
        Arrays.sort(tmpArray);
        StringBuilder s = new StringBuilder();
        if(f) {
            s.append('-');
            for(int i = tmpArray.length-1; i>=0; i--) {
                s.append(tmpArray[i]);
            }
            return Long.parseLong(s.toString());
        }
        for(int i = 0; i< tmpArray.length; i++) {
            if(tmpArray[i]!=0) {
                int p = tmpArray[0];
                tmpArray[0] = tmpArray[i];
                tmpArray[i] = p;
                break;
            }
        }
        for(int i : tmpArray) s.append(i);
        return Long.parseLong(s.toString());
    }
}
