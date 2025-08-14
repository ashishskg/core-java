package tree;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class A3_BinaryTreeToBST {

	public static void main(String[] args) {
		Node root = createBinaryTree();
		// inorder(root);
		Set<Integer> setInteger = new TreeSet<>();
		extractInorderData(root, setInteger);
		System.out.println("setInteger :" + setInteger);
		Iterator<Integer> setIter = setInteger.iterator();
		convertToBST(root, setIter);
		inorder(root);
		System.out.println();
		preorder(root);

	}

	static Node createBinaryTree() {
		
		/*
			  8
			/   \
		   /	 \
		  3	   	  5
		 / \	 / \
		/   \   /   \
	   10	2  4	 6   
	*/

		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(5);
		root.left.left = new Node(10);
		root.left.right = new Node(2);
		root.right.left = new Node(4);
		root.right.right = new Node(6);

		return root;
	}

	static void extractInorderData(Node root, Set<Integer> setInteger) {
		if (root != null) {
			extractInorderData(root.left, setInteger);
			setInteger.add(root.data);
			extractInorderData(root.right, setInteger);
		}
	}

	static void convertToBST(Node root, Iterator<Integer> setIterator) {
		if (root != null) {
			convertToBST(root.left, setIterator);
			root.data = setIterator.next();
			convertToBST(root.right, setIterator);
		}
	}

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

}
