package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_II {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null)return ret;
        List<Integer> innerList = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(null);
        queue.add(root);
        while(queue.size()>1){
            TreeNode node = queue.remove();
            if(node == null){
                if(innerList != null){
                    ret.add(innerList);
                }
                innerList = new ArrayList<Integer>();
                queue.add(null);
            }else{
                innerList.add((int)node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        ret.add(innerList);
        Collections.reverse(ret);
        return ret;
    }
	public static void main(String[] args){
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		list.add(6);
//		list.add(7);
//		list.add(8);
//		list.add(9);
//		Iterator<Integer> it = list.iterator();
//		while(it.hasNext()){
//			it.remove();
////			int i =  it.next();
////			System.out.println(i);
//		}
//		Integer i = new Integer(10);
//		Integer j = i;
//		System.out.println(i + " " + j);
//		j = 20;
//		System.out.println(i + " " + j);
		int[] i = {1,2,3,4,5,6,7,8};
		int[] j = Arrays.copyOfRange(i, 8,8);
		System.out.println(j.length);
	}
}
