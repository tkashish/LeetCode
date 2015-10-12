
public class SinglyLinedList {

	public SinglyLinedList() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] arg){
		SinglyLinedList l = new SinglyLinedList();
		Node head = new Node(10);
		Node n1 = new Node(1);
		head.next = n1;
		Node n2 = new Node(2);
		n1.next = n2;
		n2 = null;
//		l.deleteNode(n1);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	public void deleteNode(Node node) {  
        node.val = node.next.val;
        node.next = node.next.next;
	}

}
class Node{
	int val;
	Node next;
	Node(int x){
		val = x;
	}
}