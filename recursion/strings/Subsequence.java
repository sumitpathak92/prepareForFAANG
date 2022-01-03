package recursion.strings;

import java.util.ArrayList;

public class Subsequence {

    public static void main(String[] args) {
        System.out.println(subsequenceList("", "abc"));
        System.out.println(al);
    }

    static void subsequence(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subsequence(p+ch, up.substring(1));
        subsequence(p, up.substring(1));
    }

    static ArrayList<String> al = new ArrayList<>();
    static ArrayList<String> subsequenceList(String p, String up) {
        if(up.isEmpty()){
            ArrayList<String> al = new ArrayList<>();
            al.add(p);
            return al;
        }

        char ch = up.charAt(0);
        ArrayList<String> left = subsequenceList(p+ch, up.substring(1));
        ArrayList<String> right = subsequenceList(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}
