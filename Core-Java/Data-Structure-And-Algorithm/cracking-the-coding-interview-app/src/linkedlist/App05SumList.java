package linkedlist;

public class App05SumList {
	
	public static void main(String[] args) {
		SumLists.testAddLists();
		SumLists2.testAddLists();
	}
}

class SumLists {
	
	static void testAddLists()	{
		LinkedList l1 = Util.createLinkedList(new int[] {7, 1, 6});
		LinkedList l2 = Util.createLinkedList(new int[] {5, 9, 2});
		
		Node result = addLists(l1.head, l2.head, 0);
		Util.display(result);
		
	}
	
	static Node addLists(Node n1, Node n2, int carry)	{
		if(n1 == null && n2 == null && carry == 0)	{
			return null;
		}
		Node result = new Node();
		int value = carry;
		
		value = (n1 != null ) ? value + n1.data : value;
		value = (n2 != null ) ? value + n2.data : value;
		
		result.data = value % 10;
		
		// Recurse
		
		if( n1 != null || n2 != null)	{
			Node more = addLists(n1 == null ? null : n1.next, n2 == null ? null : n2.next, value > 9 ? value / 10 : 0);
			result.setNext(more);	
		}
		return result;
	}
}


class SumLists2 {
	public static void main(String[] args) {
		
	}
	
	static void testAddLists() {
		LinkedList l1 = Util.createLinkedList(new int[] {1, 2, 3, 4});
		LinkedList l2 = Util.createLinkedList(new int[] {5, 6, 7});
		Node result = addLists(l1.head, l2.head);
		Util.display(result);
	}
	
	static Node addLists(Node n1, Node n2)	{
		int len1 = Util.length(n1);
		int len2 = Util.length(n2);
		
		
		if(len1 < len2) {
			n1 = padList(n1, len2 - len1);
		}else {
			n2 = padList(n2, len1 - len2);
		}

		PartialSum sum = addListHelper(n1, n2);
		
		if(sum.carry == 0)	{
			return sum.sum;
		} else {
			Node result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	
	static PartialSum addListHelper(Node n1, Node n2)	{
		if(n1 == null && n2 == null)	{
			PartialSum sum = new PartialSum();
			System.out.println("before sum :"  + sum);

			return sum;
		}
		System.out.println("before n1 : " + n1 + " n2 :" + n2);
		PartialSum sum = addListHelper(n1.next, n2.next);
		System.out.println("after sum :"  + (sum == sum));
		System.out.println("after n1 : " + n1 + " n2 :" + n2);

		int val = sum.carry + n1.data + n2.data;
		
		Node fullResult = insertBefore(sum.sum, val % 10);
		sum.sum = fullResult;
		sum.carry = val / 10;
		return sum;
	}
	
	static Node padList(Node n, int padding)	{
		Node head = n;
		for(int i = 0; i < padding; i++)	{
			head = insertBefore(head, 0);
		}
		return head;
	}
	
	static Node insertBefore(Node list, int data)	{
		Node node = new Node(data);
		if(list != null)	{
			node.next = list;
		}
		return node;
	}

}

class PartialSum {
	public Node sum = null;
	int carry = 0;
}
