import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
		if(nums.length == 1){
			List<List<Integer>> ret = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[0]);
			ret.add(list);
			return ret;
		}
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
		for(int i = 0; i < nums.length; i++){
			int[] numNew = swap(nums, i);
			List<List<Integer>> ret = permute(Arrays.copyOfRange(numNew, 1,numNew.length));
			for(List<Integer> l : ret){
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums[i]);
				list.addAll(l);
				finalList.add(list);        
			}
		}
		return finalList;
	}
	public static int[] swap(int[] nums, int i){
		int[] ret = nums.clone();
		if(i != 0){
			int temp = ret[0];
			ret[0]  = ret[i];
			ret[i]  = temp;
		}
		return ret;
	}
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5};
		List<List<Integer>> list = permute(nums);
		for(List<Integer> l : list){
			for(int i : l){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
