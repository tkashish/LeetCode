/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * @author kashishtayal
 *
 */
public class Excel_Sheet_Column_Title {
	public static String convertToTitle(int n) {
		if(n == 0) return "";
		StringBuilder sb = new StringBuilder();
		if(n%26 == 0){
			sb.append(convertToTitle((n-1)/26));
			sb.append("Z");
		}else{
			sb.append(convertToTitle(n/26));
			sb.append(Character.valueOf((char) ((n%26)+64)));
		}
		return sb.toString();
	}
	public static void main(String[] args){
		System.out.println(convertToTitle(26));
	}
}
