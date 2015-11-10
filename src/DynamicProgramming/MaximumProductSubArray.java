package DynamicProgramming;
/*
 * https://leetcode.com/problems/maximum-product-subarray/
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */

public class MaximumProductSubArray {
	public static int maxProduct(int[] nums){
		int max = nums[0];
		int maxIncPos = 0;
		int maxIncNeg = 0;
		if(nums[0] > 0){
			maxIncPos = nums[0];
		}else{
			maxIncNeg = nums[0];
		}
		for(int i = 1; i < nums.length; i++){
			int curr = nums[i];
			if(curr > 0){
				if(maxIncPos == 0)	maxIncPos = curr;
				else	maxIncPos *= curr;
				maxIncNeg *= curr;
			}else{
				int neg = maxIncNeg;
				if(maxIncPos == 0) maxIncNeg = curr;
				else	maxIncNeg = maxIncPos*curr;
				maxIncPos = neg*curr;
			}
			max = Math.max(max, maxIncPos);
		}
		return max;
	}
	public static void main(String[] args){
		int[] input = {2,3,-4,110};
		System.out.println(maxProduct(input));
	}
}
