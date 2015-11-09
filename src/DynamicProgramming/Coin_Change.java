package DynamicProgramming;

public class Coin_Change {
	public static int coinChange(int N, int[] S, int start){
		if(N == 0) return 1;
		int ret = 0;
		int count = 0;
		for(int j = start; j < S.length; j++){
			if(N-S[j] >= 0){
				ret += coinChange(N-S[j], S , start+count);
			}
			count++;
		}
		return ret;
	} 
//	public static int coinChangeI(int N, int[] S){
//		int[][] matrix = new int[S.length][N];
//		for(int i = 0; i < S.length; i++){
//			for(int j = 0; j < N; j++){
//				if(j-S[i] == 0) matrix[i][j] = 1;
//				else if(j-S[i])
//			}
//		}
//	}
	public static void main(String[] args){
		int[] i = {2,5,3,6}; 
		System.out.println(coinChange(9, i, 0));
	}
}
