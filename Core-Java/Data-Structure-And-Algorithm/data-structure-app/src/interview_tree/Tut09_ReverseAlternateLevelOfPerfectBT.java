package interview_tree;

public class Tut09_ReverseAlternateLevelOfPerfectBT {

	public static void main(String[] args) {
		
		ReverseAlternate ra = new ReverseAlternate();
		ra.buildTree();
		ra.reverseAlternate();
		
		ra = new ReverseAlternate();
		ra.buildTree();
		ra.reverseAlternate2();
		
		
	}
}

class ReverseAlternate {
	
	Node root;
	Index index = new Index();
	
	class Node {

		char data;
		Node left, right;

		public Node(char d) {
			data = d;
			left = right = null;
		}
	}
	
	void buildTree() {
	 	root = new Node('a'); 
        root.left = new Node('b'); 
        root.right = new Node('c'); 
        root.left.left = new Node('d'); 
        root.left.right = new Node('e'); 
        root.right.left = new Node('f'); 
        root.right.right = new Node('g'); 
        root.left.left.left = new Node('h'); 
        root.left.left.right = new Node('i'); 
        root.left.right.left = new Node('j'); 
        root.left.right.right = new Node('k'); 
        root.right.left.left = new Node('l'); 
        root.right.left.right = new Node('m'); 
        root.right.right.left = new Node('n'); 
        root.right.right.right = new Node('o'); 
                
	}
	
	// Method 1
	void reverseAlternate() {
        
        System.out.println("Inorder Traversal of given tree"); 
        printInOrder(root); 
  
        reverseAlternate(root); 
        System.out.println(""); 
        System.out.println("Inorder Traversal of modified tree"); 
        printInOrder(root); 
	}
	
	void reverseAlternate(Node node)	{
		char [] arr = new char[100];
		
		storeAlternate(node, arr, index, 0);
		
		// Reverse the Array
		reverse(arr, index.index);
		
		// modify tree
		index.index = 0;
		modifyTree(node, arr, index, 0);
	}
	
	void storeAlternate(Node node, char arr[], Index index, int l)	{
		if(node == null)	{
			return;
		}
		
		// Store element of left subtree
		storeAlternate(node.left, arr, index, l + 1);
		
		// Store element if only it's odd level
		if(l % 2 != 0)	{
			arr[index.index] = node.data;
			index.index++;
		}
		
		storeAlternate(node.right, arr, index, l + 1);
	}
	
	void reverse(char [] arr, int n)	{
		int l = 0, r = n - 1;
		while(l < r)	{
			char temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			l++;
			r--;
		}
	}
	
	void modifyTree(Node node, char arr[], Index index, int l)	{
		if(node == null)	{
			return;
		}
		
		modifyTree(node.left, arr, index, l + 1);
		
		if(l % 2 != 0)	{
			node.data = arr[index.index];
			index.index++;
		}
		
		modifyTree(node.right, arr, index, l + 1);
			
	}
	
	void printInOrder(Node node)	{
		if(node != null)	{
			System.out.print(node.data + " ");
			printInOrder(node.left);
			printInOrder(node.right);
		}
	}
	
	// Method 2
	void reverseAlternateUsingPreorder(Node node1, Node node2, int level) {
		
		if(node1 == null || node2 == null)	{
			return;
		}
		
		if(level % 2 == 0)	{
			char temp = node1.data;
			node1.data = node2.data;
			node2.data = temp;
		}
		
		reverseAlternateUsingPreorder(node1.left, node2.right, level + 1);
		reverseAlternateUsingPreorder(node1.right, node2.left, level + 1);
	}
	
	void reverseAlternate2() {
		reverseAlternateUsingPreorder(root.left, root.right, 0);
		System.out.println();
        printInOrder(root); 
	}
}

class Index {
	int index;
}

