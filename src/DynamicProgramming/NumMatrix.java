package DynamicProgramming;

public class NumMatrix {
	int[][] array;
	public NumMatrix(int[][] matrix) {
		if(matrix.length > 0){
			array = new int[matrix.length][matrix[0].length];
			array[0][0] = matrix[0][0];
			for(int i = 0; i < array.length; i++){
				for(int j = 0; j < array[0].length; j++){
					if(i == 0 && j == 0) continue;
					if( i == 0){
						array[i][j] = array[i][j-1] + matrix[i][j];
					}else if(j == 0){
						array[i][j] = array[i-1][j] + matrix[i][j];
					}else{
						array[i][j] = array[i-1][j] + array[i][j-1] - array[i-1][j-1] + matrix[i][j];
					}
				}
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if(array == null) return 0;
		if (row1 == 0 && col1 == 0){
			return array[row2][col2];
		}
		if(row1 == 0 && col1 != 0){
			return array[row2][col2] - array[row2][col1-1];
		}else if (col1 == 0 && row1 != 0){
			return array[row2][col2] - array[row1-1][col2];
		}else{
			return array[row2][col2] - array[row1-1][col2] - array[row2][col1-1] + array[row1-1][col1-1];
		}
	}

	public static void main(String[] args){
		int[][] mat = new int[0][0];
		NumMatrix nm = new NumMatrix(mat);
	}
}
