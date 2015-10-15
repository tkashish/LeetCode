package DynamicProgramming;
import java.util.Arrays;
import java.util.List;

public class AvoidRoads {

	public static long avoidRoads(int w, int h, String[] bad){
		List<String> badList = Arrays.asList(bad);
		long [][] S = new long[w+1][h+1];
		S[0][0] = 1;
		for(int i = 0; i <= w; i++){
			for(int j = 0; j <= h; j++){
				if(i == 0 && j == 0){
					continue;
				}
				long m = 0;
				long n = 0;
				if(i-1 >= 0 && !badList.contains((i-1) + " " + j + " " + i + " " + j)  && !badList.contains(i + " " + j + " " + (i-1) + " " + j)){
					m = S[i-1][j];
				}
				if(j-1 >= 0 && !badList.contains(i + " " + (j-1) + " " + i + " " + j) && !badList.contains(i + " " + j + " " + i + " " + (j-1))){
					n = S[i][j-1];
				}
				S[i][j] = m + n;
			}
		}
		return S[w][h];
	}
	public static void main(String[] arg){
		String[] in1 = {"0 0 0 1","6 6 5 6"};
		System.out.println(avoidRoads(6, 6, in1));
		
		String[] in2 = {};
		System.out.println(avoidRoads(1, 1, in2));
		
		String[] in3 = {};
		System.out.println(avoidRoads(35, 31, in3));
		
		String[] in4 = {"0 0 1 0", "1 2 2 2", "1 1 2 1"};
		System.out.println(avoidRoads(2, 2, in4));
		
		
	}
}
