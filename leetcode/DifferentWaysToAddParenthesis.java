package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
LC Medium :  https://leetcode.com/problems/different-ways-to-add-parentheses/
* **/
public class DifferentWaysToAddParenthesis {

    private static Map<String, List<Integer>> hm = new HashMap<>();
    public static void main(String[] args) {
        String expression = "2*3-4*5";
//        diffWaysToCompute(expression);
        System.out.println(diffWaysToCompute(expression));
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        if(hm.containsKey(expression)) return hm.get(expression);
        for(int i = 0; i<expression.length(); i++) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                List<Integer> left = hm.getOrDefault(expression.substring(0,i), diffWaysToCompute(expression.substring(0, i)));
                List<Integer> right = hm.getOrDefault(expression.substring(i+1), diffWaysToCompute(expression.substring(i+1)));
                for (Integer p1 : left) {
                    for(Integer p2 : right) {
                        int c;
                        if(expression.charAt(i) == '+') {
                            c = p1+p2;
                            res.add(c);
                        } else if(expression.charAt(i) == '-') {
                            c = p1-p2;
                            res.add(c);
                        } else if(expression.charAt(i) == '*') {
                            c = p1*p2;
                            res.add(c);
                        }
                    }
                }
            }
        }

        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        hm.put(expression, res);
        return res;
    }

//    private static void solver(String left, String right, char operator) {
//        List<Character> validOerators = new ArrayList<>();
//        validOerators.add('+'); validOerators.add('-'); validOerators.add('*');
//        if(left.length() == 1 && right.length() == 1) {
//            if(operator == '+') res.add((int)left.charAt(0)+(int)right.charAt(0));
//            if(operator == '-') res.add((int)left.charAt(0)-(int)right.charAt(0));
//            if(operator == '*') res.add((int)left.charAt(0)*(int)right.charAt(0));
//        }
//        else {
//            int leftLen = left.length();
//            int rightLen = right.length();
//            if(leftLen > 1 && rightLen >1) {
//                for(int i = 0; i<leftLen; i++) {
//                    if(validOerators.contains(left.charAt(i))) {
//                        solver(left.substring(0, i), left.substring(i+1), left.charAt(i));
//                    }
//                }
//                for(int i = 0; i<rightLen; i++) {
//                    if(validOerators.contains(right.charAt(i))) {
//                        solver(right.substring(0, i), left.substring(i+1), left.charAt(i));
//                    }
//                }
//            }
//        }
//    }
}
