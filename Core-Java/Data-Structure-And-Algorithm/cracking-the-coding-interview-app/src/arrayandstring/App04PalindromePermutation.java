package arrayandstring;

public class App04PalindromePermutation {

	public static void main(String[] args) {
		String input = "bab";
		System.out.println("Solution 1: The Palindrome Permutation of " + input + " is " +PalPerSol1.isPermutationOfPalindrome(input));
		System.out.println("Solution 2: The Palindrome Permutation of " + input + " is " +PalPerSol2.isPermutationOfPalindrome(input));
		System.out.println("Solution 3: The Palindrome Permutation of " + input + " is " +PalPerSol3.isPermutationOfPalindrome(input));

	}
}

/* Common method in both Solution. */
class Util {
	
	/* Map each character to a number. a -> 0, b -> 1, c -> 2, etc. 
	 * This is case insensitive. Non-letter characters map to -1. */
	
	static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c); ;
		if( a <= val && val <= z)	{
			return val - a;
		}
		return -1;
	}
}

/* Palindrome Permutation Solution 1. O(N)*/
class PalPerSol1 {
	
	static boolean isPermutationOfPalindrome(String phrase) {
		int [] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}
	
	/* Check that no more than one character has an odd count. */
	static boolean checkMaxOneOdd(int[] table) {
		boolean foundOdd = false;
		int i = 0;
		for(int count : table)	{
			i++;
			if(count % 2 == 1) {
				if(foundOdd)	{
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	/* Count how many times each character appears */
	
	static int[] buildCharFrequencyTable(String phrase)	{
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for(char c: phrase.toCharArray()) {
			int x = Util.getCharNumber(c);
			if(x != -1) {
				table[x]++;
			}
		}
		/*
		  for(int i = 0; i < table.length;i++) { if(table[i] != 0)
		  System.out.println("i = " + i + " table[i] " +table[i] + " "); }
		 */
		return table;
	}
}

/* Palindrome Permutation Solution 2. O(N) */

class PalPerSol2 {	
	
	/* Instead of checking the number of odd counts at the end, we can check as we going.*/
	static boolean isPermutationOfPalindrome(String phrase) {
		int countOdd = 0;
		int [] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for(char c : phrase.toCharArray())	{
			int x = Util.getCharNumber(c);
			if(x != -1) {
				table[x]++;
				if(table[x] % 2 == 1)	{
					countOdd++;
				} else {
					countOdd--;
				}
			}
		}
		return countOdd <= 1;
	}
}

/* Palindrome Permutation Solution 3. O(N) */

class PalPerSol3 {
	
	static boolean isPermutationOfPalindrome(String phrase) {
		int bitVector = createBitVector(phrase);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
		
	}
	
	/* Create a bit vector for th string. For each letter with value i, toggle the ith bit.*/
	static int createBitVector(String phrase) {
		int bitVector = 0;
		for(char c : phrase.toCharArray())	{
			int x = Util.getCharNumber(c);
			bitVector = toggle(bitVector, x);
		}
		return bitVector;
	}
	
	/* Toggle the ith bit in the integer*/
    static int toggle(int bitVector, int index)	{
    	if(index < 0) return bitVector;
    	System.out.println("bitVector : " +  bitVector + "index : " + index);
    	int mask = 1 << index;
    	System.out.println("mask : " + mask);
    	if((bitVector & mask) == 0 )	{
    		System.out.println("if " + (bitVector & mask) + " " + (bitVector | mask));
    		bitVector |= mask;
    	} else {
    		System.out.println("else " + (bitVector & ~mask) + " " + (~mask));
    		System.out.println(Integer.toBinaryString(mask));
    		System.out.println(Integer.toBinaryString(~mask));
    		bitVector &= ~mask;
    	}
    	return bitVector;
    }
    
    /* Check that exactly one bit is set by subtracting one from the integer and ANDing it with the original integer.*/
    static boolean checkExactlyOneBitSet(int bitVector)	{
    	return (bitVector & (bitVector - 1)) == 0;
    }
}