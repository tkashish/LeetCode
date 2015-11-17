
public class Unique_Path_II {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		for(int i = 0; i < m ; i++){
			for(int j = 0; j < n ; j++){
				if(i == 0 && j == 0){
					if(obstacleGrid[i][j] == 1) return 0;
					obstacleGrid[i][j] = 1;
					continue;
				}
				if(obstacleGrid[i][j] == 1){ 
					obstacleGrid[i][j] = 0;
					continue;
				}
				if(i-1 < 0){
					obstacleGrid[i][j] = obstacleGrid[i][j-1]; 
				}else if(j-1 < 0){
					obstacleGrid[i][j] = obstacleGrid[i-1][j];
				}else{
					obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];  
				}
			}
		}
		return obstacleGrid[m-1][n-1];
	}
}
