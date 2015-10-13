package DynamicProgramming;

public class MaxSumIs {

	public static int maxSumInSubsequence(int[] in){
		int len = in.length;
		int max = 0;
		int[] S = new int[len];
		for(int i = 0; i < len; i++){
			S[i] = in[i];
		}
		for(int i = 1; i < len; i++){
			for(int j = 0; j < i; j++){
				if(in[j] < in[i] && S[j] + in[i] > S[i]){
					S[i] = S[j] + in[i];
				}
			}
			if(max < S[i]){
				max = S[i];
			}
		}
		return max;	
	}
	public static int maxSubsequenceSize(int[] in){
		int len = in.length;
		int max = 1;
		int[] S = new int[len];
		for(int i = 0; i < len; i++){
			S[i] = 1;
		}
		for(int i = 1; i < len ; i++ ){
			for(int j = 0; j < i; j++){
				if(in[j] < in[i] && S[j] + 1 > S[i]){
					S[i] = S[j] + 1;
				}
			}
			if(max < S[i]){
				max = S[i];
			}
		}

		return max;
	}
	public static void main(String[] arg){
		int[] in = {1,2,0,3,4,100,5, 200};
		System.out.println(maxSumInSubsequence(in));
		System.out.println(maxSubsequenceSize(in));
	}
}
