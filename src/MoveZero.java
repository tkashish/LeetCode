
public class MoveZero {

	public void moveZeroes(int[] nums) {
        if(nums == null){
            return;
        }
        int len = nums.length;
        for(int i = 0; i < len; i++){
            boolean flag = true;
            if(nums[i] == 0){
                for(int j = i+1; j < len; j++){
                    if(nums[j] != 0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        flag = false;
                        break;
                    }
                }
            }else{
                continue;
            }
            if(flag){
                return;
            }
        }
    }

}
