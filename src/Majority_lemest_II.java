import java.util.ArrayList;
import java.util.List;


public class Majority_lemest_II {
	public class Solution {
	    List<Integer> list;
	    public List<Integer> majorityElement(int[] nums) {
	        list = new ArrayList<Integer>();
	        if(nums.length == 0) return list;
	        int c1 = 0;
	        int c2 = -1;
	        int i1 = 0;
	        int i2 = 0;
	        for(int i : nums){
	            if(c1 == i){
	                i1++;
	            }else if(c2 == i){
	                i2++;
	            }else if(i1 == 0){
	                c1 = i;
	                i1 = 1;
	            }else if(i2 == 0){
	                c2 = i;
	                i2 = 1;
	            }else{
	                i1--;
	                i2--;
	            }
	        }
	        i1 = 0;
	        i2 = 0;
	        for(int i = 0; i < nums.length; i++){
	            if(nums[i] == c1){
	                i1++;
	            }
	            if(nums[i] == c2){
	                i2++;
	            }
	            
	        }
	        if(i1 > nums.length/3)list.add(c1);
	        if(i2 > nums.length/3)list.add(c2);
	        return list;
	    }
	   
	}
}
