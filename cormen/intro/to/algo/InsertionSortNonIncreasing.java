package cormen.intro.to.algo;

import util.CommonUtilities;

public class InsertionSortNonIncreasing {

    private static int[] array = {31, 41, 59, 28, 41, 58};
    public static void main(String[] args) {
        System.out.println("before  --> ");
        CommonUtilities.arrayPrintHelper(array);
        for(int j = 1; j<array.length ; j++) {
            int i = j-1;
            int key = array[j];
            while(i>=0 && array[i]<key) {
                array[i+1] = array[i];
                i = i-1;
            }
            array[i+1] = key;
        }
        System.out.println("after  --> ");
        CommonUtilities.arrayPrintHelper(array);
    }
}
