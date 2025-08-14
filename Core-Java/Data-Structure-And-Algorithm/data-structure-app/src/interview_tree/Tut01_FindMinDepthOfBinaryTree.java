package interview_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tut01_FindMinDepthOfBinaryTree {

	Node root;

	public static void main(String[] args) {

		Tut01_FindMinDepthOfBinaryTree tree = new Tut01_FindMinDepthOfBinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
		tree.root.right = new Node(30);
		tree.root.left.left = new Node(40);
		tree.root.left.right = new Node(50);
		// tree.root.right.right = new Node(300);
		System.out.println("Minimum Depth is : " + tree.minDepth(tree.root));
		System.out.println("\nMinimum Depth is : " + tree.minDepthByIter(tree.root));
	}

	int minDepth(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null) {
			return minDepth(root.right) + 1;
		}

		if (root.right == null) {
			return minDepth(root.left) + 1;
		}

		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	int minDepth(Node root, int level) {
		if (root == null) {
			return level;
		}
		level++;
		return Math.min(minDepth(root.left, level), minDepth(root.right, level));
	}

	int minDepthByIter(Node root) {
		if (root == null) {
			return 0;
		}
		Queue<QItem> queueItem = new LinkedList<>();
		QItem currentItem = new QItem(root, 1);
		queueItem.add(currentItem);
		while (!queueItem.isEmpty()) {
			currentItem = queueItem.peek();
			queueItem.remove();
			Node node = currentItem.node;
			int depth = currentItem.depth;

			if (node.left == null && node.right == null) {
				return depth;
			}

			if (node.left != null) {
				QItem newItem = new QItem();
				newItem.node = node.left;
				newItem.depth = depth + 1;
				queueItem.add(newItem);
			}
			if (node.right != null) {
				QItem newItem = new QItem();
				newItem.node = node.right;
				newItem.depth = depth + 1;
				queueItem.add(newItem);
			}
		}
		return 0;
	}
	
	static class QItem {
		Node node;
		int depth;
		QItem() {}

		QItem(Node node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}
}