package javaInterviewPrep;

import java.util.ArrayList;

public class StringBuilderVsBuffer {

    public static void main(String[] args) {
        int N = 999999999;
        long t;

        {
            StringBuffer sb = new StringBuffer();
            t = System.currentTimeMillis();
            for(int i = N; i-->0;) {
                sb.append("");
            }
            System.out.println(System.currentTimeMillis() - t);

            ArrayList<Integer> al = new ArrayList<>();
            int a = 9; int b = 0;
            int[] A = {a, b};
        }

        {
            StringBuilder sb = new StringBuilder();
            t = System.currentTimeMillis();
            for(int i = N; i-->0;) {
                sb.append("");
            }
            System.out.println(System.currentTimeMillis() - t);
        }
    }
}
