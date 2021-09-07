package leetcode;

import java.util.*;

/*
LC Medium : https://leetcode.com/problems/reconstruct-itinerary/
* **/
public class ReconstructItinerary {

    public static Map<String, List<String>> adjList;

    public static void main(String[] args) {

    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        for(int i = 0; i<tickets.size(); i++) {
            if(adjList.containsKey(tickets.get(i).get(0)))
                adjList.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
            else{
                List<String> ll = new ArrayList<>(Arrays.asList(tickets.get(i).get(1)));
                adjList.put(tickets.get(i).get(0), ll);
            }
        }
        return new ArrayList<>();
    }

    public static void addEdge(String src, String dest) {
        adjList.get(src).add(dest);
    }
}
