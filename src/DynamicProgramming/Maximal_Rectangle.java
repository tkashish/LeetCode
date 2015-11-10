package DynamicProgramming;

public class Maximal_Rectangle {
	public int maximalRectangle(char[][] matrix) {
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
						table[i][j] = 1+Math.max(table[i-1][j], Math.max(table[i][j-1],table[i-1][j-1]));
					}
					else table[i][j] = 0;
				}
				max = Math.max(max, table[i][j]);
			}
		}
		return max*max;
	}
	
	public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        char[] arr = s.toCharArray();
        int[] count = new int[arr.length];
        if(s.charAt(0) != '0'){
            count[0] = 1;
        }else{
            count[0] = 0;
        }
        
        if(s.length() == 1){
            return count[0];
        }
        count[1] = count[0];
        if(s.charAt(1) != '0'){
            String s1 =""+arr[0]+arr[1];
            if(Integer.parseInt(s1)<=26){
                count[1] ++;
            }
        }
        for(int i = 2; i < arr.length; i++){
            count[i] = count[i-1];
            String s1 =""+arr[i-1]+arr[i];
            if(Integer.parseInt(s1)<=26){
                count[i] += count[i-2];
            }
        }
        return count[s.length()-1];
    }
}
