

// Find the common character of 2 String in Alphabetical order
public class CommonCharacterOf2StringInAlphabeticalOrder {
	
	static int MAX_CHAR = 26;
	public static void main(String[] args) {
	//	String s1 = "geeks", s2 = "forgeeks";
		String s1 = "hello", s2 = "world";
		findCommonCharsInAlphabeticalOrder(s1, s2);
	}

	private static void findCommonCharsInAlphabeticalOrder(String s1, String s2) {
		
		
		// two arrays of length 26 to store occurrence
        // of a letters alphabetically for each string
		int [] arr1 = new int[MAX_CHAR];
		int [] arr2 = new int[MAX_CHAR];
		
		for(int i = 0; i < s1.length();i++)	{
			arr1[s1.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < s2.length();i++)	{
			arr2[s2.charAt(i) - 'a']++;
		}
		
		// If a common index is non-zero, it means
        // that the letter corresponding to that
        // index is common to both strings
		
		for(int i = 0; i < MAX_CHAR; i++)	{
			if(arr1[i] != 0 && arr2[i] !=0) {
				
				// Find the minimum of the occurrence
                // of the character in both strings and print
                // the letter that many number of times
				
				for(int j=0; j < Math.min(arr1[i], arr2[i]);j++)
					System.out.print(Character.toChars(i+'a'));
			}
		}
	}
}
