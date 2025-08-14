package linkedlist;

public class App02KthToLastElement {
	
	public static void main(String[] args) {
		
		// Iterative
		testNthToLast();
		
		// Recursive
		testPrintKthToLast();
		
		// Recursive 2
		testKthToLast();
	}
	
	// Iterative
	static void testNthToLast()	{
		LinkedList ll = Util.createLinkedList(new int[] {10, 20, 30, 40});
		Node temp = nthToLast(ll.head, 3);
		System.out.println("temp  : " + temp.data);
	}
	
	/* We can use two pointers, p1 & p2. We place them k nodes apart 
	 * in the linked list by putting p2 at the beginning and moving 
	 * p1 k nodes into the list. Then, when we move them at the same pace, 
	 * p1 will hit the end of the linked list after LENGTH - k steps. 
	 * At that point, p2 will be LENGHT - k nodes into the list, 
	 * or k nodes from the end*/
	static Node nthToLast(Node head, int k) {
		Node p1, p2;
		p1 = p2 = head;
		for(int i = 1; i <= k; i++)	{
			// Out of Bound
			if(p1 == null)	{
				return null;
			}
			p1 = p1.next;
		}
		while(p1 != null)	{
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	
	// Recursive
    /* When the linked list hits the end, the method passes back a counter set to 0.
     * Each parent call adds 1 to this counter. When the counter equals k, we know 
     * we have reached the kth to the last element of the linked list.
    */
	static void testPrintKthToLast()	{
		LinkedList ll = Util.createLinkedList(new int[] {10, 20, 30, 40});
		int index = printKthToLast(ll.head, 2);
		System.out.println("index : " + index);
	}
	
	static int printKthToLast(Node head, int k)	{
		if(head == null)	{
			return 0;
		}else {
			int index = printKthToLast(head.next, k) + 1;
			System.out.println(head.data + " " +  index);
			if(index == k)	{
				System.out.println(k + "th to last node is " + head.data);
			}
			return index;
		}
	}
	
	// Recursive 2
	static void testKthToLast()	{
		LinkedList ll = Util.createLinkedList(new int[] {10, 20, 30, 40});
		ll.display();
		Node temp = kthToLast(ll.head, 1);
		while(temp != null)	{
		 System.out.println(temp.data);	
		 temp = temp.next;
		}
	}
	
	static Node kthToLast(Node head, int k)	{
		Index idx = new Index();
		return kthToLast(head, k, idx);
	}

	static Node kthToLast(Node head, int k, Index idx) {
		if(head == null)	{
			return null;
		}
		Node node = kthToLast(head.next, k, idx);
		idx.value += 1;
		if(idx.value == k)	{
			return head;
		}
		System.out.println("After if" + node);
		return node;
	}
	
	

}
class Index	{
	public int value = 0;
}
