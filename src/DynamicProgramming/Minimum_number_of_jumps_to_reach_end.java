package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 */

public class Minimum_number_of_jumps_to_reach_end {
	public static int maxJumpsToEnd(int[] input){
		List<Integer> list = new ArrayList<Integer>();
		list.add(input[input.length-1]);
		for(int i = input.length-1; i > 0;){
			int j = 0;
			for(j = 0; j < i; j++){
				if(input[j] + j >= i){
					break;
				}
			}
			if(j == i) {
				System.out.println("No Path");
				return -1;
			}
			list.add(input[j]);
			i = j;
		}
		Collections.reverse(list);
		System.out.println(list.toString());
		return list.size()-1;
	}
	public static void main(String[] args){
		int[] input = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(maxJumpsToEnd(input));
		int[] input1 = {1, 3, 6, 1, 0, 9};
		System.out.println(maxJumpsToEnd(input1));
		int[] input2 = {1,0,2,0,1};
		System.out.println(maxJumpsToEnd(input2));
		int[] input3 = {2,0,2,0,1};
		System.out.println(maxJumpsToEnd(input3));
		
	}
}
