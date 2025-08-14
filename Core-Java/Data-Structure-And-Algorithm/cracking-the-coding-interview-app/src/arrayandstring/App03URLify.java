package arrayandstring;

public class App03URLify {
	
	public static void main(String[] args) {
		System.out.println("The URLify of '"+ "Mr John Smith'"+ " is : " + String.valueOf(replaceSpaces("Mr John Smith    ".toCharArray(), 13)));
	}
	
	static char[] replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index, i = 0;
		// Calculate Space Count
		for(i = 0; i < trueLength; i++)	{
			if(str[i] == ' ')	{
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2; 
		if(trueLength < str.length)
			str[trueLength] = '\0';
		
		for(i = trueLength - 1; i >= 0; i--)	{
			if(str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			}else {
				str[index - 1] = str[i];
				index--;
			}
		}
		return str;
	}
}