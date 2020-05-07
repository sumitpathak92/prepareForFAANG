package codeforces;

import java.util.HashMap;
import java.util.Scanner;

public class RegistrationSystem {

    public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
           int N = sc.nextInt();
           HashMap<String, Integer> mp = new HashMap<>();
           while(N-->0) {
               String name = sc.next();
//               System.out.println(name);
               if(mp.containsKey(name)) {
                   System.out.println(name+mp.get(name));
                   mp.put(name, mp.get(name)+1);
               }
               else {
                   mp.putIfAbsent(name, 1);
                   System.out.println("OK");
               }
           }
    }
}
