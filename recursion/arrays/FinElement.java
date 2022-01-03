package recursion.arrays;

import java.util.ArrayList;

public class FinElement {

    public static void main(String[] args) {
        int[] A = {3, 45, 23, 12, 5, 8, 12};
        System.out.println(fin(A, 22, 0));
        System.out.println(findMultipleTargetsNewApproach(A, 12, A.length-1));
//        System.out.println(ll);
    }

    static boolean fin(int[] A, int target, int index) {
        if(index==A.length) {
            return false;
        }
        return A[index] == target || fin(A, target, index+1);
    }

    static ArrayList<Integer> ll = new ArrayList<>();
    static void findMultipleTargets(int[] A, int target, int index) {
        if(index == -1) return;
        if(A[index] == target) ll.add(index);
        findMultipleTargets(A, target, index-1);
    }

    static ArrayList<Integer> findMultipleTargetsII(int[] A, int target, int index, ArrayList<Integer> ll) {
        // ll is a reference variable but they are pointing to the same object
        if(index == -1) return ll;
        if(A[index] == target) ll.add(index);
        return findMultipleTargetsII(A, target, index-1, ll);
    }

    // this approach is not so good since we are creating objects again and again
    static ArrayList<Integer> findMultipleTargetsNewApproach(int[] A, int target, int index) {
        ArrayList<Integer> ll = new ArrayList<>();
        // ll is a reference variable but they are pointing to the same object
        if(index == -1) return ll;
        // this will contain answer for that function call only
        if(A[index] == target) ll.add(index);

        ArrayList<Integer> answerFromBelowCalls = findMultipleTargetsNewApproach(A, target, index-1);
        ll.addAll(answerFromBelowCalls);
        return ll;
    }
}
