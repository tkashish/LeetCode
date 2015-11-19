import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Combination_Sum_III {
	public List<List<Integer>> combinationSum3(int k, int n) {
		int[] nums = {1,2,3,4,5,6,7,8,9};
		return helper(nums, k, n);
	}
	public List<List<Integer>> helper(int[] nums, int k, int n){
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(k == 0 || n == 0) return ret;
		for(int i = 0; i < nums.length; i++){
			List<Integer> list;
			if(n-nums[i] > 0){
				List<List<Integer>> list1 = helper(Arrays.copyOfRange(nums,i+1, nums.length), k-1, n-nums[i]);
				for(List<Integer> l : list1){
					list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.addAll(l);
					ret.add(list);
				}
			}else if(nums[i]-n == 0 && k == 1){
				list = new ArrayList<Integer>();
				list.add(nums[i]);
				ret.add(list);   
				break;
			}else{
				break;
			}
		}
		return ret;
	}
}
