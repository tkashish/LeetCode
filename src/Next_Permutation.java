import java.util.Arrays;

import javax.rmi.CORBA.Util;


public class Next_Permutation {
	public static void nextPermutation(int[] nums) {
		if(nums.length < 2) return;
		helper(nums,0,nums.length-1);
		Utils.printArray(nums);
	}
	public static boolean helper(int[] nums, int start, int end){
		if(end-start == 1){
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			if(nums[end] >= nums[start]){
				return true;
			}else{
				return false;
			}
		}else{
			System.out.println("s : " + start + " e : " + end);
			boolean flag = helper(nums, start+1, end);
			Utils.printArray(nums);
			if(flag == false) return false;
			int num = nums[start];
//			Utils.printArray(nums);
			int j = start;
			for(int i = start+1; i <= end; i++){
				if(nums[i] > nums[j]){
					j = i;
					break;
				}
			}
			if(nums[j] == num){
				Arrays.sort(nums, start, end+1);
				return true;
			}else{
				int temp = nums[j];
				nums[j] = nums[start];
				nums[start] = temp;
				return false;
			}
		}
	}
	public static void rotate(int[] nums, int i, int j){
		int temp = nums[j];
		for(int k = j-1; k >= i; k--){
			nums[k+1] = nums[k];
		}
		nums[i] = temp;
	}
	public static void main(String[] args){
		int[] nums = {5,4,7,5,3,2};
		nextPermutation(nums);
	}
}
