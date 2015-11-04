package BinaryTree;

import java.util.Arrays;

public class Construct_Binary_Tree_from_Inorder_and_Preorder_Traversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)return null;
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0; 
        for(i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0])break;
        }
        root.left = this.buildTree(Arrays.copyOfRange(preorder,1,1+i), Arrays.copyOfRange(inorder,0,i));
        root.right = this.buildTree(Arrays.copyOfRange(preorder,1+i,preorder.length), Arrays.copyOfRange(inorder,i+1,inorder.length));
        return root;
    }
}
