package DynamicProgramming;

public class LongestIncreasingSubSequence {
	public static int findMax(int[] input){
		if(input.length == 0)return 0;
        int[] max = new int[input.length];
		int[] maxInc = new int[input.length];
		max[0] = 1;
		maxInc[0] = 1;
		int min = input[0];
		for(int i = 1; i < input.length; i++){
			if(input[i] < min){
				min = input[i];
				maxInc[i] = 1;
				max[i] = Math.max(max[i-1], 1);
			}else{
				int j = 0;
				int maxSub = 0;
                boolean equals = false;
				for(j = i-1; j >= 0; j--){
					if(input[i] > input[j]){
						maxSub = Math.max(maxInc[j],maxSub);
					}
					if(input[i] == input[j]){
						if(maxSub < maxInc[j]){
						    maxSub = maxInc[j];
	    					equals = true;
						}
						break;
					}
				}
				if(equals){
				    maxInc[i] = maxSub;
    				max[i] = Math.max(max[i-1], max[j]);
				}else{
    				maxInc[i] = maxSub+1;
    				max[i] = Math.max(max[i-1], maxSub+1);
			    }
			}
		}
		return max[input.length-1];
	}
	public static void main(String[] args){
		int[] i1 = {1,3,6,7,9,4,10,5,6};
		System.out.println(findMax(i1));
	}
}
