package interview_tree;

public class Tut08_CheckSubtreeOfBT {
	public static void main(String[] args) {
		CheckSubtreeOfBinaryTree tree = new CheckSubtreeOfBinaryTree();
		tree.buildTree();
	}
}

class CheckSubtreeOfBinaryTree {

	class Node {

		String data;
		Node left, right;

		public Node(String d) {
			data = d;
			left = right = null;
		}
	}

	Node T;
	Node S;
	String inorderTraversalOfT, inorderTraversalOfS;
	String preorderTraversalOfT, preorderTraversalOfS;
	String temp = new String();

	void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			temp = temp.concat(root.data);
			inorder(root.right);
		}
	}

	void preorder(Node root) {
		if (root != null) {
			temp.concat(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}

	void buildTree() {
		T = new Node("a");
		T.left = new Node("b");
		T.right = new Node("d");
		T.left.left = new Node("c");
		T.right.right = new Node("e");

		S = new Node("a");
		S.left = new Node("b");
		S.right = new Node("d");
		S.left.left = new Node("c");

		if (isSubtree(T, S)) {
			System.out.println("Yes, S is a subtree of T");
		} else {
			System.out.println("No, S is not a subtree of T");
		}
	}

	boolean isSubtree(Node T, Node S) {
		
		if(S == null)	{
			return true;
		}
		
		if(T == null)	{
			return false;
		}

		temp = new String();
		inorder(T);
		inorderTraversalOfT = temp;

		temp = new String();
		inorder(S);
		inorderTraversalOfS = temp;
		
		if(!inorderTraversalOfT.contains(inorderTraversalOfS))	{
			return false;
		}

		temp = new String();
		preorder(T);
		preorderTraversalOfT = temp;

		temp = new String();
		preorder(S);
		preorderTraversalOfS = temp;

		if(preorderTraversalOfT.contains(preorderTraversalOfS))	{
			return true;
		}
		
		System.out.println(
				"inorderTraversalOfT : " + inorderTraversalOfT + "inorderTraversalOfS : " + inorderTraversalOfS);
		System.out.println(
				"preorderTraversalOfT : " + preorderTraversalOfT + "preorderTraversalOfS : " + preorderTraversalOfS);
		return false;
	}
}