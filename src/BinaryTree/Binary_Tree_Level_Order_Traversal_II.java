package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
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
}
