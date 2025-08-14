package linkedlist;

import java.util.HashSet;

public class App01RemoveDuplicate {
	
	public static void main(String[] args) {
		testDeleteDuplicates();
		System.out.println();
		testdeleteDuplicatesNoBuffer();

	}
	
	static void testDeleteDuplicates()	{
		System.out.println("RemoveDuplicateLL.testDeleteDuplicates()");
		System.out.println("Original List");
		LinkedList ll = Util.createLinkedList(new int[] {10, 10, 20, 10, 30, 10});
		ll.display();
		deleteDuplicates(ll.head);
		System.out.println("\nAfter removing Duplicate");
		ll.display();
	}
	
	/* Solution 1 : Remove Duplicates With HashSet */
	static void deleteDuplicates(Node n)	{
		HashSet<Integer> set = new HashSet<>();
		Node previous = null;
		while(n != null)	{
			if(set.contains(n.data))	{
				previous.next = n.next;
			}else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
	
	static void testdeleteDuplicatesNoBuffer()	{
		System.out.println("RemoveDuplicateLL.testdeleteDuplicatesNoBuffer()");
		System.out.println("Original List");
		LinkedList ll = Util.createLinkedList(new int[] {10, 10, 20, 10, 30, 10});
		ll.display();
		deleteDuplicatesNoBuffer(ll.head);
		System.out.println("\nAfter removing Duplicate");
		ll.display();
	}
	
	/* Solution 2: Remove Duplicate Without buffer. */
	static void deleteDuplicatesNoBuffer(Node n)	{
		Node current = n;
		while(current != null)	{
			/* Remove all future nodes that have the same value */
			Node runner = current;
			while(runner.next != null)	{
				if(runner.next.data == current.data)	{
					runner.next = runner.next.next;
				}else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
}