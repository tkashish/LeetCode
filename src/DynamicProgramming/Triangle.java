package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {
		int[] prev = new int[1];
        prev[0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++){
            int[] curr = new int[triangle.get(i).size()];
            curr[0] = triangle.get(i).get(0) + prev[0];
            for(int j = 1; j < curr.length-1; j++){
                int sum1 = triangle.get(i).get(j) + prev[j-1];
                int sum2 = triangle.get(i).get(j) + prev[j];
                curr[j] = Math.min(sum1,sum2);
            }
            curr[curr.length-1] = triangle.get(i).get(curr.length-1) + prev[curr.length-2];
            prev = curr;
        }
        Arrays.sort(prev);
        return prev[0];
    }
}
