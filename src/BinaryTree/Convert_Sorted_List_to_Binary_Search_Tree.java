package BinaryTree;

import java.util.ArrayList;

public class Convert_Sorted_List_to_Binary_Search_Tree {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public class Solution {
	    public TreeNode sortedListToBST(ListNode head) {
	        ArrayList<ListNode> list = new ArrayList<ListNode>();
	        while(head != null){
	            list.add(head);
	            head = head.next;
	        }
	        return helper(list, 0, list.size()-1);
	    }
	    private TreeNode helper(ArrayList<ListNode> list, int start, int end){
	        if(end < start){
	            return null;
	        }
	        int len = end-start;
	        TreeNode root = null;
	        int mid = start + (len/2);
	        root = new TreeNode(list.get(mid).val);
	        root.left = helper(list,start,mid-1);
	        root.right = helper(list,mid+1,end);
	        return root;
	    }
	}

}
