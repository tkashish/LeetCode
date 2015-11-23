package DynamicProgramming;

public class Longest_Valid_Parentheses {
	public static int longestValidParentheses(String s) {
		int counter = 0;
		int count = 0;
		int max = 0;
		for(char c : s.toCharArray()){
			if(c == '('){
				count++;
			}else{
				if(count > 0){
					counter+=2;
					count--;
				}else{
					max = Math.max(max , counter);
					counter = 0;
				}
			}
		}
		max = Math.max(max , counter);
		return max;
	}
	public static void main(String[] args){
//		System.out.println(longestValidParentheses(")()())(())()()"));
		String encrypted = Longest_Valid_Parentheses.encryptDecrypt("kylewbanks.com");
		System.out.println("Encrypted:" + encrypted);
		
		String decrypted = Longest_Valid_Parentheses.encryptDecrypt(encrypted);
		System.out.println("Decrypted:" + decrypted);
	}
	
	private static String encryptDecrypt(String input) {
		char[] key = {'K', 'C', 'Q'}; //Can be any chars, and any length array
		StringBuilder output = new StringBuilder();
		
		for(int i = 0; i < input.length(); i++) {
			output.append((char) (input.charAt(i) ^ key[i % key.length]));
		}
 		
		return output.toString();
	}
	
}
