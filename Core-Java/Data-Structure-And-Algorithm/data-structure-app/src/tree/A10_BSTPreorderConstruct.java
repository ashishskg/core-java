package tree;

public class A10_BSTPreorderConstruct {

	public static void main(String[] args) {
		
		A10_BSTPreorderConstruct tree = new A10_BSTPreorderConstruct();
		// Construct BST using Preorder Method 1
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		int size = pre.length;
		Node root = tree.constructTree(pre, size);
		System.out.println("Inorder traversal of the constructed tree is ");
		BSTUtil.inorder(root);

		// Construct BST using Preorder Method 2
		pre = new int[] { 10, 5, 1, 7, 40, 50 };
		size = pre.length;
		root = tree.constructTree2(pre, size);
		System.out.println("\nInorder traversal of the constructed tree is ");
		BSTUtil.inorder(root);

	}

	Node constructTree(int pre[], int size) {
		Index index = new Index();
		return constructTreeUtil(pre, index, 0, size - 1, size);
	}

	// The main function to construct BST from given preorder traversal.
	// This function mainly uses constructTreeUtil()
	Node constructTree2(int pre[], int size) {
		Index index = new Index();
		return constructTreeUtil2(pre, index, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
	}

	// Construct BST using Preorder Method 1

	Node constructTreeUtil(int pre[], Index preIndex, int low, int high, int size) {

		// Base case
		if (preIndex.index >= size || low > high) {
			return null;
		}

		// The first node in preorder traversal is root. So take the node at
		// preIndex from pre[] and make it root, and increment preIndex
		Node root = new Node(pre[preIndex.index]);
		preIndex.index = preIndex.index + 1;

		// If the current subarry has only one element, no need to recur
		if (low == high) {
			return root;
		}

		// Search for the first element greater than root
		int i;
		for (i = low; i <= high; ++i) {
			if (pre[i] > root.data) {
				break;
			}
		}

		// Use the index of element found in preorder to divide
		// preorder array in two parts. Left subtree and right subtree
		// System.out.println("Before preIndex.index " + preIndex.index + " " + (i -
		// 1));
		root.left = constructTreeUtil(pre, preIndex, preIndex.index, i - 1, size);
		// System.out.println("After preIndex.index " + preIndex.index + " " + i + " " +
		// high);

		root.right = constructTreeUtil(pre, preIndex, i, high, size);

		return root;
	}

	// Construct BST using Preorder Method 2

	Node constructTreeUtil2(int pre[], Index preIndex, int key, int min, int max, int size) {

		// Base case
		if (preIndex.index >= size) {
			return null;
		}

		Node root = null;

		// If current element of pre[] is in range, then
		// only it is part of current subtree
		if (key > min && key < max) {

			// Allocate memory for root of this
			// subtree and increment *preIndex
			root = new Node(key);
			preIndex.index = preIndex.index + 1;

			if (preIndex.index < size) {

				// Construct the subtree under root
				// All nodes which are in range {min .. key}
				// will go in left subtree, and first such
				// node will be root of left subtree.
				root.left = constructTreeUtil2(pre, preIndex, pre[preIndex.index], min, key, size);

				// All nodes which are in range {key..max}
				// will go in right subtree, and first such
				// node will be root of right subtree.
				root.right = constructTreeUtil2(pre, preIndex, pre[preIndex.index], key, max, size);
			}
		}

		return root;
	}
}
