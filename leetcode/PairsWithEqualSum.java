
// solution for uber onsite interview 

// Given an unsorted array with unique numbers. Find all pairs with equal sums.
// input = [9, 4, 3, 1, 7, 12]
// output= [1, 12] & [4, 9] etc etc
package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class PairsWithEqualSum {

	public static void main(String[] args) {
		int[] input = {9, 1, 3, 4, 7, 12};
		System.out.println(sumOfPairs(input));
	}

	// Approach 1
	// time complexity O(n^2)
	private static List<List<List<Integer>>> sumOfPairs(int[] input) {
		final Map<Integer, List<List<Integer>>> hm = new HashMap<>();
		for(int i = 0; i< input.length; i++) {
			for (int j = i+1; j<input.length; j++) {
				int sum = input[i] + input[j];
				if(!hm.containsKey(sum)) {
					hm.put(sum, new ArrayList<>());
				}
				hm.get(sum).add(Arrays.asList(input[i], input[j]));
			}
		}
		return hm.values().stream().filter(l->l.size() == 2).collect(Collectors.toList());
	}

	// Approach 2
	// time complexity O(nlogn) + (max - min)O(n)	

	/*
	
	Step 1 : sort the array
	Step 2 : find max and min sum --> max = A[n-2] + A[n-1]. min = A[0] + A[1]
	Step 3 : find pairs in the sorted array with sum in range [min, max]
	Step 4 : store all pairs corresponding to all sum values in a hashmap
	Step 5 : return pairs from hashmap with same sum
	
	*/

} 