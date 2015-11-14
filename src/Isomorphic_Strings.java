import java.util.Arrays;
import java.util.HashMap;


public class Isomorphic_Strings {
	public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())return false;
        HashMap<Character, Character> mapTS = new HashMap<Character, Character>();
        HashMap<Character, Character> mapST = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++){
            if(mapTS.containsKey(t.charAt(i)) && mapTS.get(t.charAt(i)) != s.charAt(i)){
                return false;
            }else{
            	if(mapST.containsKey(s.charAt(i))) return false;
                mapTS.put(t.charAt(i), s.charAt(i));
                mapST.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
	public static void main(String[] args){
//		System.out.println(isIsomorphic("egg", "add"));
		int[] arr = {1,2,3,4,5,6,7};
		int[] copy = (Arrays.copyOfRange(arr, 1, arr.length));
		for(int i : copy){
			System.out.println(i);
		}
	}
}
