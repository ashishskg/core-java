package arrayandstring;

public class App07StringRotation {
	
	public static void main(String[] args) {
		System.out.println(isSubstring("abcdef", "bcd"));
		System.out.println(isRotation("kumar1", "rkuma"));

	}
	
	/* Solution 1 */
	static boolean isSubstring(String s1, String s2)	{
		for(int i = 0; i < s1.length(); i++)	{
			int count = 0;
			for(int j = 0; j < s2.length(); j++)	{
				// System.out.println(s1.charAt(i + j) + " " + s2.charAt(j));
				if(s1.charAt(i+j) == s2.charAt(j))	{
					count++;
				}else {
					break;
				}
				if(count == s2.length())
					return true;
			}
		}
		return false;
	}
	/* Solution 2 */
	static boolean isRotation(String s1, String s2)	{
		int len = s1.length();
		if(len == s2.length() && len > 0)	{
			String s1s1 = s1 + s1;
			// System.out.println("s1s1" + s1s1);
			return isSubstring(s1s1, s2);
		}
		return false;
	}
}
