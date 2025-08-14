package interview_tree;

public class Tut06_RemoveNodesOfRootToLeafPath {

	public static void main(String[] args) {
		int k = 4;
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(7);
		root.right.right = new Node(6);
		root.right.right.left = new Node(8);

		System.out.println("The inorder traversal of original tree is : ");
		inorder(root);
		Node res = removeShortPathNodes(root, 1, k);
		System.out.println("");
		System.out.println("The inorder traversal of modified tree is : ");
		inorder(res);
	}

	static Node removeShortPathNodes(Node node, int level, int k) {

		if (node == null)
			return null;

		node.left = removeShortPathNodes(node.left, level + 1, k);
		node.right = removeShortPathNodes(node.right, level + 1, k);

		if (node.left == null & node.right == null && level < k) {
			return null;
		}

		return node;
	}

	static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
}