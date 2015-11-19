import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Combination_Sum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		return helper(candidates,target);
	}
	public List<List<Integer>> helper(int[] candidates, int target){
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(candidates.length == 0)return ret;
		List<Integer> list;
		if(target-candidates[0] > 0){
			List<List<Integer>> list1 = helper(candidates,target-candidates[0]);
			for(List<Integer> l : list1){
				list = new ArrayList<Integer>();
				list.add(candidates[0]);
				list.addAll(l);
				ret.add(list);
			}
			List<List<Integer>> list2 = helper(Arrays.copyOfRange(candidates,1,candidates.length),target);
			for(List<Integer> l : list2){
				list = new ArrayList<Integer>();
				list.addAll(l);
				ret.add(list);
			}
		}else if(target-candidates[0] == 0){
			list = new ArrayList<Integer>();
			list.add(candidates[0]);
			ret.add(list);
		}
		return ret;
	}
}
