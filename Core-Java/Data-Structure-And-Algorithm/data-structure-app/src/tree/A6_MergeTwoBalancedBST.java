package tree;

import java.util.ArrayList;

public class A6_MergeTwoBalancedBST {

	public static void main(String[] args) {
		
		/* 
				100 
				/ \ 
			  50  300 
			 /  \ 
			20  70 
		*/
		
		BST tree1 = new BST(); 
		tree1.root = new Node(100); 
		tree1.root.left = new Node(50); 
		tree1.root.right = new Node(300); 
		tree1.root.left.left = new Node(20); 
		tree1.root.left.right = new Node(70); 
		
		/*  
				80 
			    / \ 
			   40  120 
		*/

		BST tree2 = new BST();
		tree2.root = new Node(80);
		tree2.root.left = new Node(40);
		tree2.root.right = new Node(120);

		BST tree = new BST();
		tree.root = tree.mergeTrees(tree1.root, tree2.root);
		System.out.println("The Inorder traversal of the merged BST is: ");
		BSTUtil.inorder(tree.root);
	}
}

class BST {

	Node root;

	BST() {
		root = null;
	}

	void storeInorderToList(Node node, ArrayList<Integer> list) {
		if (node != null) {
			storeInorderToList(node.left, list);
			list.add(node.data);
			storeInorderToList(node.right, list);
		}
	}

	ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2, int m, int n) {
		ArrayList<Integer> list3 = new ArrayList<>();
		int i = 0;
		int j = 0;

		while (i < m && j < n) {
			if (list1.get(i) < list2.get(j)) {
				list3.add(list1.get(i));
				i++;
			} else {
				list3.add(list2.get(j));
				j++;
			}
		}
		while (i < m) {
			list3.add(list1.get(i));
			i++;
		}

		while (j < n) {
			list3.add(list2.get(j));
			j++;
		}
		return list3;
	}

	Node ALtoBST(ArrayList<Integer> list, int start, int end) {
		if (start > end)
			return null;

		int mid = (start + end) / 2;
		Node node = new Node(list.get(mid));

		node.left = ALtoBST(list, start, mid - 1);
		node.right = ALtoBST(list, mid + 1, end);

		return node;
	}

	Node mergeTrees(Node node1, Node node2) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		storeInorderToList(node1, list1);
		System.out.println(list1);

		storeInorderToList(node2, list2);

		ArrayList<Integer> list3 = merge(list1, list2, list1.size(), list2.size());

		Node node = ALtoBST(list3, 0, list3.size() - 1);
		return node;
	}
}