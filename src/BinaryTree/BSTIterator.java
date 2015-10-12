package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTIterator {

	TreeNode rootNode;
    Queue<TreeNode> queue;
    public BSTIterator(TreeNode root) {
        this.rootNode = root;
        queue = new LinkedList<TreeNode>();
        inOrder(root);
    }
    private void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            queue.add(root);
            inOrder(root.right);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public Object next() {
        if(this.hasNext()){
            return queue.remove().val;
        }else{
            return  null;
        }
    }
    public static void main(String[] args){
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
		BSTIterator it = new BSTIterator(F);
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
