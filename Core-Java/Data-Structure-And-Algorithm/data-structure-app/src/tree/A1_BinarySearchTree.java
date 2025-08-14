package tree;

public class A1_BinarySearchTree {

	Node root;

	public A1_BinarySearchTree() {
		root = null;
	}

	public static void main(String[] args) {
		A1_BinarySearchTree tree = new A1_BinarySearchTree();
		
		/* Let us create following BST 
		        50 
		     /     \ 
		    30      70 
		   /  \    /  \ 
		 20   40  60   80 */

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		// Inorder Traversal
		System.out.println("Inorder Traversal");
		BSTUtil.inorder(tree.root);
		System.out.println("\nPreOrder Traversal");
		BSTUtil.preorder(tree.root);
		System.out.println("\nPostOrder Traversal");
		BSTUtil.postorder(tree.root);

		// Inorder using Non Recursive
		System.out.println("\nInorder using non Recursive");
		BSTUtil.inorder(tree.root);
		// PreOrder using Non Recursive
		System.out.println("\nPreorder using non Recursive");
		BSTUtil.preorder(tree.root);

		// Search
		Node searchNode = BSTUtil.search(tree.root, 20);
		System.out.println(searchNode != null ? "\nData found :" + searchNode.data : "\nData Not Found");

	}

	void insert(int data) {
		root = insertRec(root, data);
	}

	Node insertRec(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}
		if (data < root.data) {
			root.left = insertRec(root.left, data);
		} else if (data > root.data) {
			root.right = insertRec(root.right, data);
		}
		return root;
	}
}