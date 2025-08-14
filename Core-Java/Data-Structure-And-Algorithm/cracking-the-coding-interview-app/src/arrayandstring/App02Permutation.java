package arrayandstring;

public class App02Permutation {

	public static void main(String[] args) {
		System.out.println("abc is permutation of cba : " + CheckPermutationSol1.permutation("abc", "cba"));
		System.out.println("abc is permutation of zab : " + CheckPermutationSol2.permutation("abc", "zab"));
	}
}

/*
 * Solution1 : Sort & Compare
 */
class CheckPermutationSol1 {
	static String sort(String s) {
		char[] content = s.toCharArray();
		System.out.println("Before Sort: " + String.valueOf(content));
		java.util.Arrays.sort(content);
		System.out.println("After Sort: " + String.valueOf(content));
		return new String(content);
	}

	static boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
}

/*
 * Solution 2: Check if the two strings have identical character counts
 */

class CheckPermutationSol2 {

	static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}

	static boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] letters = new int[128];
		char[] s_array = s.toCharArray();
		for (char c : s_array) {
			letters[c]++;
			System.out.println(Integer.valueOf(c) + " " + letters[c]); // 97 1
		}
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;
			if (letters[c] < 0) {
				return false;
			}
		}
		return true;
	}
}

/*
 * Output:
	Before Sort: abc
	After Sort: abc
	Before Sort: cba
	After Sort: abc
	abc is permutation of cba : true
	97 1
	98 1
	99 1
	abc is permutation of zab : false
 */
