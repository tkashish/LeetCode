package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepthBinaryTree {
	/*
	 * Recursion
	 */
	public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            int l = this.maxDepth(root.left) + 1;
            int r = this.maxDepth(root.right) + 1;
            if(l > r){
                return l;
            }else{
                return r;
            }
        }
    }
	/*
	 * iteration BFS
	 */
	public int maxDeprth_BFS(TreeNode root){
		if(root == null){
			return 0;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(null);
		q.add(root);
		q.add(null);
		int val = 0;
		while(true){
			if(q.size() == 1 && q.element() == null){
				break;
			}
			TreeNode node = q.remove();
			if(node == null){
				q.add(null);
				val++;
			}else{
				if(node.left != null){
					q.add(node.left);
				}
				if(node.right != null){
					q.add(node.right);
				}
			}
		}
		return val;
		
	}
	
	public int maxDepth_DFS(TreeNode root){
		Stack<TreeNode> s = new Stack<TreeNode>();
		int maxVal = 0;
		int val = 0;
		while(true){
			if(root != null){
				s.push(root);
				root = root.left;
				val++;
			}else{
				TreeNode node = s.peek();
				if(node.right == null){
					if(maxVal < val){
						maxVal = val;
					}
					s.pop();
					val--;
					if(s.isEmpty()){
						return maxVal;
					}
					if(s.peek().right!=null && node.val == s.peek().right.val){
						s.pop();
						val--;
					}
				}else{
					root = node.right;
				}
			}
			if(s.isEmpty()){
				break;
			}
		}
		return maxVal;
	}
	
	public static void main(String[] arg){

		Stack<TreeNode> s = new Stack<TreeNode>();
		System.out.println(s.pop());
	}

}
