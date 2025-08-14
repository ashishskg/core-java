package tree;

import java.util.Stack;

public class A2_BinarySearchTreeIter {

	public static void main(String[] args) {
		A2_BinarySearchTreeIter tree = new A2_BinarySearchTreeIter();

		/*
		 * Let us create following BST 50 / \ 30 70 / \ / \ 20 40 60 80
		 */
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		System.out.println("Inorder Traversal");
		tree.iterativeInorder();
		System.out.println("\n PreOrder Traversal");
		tree.iterativePreorder();
		System.out.println("\n PostOrder Traversal");
		tree.iterativePostorder();

		System.out.println("\n Before Deletion Preorder Traversal");
		tree.iterativePreorder();

		System.out.println("After Deletion Preorder Traversal");
		Node result = tree.deleteNodeIteratively(tree.root, 50);

		System.out.println(result != null ? "\nDeletion Successful " : "\nNot Deleted");
		tree.iterativePreorder();

		// Search
		System.out.println(tree.iterativeSearch(tree.root, 20) ? "\nData found " : "\nData Not Found");

		// Construct BST using Preorder Traversal

		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		int size = pre.length;
		Node root = tree.constructTree(pre, size);
		System.out.println("Inorder traversal of the constructed tree is ");
		tree.iterativeInorder(root);

	}

	Node root;

	public A2_BinarySearchTreeIter() {
		root = null;
	}

	void insert(int data) {
		root = insertRec(root, data);
	}

	Node insertRec(Node root, int data) {
		Node newNode = new Node(data);
		Node temp = null;

		Node traverse = root;
		while (traverse != null) {
			temp = traverse;
			if (data < traverse.data) {
				traverse = traverse.left;
			} else if (data > traverse.data) {
				traverse = traverse.right;
			}
		}
		if (temp == null) {
			return root = newNode;
		} else if (data < temp.data) {
			temp.left = newNode;
		} else if (data > temp.data) {
			temp.right = newNode;
		}
		return root;
	}

	// inorder traversal without recursion

	void iterativeInorder() {
		if (root == null) {
			return;
		}

		Stack<Node> stack = new Stack<>();
		Node current = root;

		while (current != null || stack.size() > 0) {

			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			System.out.print(current.data + " ");
			current = current.right;
		}
	}

	void iterativeInorder(Node root) {
		if (root == null) {
			return;
		}

		Stack<Node> stack = new Stack<>();
		Node current = root;

		while (current != null || stack.size() > 0) {

			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			current = stack.pop();
			System.out.print(current.data + " ");
			current = current.right;
		}
	}

	/* Time Complexity O(n*2) */

	void iterativePreorder() {
		if (root == null) {
			return;
		}

		Stack<Node> stack = new Stack<>();
		Node current = root;

		while (current != null || stack.size() > 0) {
			while (current != null) {
				System.out.print(current.data + " ");
				if (current.right != null) {
					stack.push(current.right);
				}
				current = current.left;
			}
			if (!stack.empty()) {
				current = stack.peek();
				stack.pop();
			}
		}
	}

	/* Time Complexity : O(N) */
	void iterativePreorder2() {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.empty()) {
			Node myNode = stack.peek();
			System.out.print(myNode.data + " ");
			stack.pop();

			if (myNode.right != null) {
				stack.push(myNode.right);
			}
			if (myNode.left != null) {
				stack.push(myNode.left);
			}
		}

	}

	void iterativePostorder() {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		if (root == null) {
			return;
		}

		s1.push(root);

		while (!s1.empty()) {
			Node temp = s1.pop();
			s2.push(temp);

			if (temp.left != null) {
				s1.push(temp.left);
			}
			if (temp.right != null)
				s1.push(temp.right);

		}
		while (!s2.empty()) {
			Node temp = s2.pop();
			System.out.print(temp.data + " ");
		}
	}

	boolean iterativeSearch(Node root, int value) {

		while (root != null) {
			if (root.data == value)
				return true;

			if (value < root.data)
				root = root.left;

			else
				root = root.right;
		}

		return false;
	}

	Node deleteNodeIteratively(Node root, int value) {
		Node parent = null, current = root;
		boolean hasLeft = false;

		if (root == null)
			return root;

		while (current != null) {
			if ((int) current.data == value) {
				break;
			}

			parent = current;
			if (value < (int) current.data) {
				hasLeft = true;
				current = current.left;
			} else {
				hasLeft = false;
				current = current.right;
			}
		}

		if (parent == null) {
			return deleteNodeIteratively(current);
		}

		if (hasLeft) {
			parent.left = deleteNodeIteratively(current);
		} else {
			parent.right = deleteNodeIteratively(current);
		}

		return root;
	}

	Node deleteNodeIteratively(Node node) {

		if (node != null) {
			if (node.left == null && node.right == null) {
				return null;
			}

			if (node.left != null && node.right != null) {
				Node inOrderSuccessor = deleteInOrderSuccessorDuplicate(node);
				node.data = inOrderSuccessor.data;
			} else if (node.left != null) {
				node = node.left;
			} else {
				node = node.right;
			}
		}

		return node;
	}

	Node deleteInOrderSuccessorDuplicate(Node node) {
		Node parent = node;
		node = node.right;
		boolean rightChild = node.left == null;

		while (node.left != null) {
			parent = node;
			node = node.left;
		}

		if (rightChild) {
			parent.right = node.right;
		} else {
			parent.left = node.right;
		}

		node.right = null;
		return node;
	}

	/* Construct Binary Search Tree using Preorder */
	Node constructTree(int pre[], int size) {

		// The first element of pre[] is always root
		Node root = new Node(pre[0]);

		Stack<Node> s = new Stack<Node>();

		// Push root
		s.push(root);

		// Iterate through rest of the size-1 items of given preorder array
		for (int i = 1; i < size; ++i) {
			Node temp = null;

			/*
			 * Keep on popping while the next value is greater than stack's top value.
			 */
			while (!s.isEmpty() && pre[i] > s.peek().data) {
				temp = s.pop();
			}

			// Make this greater value as the right child
			// and push it to the stack
			if (temp != null) {
				temp.right = new Node(pre[i]);
				s.push(temp.right);
			}

			// If the next value is less than the stack's top
			// value, make this value as the left child of the
			// stack's top node. Push the new node to stack
			else {
				temp = s.peek();
				temp.left = new Node(pre[i]);
				s.push(temp.left);
			}
		}

		return root;
	}
}
