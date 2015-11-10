package DynamicProgramming;

public class Maximal_Square {
	public static int maximalSquare(char[][] matrix) {
		int max = 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(i != 0 && j != 0){
					if(matrix[i][j] != '0'){
						int i1 = (int)matrix[i-1][j] - 48;
						int i2 = (int)matrix[i-1][j-1] - 48;
						int i3 = (int)matrix[i][j-1] - 48;
						matrix[i][j] = Integer.toString((1 + Math.min(i1, Math.min(i2, i3)))).charAt(0);
					}
				}
				max = Math.max(max, ((int)matrix[i][j])-48);
			}
		}
		return max*max;
	}
	public static int maximalSq(char[][] matrix){
        if(matrix.length == 0) return 0;
		int[][] table = new int[matrix.length][matrix[0].length];
		int max = 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(i == 0 || j == 0){
					if(matrix[i][j] == '0') table[i][j] = 0;
					else table[i][j] = 1;
				}else{
					if(matrix[i][j] == '1'){
						table[i][j] = 1+Math.min(table[i-1][j], Math.min(table[i][j-1],table[i-1][j-1]));
					}
					else table[i][j] = 0;
				}
				max = Math.max(max, table[i][j]);
			}
		}
		return max*max;
	}
	public static void print(char[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int numDecodings(String s) {
        int max = 2;
        int prev = 1;
        for(int i = 2; i < s.length(); i++){
            int temp = 0;
            int num = Integer.parseInt(s.substring(i-1,i+1));
            if(num < 27 && num > 0){
                temp = prev*1;
            }
            prev = max;
            max += temp;
        }
        return max;
    }
	public static void main(String[] args){
//		char[][] input = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','1'}};
//		print(input);
////		System.out.println(maximalSquare(input));
//		System.out.println(maximalSq(input));
		System.out.println(numDecodings("1222".contains({'0'})));
	}	
}
