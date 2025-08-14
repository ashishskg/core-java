package linkedlist;

public class Node {
	 int data;
	 Node next;
	
	Node(int data)	{
		this.data = data;
	}
	
	Node()	{}
	
	public void setNext(Node n)	{
		this.next = n;
	}
}
