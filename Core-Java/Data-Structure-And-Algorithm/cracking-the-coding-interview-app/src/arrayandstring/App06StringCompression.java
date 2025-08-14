package arrayandstring;

public class App06StringCompression {
	
	public static void main(String[] args) {
		System.out.println(compress("aaaabbbccabbcccd"));
	}
	
	static String compress(String str)	{
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for(int i = 0; i < str.length(); i++)	{
			countConsecutive++;
			System.out.println((i+1 >= str.length()) +  " " + (i + 1));
			if( i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}

}
