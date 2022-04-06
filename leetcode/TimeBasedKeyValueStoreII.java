package leetcode;

import java.util.*;

/**
 *
 * LC Medium : https://leetcode.com/problems/time-based-key-value-store/
 * **/
public class TimeBasedKeyValueStoreII {

    public static void main(String[] args) {

        TimemapII obj = new TimemapII();
        obj.set("foo","bar",1);
        System.out.println(obj.get("foo", 1));
        System.out.println(obj.get("foo", 3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4));
        System.out.println(obj.get("foo", 5));
    }

}

class TimemapII {

    Map<String, List<PairII>> hm;
    public TimemapII() {
        hm = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)) hm.put(key, new ArrayList<>());
        hm.get(key).add(new PairII(value, timestamp));
        System.out.println(hm);
    }

    public String get(String key, int time) {
        List<PairII> vals = hm.get(key);
        int i = 0; int j = vals.size()-1;

        while(i<j) {
            int mid = i+(j-i)/2;
            if(vals.get(mid).timestamp == time) return vals.get(mid).value;
            else if(vals.get(mid).timestamp > time) {
                j=mid-1;
            } else {
                if(vals.get(mid+1).timestamp > time){
                    return vals.get(mid).value;
                }
                i = mid+1;
            }
        }
        return vals.get(j).timestamp<=time?vals.get(j).value:"";
    }

}

class PairII {
    String value;
    int timestamp;

    public PairII(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
