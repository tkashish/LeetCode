import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Letter_Combinations_of_a_Phone_Number {
	HashMap<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
    public List<String> letterCombinations(String digits) {
        for(int i = 2; i < 10 ; i++){
            List<Character> list = new ArrayList<Character>();
            if(i == 2){
                list.addAll(Arrays.asList('a','b','c'));
            }else if(i == 3){
                list.addAll(Arrays.asList('d','e','f'));
            }else if(i == 4){
                list.addAll(Arrays.asList('g','h','i'));
            }else if(i == 5){
                list.addAll(Arrays.asList('j','k','l'));
            }else if(i == 6){
                list.addAll(Arrays.asList('m','n','o'));
            }else if(i == 7){
                list.addAll(Arrays.asList('p','q','r','s'));
            }else if(i == 8){
                list.addAll(Arrays.asList('t','u','v'));
            }else if(i == 9){
                list.addAll(Arrays.asList('w','x','y','z'));
            }
            map.put(i,list);
        }
        System.out.println(map.get(2));
        return helper(digits);
    }
    public List<String> helper(String digits){
        List<String> list = new ArrayList<String>();
        if(digits.length() == 0) return list;
        List<Character> l = map.get(Integer.parseInt(String.valueOf(digits.charAt(0))));
        if(digits.length() == 1){
            for(char c : l){
                list.add(String.valueOf(c));
            }
            return list;
        }
        List<String> list1 = helper(digits.substring(1,digits.length()));
        for(char c : l){
            for(String s : list1){
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                sb.append(s);
                list.add(sb.toString());
            }
        }
        return list;
    }
    public static void main(String[] args){
    	Letter_Combinations_of_a_Phone_Number l = new Letter_Combinations_of_a_Phone_Number();
    	List<String> list = l.letterCombinations("23");
    	for(String s : list){
    		System.out.println(s);
    	}
    }
}
