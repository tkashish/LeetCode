package DynamicProgramming;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestCommonSubsequence {
	public static String LCS(String s1, String s2){
		int[][] mat = new int[s1.length()+1][s2.length()+1];
		Set<Character> list = new LinkedHashSet<Character>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s1.length()+1; i++){
			for(int j = 0; j < s2.length()+1; j++){
				if(i == 0 || j == 0){
					mat[i][j] = 0;
				}else if(s1.charAt(i-1) == s2.charAt(j-1)){
					mat[i][j] = mat[i-1][j-1]+1;
					list.add(s1.charAt(i-1));
				}else{
					mat[i][j] = Math.max(mat[i][j-1],mat[i-1][j]);
				}
			}
		}
		int s = mat[s1.length()][s2.length()]; 
		Iterator<Character> it = list.iterator();
		int count = 0;
		while(it.hasNext()){
			Character c = it.next();
			if(count >= list.size()-s){
				sb.append(c);
			}
			count++;
		}
		return sb.toString();
	}
	public static void main(String[] args){
		System.out.println(LCS("GXTXAYB","AUUTGAB"));
	}
}
