package tree;

public class BSTUtil {
	static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	static void preorder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	static void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}

	static Node search(Node root, int data) {
		if (root == null || root.data == data) {
			return root;
		}
		if (root.data > data) {
			return search(root.left, data);
		}
		return search(root.right, data);

	}

	static Node delete(Node root, int data) {

		if (root == null)
			return root;

		if (data < root.data) {
			root.left = delete(root.left, data);
		} else if (data > root.data) {
			root.right = delete(root.right, data);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			System.out.println("left & right not null");
			root.data = minValue(root.right);
			root.right = delete(root.right, root.data);
		}
		return root;
	}

	static int minValue(Node root) {
		int min = root.data;
		while (root.left != null) {
			min = root.left.data;
			root = root.left;
		}
		return min;
	}
}
