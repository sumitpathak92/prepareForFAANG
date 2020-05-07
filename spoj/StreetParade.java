package spoj;

import java.util.Scanner;
import java.util.Stack;

public class StreetParade {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n!=0) {
            int[] input = new int[n];
            for(int i = 0; i<n; i++) {
                input[i] = sc.nextInt();
            }
            Stack<Integer> st = new Stack<>(); int want = 1;
            boolean ans = true;
            for(int i =0; i<n; i++) {
                while(!st.isEmpty() && st.peek()==want) {
                    want++;
                    st.pop();
                }
                if(input[i]==want) {
                    want++;
                } else if(!st.isEmpty() && st.peek()<input[i]){
                    ans = false;
                    break;
                } else {
                    st.push(input[i]);
                }
            }
            System.out.println(ans? "yes" : "no");
            n=sc.nextInt();
        }

    }

}
