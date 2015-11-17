
public class Remove_Duplicates_from_sorted_arrays_II {
	public int removeDuplicates(int[] nums) {
		if(nums.length == 0) return 0;
		int[] numsDup = new int[nums.length];
		int count = 1;
		int num = nums[0];
		int id = 1;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] == num){
				if(count == 2){
					continue;
				}else{
					nums[id] = nums[i];
					id++;
					count++;
				}
			}else{
				count = 1;
				num = nums[i];
				nums[id] = nums[i];
				id++;
			}
		}
		return id;
	}
}
