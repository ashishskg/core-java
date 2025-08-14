import java.util.Arrays;
import java.util.stream.IntStream;

public class CommonCharsInNString {

	static int MAX_CHAR = 26;
	
	public static void main(String[] args) {
		String[] str = { "geeksforgeeks", "gemkstones", 
				//"acknowledges", "aguelikes" 
				};
		int strLen = str.length;
		commonChars(str, strLen);
	}
	
	static void commonChars(String str[], int n) {
		
		// Primary array for common characters
		// We assume all characters are seen before
		Boolean [] primary = new Boolean[MAX_CHAR];
		Arrays.fill(primary, new Boolean(true));
		
		// for each string
		for(int i=0; i < n; i++)	{
			
			// Secondary array for common characters
			// Initially marked false
			Boolean [] sec = new Boolean[MAX_CHAR];
			Arrays.fill(sec, new Boolean(false));
						
			// for every characters of ith string
			for(int j=0; j < str[i].length(); j++)	{
				
				// if character is present in all
				// strings before, mark it.
				if(primary[str[i].charAt(j) - 'a']) {
					// System.out.print(str[i].charAt(j));
					sec[str[i].charAt(j) - 'a'] = true;
				}
			}
			System.arraycopy(sec, 0, primary, 0, MAX_CHAR);
			// System.out.println("        :" + Arrays.toString(IntStream.rangeClosed(1, 26).toArray()));
			// System.out.println("primary : " + Arrays.toString(primary));
			// System.out.println("sec     : " + Arrays.toString(sec));

		}
		
		// Display common characters
		for(int i = 0; i < 26; i++)	{
			if(primary[i]) {
				System.out.print(Character.toChars(i + 97));
				System.out.print(" ");
			}
		}
	}
}
