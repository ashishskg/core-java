package linkedlist;

public class App04Partition {

	public static void main(String[] args) {
		testPartition();
		testPartition2();
	}
	
	static void testPartition() {
		System.out.println("Partition.testPartition()");
		LinkedList ll = Util.createLinkedList(new int[] {3, 5, 8, 5, 10, 2, 1});
		// Util.display(ll.head);
		Util.displayDataRef(ll.head);
		Node result = partition(ll.head, 5);
		Util.display(result);
	}
	
	
	static Node partition(Node node, int x)	{
		Node beforeStart, beforeEnd, afterStart, afterEnd;
		beforeStart = beforeEnd = afterStart = afterEnd = null;
		
		while(node != null)	{
			System.out.println(node + " " + node.data);
			Node next = node.next;
			node.next = null;
			System.out.println("next : " + next);
			if(node.data < x)	{
				if(beforeStart == null)	{
					beforeEnd = beforeStart = node;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if(afterStart == null)	{
					afterEnd = afterStart = node;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		if(beforeStart == null)	{
			return afterStart;
		}
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	static void testPartition2() {
		System.out.println("Partition.testPartition2()");
		LinkedList ll = Util.createLinkedList(new int[] {3, 5, 8, 5, 10, 2, 1});
		Util.display(ll.head);
		Node result = partition2(ll.head, 5);
		Util.display(result);
	}
	
	/* We start a "new" list (using the existing nodes). Elements
	 * bigger than the pivot element are put at the tail and elements smaller are 
	 * put at the head. Each time we insert an element, we update either the head or tail.*/
	static Node partition2(Node node, int x)	{
		Node head, tail;
		head = tail = node;
		
		while(node != null)	{
			Node next = node.next;
			if(node.data < x)	{
				node.next = head;
				head = node;

			} else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}
	
}
