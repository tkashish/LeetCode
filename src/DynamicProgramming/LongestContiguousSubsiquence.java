package DynamicProgramming;

public class LongestContiguousSubsiquence {
	public int maxSubSeq(int[] input){
		int max = 0;
		int maxInc = 0;
		for(int i: input){
			maxInc = Math.max(0, maxInc+i);
			max = Math.max(max, maxInc);
		}
		return max;
	}
}
