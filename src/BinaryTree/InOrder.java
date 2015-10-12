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
	List<TreeNode> list = new ArrayList<TreeNode>();
	public void inOrderRec(TreeNode root){
		if(root != null){
			inOrderRec(root.left);
			list.add(root);
			inOrderRec(root.right);
		}
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
		List<Object> list1 = io.inOrder(F);
		for(Object i : list1){
			System.out.print(i + " ");
		}
		System.out.println("");
		io.inOrderRec(F);
		for(TreeNode i : io.list){
			System.out.print(i.val + " ");
		}
	}
}
