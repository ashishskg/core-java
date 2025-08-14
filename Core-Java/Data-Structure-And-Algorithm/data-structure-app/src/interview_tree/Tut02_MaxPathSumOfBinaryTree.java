package interview_tree;

public class Tut02_MaxPathSumOfBinaryTree {
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(10); 
        tree.root.left.left = new Node(20); 
        tree.root.left.right = new Node(1); 
        tree.root.right.right = new Node(-25); 
        tree.root.right.right.left = new Node(3); 
        tree.root.right.right.right = new Node(4); 
        System.out.println("maximum path sum is : " + MaxPathSumUtil.find(tree.root)); 
        
        
        tree = new BinaryTree();
        tree.root = new Node(-10);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);
        
        System.out.println("maximum path sum is : " + MaxPathSumUtil.find(tree.root)); 
        
	}
}

class Res {
	public int val = Integer.MIN_VALUE;
}

class MaxPathSumUtil {
	
	static int find(Node node) {
		Res result = new Res();
		findMax(node, result);
		return result.val;
		
	}
	
	static int findMax(Node node, Res res) {
		
		if(node == null)	{
			return 0;
		}
		
		int leftVal = findMax(node.left, res);
		int rightVal = findMax(node.right, res);
		
		int maxSingle = Math.max(Math.max(leftVal, rightVal) + node.data, node.data);
		
		int maxTop = Math.max(maxSingle, leftVal + rightVal + node.data);
		
		res.val = Math.max(res.val, maxTop);
		return maxSingle;
	}
}
