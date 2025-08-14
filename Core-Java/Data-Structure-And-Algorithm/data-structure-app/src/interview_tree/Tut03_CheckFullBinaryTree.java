package interview_tree;

public class Tut03_CheckFullBinaryTree {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
		tree.root.right = new Node(30);
		tree.root.left.right = new Node(40);
		tree.root.left.left = new Node(50);

		if(isFullBinaryTree(tree.root)) {
			System.out.println("Full Binary Tree");
		} else {
			System.out.println("Not Full Binary Tree");
		}

	}

	static boolean isFullBinaryTree(Node node) {

		if (node == null) {
			return true;
		}

		if (node.left == null && node.right == null) {
			return true;
		}

		if (node.left != null && node.right != null) {
			return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
		}

		return false;

	}
}