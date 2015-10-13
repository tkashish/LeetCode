package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SpiralOrdering {
	/*
	 * using two stack
	 */
	public List<TreeNode> spiralOrdering(TreeNode root){
		List<TreeNode> list = new ArrayList<TreeNode>();
		Stack<TreeNode> q = new Stack<TreeNode>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		boolean flag = true; // if flag = true pop from q and push to stack
							 // if flag = false pop from stack and push to q
		q.push(root);
		while(true){
			if(flag){
				while(!q.isEmpty()){
					TreeNode node = q.pop();
					list.add(node);
					if(node.left != null){
						s.push(node.left);
					}
					if(node.right != null){
						s.push(node.right);
					}
				}
				flag = false;
			}else{
				while(!s.isEmpty()){
					TreeNode node = s.pop();
					list.add(node);
					if(node.right != null){
						q.push(node.right);
					}
					if(node.left != null){
						q.push(node.left);
					}
				}
				flag = true;
			}
			if(s.isEmpty() && q.isEmpty()){
				break;
			}
		}
		
		return list;
	}
	/*
	 * Using deque
	 */
	public List<TreeNode> sprialOrder(TreeNode root){
		List<TreeNode> list = new ArrayList<TreeNode>();
		Deque<TreeNode> d = new LinkedList<TreeNode>();
		boolean flag = true;
		d.addLast(root);
		d.addLast(null);
		while(true){
			if(flag){
				while(d.getFirst() != null){
					TreeNode node = d.removeFirst();
					list.add(node);
					if(node.left != null){
						d.addLast(node.left);
					}
					if(node.right != null){
						d.addLast(node.right);
					}
				}
				flag = false;
			}else{
				while(d.getLast() != null){
					TreeNode node = d.removeLast();
					list.add(node);
					if(node.right != null){
						d.addFirst(node.right);
					}
					if(node.left != null){
						d.addFirst(node.left);
					}
				}
				flag = true;
			}
			if(d.isEmpty() || (d.size() == 1 && d.element() == null)){
				break;
			}
		}
		return list;
	}
	public static void main(String[] args){
		Deque<TreeNode> d = new LinkedList<TreeNode>();
		SpiralOrdering so = new SpiralOrdering();
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
		List<TreeNode> list = so.sprialOrder(F);
		for(TreeNode i : list){
			System.out.println(i.val);
		}
	}
}
