package datastructureudemy;


import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		System.out.println(reverse("Ashish"));
		System.out.println(new StringBuilder("Ashish").reverse());

		Arrays.stream(mergeSortedArray(new int[] { 0, 3, 4, 31 }, new int[] { 4, 6, 30, 45,49 })).forEach(System.out::println);;
	}

	static String reverse(String str) {
		if (str == null || (str != null && str.length() < 2))
			return "Not a valid input";

		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	static int[] mergeSortedArray(int[] arr1, int[] arr2) {

		int[] mergedArray = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;
		while (true) {
			if (!(i < arr1.length && j < arr2.length))
				break;
			if (arr1[i] <= arr2[j]) {
				mergedArray[k++] = arr1[i];
				i++;
			} else {
				mergedArray[k++] = arr2[j];
				j++;
			}
		}
		while (i < arr1.length) {
			mergedArray[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			mergedArray[k++] = arr2[j++];
		}

		return mergedArray;
	}

}
