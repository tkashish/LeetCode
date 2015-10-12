package BinaryTree;

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if(root != null){
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			this.invertTree(root.left);
			this.invertTree(root.right);
		}
		return root;
	}
}
