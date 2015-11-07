
public class Container_With_Most_Water {
	public int maxArea(int[] nums) {
        int low = 0; 
        int high = nums.length-1;
        int max = 0;
        while(low < high){
            max = Math.max(max, (nums[low]>nums[high]?nums[high]:nums[low])*(high-low));
            // System.out.println(max);
            if(nums[low] > nums[high]){
                high--;
            }else{
                low++;
            }
        }
        return max;
    }
}
