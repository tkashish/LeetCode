package BinaryTree;

import java.util.Arrays;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int i = 0;
        for(i = 0; i < inorder.length; i++){
            if(inorder[i] == postorder[postorder.length-1]) break;
        }
        root.right = this.buildTree(Arrays.copyOfRange(inorder,i+1,inorder.length), Arrays.copyOfRange(postorder,postorder.length-1-(inorder.length-i-1) ,postorder.length-1));
        root.left = this.buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder,0,postorder.length-1-(inorder.length-i-1)));
        return root;
    }
}
