import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

import BinaryTree.TreeNode;

public class LRU {
    int capacity;
    int count;
    int time;
    PriorityQueue<Node> queue = null;
    HashMap<Integer, Integer> map;
    public LRU(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<Integer, Integer>();
        queue = new PriorityQueue<Node>();
    }
    
    public int get(int key) {
    	queue.remove(new Node(key, 1));
        this.time++;
    	queue.add(new Node(key, this.time));
        if(map.containsKey(key)){
            return map.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        time++;
        System.out.println("count =" + count);
        if(count == capacity){
        	queue.poll();
        	map.remove(key);
        }
        map.put(key, value);
        queue.add(new Node(key, this.time));
        count++;
    }
    
    private class Node implements Comparable<Node>{
        int key;
        int count;
        public Node(int k, int c){
            this.key = k;
            this.count = c;
        }
        @Override
        public int compareTo(Node o){
            if(count > o.count){
                return 1;
            }else if(count < o.count){
                return -1;
            }else{
                return 0;
            }
        }
        public boolean equals(Object o){
        	if(o == null)return false;
        	if(this.getClass() != o.getClass()) return false;
        	Node node = (Node) o;
        	return node.key == this.key;
        }
    }
    public static void main(String[] args){
    	LRU lru = new LRU(1);
    	lru.set(1, 1);
    	System.out.println(lru.get(1));
    	lru.set(3, 2);
    	lru.set(2, 2);
    	System.out.println(lru.get(1));
    }
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
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }else{
            	Deque<TreeNode> dq = new LinkedList<TreeNode>();
            	dq.removeLast()
            	dq.removeFirst()
                if((root.left != null && root.right == null) || (root.left = null && root.right != null)){
                    return false;
                }else if(root.left == null && root.right == null){
                    return true;
                }
                else{
                    boolean l = isSymmetric(root.left);
                    boolean r = isSymmetric(root.right);
                    if(l && r)
                        return true;
                    else
                        return false;
                }
            }
        }
    }
}