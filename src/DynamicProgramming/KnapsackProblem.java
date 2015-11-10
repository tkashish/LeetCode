package DynamicProgramming;

public class KnapsackProblem {
	/*
	 * correct version
	 */
	public static int knapSack(int[] V, int[] W, int maxW){
		int[][] K = new int[V.length+1][maxW+1];
		for(int i = 0; i <= V.length; i++){
			for(int j = 0; j <= maxW; j++){
				if(i == 0 || j == 0){
					K[i][j] = 0;
				}else{
					if(j >= W[i-1]){
						K[i][j] = Math.max(K[i-1][j-W[i-1]]+V[i-1], K[i-1][j]);
					}else{
						K[i][j] = K[i-1][j];
					}
				}
			}
		}
		return K[V.length][maxW];
	}
	/*
	 * Wrong version
	 */
	public static int knapSack_I(int[] V, int[] W, int MaxW){
		int[][] maxInc = new int[V.length+1][2];
		int[][] maxNInc = new int[V.length+1][2];
		boolean[] inc = new boolean[V.length+1];
		inc[0] = true;
		maxInc[0][0] = 0;
		maxInc[0][1] = MaxW;
		maxNInc[0][0] = 0;
		maxNInc[0][1] = MaxW;

		for(int i = 1; i <= V.length; i++){
			if(inc[i-1]){
				maxNInc[i][0] = maxInc[i-1][0];
				maxNInc[i][1] = maxInc[i-1][1];
			}else{
				maxNInc[i][0] = maxNInc[i-1][0];
				maxNInc[i][1] = maxNInc[i-1][1];
			}
			for(int j = i-1; j >= 0; j--){
				if(inc[j]){
					if(maxInc[j][1] - W[i-1] >= 0){
						maxInc[i][0] = maxInc[j][0]+V[i-1];
						maxInc[i][1] = maxInc[j][1]-W[i-1];
						break;
					}else if(maxNInc[j][1] - W[i-1] >= 0){
						maxInc[i][0] = maxNInc[j][0]+V[i-1];
						maxInc[i][1] = maxNInc[j][1]-W[i-1];
						break;
					}
				}else{
					if(maxNInc[j][1] - W[i-1] >= 0){
						maxInc[i][0] = maxNInc[j][0]+V[i-1];
						maxInc[i][1] = maxNInc[j][1]-W[i-1];
						break;
					}else if(maxInc[j][1] - W[i-1] >= 0){
						maxInc[i][0] = maxInc[j][0]+V[i-1];
						maxInc[i][1] = maxInc[j][1]-W[i-1];
						break;
					}
				}

			}
			if(maxInc[i][0] > maxNInc[i][0]){
				inc[i] = true;
			}else{
				inc[i] = false;
			}
		}
		if(inc[V.length]){
			return maxInc[V.length][0];
		}else{
			return maxNInc[V.length][0];
		}
	}
	public static void main(String[] args){
		int[] V = {10,5,6,8,7};
		int[] W = {2,5,8,3,6};
		System.out.println(knapSack(V, W, 10));
		System.out.println(knapSack_I(V, W, 10));
		
		int[] V1 = {60, 100, 120};
		int[] W1 = {10, 20, 30};
		System.out.println(knapSack(V1, W1, 50));
		System.out.println(knapSack_I(V1, W1, 50));
	}
}
