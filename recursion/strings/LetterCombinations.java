package recursion.strings;

import java.util.ArrayList;

public class LetterCombinations {

    public static void main(String[] args) {
        System.out.println(padArrayList("", "23"));
        pad("", "23");
    }

    static void pad(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0)-'0'; // this will convert '2' into integer 2
        for(int i = (digit-1)*3; i<digit*3; i++) {
            char ch = (char) ('a'+i);
            pad(p+ch, up.substring(1));
        }
    }

    static final String[] keys = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static ArrayList<String> padArrayList(String p, String up) {
        if(up.isEmpty()) {
            ArrayList<String> ll = new ArrayList<>();
            ll.add(p);
            return ll;
        }
        ArrayList<String> res = new ArrayList<>();
        int digit = up.charAt(0)-'0'; // this will convert '2' into integer 2
        for(int i =0; i<keys[digit].length(); i++) {
            char ch = keys[digit].charAt(i);
            res.addAll(padArrayList(p+ch, up.substring(1)));
        }
        return res;
    }
}
