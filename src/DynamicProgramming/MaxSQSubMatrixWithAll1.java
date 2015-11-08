package DynamicProgramming;

public class MaxSQSubMatrixWithAll1 {
	public static int maxSize(int[][] matrix){
		int[][] S = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++){
			S[i][0] = matrix[i][0];
		}
		for(int i = 0; i < matrix[0].length; i++){
			S[0][i] = matrix[0][i];
		}
		int max = 0;
		for(int i = 1; i < matrix.length; i++){
			for(int j = 1; j < matrix[0].length; j++){
				if(matrix[i][j] == 1){
					S[i][j] = Math.min(S[i-1][j], Math.min(S[i][j-1], S[i-1][j-1]))+1;
					max = Math.max(max, S[i][j]);
				}else{
					S[i][j] = 0;
				}
			}
		}
		return max;
	}
	public static void main(String[] args){
		int[][] matrix = {{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
		System.out.println(maxSize(matrix));
	}
}
