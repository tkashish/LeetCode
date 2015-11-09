package DynamicProgramming;

public class Binomial_Coefficient {
	public static int getCoefficient(int n, int k){
		int[][] s = new int[n+1][n+1];
		for(int i = 0; i <= n ; i++){
			s[i][0] = 1;
		}
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= k; j++){
				if(j <= i){
					s[i][j] = s[i-1][j-1] + s[i-1][j];
				}
			}
		}
		return s[n][k];
	}
	public static void main(String[] args){
		System.out.println(getCoefficient(4, 2));
	}
}
