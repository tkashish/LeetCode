package DynamicProgramming;

import java.util.Arrays;

public class House_Robber_II {
	public static int rob(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		return Math.max(helper(Arrays.copyOfRange(nums,0,nums.length-1)),helper(Arrays.copyOfRange(nums,1,nums.length)));
	}
	public static int helper(int[] nums){
		int[] max = new int[nums.length];
		int[] house = new int[nums.length];
		max[0] = nums[0];
		house[0] = 0;
		for(int i = 1; i < nums.length; i++){
			if(i == 1){
				if(max[i-1] > nums[i]){
					max[i] = max[i-1];
					house[i] = house[i-1];
				}else if(max[i-1] < nums[i]){
					max[i] = nums[i];
					house[i] = i;
				}else{
					max[i] = nums[i];
					house[i] = house[i-1];
				}
			}else{
				if(max[i-1] > nums[i]+max[i-2]){
					max[i] = max[i-1];
					house[i] = house[i-1];
				}else if(max[i-1] < nums[i]+max[i-2]){
					max[i] = nums[i]+max[i-2];
					house[i] = i;
				}else{
					max[i] = max[i-1];
					house[i] = house[i-1];
				}
			}
		}
		return max[nums.length-1];
	}
	public static void main(String[] args){
		int[] arr = {2,1,1,2};
		System.out.println(rob(arr));
	}
}
