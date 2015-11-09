package DynamicProgramming;
/* https://leetcode.com/problems/product-of-array-except-self/
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 */
public class Product_of_Array_Except_Self {
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] forward = new int[len];
		int[] backwards = new int[len];
		forward[0] = nums[0];
		backwards[len-1] = nums[len-1];
		for(int i = 1; i < len; i++){
			forward[i] = forward[i-1]*nums[i];
			backwards[len-1-i] = backwards[len-i]*nums[len-1-i];
		}
		int[] output = new int[len];
		output[0] = backwards[1];
		output[len-1] = forward[len-2];
		for(int i = 1; i < len-1; i++){
			output[i] = forward[i-1]*backwards[i+1];
		}
		return output;   
	}
}
