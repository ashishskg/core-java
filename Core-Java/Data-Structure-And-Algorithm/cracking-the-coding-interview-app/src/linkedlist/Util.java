package linkedlist;

public class Util {

	static LinkedList createLinkedList(int []arrData) {
		LinkedList ll = new LinkedList();
		ll.createLinkedList(arrData);
		return ll;
	}
	
	static void display(Node n)	{
		for(;n != null; n = n.next)	{
			System.out.print(n.next != null ? (n.data + " -> ") : n.data);
		}
		System.out.println();
	}
	
	static void displayDataRef(Node n)	{
		for(;n != null; n = n.next)	{
			System.out.print(n.next != null ? ((n + " " + (n.data)) + " -> ") : (n + " " + (n.data)));
		}
		System.out.println();
	}
	
	static int length(Node n) {
		int length = 0;
		for(;n != null ; n = n.next)	{
			length++;
		}
		return length;
	}
}
