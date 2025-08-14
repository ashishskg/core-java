package linkedlist;

public class LinkedList {
	
	public Node head;
	void createLinkedList(int []arrData)	{
		
		for(int data : arrData )	{
			add(data);
		}	
	}
	
	void add(int data)	{
		Node temp = head;
		Node newNode = new Node(data); 
		if( temp == null)	{
			head = newNode;
		}else {
			while(temp.next != null)	{
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}
	
	void display() {
		for(Node temp = head; temp != null ; temp = temp.next)	{
			// System.out.print(temp.data + " " + temp + " ");
			System.out.print(temp.data + " ");
		}
		System.out.println();
	}
	
	boolean deleteNode(Node n)	{
		if( n == null || n.next == null)	{
			return false;
		}
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}	
}