package arrayandstring;

public class App05OneAway {
	public static void main(String[] args) {
		System.out.println(OneAwayAppSol1.oneEditAway("bale", "pale"));
		System.out.println(OneAwayAppSol1.oneEditAway("apple", "pple"));
		System.out.println(OneAwayAppSol1.oneEditAway("pple", "apple"));
		
		System.out.println(OneAwayAppSol2.oneEditAway("bale", "pale"));
		System.out.println(OneAwayAppSol2.oneEditAway("apple", "pple"));
		System.out.println(OneAwayAppSol2.oneEditAway("pple", "apple"));
	}
}

class OneAwayAppSol1 {

	static boolean oneEditAway(String first, String second)	{
		if(first.length() == second.length())	{
			return oneEditReplace(first, second);
		}else if(first.length() + 1  == second.length())	{
			return oneEditInsert(first, second);
		}else if(first.length() - 1 == second.length())	{
			return oneEditInsert(second, first);
		}
		return false;
	}
	
	static boolean oneEditReplace(String s1, String s2)	{
		boolean foundDifference = false;
		for(int i = 0; i< s1.length(); i++)	{
			if(s1.charAt(i) != s2.charAt(i))	{
				if(foundDifference)	{
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}
	
	static boolean oneEditInsert(String s1, String s2)	{
		int index1 = 0;
		int index2 = 0;
		while(index2 < s2.length() && index1 < s1.length())	{
			if(s1.charAt(index1) != s2.charAt(index2))	{
				if(index1 != index2)	{
					return false;
				}
				index2++;
			}else {
				index1++;
				index2++;
			}
		}
		return true;
	}
}

class OneAwayAppSol2 {
	
	static boolean oneEditAway(String first, String second)	{
		
		/* Length checks */
		if(Math.abs(first.length() - second.length()) > 1)	{
			return false;
		}
		
		/* Get Shorter and longer string. */
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;
		
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while(index2 < s2.length() && index1 < s1.length())	{
			// System.out.println(s1.charAt(index1) + " "  + s2.charAt(index2));
			if(s1.charAt(index1) != s2.charAt(index2))	{
			/* Ensure that this is the first difference found. */
				if(foundDifference) 
					return false;
				foundDifference = true;
				// on Replace, move shorter pointer
				if(s1.length() == s2.length())	{ 
					index1++;
				}
			} else {
				index1++; // if matching, move shorter pointer
			}
			index2++;
		}
		return true;
	}
}