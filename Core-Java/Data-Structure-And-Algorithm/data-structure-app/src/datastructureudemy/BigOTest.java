package datastructureudemy;

import java.util.HashSet;
import java.util.Set;

public class BigOTest {
	
	public static void main(String[] args) {
		String [] str = new String []{ "Manish", "Ashish", "Niraj" };
		
		findAshish(str); // O(n) --> Linear Time
		
		displayName(str); // O(2) -> Constant Time
		
		funChallenge(str); // O(1) + O(1) + O(1) + O(n) + O(n) + O(n) + O(n) -> 4n + 3 -> O(n)
	}
	
	static void findAshish(String [] strArr) {
		for(int i = 0; i < strArr.length;i++) {
			if(strArr[i].equals("Ashish"))	{
				System.out.println("Ashish Found!");
			}
		}
	}
	
	static void displayName(String [] names) {
		System.out.println(names[0]);  // O(1)
		System.out.println(names[1]);  // O(1)
	}
	
	static int funChallenge(String[] input) {
		int a = 10; // O(1)
		a = 50 + 3; // O(1)
		
		for(int i = 0; i < input.length; i++)	{ // O(n)
			anotherFunction();	// O(n)
			boolean strange = true;	// O(n)
			a++;	// O(n)
		}
		return a; // O(1)
	}
	
	static void anotherFunction() { // Assume this is having operation O(n)
	}
	
	
	static void findName(String [] strArr) {
		for(int i = 0; i < strArr.length;i++) {
			if(strArr[i].equals("Ashish"))	{
				System.out.println("Ashish Found!");
				break;
			}
		}
		
		// Worst case O(n) because "Ashish" could be the last element
		// Best case O(1) because "Ashish" could be the first element
	}
	
	static void rule3DifferentTermsForInput(String [] str1, String [] str2) {
		for(String s1 : str1)	{
			System.out.println(s1); // O(a)
		}
		
		for(String s2 : str2) {
			System.out.println(s2);	// O(b)
		}
		
		// O(a + b)
	}
	
	static void rule3DiffeTerms2(int m, int n) { // O(a * b)
		for(int i = 0; i < n ;i++)	{
			for(int j = 0;j< m;j++) {
				System.out.println(i + " " + j); 
			}
		}
	}
	
	static void rule4n2(int n) { // O(n^2)
		for(int i = 0; i < n ;i++)	{
			for(int j = 0;j< n;j++) {
				System.out.println(i + " " + j); 
			}
		}
	}
	
	
	// Space Complexity Starts
	
	// Space Complexity O(1)
	static void display(String [] strArr) {
		for(int i = 0; i < strArr.length;i++) {
				System.out.println(strArr[i]);
		}
	}
	
	// Space Complexity O(n) (temp array stores n elements)
	static String[] display2(String [] strArr) {
		String []temp = new String[strArr.length];
		for(int i = 0; i < strArr.length;i++) {
				temp[i] = strArr[i];
		}
		return temp;
	}
	
	
	// Space Complexity O(1)
	static void display() {
		String [] str = {"abc", "def", "ghi"};
		System.out.println(str[0]);	// O(1) (Without including syso O(1) is the space complexity
		System.out.println(str[str.length-1]);	// O(1) (Without including syso O(1) is the space complexity
		System.out.println(str.length); // O(1) (Without including syso O(1) is the space complexity
	}
	
	// Time Complexity: O(a * b)
	// Space Complexity: O(1)
	static boolean isCommonItems(String[] s1, String[] s2) { 
		for(int i = 0; i < s1.length ;i++)	{
			for(int j = 0;j< s2.length;j++) {
				if(s1[i].equals(s2[i]))	{
					return true;
				}
			}
		}
		return false;
	}
	
		// Time Complexity: O(a + b)
		// Space Complexity: O(a) 
		static boolean isCommonItems2(String[] s1, String[] s2) {
			Set<String> setValues = new HashSet();
			for(int i = 0; i < s1.length ;i++)	{
				if(!setValues.contains(s1[i]))	{
					setValues.add(s1[i]);
				}
			}	
			for(int j = 0;j< s2.length;j++) {
				if(setValues.contains(s2[j]))	{
					return true;
				}
			}
			
			return false;
		}
}
