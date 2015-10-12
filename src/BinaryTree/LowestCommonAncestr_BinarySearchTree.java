package BinaryTree;

public class LowestCommonAncestr_BinarySearchTree {
	public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
	    if(p.val == q.val){
	        return p;
	    }else if(root == null){
	        return root;
	    }
	    if(((int)p.val <= (int)root.val && (int)q.val >= (int)root.val) || ((int)p.val >= (int)root.val && (int)q.val <= (int)root.val)){
	        return root;
	    }else if((int)p.val > (int)root.val && (int)q.val > (int)root.val){
	        return lowestCommonAncestor_1(root.right, p, q);
	    }else if((int)p.val < (int)root.val && (int)q.val < (int)root.val){
	        return lowestCommonAncestor_1(root.left, p, q);
	    }
	    return null;
	}

	public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val == q.val){
			return p;
		}else if (root == null){
			return root;
		}
		return find(root, (int)p.val, (int)q.val);
	}

	public TreeNode find(TreeNode node, int val1, int val2){
		if(node == null){
			return null;
		}
		if(val1 > (int)node.val && val2 < (int)node.val || val2 > (int)node.val && val1 < (int)node.val){
			return node;
		}
		if((int)node.val == val1 || (int)node.val == val2){
			return node;
		}
		if(val1 > (int)node.val){
			return find(node.right, val1, val2);
		}else{
			return find(node.left, val1, val2);
		}
	}

	public boolean find(TreeNode root, TreeNode p){
		if(root == null){
			return false;
		}
		if(root.val == p.val){
			return true;
		}else{
			return find(root.left,p) | find(root.right,p);
		}
	}
	

}
