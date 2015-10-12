package BinaryTree;

public class LowestCommonAncestor_BinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	      if(root == null){
	    	   return null;
	       }else if(root == p || root == q){
	    	   return root;
	       }else if(p == q){
	    	   return p;
	       }else{
	    	   TreeNode l = lowestCommonAncestor(root.left, p, q);
	    	   TreeNode r = lowestCommonAncestor(root.right, p, q);
	    	   /*
	    	    * if l == null this means that both p, q does not exist in left sub tree and similar for r
	    	    * if l != null means that either p or q or both exists in left sub tree and similar for r
	    	    * 
	    	    */
	    	   if(l == null){
	    		   return r;
	    	   }else if(r == null){
	    		   return l;
	    	   }else{
	    		   return root;
	    	   }
	       }
	    }
	
}
