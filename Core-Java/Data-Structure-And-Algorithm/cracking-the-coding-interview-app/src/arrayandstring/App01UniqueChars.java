package arrayandstring;

public class App01UniqueChars {

	public static void main(String[] args) {
		System.out.println("Does abc having unique chars : " + isUniqueCharsSol1("abc"));
		System.out.println("Does abcc having unique chars : " + isUniqueCharsSol2("abcc"));
	}

	/*
	 * Solution 1: Create an array of boolean values, where the flag at index i
	 * indicates whether character i in the alphabet is contained in the string. The
	 * second time you see this character you can immediately return false.
	 */
	static boolean isUniqueCharsSol1(String str) {
		if (str.length() > 128)
			return false;

		boolean[] charSet = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (charSet[val]) {
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}

	/*
	 * Solution 2: We can reduce our space usage by a factor of eight by using a bit
	 * vector. We convert the character to an int by subtract and check the bit
	 * flag.
	 */
	static boolean isUniqueCharsSol2(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a'; // 'a' - 'a' = 0
			if ((checker & (1 << val)) > 0) { // 1 << 0 = 1, 0 & 1 = 0
				return false;
			}
			checker |= (1 << val); // 0 |= (1 << 0) = 1
		}
		return true;
	}
}

/*
 * Output:
	Does abc having unique chars : true
	Does abcc having unique chars : false
 */