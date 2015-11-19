import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CodingTest {
	public static void main(String[] args){
		int[] i = {1,2,3,4};
		System.out.println(solution(i));
	}
	public static  int solution(int[] A) {
        int[] forward = new int[A.length];
        int[] backward = new int[A.length];
        forward[0] = A[0];
        backward[A.length-1] = A[A.length-1];
        for(int i = 1; i < A.length; i++){
            forward[i] = forward[i-1]+A[i];
            backward[A.length-1-i] = backward[A.length-i]+A[A.length-1-i];
        }
        Utils.printArray(forward);
        Utils.printArray(backward);
        for(int i = 0; i < A.length; i++){
            if(forward[i] == backward[i]){
                return i;    
            }
        }
        return -1;
    }
	 public int solution(int[] A, int X, int D) {
	        int time = -1;
	        int dist = 0;
	        List<Integer> positions = new ArrayList<Integer>();
	        for(int i = 0; i < A.length; i++){
	            positions.add(A[i]);
	            if(dist + D >= X) return time;
	            time++;
	            if(A[i]-dist < D+1 && A[i]-dist > 0){
	                dist = A[i];
	                Collections.sort(positions);
	                for(int j = 0; j < positions.size(); j++){
	                    if(positions.get(j) - dist < D+1){
	                        dist = positions.get(j);
	                    }
	                }
	            }
	        }
	        if(dist + D >= X) return time;
	        return -1;
	    }
}
