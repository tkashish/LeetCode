package DynamicProgramming;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Lengt_of_the_longest_substring_without_repeating_characters {
	public static int longestUniqueSubsttr(String s){
		int maxLen = 1;
		Set<Character> set = new LinkedHashSet<Character>();
		String ret = "";
		set.add(s.charAt(0));
		for(int i = 1; i < s.length(); i++){
			if(set.contains(s.charAt(i))){
				Iterator<Character> it = set.iterator();
				while(it.hasNext()){
					Character c = it.next();
					it.remove();
					if(c == s.charAt(i)){
						break;
					}
				}
			}
			set.add(s.charAt(i));
			if(set.size() > maxLen){
				maxLen = Math.max(set.size(), maxLen);
				ret = set.toString();
			}
		}
		System.out.println(ret);
		return maxLen;
	}
	public static void main(String[] args){
		System.out.println(longestUniqueSubsttr("geeksforgeeks"));
		System.out.println(longestUniqueSubsttr("ABDEFGABEF"));
		System.out.println(longestUniqueSubsttr("aibdefgaobef"));
	}
}
