package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Unique_Binary_Search_Trees_II {
	public static List<TreeNode> generateTrees(int n) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(n == 0){
			list.add(null);
		}
		for(int i = 1;i < n+1; i++){
			list = addNode(list, new TreeNode(i));
		}
		return list;
	}
	public static List<TreeNode> addNode(List<TreeNode> list, TreeNode node){
		List<TreeNode> newList = new ArrayList<TreeNode>();
		if(list.size() == 0){
			newList.add(node);
		}else{
			for(TreeNode root : list){
				TreeNode newNode = new TreeNode(node.val);
				newNode.left = copyTree(root);
				newList.add(newNode);
				TreeNode newRoot = copyTree(root);
				TreeNode r = newRoot;
				while(r != null){
					newNode = new TreeNode(node.val);
					TreeNode temp = r.right;
					r.right = newNode;
					newNode.left = temp;
					newList.add(copyTree(newRoot));
					r.right = temp;
					r = temp;
				}
			}
		}
		return newList;
	}
	public static TreeNode copyTree(TreeNode node){
		if(node == null)return null;
		TreeNode root = new TreeNode(node.val);
		root.left = copyTree(node.left);
		root.right = copyTree(node.right);
		return root;
	}
	public static void main(String[] args){
		generateTrees(3);
	}
}
