package recursion.strings;

import java.util.ArrayList;

public class Permutations {

    public static void main(String[] args) {
        permutations("", "abc");
    }

    static void permutations(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for(int i = 0; i<=p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            permutations(first+ch+second, up.substring(1));
        }
    }

    static ArrayList<String> permutationsList(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            ArrayList<String> ll = new ArrayList<>();
            ll.add(p);
            return ll;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for(int i = 0; i<=p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            ans.addAll(permutationsList(first+ch+second, up.substring(1)));
        }
        return ans;
    }

    static int permutationsCount(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for(int i = 0; i<=p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i);
            count+=permutationsCount(first+ch+second, up.substring(1));
        }
        return count;
    }
}
