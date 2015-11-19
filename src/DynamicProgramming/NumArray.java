package DynamicProgramming;

public class NumArray {
	int[] matrix;
    public NumArray(int[] nums) {
        matrix = new int[nums.length+1];
        matrix[0] = 0;
        for(int i = 1; i <= nums.length; i++){
            matrix[i] = matrix[i-1] + nums[i-1];
        }
        for(int i = 0; i < matrix.length; i++){
            System.out.print(matrix[i] + " ");
        }
        System.out.println();
    }

    public int sumRange(int i, int j) {
        return matrix[j+1]-matrix[i];
    }
    public static void main(String[] args){
    	int[] arr = {-2,0,3,-5,2,-1};
    	NumArray na = new  NumArray(arr);
    	System.out.println(na.sumRange(0, 2));
    	System.out.println(na.sumRange(2, 5));
    	System.out.println(na.sumRange(0, 5));
    }
}
