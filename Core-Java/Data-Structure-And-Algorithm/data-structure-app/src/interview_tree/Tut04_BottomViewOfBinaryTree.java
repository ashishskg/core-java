package interview_tree;

import java.util.*;
import java.util.Map.Entry;

public class Tut04_BottomViewOfBinaryTree {
	public static void main(String[] args) {

		System.out.println("Bottom view of the given binary tree:");
		BottomViewOfBT tree = new BottomViewOfBT();
		tree.buildTree();
		tree.bottomView();
	}
}

class BottomViewOfBT {

	Node root;
	
	class Node {
		Node left, right;
		int hd;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	Node buildTree() {
		root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		return root;
	}

	void bottomView() {

		if (root == null)
			return;

		int hd = 0;

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Node> queue = new LinkedList<>();

		// initialize hd to 0 for Root
		root.hd = hd;
		queue.add(root);

		while (!queue.isEmpty()) {

			// Remove node from Queue and add to Map

			Node temp = queue.remove();
			hd = temp.hd;

			map.put(hd, temp.data);
			// System.out.println("map" + map);
			// System.out.println("while : " + hd + " " + temp.data);
			if (temp.left != null) {
				temp.left.hd = hd - 1;
				queue.add(temp.left);
			}

			if (temp.right != null) {
				temp.right.hd = hd + 1;
				queue.add(temp.right);
			}
		}
		
		Set<Entry<Integer, Integer>> set = map.entrySet();

		Iterator<Entry<Integer, Integer>> iterator = set.iterator();

		while (iterator.hasNext()) {
			System.out.print(iterator.next().getValue() + " ");
		}
	}
}
