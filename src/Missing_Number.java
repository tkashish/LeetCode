import java.util.Arrays;


public class Missing_Number {
	public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        if(nums[end] != nums.length) return nums.length;
        int ret = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] != mid){
                ret = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ret;
    }
	public static void main(String[] args){
		String s1 = "abcd";
		System.out.println(s1.substring(0, 1));
		System.out.println(s1.substring(0, 0).length());
	}
}
