package datastructureudemy;


public class LinkedList {
	
	class Node {
		Node next;
		int data;
		
		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	Node head;
	void append(int data) {
		Node temp = new Node(data);

		if(head == null) {
			head = temp;
		}
		else {
			temp.next = head;
			head = temp;
		}
	}
	
	void display() {
		for(Node temp = head; temp != null; temp = temp.next)
			System.out.println(temp.data);
	}
	
	void reverse() {
		Node first = head;
		Node second = first.next;
		while(second != null)	{
			Node temp = second.next;
			second.next = first;
			first = second;
			second = temp;
		}
		head.next = null;
		head = first;
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(10);
		ll.append(20);
		ll.append(30);
		ll.append(40);
		
		ll.display();
		
		ll.reverse();
		
		ll.display();
	}
}

