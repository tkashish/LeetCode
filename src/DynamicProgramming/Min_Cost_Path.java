package DynamicProgramming;

public class Min_Cost_Path {
	public static int minCostPath(int[][] matrix, int x, int y){
		int[][] cost = new int[matrix.length][matrix[0].length];
		cost[0][0] = matrix[0][0];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(i==0 && j==0)continue;
				if(i-1 >= 0 && j-1 < 0) cost[i][j] = matrix[i][j] + cost[i-1][j];
				else if(i-1 < 0 && j-1 >= 0) cost[i][j] = matrix[i][j] + cost[i][j-1];
				else cost[i][j] = matrix[i][j] + Math.min(cost[i-1][j-1], Math.min(cost[i-1][j], cost[i][j-1]));
				
				if(i == x && j == y) return cost[x][y];
			}
		}
		return -1;
	}
	public static void main(String[] args){
		int[][] input = {{1,2,3},{4,8,2},{1,5,3}};
		System.out.println(minCostPath(input, 2, 2));
	}
}
