package datastructureudemy;


public class Stack {

	Node top;
	Node bottom;
	int length = 0;
	
	class Node {
		Node next;
		int data;
		
		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	Stack() {
		this.top = null;
		this.bottom = null;
		this.length = 0; 
	}
	
	int peek() {
		return this.top.data;
	}
	
	void push(int value) {
		Node newNode = new Node(value);
		if(length == 0)	{
			top = newNode;
			bottom = newNode;
		} else {
			Node temp = top;
			top = newNode;
			top.next = temp;
		}
		length++;
	}
	
	int pop() {
		if(top == null)
			return 0;
		if(top == bottom)	{
			bottom = null;
		}
		int data = top.data;
		top = top.next;
		length--;
		return data;
	}
	
	
	
	
}
