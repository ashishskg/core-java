package tree;

import java.util.Stack; 


public class A5_IsArrayRepresentPreTraversalOfBST {
	public static void main(String args[]) { 
		int[] preArr = new int[]{60, 50, 65, 90, 100}; 
		int n = preArr.length; 
		if (canRepresentBST(preArr, n) == true) { 
			System.out.println("true"); 
		} else { 
			System.out.println("false"); 
		} 
		int[] preArr2 = new int[]{60, 50, 65, 15, 90, 100}; 
		int n1 = preArr2.length; 
		if (canRepresentBST(preArr2, n) == true) { 
			System.out.println("true"); 
		} else { 
			System.out.println("false"); 
		} 
	} 
	
	static boolean canRepresentBST(int pre[], int preLen) { 
		Stack<Integer> s = new Stack<Integer>(); 
		Stack<Integer> s2 = new Stack<Integer>();
		int root = Integer.MIN_VALUE; 
		for (int i = 0; i < preLen; i++) { 
			if (pre[i] < root) { 
				return false; 
			} 

			while (!s.empty() && s.peek() < pre[i]) { 
				root = s.peek(); 
				System.out.println("Pop : " +s.pop()); 
			} 
			s.push(pre[i]); 
			System.out.println(s + " root :" + root);

		} 
		return true; 
	} 	
}