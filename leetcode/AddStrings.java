package leetcode;

import java.util.Stack;

/***
 *  problem : https://leetcode.com/problems/add-strings/
 */

public class AddStrings {
      public static void main(String[] args) {
            System.out.println("result is :::  "+addStrings("548912", "6213"));
      }

      public static String addStrings(String num1, String num2) {
          StringBuilder sb = new StringBuilder();
          int l1 = num1.length()-1; int l2 = num2.length()-1;
          int carry = 0;
          while(l1>=0 || l2>=0) {
              int x1 = l1>=0 ? num1.charAt(l1) - '0' : 0;
              int x2 = l2>=0 ? num2.charAt(l2) - '0' : 0;
              int val = (x1 + x2 + carry)%10;
              carry = (x1 + x2 + carry)/10;
              sb.append(val);
              l1--; l2--;
          }
          if(carry!=0) {
              sb.append(carry);
          }
          return sb.reverse().toString();
      }
}
