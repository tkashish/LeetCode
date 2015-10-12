package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

	public List<Object> postOrder(TreeNode root){
		List<Object> list = new ArrayList<Object>();
		List<TreeNode> right = new ArrayList<TreeNode>();
		if(root == null){
			return list;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(true){
			if(root != null){
				s.push(root);
				root = root.left;
			}else{
				TreeNode node = s.peek();
				if(node.right != null && !right.contains(node.right)){
					right.add(node.right);
					root = node.right;
				}else{
					list.add(node.val);
					s.pop();
				}
			}
			if(s.isEmpty() && root == null){
				break;
			}
		}
		return list;
	}
	public static void main(String[] args){
		PostOrder po = new PostOrder();
		/**
		 * test 1
		 */
		TreeNode F = new TreeNode("F");
		TreeNode B = new TreeNode("B");
		TreeNode G = new TreeNode("G");
		TreeNode A = new TreeNode("A");
		TreeNode D = new TreeNode("D");
		TreeNode C = new TreeNode("C");
		TreeNode E = new TreeNode("E");
		TreeNode I = new TreeNode("I");
		TreeNode H = new TreeNode("H");
		F.left = B;
		F.right = G;
		B.right = D;
		B.left = A;
		D.left = C;
		D.right = E;
		G.right = I;
		I.left = H;
		List<Object> list = po.postOrder(F);
		for(Object i : list){
			System.out.println(i);
		}
	}

}
