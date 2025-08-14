package linkedlist;

public class App03DeleteCurrentNode {

	public static void main(String[] args) {
		testDeleteCurrentNode();
	}
	
	static void testDeleteCurrentNode() {
		LinkedList ll = Util.createLinkedList(new int[] {10, 20, 30, 40});
		System.out.println("Before Deleting");
		ll.display();
		ll.deleteNode(ll.head.next.next);
		System.out.println("After Deleting");
		ll.display();
	}
}
