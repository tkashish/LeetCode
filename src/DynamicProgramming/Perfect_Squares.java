package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Perfect_Squares {
	public int numSquares(int n) {
        List<Integer> squares = generateSqs(n);
        int[] array = new int[n+1];
        array[0] = 0;
        for(int i = 1; i < array.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < squares.size(); j++){
                if(squares.get(j) > i){
                    break;
                }
                min = Math.min(min, array[i-squares.get(j)]);
            }
            array[i] = min+1;
        }
        return array[array.length-1];
    }
    public List<Integer> generateSqs(int n){
        List<Integer> ret = new ArrayList<Integer>();
        int num = 1;
        int sq = 1;
        while(sq <= n){
            ret.add(sq);
            num++;
            sq = num*num;
        }
        return ret;
    }
}
