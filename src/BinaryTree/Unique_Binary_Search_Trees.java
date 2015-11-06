package BinaryTree;

import java.util.HashMap;

public class Unique_Binary_Search_Trees {
	public static int numTrees(int n) {
        if(n == 0)return 0;
        if(n == 1) return 1;
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        map1.put(0,1);
        map.put(1,map1);
        for(int i = 2; i <= n; i++){
            HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
            HashMap<Integer, Integer> m = map.get(i-1);
            for(int j = 0; j < i; j++){
                int count = 0;
                for(int k = j-1; k < m.size() ; k++){
                    if(k >= 0){
                        count += m.get(k);                     
                    }
                }
                map2.put(j, count);
            }
            map.put(i, map2);
        }
        int count = 0;
        HashMap<Integer, Integer> m = map.get(n);
        for(int i = 0; i < m.size(); i++){
            count += m.get(i);
        }
        return count;
    }
	public static void main(String[] args){
		System.out.println(numTrees(5));
	}
}
