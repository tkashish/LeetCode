package BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Zigzag_Level_Order_Traversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null) return ret;
        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        dq.addFirst(root);
        dq.addFirst(null);
        List<Integer> list = new ArrayList<Integer>();
        boolean flag = true;
        while(dq.size() > 1){
            if(flag){
                TreeNode node = dq.getLast();
                if(node == null){
                    ret.add(list);
                    list = new ArrayList<Integer>();
                    flag = false;                    
                }else{
                    node = dq.removeLast();
                    list.add((Integer) node.val);
                    if(node.left != null) dq.addFirst(node.left);
                    if(node.right != null) dq.addFirst(node.right);
                }
            }else{
                TreeNode node = dq.getFirst();
                if(node == null){
                    ret.add(list);
                    list = new ArrayList<Integer>();
                    flag = true;                    
                }else{
                    node = dq.removeFirst();
                    list.add((Integer) node.val);
                    if(node.right != null) dq.addLast(node.right);
                    if(node.left != null) dq.addLast(node.left);
                }
            }
        }
        ret.add(list);
        return ret;
    }

	public static void main(String[] args){
		System.out.println(3&4);
		for(int i = 1; i < 100; i++ ){
			System.out.println(Integer.toBinaryString(i) + "   " + i);
		}
	
	}
}
