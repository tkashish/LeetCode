package DynamicProgramming;

public class BadNeighbors {

	public static int badNeighbors(int[] in){
		int len = in.length;
		int[][] S = new int[len][2];
		S[0][0] = in[0];
		S[0][1] = 1;
		int max = in[0];
		for(int i = 1; i < len; i++ ){
			S[i][0] = in[i];
			S[i][1] = -1;
		}
		for(int i = 1; i < len ; i++){
			for(int j = 0; j < i-1 ; j++){
				if(S[j][0] + in[i] > S[i][0]){
					if(i == len-1 && S[j][1] > 0){
						continue;
					}
					S[i][0] = S[j][0] + in[i];
					if(S[j][1] > 0){
						S[i][1] = 1;
					}else{
						S[i][1] = -1;
					}
				}
			}
//			System.out.println(in[i] + "   " + S[i][0] + "  " + S[i][1]);
			if(max < S[i][0]){
				max = S[i][0];
			}
		}
		return max;
	}
	
	public static void main(String[] arg){
		int[] in1 = {10, 3, 2, 5, 7, 8};
		System.out.println(badNeighbors(in1));
		

		int[] in2 = {11, 15};
		System.out.println(badNeighbors(in2));

		int[] in3 = { 7, 7, 7, 7, 7, 7, 7 };
		System.out.println(badNeighbors(in3));

		int[] in4 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
		// 1, 2, 4, 6, 9, 7, 11, 12, 15, 
		System.out.println(badNeighbors(in4));

		int[] in5 = {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
				  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
				  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};
		System.out.println(badNeighbors(in5));
	}
}
