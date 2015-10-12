package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

	public List<Object> inOrder(TreeNode root){
		List<Object> list = new ArrayList<Object>();
		if(root == null){
            return list;
        }
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(true){
			if(root != null){
				s.push(root);
				root = root.left;
			}else{
				TreeNode node = s.pop();
				list.add(node.val);
				if(node.right != null){
					root = node.right;
				}
			}
			if(s.isEmpty() && root == null){
				break;
			}
		}
		return list;
	}
	public static void main(String[] args){
		InOrder io = new InOrder();
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
		List<Object> list = io.inOrder(F);
		for(Object i : list){
			System.out.println(i);
		}
	}
	private static void inorderTraversalwithoutrecursion(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		if(root == null)
			return;
		
		foo(root,s);
		
		while(!s.isEmpty()){
			root = s.pop();
			System.out.println(root.val);
			if(root.right != null){
				root = root.right;
				foo(root,s);
			}
		}
		
	}


	private static void foo(TreeNode root, Stack<TreeNode> s) {
		while(root != null){
			s.push(root);
			root = root.left;
		}
		
	}
}
