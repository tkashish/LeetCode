package BinaryTree;

public class MaximumPathSum {

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    int max = Integer.MIN_VALUE;
	    public int maxPathSum(TreeNode root) {
	        if(root == null){
	            return 0;
	        }else{
	            helper(root);
	            return max;
	        }
	    }
	    private int helper(TreeNode root){
	        if(root == null){
	            return 0;
	        }else{
	            int val = (int) root.val;
	            int l = maxPathSum(root.left);
	            if(l < 0) l = 0;
	            int r = maxPathSum(root.right);
	            if(r < 0) r = 0;
	            if(max < val + r + l){
	                max = val + r + l;
	            }
	            if((val+l)>(val+r)){
	                    return (val+l);
	            }else{
	                    return (val+r);
	            }
	        }
	    }
	}

}
