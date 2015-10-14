package DynamicProgramming;
/*
 * http://community.topcoder.com/stat?c=problem_statement&pm=1918&rd=5006
 */
public class FlowerGarden {

	public static int[][] flowerGarden(int[] h, int[] b, int[] w){
		int len = h.length;
		int[][] S = new int[len][3];
		for(int i = 0; i < len; i++){
			S[i][0] = h[i];
			S[i][1] = b[i];
			S[i][2] = w[i];
		}
		for(int i = 0; i < len; i++){
			for(int j = 0; j < i; j++){
				if(S[j][1] > S[i][1]){
					if(S[j][2] <= S[i][2] && S[j][0] > S[i][0]){
						rotate(S,i,j);
						break;
					}else if (S[j][2] > S[i][2]){
						rotate(S, i, j);
						break;
					}
				}else if(S[j][1] < S[i][1]){
					if(S[j][2] > S[i][2]){
						rotate(S, i, j);
						break;
					}else if(S[j][2] <= S[i][2] && S[j][2] >= S[i][1] && S[j][0] > S[i][0]){
						rotate(S,i,j);
						break;
					}
				}else{
					if(S[j][2] <= S[i][2] && S[j][0] > S[i][0]){
//						System.out.println("*********");
						rotate(S,i,j);
						break;
					}else if (S[j][2] > S[i][2]){
						rotate(S, i, j);
						break;
					}
				}
			}
		}
		return S;
	}
	public static void rotate(int[][] S, int i, int j){
		
		for(int k = i-1; k >= j; k--){
			int temp0 = S[k][0];
			int temp1 = S[k][1];
			int temp2 = S[k][2];
			S[k][0] = S[k+1][0];
			S[k][1] = S[k+1][1];
			S[k][2] = S[k+1][2];
			S[k+1][0] = temp0;
			S[k+1][1] = temp1;
			S[k+1][2] = temp2;
		}

	}
	public static void main(String[] arg){
		int[] h = {5,4,3,2,1};
		int[] b = {1,1,1,1,1};
		int[] w = {365,365,365,365,365};
		int[][] out = flowerGarden(h, b, w);
		for(int i = 0; i < h.length; i++){
			System.out.print(out[i][0] + " ");
		}
		System.out.println();
		int[] h1 = {5,4,3,2,1};
		int[] b1 = {1,5,10,15,20};
		int[] w1 = {4,9,14,19,24};
		int[][] out1 = flowerGarden(h1, b1, w1);
		for(int i = 0; i < h1.length; i++){
			System.out.print(out1[i][0] + " ");
		}
		System.out.println();
		int[] h2 = {5,4,3,2,1};
		int[] b2 = {1,5,10,15,20};
		int[] w2 = {5,10,15,20,25};
		int[][] out2 = flowerGarden(h2, b2, w2);
		for(int i = 0; i < h2.length; i++){
			System.out.print(out2[i][0] + " ");
		}
		
		System.out.println();
		int[] h3 = {1,2,3,4,5,6};
		int[] b3 = {1,3,1,3,1,3};
		int[] w3 = {2,4,2,4,2,4};
		int[][] out3 = flowerGarden(h3, b3, w3);
		for(int i = 0; i < h3.length; i++){
			System.out.print(out3[i][0] + " ");
		}
		
		System.out.println();
		int[] h4 = {3,2,5,4};
		int[] b4 = {1,2,11,10};
		int[] w4 = {4,3,12,13};
		int[][] out4 = flowerGarden(h4, b4, w4);
		for(int i = 0; i < h4.length; i++){
			System.out.print(out4[i][0] + " ");
		}
	}
}

