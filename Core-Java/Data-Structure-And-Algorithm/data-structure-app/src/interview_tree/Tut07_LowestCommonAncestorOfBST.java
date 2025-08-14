package interview_tree;

public class Tut07_LowestCommonAncestorOfBST {

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		int n1 = 10, n2 = 14;
		Node t = lcaRecursive(root, n1, n2);
		System.out.println("Recursive LCA of " + n1 + " and " + n2 + " is " + t.data);

		t = lcaIter(root, n1, n2);
		System.out.println("Iteratvie LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 14;
		n2 = 8;
		t = lcaRecursive(root, n1, n2);
		System.out.println("Recursive LCA of " + n1 + " and " + n2 + " is " + t.data);

		t = lcaIter(root, n1, n2);
		System.out.println("Iteratvie LCA of " + n1 + " and " + n2 + " is " + t.data);

		n1 = 10;
		n2 = 22;
		t = lcaRecursive(root, n1, n2);
		System.out.println("Recursive LCA of " + n1 + " and " + n2 + " is " + t.data);

		t = lcaIter(root, n1, n2);
		System.out.println("Iteratvie LCA of " + n1 + " and " + n2 + " is " + t.data);

	}

	static Node lcaRecursive(Node node, int num1, int num2) {
		if (node == null) {
			return null;
		}

		if (node.data > num1 && node.data > num2) {
			return lcaRecursive(node.left, num1, num2);
		}

		if (node.data < num1 && node.data < num2) {
			return lcaRecursive(node.right, num1, num2);
		}

		return node;
	}

	static Node lcaIter(Node node, int num1, int num2) {

		while (node != null) {
			if (node.data > num1 && node.data > num2) {
				node = node.left;
			} else if (node.data < num1 && node.data < num2) {
				node = node.right;
			} else {
				break;
			}
		}
		return node;
	}
}
