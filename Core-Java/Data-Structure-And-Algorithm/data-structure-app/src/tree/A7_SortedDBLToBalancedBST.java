package tree;

public class A7_SortedDBLToBalancedBST {
	public static void main(String[] args) {
		DBL llist = new DBL();

		/*  77->66->55->44->33->22->11 */
//		llist.push(77); 
//		llist.push(66); 
//		llist.push(55); 
		llist.push(44);
		llist.push(33);
		llist.push(22);
		llist.push(11);

		llist.printList(DBL.head);

		/* Convert List to BST */
		Node root = llist.sortedListToBST();
		llist.preOrder(root);
	}
}

class DBL {
	static LNode head;

	/* Link list Node */
	class LNode {
		int data;
		LNode next, prev;

		LNode(int d) {
			data = d;
			next = prev = null;
		}
	}

	Node sortedListToBST() {
		int n = countNodes(head);

		/* Construct BST */
		return sortedListToBSTRecur(n);
	}

	Node sortedListToBSTRecur(int n) {

		if (n <= 0)
			return null;

		/* Recursively construct the left subtree */
		System.out.println("\nleft call :" + n);
		Node left = sortedListToBSTRecur(n / 2);
		System.out.println("********** After first left************** n : " + n);

		// System.out.println("ro");

		Node root = new Node(head.data);

		// Set pointer to left subtree
		root.left = left;
		System.out.println("root :" + root + " left : " + left + " head.data " + head.data);

		head = head.next;
		
		root.right = sortedListToBSTRecur(n - n / 2 - 1);
		System.out.println("root.right : " + root.right + " root : " + root + " n :" + n);
		return root;
	}

	int countNodes(LNode head) {
		int count = 0;
		LNode temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}
	
	void push(int new_data) {
		LNode newNode = new LNode(new_data);
		newNode.prev = null;
		newNode.next = head;
		if (head != null)
			head.prev = newNode;
		head = newNode;
	}

	void printList(LNode node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
}
