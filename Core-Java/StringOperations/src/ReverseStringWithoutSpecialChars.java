
/* Reverse a string without affecting special characters */
public class ReverseStringWithoutSpecialChars {

	public static void main(String[] args) {
		String str = "a!!!b.c.d.e'f,ghi";
		char [] charArr = str.toCharArray();
		System.out.println("Input string: " + str);
		reverse(charArr);
		System.out.println("Output String: " + new String(charArr));
		
	}
	
	static void reverse(char[] str) {
		// Initialize left and right pointers
		int right = str.length - 1, left = 0;
		
		// Traverse string from both ends until 'left' and 'right'
		while(left < right)	{
			// Ignore special characters
			if(!Character.isAlphabetic(str[left]))	{
				left++;
			} else if(!Character.isAlphabetic(str[right]))	{
				right--;
			}
			// Both str[left] and str[right] are not special
			else {
				char tmp = str[left];
				str[left] = str[right];
				str[right] = tmp;
				left++;
				right--;
			}
		}
	}
}
