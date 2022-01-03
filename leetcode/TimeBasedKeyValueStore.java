package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {

    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo","bar",1);
        System.out.println(obj.get("foo", 1));
        System.out.println(obj.get("foo", 3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4));
        System.out.println(obj.get("foo", 5));
//        System.out.println(param_2);
    }
}

class TimeMap {

    Map<String, List<Data>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)) hm.put(key, new ArrayList<>());
        hm.get(key).add(new Data(value, timestamp));

    }

    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        return binarySearch(hm.get(key), timestamp);
    }

    private static String binarySearch(List<Data> list, int timestamp) {
        int i = 0; int j = list.size()-1;

        while(i<=j){
            int mid = i+(j-i)/2;
            if(timestamp == list.get(mid).timestamp) return list.get(mid).value;
            else if(timestamp > list.get(mid).timestamp) {
//                if(timestamp < list.get(mid+1).timestamp) {
//                    return list.get(mid).value;
//                }
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return list.get(j).timestamp <= timestamp ? list.get(j).value : "";

    }
}

class Data {
    String value;
    int timestamp;

    public Data(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
