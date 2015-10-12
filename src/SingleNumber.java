import java.util.HashMap;
import java.util.Map.Entry;

/**
 * https://leetcode.com/problems/single-number/
 * 
 * @author kashishtayal
 *
 */
public class SingleNumber {
	// Using HashMap
	public class Solution1 {
	    public int singleNumber(int[] nums) {
	        if(nums == null){
	            return -1;
	        }
	        if(nums.length == 0){
	            return 0;
	        }
	        if(nums.length == 1){
	            return nums[0];
	        }
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i : nums){
	            if(map.containsKey(i)){
	                map.put(i, map.get(i)+1);
	            }else{
	                map.put(i,1);
	            }
	        }
	        for (Entry<Integer, Integer> entry : map.entrySet()) {
	            Integer value = entry.getValue();
	            if(value == 1){
	                return entry.getKey();
	            }
	        }
	        return 0;
	    }
	}
	/*
	 * Bit manipulation : USE of XOR
	 */
	public class Solution {
	    public int singleNumber(int[] nums) {
	        if(nums == null){
	            return 0;
	        }
	        int ret = 0;
	        for(int i : nums){
	            ret ^= i;
	        }
	        return ret;
	    }
	}
}
