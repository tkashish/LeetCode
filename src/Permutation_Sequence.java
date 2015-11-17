import java.util.Arrays;


public class Permutation_Sequence {
	public static String getPermutation(int n, int k) {
		int[] nums = new int[n];
		for(int i = 0; i < n; i++){
			nums[i] = i+1;
		}
		return helper(nums, k);
	}
	public static String helper(int[] nums, int k){
		StringBuilder sb = new StringBuilder();
		if(k < 0){
			for(int i : nums){
				sb.append(i);
			}
			return sb.toString();
		}
		if(nums.length == 0) return "";
		int m = fact(nums.length-1);
		int i = (k/m);
		int j = k%m;
		if(j == 0) i--;
		sb.append(nums[i]);
		int temp = nums[i];
		nums[i] = nums[0];
		nums[0] = temp;
		int[] arr = Arrays.copyOfRange(nums, 1, nums.length);
		Arrays.sort(arr);
		sb.append(helper(arr,j-1));
		return sb.toString();
	}
	public static int fact(int n){
		int ret = 1;
		while(n > 1){
			ret *= n;
			n --;
		}
		return ret;
	}
	public static void main(String[] args){
		System.out.println(getPermutation(3, 2));
	}
}
