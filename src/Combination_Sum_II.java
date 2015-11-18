import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Combination_Sum_II {
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		//		System.out.println("Target : " + target);
		//		Utils.printArray(candidates);
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(candidates.length == 1){
			if(target == candidates[0]) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(target);
				ret.add(list);
			}
			return ret;
		}
		if(target <= 0) return ret;
		for(int i = 0; i < candidates.length; i++){
			if(candidates[i] > target) continue;
			List<Integer> list;
			if(target-candidates[i] == 0){
				list = new ArrayList<Integer>();
				list.add(candidates[i]);
				if(!ret.contains(list)) ret.add(list);
			}else{
				List<List<Integer>> list1 = combinationSum2(Arrays.copyOfRange(candidates,i+1,candidates.length), target-candidates[i]);
				for(List<Integer> l : list1){
					list = new ArrayList<Integer>();
					list.add(candidates[i]);
					list.addAll(l);
					Collections.sort(list);
					if(!ret.contains(list))  ret.add(list);
				}
			}
		}
		return ret;
	}
	public static void main(String[] args){
		int[] cand = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
		int target = 27;
		List<List<Integer>> list = combinationSum2(cand, target);
		for(List<Integer> l : list){
			System.out.println(l.toString());
		}
//		Arrays.sort(cand);
//		// 1,1,2,5,6,7,10
//		List<List<Integer>> list1 = combinationSum(cand, target, 0, cand.length);
//		for(List<Integer> l : list1){
//			System.out.println(l.toString());
//		}
	}

	public static List<List<Integer>> combinationSum(int[] cand,int target, int start, int end){
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for(int i = start; i < end; i++){
			if(target < cand[i]){
				break;
			}
			List<Integer> list = new ArrayList<Integer>();
			if(target-cand[i] > 0){
				List<List<Integer>> list2 = combinationSum(cand,target-cand[i],i+1, end);
				for(List<Integer> l : list2){
					List<Integer> list3 = new ArrayList<Integer>();
					list3.add(cand[i]);
					list3.addAll(l);
					if(!ret.contains(list3)){
						ret.add(list3);
					}
				}
			}else if(target-cand[i] == 0){
				list.add(cand[i]);
				if(!ret.contains(list)){
					ret.add(list);
				}
			}
			
		}
		return ret;
	}
}
