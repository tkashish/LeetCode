package DynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;
/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=1592&rd=4482
 * Problem Statement
    	Suppose you had an n by n chess board and a super piece called a kingknight. Using only one move the kingknight denoted 'K' below can reach any of the spaces denoted 'X' or 'L' below:
   .......
   ..L.L..
   .LXXXL.
   ..XKX..
   .LXXXL.
   ..L.L..
   .......
In other words, the kingknight can move either one space in any direction (vertical, horizontal or diagonally) or can make an 'L' shaped move. An 'L' shaped move involves moving 2 spaces horizontally then 1 space vertically or 2 spaces vertically then 1 space horizontally. In the drawing above, the 'L' shaped moves are marked with 'L's whereas the one space moves are marked with 'X's. In addition, a kingknight may never jump off the board.



Given the size of the board, the start position of the kingknight and the end position of the kingknight, your method will return how many possible ways there are of getting from start to end in exactly numMoves moves. start and finish are int[]s each containing 2 elements. The first element will be the (0-based) row position and the second will be the (0-based) column position. Rows and columns will increment down and to the right respectively. The board itself will have rows and columns ranging from 0 to size-1 inclusive. 



Note, two ways of getting from start to end are distinct if their respective move sequences differ in any way. In addition, you are allowed to use spaces on the board (including start and finish) repeatedly during a particular path from start to finish. We will ensure that the total number of paths is less than or equal to 2^63-1 (the upper bound for a long).
 
Definition
    	
Class:	ChessMetric
Method:	howMany
Parameters:	int, int[], int[], int
Returns:	long
Method signature:	long howMany(int size, int[] start, int[] end, int numMoves)
(be sure your method is public)
    
 
Notes
-	For C++ users: long long is a 64 bit datatype and is specific to the GCC compiler.
 
Constraints
-	size will be between 3 and 100 inclusive
-	start will contain exactly 2 elements
-	finish will contain exactly 2 elements
-	Each element of start and finish will be between 1 and size-1 inclusive
-	numMoves will be between 1 and 50 inclusive
-	The total number of paths will be at most 2^63-1.
 
Examples
0)	
    	
3
{0,0}
{1,0}
1
Returns: 1
Only 1 way to get to an adjacent square in 1 move
1)	
    	
3
{0,0}
{1,2}
1
Returns: 1
A single L-shaped move is the only way
2)	
    	
3
{0,0}
{2,2}
1
Returns: 0
Too far for a single move
3)	
    	
3
{0,0}
{0,0}
2
Returns: 5
Must count all the ways of leaving and then returning to the corner
4)	
    	
100
{0,0}
{0,99}
50
Returns: 243097320072600

 * @author kashishtayal
 *
 */
public class ChessMatrix {
	public static int solution(int size, int[] start, int[] end, int numMoves){
		int[] i = {-2,-2,-1,-1,-1,-1,-1,0,0,1,1,1,1,1,2,2};
		int[] j = {-1,1,-2,-1,0,1,2,-1,1,-2,-1,0,1,2,-1,1};
		int[][] board = new int[size][size];
		board[start[0]][start[1]] = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(start);
		queue.add(null);
		for(int l = 0; l < numMoves; l++){
			int[] arr = queue.remove();
			while(arr != null){
				for(int k = 0; k < i.length; k++){
					int[] nextArr = new int[2];
					nextArr[0] = arr[0]+i[k];
					nextArr[1] = arr[1]+j[k];
					if(nextArr[0]>=0 && nextArr[0]<size && nextArr[1]>=0 && nextArr[1]<size){
						queue.add(nextArr);
					}
				}
				arr = queue.remove();
			}
			queue.add(null);
		}
		int num = 0;
		int[] f = queue.remove();
		while(f != null){
			if(f[0] == end[0] && f[1] == end[1]){
				num++;
			}
			f = queue.remove();
		}
		return num;
	}
	public static void main(String[] args){
		int size = 3;
		int[] start = {0,0};
		int[] end = {1,0};
		int numMoves = 1;
		System.out.println(solution(size, start, end, numMoves));

		int size1 = 3;
		int[] start1 = {0,0};
		int[] end1 = {1,2};
		int numMoves1 = 1;
		System.out.println(solution(size1, start1, end1, numMoves1));

		int size2 = 3;
		int[] start2 = {0,0};
		int[] end2 = {2,2};
		int numMoves2 = 1;
		System.out.println(solution(size2, start2, end2, numMoves2));

		int size3 = 3;
		int[] start3 = {0,0};
		int[] end3 = {0,0};
		int numMoves3 = 2;
		System.out.println(solution(size3, start3, end3, numMoves3));

		int size4 = 100;
		int[] start4 = {0,0};
		int[] end4 = {0,99};
		int numMoves4 = 50;
		System.out.println(solution(size4, start4, end4, numMoves4));
	}
}