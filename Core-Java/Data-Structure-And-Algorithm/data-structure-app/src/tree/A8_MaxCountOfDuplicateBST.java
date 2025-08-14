package tree;

public class A8_MaxCountOfDuplicateBST {
	public static void main(String args[]) {

		/* Let us create following BST 
				 6 
			   /   \ 
			  5	    7 
			 /  \  / \ 
			4   5  7  7 
	    */
		Node root = new Node(6);
		root.left = new Node(5);
		root.right = new Node(7);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(7);
		root.right.right = new Node(7);

		System.out.println("Node of BST is " + findnode(root));
	}

	static int current = 1, max = 0;
	static int node;
	static Node previous = null;

// Find the inorder traversal of the BST 
	static void inorder(Node root) {
		// If root is null then return
		if (root == null) {
			return;
		}
		inorder(root.left);
		if (previous != null) {

			if (root.data == previous.data) {
				current++;
			} else {
				current = 1;
			}
		}

		if (current > max) {
			max = current;
			node = root.data;
		}

		previous = root;
		inorder(root.right);
	}

	static int findnode(Node root) {
		inorder(root);
		return node;
	}
}