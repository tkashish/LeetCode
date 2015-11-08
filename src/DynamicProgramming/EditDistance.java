package DynamicProgramming;
/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 */
public class EditDistance {
	public static int editDistance(String s1, String s2){
		int l1 = s1.length();
		int l2 = s2.length();
		int rem = 0;
		if(l2-l1 < 0) rem = l1-l2;
		int[][] matrix = new int[l1+1][l2+1];
		for(int i = 0; i <= l1; i++){
			for(int j = 0;j <= l2; j++){
				if(i == 0 || j == 0)matrix[i][j]=0;
				else if(s1.charAt(i-1) == s2.charAt(j-1))matrix[i][j] = matrix[i-1][j-1]+1;
				else matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
			}
		}
		return l2-matrix[l1][l2] + rem;
	}
	public static void main(String[] args){
		System.out.println(editDistance("sunday", "saturday"));
		System.out.println(editDistance("cut", "cat"));
		System.out.println(editDistance("gesek", "gearrk"));
	}
}
