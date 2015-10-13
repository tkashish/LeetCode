package DynamicProgramming;

public class ZigZag {

	public static int zigZag(int[] in){
		int len = in.length;
		int[][] S = new int[len][2];
		S[0][0] = 1;
		S[0][1] = 1;
		int max = 1;
		for(int i = 1; i < len; i++){
			S[i][0] = 0;
			S[i][1] = 0;
		}
		for(int i = 1; i < len; i++){
			for(int j = 0; j < i ; j++){
				if((in[j] < S[j][1] && in[i] > in[j] && S[j][0] + 1 > S[i][0]) || (in[j] > S[j][1] && in[i] < in[j] && S[j][0] + 1 > S[i][0]) || (j == 0 && S[j][0] + 1 > S[i][0]) ){
					S[i][0] = S[j][0] + 1;
					S[i][1] = in[j];
				}
			}
//			System.out.println(in[i]+"  " +S[i][1] + "   " + S[i][0]);
			if(max < S[i][0]){
				max = S[i][0];
			}
		}
		return max;
	}
	public static void main(String[] arg){
		int[] in1 = {1, 7, 4, 9, 2, 5};
		System.out.println(zigZag(in1));
		
		int[] in2 = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
		System.out.println(zigZag(in2));
		
		int[] in3 = {1};
		System.out.println(zigZag(in3));
		
		int[] in4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(zigZag(in4));
		
		int[] in5 = {70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32};
		System.out.println(zigZag(in5));
		
		int[] in6 = {374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244};
		System.out.println(zigZag(in6));
		
	}
}
