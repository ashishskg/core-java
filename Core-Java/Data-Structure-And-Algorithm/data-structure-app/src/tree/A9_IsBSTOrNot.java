package tree;

public class A9_IsBSTOrNot {
	
	public static void main(String args[]) {
		Node root = new Node(13);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(1);
		root.left.right = new Node(11);

		if (isBST(root, null, null))
			System.out.print("Is BST");
		else
			System.out.print("Not a BST");
	}

	static boolean isBST(Node root, Node l, Node r) {
		if (root == null)
			return true;

		// if left node exist then check it has
		// correct data or not i.e. left node's data
		// should be less than root's data
		if (l != null && root.data <= l.data)
			return false;

		// if right node exist then check it has
		// correct data or not i.e. right node's data
		// should be greater than root's data
		if (r != null && root.data >= r.data)
			return false;

		return isBST(root.left, l, root) && isBST(root.right, root, r);
	}
}
