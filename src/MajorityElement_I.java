import java.util.HashMap;


public class MajorityElement_I {
	public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        int maxNum = 0;
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
            if(map.get(i) >= n/2){
                if(maxNum < map.get(i)){
                    maxNum = map.get(i);
                    max = i;
                }
            }
        }    
        return max;
    }
}
